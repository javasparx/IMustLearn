/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client.animationdone;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Daniel Kurka
 */
public class AnimationPopPlace extends Place {
    public static class AnimationPopPlaceTokenizer implements PlaceTokenizer<AnimationPopPlace> {

        @Override
        public AnimationPopPlace getPlace(String token) {
            return new AnimationPopPlace();
        }

        @Override
        public String getToken(AnimationPopPlace place) {
            return "";
        }

    }
}
