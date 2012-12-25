/*
 * Copyright 2012 Javlon Eraliyev
 */
package com.mgwt.imustlearn.client.activity.animation;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.mgwt.imustlearn.client.Animation;
import com.mgwt.imustlearn.client.ClientFactory;
import com.mgwt.imustlearn.client.event.ActionEvent;
import com.mgwt.imustlearn.client.event.ActionNames;
import com.mgwt.imustlearn.client.event.AnimationSelectedEvent;

import java.util.ArrayList;
import java.util.List;

public class AnimationActivity extends MGWTAbstractActivity {

    private final ClientFactory clientFactory;
    private List<Animation> animations;

    /**
     *
     */
    public AnimationActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;

    }

    @Override
    public void start(AcceptsOneWidget panel, final EventBus eventBus) {
        AnimationView view = clientFactory.getAnimationView();

        view.setLeftButtonText("Home");
        view.setTitle("Animation");
        animations = createAnimations();
        view.setAnimations(animations);

        addHandlerRegistration(view.getBackButton().addTapHandler(new TapHandler() {

            @Override
            public void onTap(TapEvent event) {
                ActionEvent.fire(eventBus, ActionNames.BACK);

            }
        }));

        addHandlerRegistration(view.getCellSelectedHandler().addCellSelectedHandler(
                new CellSelectedHandler() {

                    @Override
                    public void onCellSelected(CellSelectedEvent event) {
                        int index = event.getIndex();
                        AnimationSelectedEvent.fire(eventBus, animations.get(index));
                    }
                }));

        panel.setWidget(view);

    }

    /**
     * @return
     */
    private List<Animation> createAnimations() {
        ArrayList<Animation> list = new ArrayList<Animation>();

        list.add(new Animation(Animation.AnimationNames.SLIDE, "Slide"));
        list.add(new Animation(Animation.AnimationNames.SLIDE_UP, "Slide up"));
        list.add(new Animation(Animation.AnimationNames.DISSOLVE, "Dissolve"));
        list.add(new Animation(Animation.AnimationNames.FADE, "Fade"));
        list.add(new Animation(Animation.AnimationNames.FLIP, "Flip"));
        list.add(new Animation(Animation.AnimationNames.POP, "Pop"));
        list.add(new Animation(Animation.AnimationNames.SWAP, "Swap"));
        // list.add(new Animation("Cube"));

        return list;
    }

}
