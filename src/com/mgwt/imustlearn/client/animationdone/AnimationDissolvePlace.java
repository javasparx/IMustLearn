/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client.animationdone;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Daniel Kurka
 */
public class AnimationDissolvePlace extends Place {
    public static class AnimationDissolvePlaceTokenizer implements PlaceTokenizer<AnimationDissolvePlace> {

        @Override
        public AnimationDissolvePlace getPlace(String token) {
            return new AnimationDissolvePlace();
        }

        @Override
        public String getToken(AnimationDissolvePlace place) {
            return "";
        }

    }
}
