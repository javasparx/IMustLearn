package com.mgwt.imustlearn.client.event;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class WordListSelectedEvent extends Event<WordListSelectedEvent.Handler> {

    public interface Handler {
        void onAction(WordListSelectedEvent event);
    }

    private static final Type<Handler> TYPE = new Type<Handler>();

    public static void fire(EventBus eventBus, String sourceName) {
        eventBus.fireEventFromSource(new WordListSelectedEvent(), sourceName);
    }

    public static HandlerRegistration register(EventBus eventBus, Handler handler) {
        return eventBus.addHandler(TYPE, handler);
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    protected WordListSelectedEvent() {

    }

    @Override
    protected void dispatch(WordListSelectedEvent.Handler handler) {
        handler.onAction(this);
    }

}
