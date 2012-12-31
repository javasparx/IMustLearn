/*
 * Copyright 2012 Javlon Eraliyev
 */
package com.mgwt.imustlearn.client.activity.about;

import com.google.gwt.user.client.ui.HTML;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.mgwt.imustlearn.client.activity.general.GeneralViewImpl;

public class AboutViewImpl extends GeneralViewImpl implements AboutView {

    private RoundPanel round;
    private Button button;

    public AboutViewImpl() {

        round = new RoundPanel();

        round.add(new HTML("mgwt"));
        round.add(new HTML("Version 1.2.0-SNAPSHOT"));
        round.add(new HTML("Built by Javlon Eraliyev"));

        round.add(new HTML("Using GWT to build mobile apps"));

        if (MGWT.getOsDetection().isPhone()) {
            button = new Button("back");
            button.getElement().setAttribute("style", "margin:auto;width: 200px;display:block");
            round.add(button);
            headerBackButton.removeFromParent();
        }

        scrollPanel.setWidget(round);
        scrollPanel.setScrollingEnabledX(false);

    }

    @Override
    public HasTapHandlers getBackbutton() {
        if (MGWT.getOsDetection().isPhone()) {
            return button;
        }
        return super.getBackbutton();
    }

}
