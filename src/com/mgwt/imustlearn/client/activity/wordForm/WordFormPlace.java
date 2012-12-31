package com.mgwt.imustlearn.client.activity.wordForm;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * User: JAVASPARX
 * Date: 26.12.12
 */
public class WordFormPlace extends Place {

    private String ID;

    public WordFormPlace(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public static class AboutPlaceTokenizer implements PlaceTokenizer<WordFormPlace> {

        @Override
        public WordFormPlace getPlace(String token) {
            return new WordFormPlace(token);
        }

        @Override
        public String getToken(WordFormPlace place) {
            return place.getID();
        }
    }

}
