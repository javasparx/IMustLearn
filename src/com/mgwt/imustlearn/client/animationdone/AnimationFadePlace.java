/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client.animationdone;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Daniel Kurka
 */
public class AnimationFadePlace extends Place {
    public static class AnimationFadePlaceTokenizer implements PlaceTokenizer<AnimationFadePlace> {

        @Override
        public AnimationFadePlace getPlace(String token) {
            return new AnimationFadePlace();
        }

        @Override
        public String getToken(AnimationFadePlace place) {
            return "";
        }

    }
}
