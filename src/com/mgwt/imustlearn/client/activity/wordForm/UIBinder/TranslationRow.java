package com.mgwt.imustlearn.client.activity.wordForm.UIBinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

/**
 * User: JAVASPARX
 * Date: 28.12.12
 */
public class TranslationRow {
    interface TranslationRowUiBinder extends UiBinder<DivElement, TranslationRow> {
    }

    private static TranslationRowUiBinder ourUiBinder = GWT.create(TranslationRowUiBinder.class);

    public TranslationRow() {
        DivElement rootElement = ourUiBinder.createAndBindUi(this);

    }
}