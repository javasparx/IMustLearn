package com.mgwt.imustlearn.client.activity.home;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * User: JAVASPARX
 * Date: 25.12.12
 */
public class HomePlace extends Place {

    public static class HomePlaceTokenizer implements PlaceTokenizer<HomePlace> {

        @Override
        public HomePlace getPlace(String token) {
            return new HomePlace();
        }

        @Override
        public String getToken(HomePlace place) {
            return "";
        }

    }

    @Override
    public int hashCode() {
        return 3;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other == null)
            return false;

        if (other instanceof HomePlace)
            return true;
        return false;
    }

}
