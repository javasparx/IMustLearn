package com.mgwt.imustlearn.client.activity.home;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;
import com.googlecode.mgwt.ui.client.widget.celllist.BasicCell;
import com.googlecode.mgwt.ui.client.widget.celllist.CellListWithHeader;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.mgwt.imustlearn.client.Topic;

import java.util.List;

/**
 * User: JAVASPARX
 * Date: 25.12.12
 */
public class HomeViewImpl implements HomeView {

    private LayoutPanel main;
    private HeaderButton forwardButton;
    private HeaderPanel headerPanel;
    private CellListWithHeader<Topic> cellList;

    public HomeViewImpl() {
        main = new LayoutPanel();

        headerPanel = new HeaderPanel();

        forwardButton = new HeaderButton();
        forwardButton.setForwardButton(true);
        if (MGWT.getOsDetection().isPhone()) {
            headerPanel.setRightWidget(forwardButton);
        }
        main.add(headerPanel);

        cellList = new CellListWithHeader<Topic>(new BasicCell<Topic>() {

            @Override
            public String getDisplayString(Topic model) {
                return model.getName();
            }

            @Override
            public boolean canBeSelected(Topic model) {
                return true;
            }

        });

        cellList.getCellList().setRound(true);

        ScrollPanel scrollPanel = new ScrollPanel();
        scrollPanel.setWidget(cellList);
        scrollPanel.setScrollingEnabledX(false);
        main.add(scrollPanel);
    }

    @Override
    public Widget asWidget() {
        return main;
    }

    @Override
    public void setTitle(String text) {
        headerPanel.setCenter(text);

    }

    @Override
    public void setRightButtonText(String text) {
        forwardButton.setText(text);

    }

    @Override
    public HasTapHandlers getAboutButton() {
        return forwardButton;
    }

    @Override
    public HasCellSelectedHandler getCellSelectedHandler() {
        return cellList.getCellList();
    }

    @Override
    public void setTopics(List<Topic> createTopicsList) {
        cellList.getCellList().render(createTopicsList);

    }

    @Override
    public HasText getFirstHeader() {
        return cellList.getHeader();
    }
}
