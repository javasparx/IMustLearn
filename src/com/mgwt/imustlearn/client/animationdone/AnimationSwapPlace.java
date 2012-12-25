/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client.animationdone;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Daniel Kurka
 */
public class AnimationSwapPlace extends Place {
    public static class AnimationSwapPlaceTokenizer implements PlaceTokenizer<AnimationSwapPlace> {

        @Override
        public AnimationSwapPlace getPlace(String token) {
            return new AnimationSwapPlace();
        }

        @Override
        public String getToken(AnimationSwapPlace place) {
            return "";
        }

    }
}
