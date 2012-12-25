/*
 * Copyright 2012 Javlon Eraliyev
 */
package com.mgwt.imustlearn.client.activity.animation;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.mgwt.imustlearn.client.Animation;

import java.util.List;

public interface AnimationView extends IsWidget {

    public void setTitle(String text);

    public void setLeftButtonText(String text);

    public HasTapHandlers getBackButton();

    public HasCellSelectedHandler getCellSelectedHandler();

    public void setAnimations(List<Animation> animations);

    public HasText getFirstHeader();
}
