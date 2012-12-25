package com.mgwt.imustlearn.client.activity.general;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.event.ShowMasterEvent;
import com.mgwt.imustlearn.client.event.ActionEvent;
import com.mgwt.imustlearn.client.event.ActionNames;

public class GeneralActivity extends MGWTAbstractActivity {

    private final GeneralView generalView;
    private final String eventId;

    public GeneralActivity(GeneralView generalView, String eventId) {
        this.generalView = generalView;
        this.eventId = eventId;

    }

    @Override
    public void start(AcceptsOneWidget panel, final EventBus eventBus) {
        addHandlerRegistration(generalView.getMainButton().addTapHandler(new TapHandler() {

            @Override
            public void onTap(TapEvent event) {
                eventBus.fireEvent(new ShowMasterEvent(eventId));
            }
        }));

        addHandlerRegistration(generalView.getBackbutton().addTapHandler(new TapHandler() {

            @Override
            public void onTap(TapEvent event) {
                ActionEvent.fire(eventBus, ActionNames.BACK);
            }
        }));

    }

}
