package com.mgwt.imustlearn.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.googlecode.mgwt.dom.client.event.mouse.HandlerRegistrationCollection;
import com.googlecode.mgwt.mvp.client.history.HistoryHandler;
import com.googlecode.mgwt.mvp.client.history.HistoryObserver;
import com.googlecode.mgwt.ui.client.MGWT;
import com.mgwt.imustlearn.client.activity.about.AboutPlace;
import com.mgwt.imustlearn.client.activity.animation.AnimationPlace;
import com.mgwt.imustlearn.client.activity.home.HomePlace;
import com.mgwt.imustlearn.client.activity.words.WordListPlace;
import com.mgwt.imustlearn.client.event.ActionEvent;
import com.mgwt.imustlearn.client.event.ActionNames;
import com.mgwt.imustlearn.client.event.WordListSelectedEvent;

public class AppHistoryObserver implements HistoryObserver {

    @Override
    public void onPlaceChange(Place place, HistoryHandler handler) {

    }

    @Override
    public void onHistoryChanged(Place place, HistoryHandler handler) {

    }

    @Override
    public void onAppStarted(Place place, HistoryHandler historyHandler) {
        if (MGWT.getOsDetection().isPhone() || true) {
            onPhoneNav(place, historyHandler);
        } else {
            // tablet
            onTabletNav(place, historyHandler);
        }
    }

    @Override
    public HandlerRegistration bind(EventBus eventBus, final HistoryHandler historyHandler) {

        HandlerRegistration registerWordListSelected = WordListSelectedEvent.register(eventBus, new WordListSelectedEvent.Handler() {
            @Override
            public void onAction(WordListSelectedEvent event) {

                Place place = new WordListPlace();

                if (MGWT.getOsDetection().isTablet()) {
                    historyHandler.replaceCurrentPlace(place);
                    historyHandler.goTo(place, true);
                } else {
                    historyHandler.goTo(place);
                }
            }
        });

        HandlerRegistration register2 = ActionEvent.register(eventBus, ActionNames.BACK, new ActionEvent.Handler() {

            @Override
            public void onAction(ActionEvent event) {

                History.back();

            }
        });

        HandlerRegistration register = ActionEvent.register(eventBus, ActionNames.ANIMATION_END, new ActionEvent.Handler() {

            @Override
            public void onAction(ActionEvent event) {
                if (MGWT.getOsDetection().isPhone()) {
                    History.back();
                } else {
                    historyHandler.goTo(new AnimationPlace(), true);
                }
            }
        });

        HandlerRegistrationCollection registrationCollection = new HandlerRegistrationCollection();
        registrationCollection.addHandlerRegistration(register);
        registrationCollection.addHandlerRegistration(register2);
        registrationCollection.addHandlerRegistration(registerWordListSelected);
        return registrationCollection;
    }

    private void onPhoneNav(Place place, HistoryHandler historyHandler) {
        if (place instanceof AboutPlace) {
            historyHandler.replaceCurrentPlace(new HomePlace());
        } else if (place instanceof WordListPlace) {
            historyHandler.replaceCurrentPlace(new WordListPlace());
        }
    }

    private void onTabletNav(Place place, HistoryHandler historyHandler) {
        if (place instanceof HomePlace) {
            historyHandler.replaceCurrentPlace(new AboutPlace());
        } else if (place instanceof AboutPlace) {
            historyHandler.replaceCurrentPlace(new HomePlace());
        } else if (place instanceof WordListPlace) {
            historyHandler.replaceCurrentPlace(new WordListPlace());
        }
    }

}
