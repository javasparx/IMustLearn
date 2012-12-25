package com.mgwt.imustlearn.client.activity.home;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.mgwt.imustlearn.client.Topic;

import java.util.List;

/**
 * User: JAVASPARX
 * Date: 25.12.12
 */
public interface HomeView extends IsWidget {

    public void setTitle(String text);

    public void setRightButtonText(String text);

    public HasTapHandlers getAboutButton();

    public HasCellSelectedHandler getCellSelectedHandler();

    public void setTopics(List<Topic> createTopicsList);

    public HasText getFirstHeader();

}
