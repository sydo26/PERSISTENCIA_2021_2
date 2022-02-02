package com.redis.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.html.HTML.Tag;

import com.redis.entities.ArticlesEntity;
import com.redis.entities.TagEntity;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class ArticlesService {

    private Jedis jedis;

    public ArticlesService(final Jedis jedis) {
        this.jedis = jedis;
    }

    public ArticlesEntity store(final ArticlesEntity articleEntity) {

        String lastIndex = this.jedis.get("entities/article/lastindex");

        Integer newIndex = Integer.parseInt(lastIndex != null ? lastIndex : "0") + 1;

        Pipeline p = this.jedis.pipelined();

        // Object Hash
        p.hset("article#" + newIndex, "name", articleEntity.getName());
        p.hset("article#" + newIndex, "description", articleEntity.getDescription());
        p.hset("article#" + newIndex, "filename", articleEntity.getFilename());
        p.hset("article#" + newIndex, "posting_date", articleEntity.getPostingDate().toString());
        p.sadd("article#all", String.valueOf(newIndex));

        p.set("entities/article/lastindex", String.valueOf(newIndex));

        p.sync();

        articleEntity.setIdentification(String.valueOf(newIndex));

        return articleEntity;
    }

    public ArticlesEntity store(final String name, final String description, final String filename,
            final Instant postingDate) {
        return this.store(new ArticlesEntity(name, description, filename, postingDate));
    }

    public TagEntity addTag(String tag, ArticlesEntity... articles) {

        Pipeline p = this.jedis.pipelined();
        for (ArticlesEntity article : articles) {

            List<TagEntity> tags = article.getTags();
            tags.add(new TagEntity(tag));
            article.setTags(tags);

            p.sadd(String.format("article#%s#tags", article.getIdentification()), tag);
            p.sadd("tags#article#" + tag, article.getIdentification());
        }
        p.sync();

        return new TagEntity(tag);
    }

    public List<ArticlesEntity> listAll() {

        List<String> identifications = this.jedis.smembers("article#all").stream()
                .collect(Collectors.toList());

        List<ArticlesEntity> list = new ArrayList<ArticlesEntity>();

        for (String _id : identifications) {

            Map<String, String> mappedArticle = this.jedis.hgetAll("article#" + _id);

            ArticlesEntity article = new ArticlesEntity(mappedArticle.get("name"), mappedArticle.get("description"),
                    mappedArticle.get("filename"), Instant.parse(mappedArticle.get("posting_date")));

            article.setIdentification(_id);

            article.setTags(
                    this.jedis.smembers("article#" + _id + "#tags").stream().map((String name) -> new TagEntity(name))
                            .collect(Collectors.toList()));

            list.add(article);

        }

        return list;

    }

    public List<TagEntity> listTagsByArticle(ArticlesEntity article) {
        return this.jedis.smembers(String.format("article#%s#tags", article.getIdentification())).stream()
                .map((tag) -> {
                    TagEntity tagEntity = new TagEntity(tag);
                    return tagEntity;
                }).collect(Collectors.toList());
    }

    public List<ArticlesEntity> listArticlesByTag(String tag) {
        return this.jedis.smembers(String.format("tags#articles#%s", tag)).stream()
                .map((String _id) -> {
                    Map<String, String> mappedArticle = this.jedis.hgetAll("article#" + _id);

                    ArticlesEntity article = new ArticlesEntity(mappedArticle.get("name"),
                            mappedArticle.get("description"),
                            mappedArticle.get("filename"), Instant.parse(mappedArticle.get("posting_date")));

                    return article;
                }).collect(Collectors.toList());
    }

}
