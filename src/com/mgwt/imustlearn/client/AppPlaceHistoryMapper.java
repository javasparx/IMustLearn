/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.mgwt.imustlearn.client.activity.about.AboutPlace;
import com.mgwt.imustlearn.client.activity.home.HomePlace;
import com.mgwt.imustlearn.client.activity.words.WordListPlace;

//TODO - add tokenizer
@WithTokenizers({HomePlace.HomePlaceTokenizer.class, WordListPlace.AboutPlaceTokenizer.class, AboutPlace.AboutPlaceTokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
