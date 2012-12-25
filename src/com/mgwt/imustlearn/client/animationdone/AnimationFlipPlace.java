/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client.animationdone;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Daniel Kurka
 */
public class AnimationFlipPlace extends Place {
    public static class AnimationFlipPlaceTokenizer implements PlaceTokenizer<AnimationFlipPlace> {

        @Override
        public AnimationFlipPlace getPlace(String token) {
            return new AnimationFlipPlace();
        }

        @Override
        public String getToken(AnimationFlipPlace place) {
            return "";
        }

    }
}
