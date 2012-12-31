/*
 * Copyright 2010 Daniel Kurka
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.mgwt.imustlearn.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.mgwt.imustlearn.client.activity.about.AboutActivity;
import com.mgwt.imustlearn.client.activity.about.AboutPlace;
import com.mgwt.imustlearn.client.activity.home.HomeActivity;
import com.mgwt.imustlearn.client.activity.home.HomePlace;
import com.mgwt.imustlearn.client.activity.wordForm.WordFormActivity;
import com.mgwt.imustlearn.client.activity.wordForm.WordFormPlace;
import com.mgwt.imustlearn.client.activity.words.WordListActivity;
import com.mgwt.imustlearn.client.activity.words.WordListPlace;

/**
 * @author Daniel Kurka
 */
public class PhoneActivityMapper implements ActivityMapper {

    private final ClientFactory clientFactory;

    public PhoneActivityMapper(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof HomePlace) {
            return new HomeActivity(clientFactory);
        }

        if (place instanceof AboutPlace) {
            return new AboutActivity(clientFactory);
        }

        if (place instanceof WordListPlace) {
            return new WordListActivity(clientFactory);
        }

        if (place instanceof WordFormPlace) {

            return new WordFormActivity(clientFactory, ((WordFormPlace) place).getID());
        }

        /*Add your activities*/


        return new HomeActivity(clientFactory);
    }
}
