package com.mgwt.imustlearn.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.ArrayList;

/**
 * User: JAVASPARX
 * Date: 26.12.12
 */
public class Word implements IsSerializable {

    private ArrayList<Translation> translations = new ArrayList<Translation>(Language.values().length + 1);
    private ArrayList<Media> medias = new ArrayList<Media>(MediaType.values().length);

    private Integer ID;
    private String webID;

    public Word() {
    }

    public Word(Integer ID) {
        this.ID = ID;
    }

    public Word(String ID) {
        this.ID = Integer.parseInt(ID);
    }

    public Word(Integer ID, String webID) {
        this.ID = ID;
        this.webID = webID;
    }

    public Word(String ID, String webID) {
        this(Integer.parseInt(ID), webID);
    }

    public int addTranslation(Translation translation) {
        if (translation != null) {
            translations.add(translation);
            return translations.size();
        }

        return -1;
    }

    public int addMedia(Media media) {
        if (media != null) {
            medias.add(media);
            return medias.size();
        }

        return -1;
    }

    public ArrayList<Translation> getTranslations() {
        return translations;
    }

    public ArrayList<Media> getMedias() {
        return medias;
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

    public String getWebID() {
        return webID;
    }

    public void setWebID(String webID) {
        this.webID = webID;
    }

}
