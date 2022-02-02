package com.redis.entities;

import java.util.ArrayList;
import java.util.List;

public class TagEntity extends Entity {
    private List<ArticlesEntity> articles;

    public TagEntity(String _id) {
        super(_id);
        this.articles = new ArrayList<ArticlesEntity>();
    }

    public List<ArticlesEntity> getArticles() {
        return articles;
    }

    @Override
    public String toString() {
        return this._id;
    }

}
