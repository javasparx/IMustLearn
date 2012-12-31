package com.mgwt.imustlearn.client.model;

public class Media {

    private Integer ID;
    private String path;
    private MediaType type;

    public Media(Integer ID, String path, MediaType type) {
        this.ID = ID;
        this.path = path;
        this.type = type;
    }

    public Media(String path, MediaType type) {
        this.path = path;
        this.type = type;
    }

    public Media(String ID, String path, MediaType type) {
        this(Integer.parseInt(ID), path, type);
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setID(String ID) {
        setID(Integer.parseInt(ID));
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

}