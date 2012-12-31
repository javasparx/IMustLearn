package com.mgwt.imustlearn.client.event.mycelllist.celllist;

import com.google.gwt.resources.client.ImageResource;
import com.googlecode.mgwt.ui.client.MGWTStyle;

/**
 * User: JAVASPARX
 * Date: 30.12.12
 */
public class ArrowLeftButton implements CellButton {
    @Override
    public ImageResource getImageResource() {
        return MGWTStyle.getTheme().getMGWTClientBundle().getButtonBarArrowLeftImage();
    }
}
