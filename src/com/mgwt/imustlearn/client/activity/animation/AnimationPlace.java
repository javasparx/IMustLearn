/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client.activity.animation;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Daniel Kurka
 */
public class AnimationPlace extends Place {
    public static class AnimationPlaceTokenizer implements PlaceTokenizer<AnimationPlace> {

        @Override
        public AnimationPlace getPlace(String token) {
            return new AnimationPlace();
        }

        @Override
        public String getToken(AnimationPlace place) {
            return "";
        }

    }
}
