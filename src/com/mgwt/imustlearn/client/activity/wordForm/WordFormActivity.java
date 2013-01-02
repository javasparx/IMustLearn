package com.mgwt.imustlearn.client.activity.wordForm;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.mgwt.imustlearn.client.ClientFactory;
import com.mgwt.imustlearn.client.model.*;

import java.util.ArrayList;

/**
 * User: JAVASPARX
 * Date: 26.12.12
 */
public class WordFormActivity extends MGWTAbstractActivity {

    private final ClientFactory clientFactory;
    private Word word;

    public WordFormActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public WordFormActivity(ClientFactory clientFactory, String token) {
        this(clientFactory);
        word = new Word();
        if (!token.isEmpty()) {
            word.setID(token);
        }
    }

    @Override
    public void start(AcceptsOneWidget panel, final EventBus eventBus) {

        WordFormView view = clientFactory.getWordFormView();

//        addHandlerRegistration(view.getForwardButton().addTapHandler(new TapHandler() {
//
//            @Override
//            public void onTap(TapEvent event) {
//                //TODO - impl event_id enum for "nav"
//                eventBus.fireEvent(new ShowMasterEvent("nav"));
//            }
//        }));

//        addHandlerRegistration(view.getBackButton().addTapHandler(new TapHandler() {
//
//            @Override
//            public void onTap(TapEvent event) {
//                ActionEvent.fire(eventBus, ActionNames.BACK);
//            }
//        }));


//        view.getMainButtonText().setText("Nav");
//        view.setBackButtonText().setText("Cancel");
//        view.getHeader().setText("Edit Word");
        view.setBackButtonText("Cancel");

        view.setForwardButtonText("Save");

        ArrayList<Translation> translations = new ArrayList<Translation>();
        translations.add(new Translation("car", Language.EN));
        translations.add(new Translation("moshna", Language.UZ));
        translations.add(new Translation("mashina", Language.RU));

        view.setWords(translations);

        ArrayList<Media> medias = new ArrayList<Media>();
        medias.add(new Media(0, "asd", MediaType.IMAGE));
        medias.add(new Media(0, "sdfg", MediaType.VIDEO));
        medias.add(new Media(0, "adqw", MediaType.AUDIO));

        view.setMedias(medias);

        panel.setWidget(view);
    }
}
