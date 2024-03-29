/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client.activity.animation;

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
import com.mgwt.imustlearn.client.Animation;

import java.util.List;

/**
 * @author Daniel Kurka
 */
public class AnimationViewGwtImpl implements AnimationView {

    private CellListWithHeader<Animation> list;
    private LayoutPanel main;
    private HeaderPanel headerPanel;
    private HeaderButton headerBackButton;

    /**
     *
     */
    public AnimationViewGwtImpl() {
        main = new LayoutPanel();

        headerPanel = new HeaderPanel();

        headerBackButton = new HeaderButton();

        headerPanel.setLeftWidget(headerBackButton);
        headerBackButton.setBackButton(true);
        headerBackButton.setVisible(!MGWT.getOsDetection().isAndroid());

        main.add(headerPanel);

        ScrollPanel scrollPanel = new ScrollPanel();

        list = new CellListWithHeader<Animation>(new BasicCell<Animation>() {

            @Override
            public String getDisplayString(Animation model) {
                return model.getName();
            }

            @Override
            public boolean canBeSelected(Animation model) {
                return true;
            }
        });

        list.getCellList().setRound(true);

        scrollPanel.setWidget(list);
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
    public HasTapHandlers getBackButton() {
        return headerBackButton;
    }

    @Override
    public HasCellSelectedHandler getCellSelectedHandler() {
        return list.getCellList();
    }

    @Override
    public void setLeftButtonText(String text) {
        headerBackButton.setText(text);

    }

    @Override
    public void setAnimations(List<Animation> animations) {
        list.getCellList().render(animations);

    }

    @Override
    public HasText getFirstHeader() {
        return list.getHeader();
    }

}
