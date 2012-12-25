package com.mgwt.imustlearn.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.mgwt.imustlearn.client.activity.about.AboutView;
import com.mgwt.imustlearn.client.activity.animation.AnimationView;
import com.mgwt.imustlearn.client.activity.home.HomeView;
import com.mgwt.imustlearn.client.activity.words.WordListView;
import com.mgwt.imustlearn.client.animationdone.AnimationDoneView;

/**
 * @author Javlon Eraliyev
 */
public interface ClientFactory {
    public EventBus getEventBus();

    public PlaceController getPlaceController();

    public AnimationDoneView getAnimationDoneView();

    public HomeView getHomeView();

    public AboutView getAboutView();

    public WordListView getWordListView();

    public AnimationView getAnimationView();

    /**
     * @return
     */


}
