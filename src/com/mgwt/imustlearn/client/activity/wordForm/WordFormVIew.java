package com.mgwt.imustlearn.client.activity.wordForm;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.mgwt.imustlearn.client.model.Media;
import com.mgwt.imustlearn.client.model.Translation;

import java.util.ArrayList;

/**
 * User: JAVASPARX
 * Date: 26.12.12
 */
public interface WordFormView extends IsWidget {


    public void setBackButtonText(String text);

    public HasTapHandlers getBackButton();

    public void setForwardButtonText(String text);

    public HasTapHandlers getForwardButton();

    public void setTitle(String text);

    public void setWords(ArrayList<Translation> translations);

    public void setMedias(ArrayList<Media> medias);

}
