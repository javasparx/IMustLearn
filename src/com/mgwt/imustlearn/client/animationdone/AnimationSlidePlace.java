/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client.animationdone;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Daniel Kurka
 */
public class AnimationSlidePlace extends Place {
    public static class AnimationSlidePlaceTokenizer implements PlaceTokenizer<AnimationSlidePlace> {

        @Override
        public AnimationSlidePlace getPlace(String token) {
            return new AnimationSlidePlace();
        }

        @Override
        public String getToken(AnimationSlidePlace place) {
            return "";
        }

    }
}
