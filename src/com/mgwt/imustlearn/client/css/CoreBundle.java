package com.mgwt.imustlearn.client.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface CoreBundle extends ClientBundle {
    //This is a very nasty workaround because GWT CssResource does not support @media correctly!
    @Source("core.css")
    TextResource css();

    public static final CoreBundle INSTANCE = GWT.create(CoreBundle.class);

}
