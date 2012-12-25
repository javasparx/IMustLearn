package com.mgwt.imustlearn.client.event;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.mgwt.imustlearn.client.Animation;

public class AnimationSelectedEvent extends Event<AnimationSelectedEvent.Handler> {

    public interface Handler {
        void onAnimationSelected(AnimationSelectedEvent event);
    }

    private static final Type<Handler> TYPE = new Type<Handler>();
    private final Animation animation;

    public static void fire(EventBus eventBus, Animation animation) {
        eventBus.fireEvent(new AnimationSelectedEvent(animation));
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    protected AnimationSelectedEvent(Animation animation) {
        this.animation = animation;

    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onAnimationSelected(this);

    }

    public static Type<Handler> getType() {
        return TYPE;
    }

    public Animation getAnimation() {
        return animation;
    }

}
