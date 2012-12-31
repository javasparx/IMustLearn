/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.mgwt.imustlearn.client.activity.about.AboutView;
import com.mgwt.imustlearn.client.activity.about.AboutViewImpl;
import com.mgwt.imustlearn.client.activity.animation.AnimationView;
import com.mgwt.imustlearn.client.activity.animation.AnimationViewGwtImpl;
import com.mgwt.imustlearn.client.activity.home.HomeView;
import com.mgwt.imustlearn.client.activity.home.HomeViewImpl;
import com.mgwt.imustlearn.client.activity.wordForm.WordFormView;
import com.mgwt.imustlearn.client.activity.wordForm.WordFormViewImpl;
import com.mgwt.imustlearn.client.activity.words.WordListView;
import com.mgwt.imustlearn.client.activity.words.WordListViewImpl;
import com.mgwt.imustlearn.client.animationdone.AnimationDoneView;
import com.mgwt.imustlearn.client.animationdone.AnimationDoneViewImpl;

import java.util.HashMap;

/**
 * @author Daniel Kurka
 */
public class ClientFactoryImpl implements ClientFactory {

    private EventBus eventBus;
    private PlaceController placeController;
    private HashMap<String, Place> placeMap = new HashMap<String, Place>();

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    public ClientFactoryImpl() {
        eventBus = new SimpleEventBus();

        placeController = new PlaceController(eventBus);

        homeView = new HomeViewImpl();
        wordListView = new WordListViewImpl();
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    @Override
    public Place getPlaceByID(String ID) {
        return placeMap.get(ID);
    }

    @Override
    public void putPlace(String ID, Place place) {
        placeMap.put(ID, place);
    }

    /**
     * *******Views*********
     */

    private AnimationDoneView animationDoneView;
    private HomeView homeView;
    private AboutView aboutView;
    private WordListView wordListView;
    private AnimationView animationView;
    private WordFormView wordFormView;

    @Override
    public HomeView getHomeView() {
        if (homeView == null) {
            homeView = new HomeViewImpl();
        }
        return homeView;
    }

    @Override
    public AboutView getAboutView() {
        if (aboutView == null) {
            aboutView = new AboutViewImpl();
        }
        return aboutView;
    }

    @Override
    public WordListView getWordListView() {
        if (wordListView == null) {
            wordListView = new WordListViewImpl();
        }
        return wordListView;
    }

    @Override
    public AnimationDoneView getAnimationDoneView() {
        if (animationDoneView == null) {
            animationDoneView = new AnimationDoneViewImpl();
        }
        return animationDoneView;
    }

    @Override
    public AnimationView getAnimationView() {
        if (animationView == null) {
            animationView = new AnimationViewGwtImpl();
        }
        return animationView;
    }

    public WordFormView getWordFormView() {
        if (wordFormView == null) {
            wordFormView = new WordFormViewImpl();
        }
        return wordFormView;
    }


}
