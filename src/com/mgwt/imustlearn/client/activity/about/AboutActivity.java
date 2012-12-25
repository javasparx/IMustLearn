/*
 * Copyright 2010 Javlon Eraliyev
 */
package com.mgwt.imustlearn.client.activity.about;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.mgwt.imustlearn.client.ClientFactory;
import com.mgwt.imustlearn.client.activity.general.GeneralActivity;
import com.mgwt.imustlearn.client.event.ActionEvent;
import com.mgwt.imustlearn.client.event.ActionNames;

public class AboutActivity extends GeneralActivity {

    private final ClientFactory clientFactory;

    public AboutActivity(ClientFactory clientFactory) {
        super(clientFactory.getAboutView(), "nav");
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget panel, final EventBus eventBus) {
        super.start(panel, eventBus);
        AboutView aboutView = clientFactory.getAboutView();

        aboutView.getBackbuttonText().setText("Home");

        aboutView.getHeader().setText("About");

        aboutView.getMainButtonText().setText("Nav");

        addHandlerRegistration(aboutView.getBackbutton().addTapHandler(new TapHandler() {

            @Override
            public void onTap(TapEvent event) {
                ActionEvent.fire(eventBus, ActionNames.BACK);
            }
        }));

        panel.setWidget(aboutView);
    }

}
