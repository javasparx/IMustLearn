package com.mgwt.imustlearn.client.event.mycelllist.celllist;

import com.google.gwt.resources.client.ImageResource;
import com.googlecode.mgwt.ui.client.MGWTStyle;

/**
 * User: JAVASPARX
 * Date: 30.12.12
 */
public class TextOnlyButton implements CellButton {
    @Override
    public ImageResource getImageResource() {
        return null;
    }

    private String text;

    public TextOnlyButton(String text) {
        this.text = text;
        MGWTStyle.getTheme().getMGWTClientBundle().getButtonBarCss().ensureInjected();
    }

    public String getHtml() {
        return text;
    }
}
