package com.redis.entities;

public abstract class Entity {
    protected String _id;

    public Entity(final String _id) {
        this._id = _id;
    }

    public Entity() {

    }

    public String getIdentification() {
        return _id;
    }

    public void setIdentification(String _id) {
        this._id = _id;
    }

}
