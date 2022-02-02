package com.redis.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ArticlesEntity extends Entity {

    private String name, description, filename;
    private Instant postingDate;
    private List<TagEntity> tags;

    public ArticlesEntity(final String name, final String description, final String filename,
            Instant postingDate) {
        super();
        this.name = name;
        this.description = description;
        this.filename = filename;
        this.postingDate = postingDate;
        this.tags = new ArrayList<TagEntity>();
    }

    public String getDescription() {
        return description;
    }

    public String getFilename() {
        return filename;
    }

    public String getName() {
        return name;
    }

    public Instant getPostingDate() {
        return postingDate;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[ ").append("ID=" + this._id).append(", name=" + this.name)
                .append(", description=" + this.description).append(", filename=" + this.filename)
                .append(", posting_date=" + this.postingDate.toString()).append(", tags=" + this.tags).append(" ]")
                .toString();
    }

}
