package com.redis;

import java.time.Instant;
import java.util.List;

import com.redis.db.JedisConnection;
import com.redis.entities.ArticlesEntity;
import com.redis.entities.TagEntity;
import com.redis.services.ArticlesService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        JedisPool jedisPool = new JedisPool(JedisConnection.poolConfig(), "localhost");

        try (Jedis jedis = jedisPool.getResource()) {
            bootstrap(jedis);
        }

        jedisPool.close();
    }

    public static void bootstrap(Jedis jedis) {

        ArticlesService as = new ArticlesService(jedis);

        ArticlesEntity art1 = as.store("Exemplo 01", "Desc 01", "001",
                Instant.now().minusSeconds(60 * 60 * 24 * 2));

        ArticlesEntity art2 = as.store("Exemplo 02", "Desc 02", "002",
                Instant.now().minusSeconds(60 * 60 * 24 * 1));

        ArticlesEntity art3 = as.store("Exemplo 03", "Desc 03", "003",
                Instant.now().minusSeconds(60 * 60 * 4));

        System.out.println("# Artigos criados");
        System.out.println(art1);
        System.out.println(art2);
        System.out.println(art3);
        System.out.println();

        as.addTag("dev", art1, art2);
        as.addTag("blog", art2);
        as.addTag("game", art1);
        as.addTag("all", art1, art2, art3);
        as.addTag("movie", art3);

        System.out.println("# Tags adicionadas aos artigos");
        System.out.println(art1);
        System.out.println(art2);
        System.out.println(art3);
        System.out.println();

        System.out.println("# Listagem de todos os artigos");
        for (ArticlesEntity article : as.listAll())
            System.out.println(article);
        System.out.println();

        System.out.println("# Tags do art1");
        for (TagEntity tag : as.listTagsByArticle(art1))
            System.out.println(tag);
        System.out.println();
    }
}
