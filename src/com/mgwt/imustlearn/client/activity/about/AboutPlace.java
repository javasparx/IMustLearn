/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client.activity.about;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Daniel Kurka
 */
public class AboutPlace extends Place {
    public static class AboutPlaceTokenizer implements PlaceTokenizer<AboutPlace> {

        @Override
        public AboutPlace getPlace(String token) {
            return new AboutPlace();
        }

        @Override
        public String getToken(AboutPlace place) {
            return "";
        }

    }
}
