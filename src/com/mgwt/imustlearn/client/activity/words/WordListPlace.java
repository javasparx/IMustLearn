package com.mgwt.imustlearn.client.activity.words;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * User: JAVASPARX
 * Date: 25.12.12
 */
public class WordListPlace extends Place {
    public static class AboutPlaceTokenizer implements PlaceTokenizer<WordListPlace> {

        @Override
        public WordListPlace getPlace(String token) {
            return new WordListPlace();
        }

        @Override
        public String getToken(WordListPlace place) {
            return "";
        }

    }
}
