package com.mgwt.imustlearn.client.activity.words;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.mgwt.imustlearn.client.ClientFactory;
import com.mgwt.imustlearn.client.Topic;
import com.mgwt.imustlearn.client.activity.general.GeneralActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * User: JAVASPARX
 * Date: 25.12.12
 */
public class WordListActivity extends GeneralActivity {

    private final ClientFactory clientFactory;

    public WordListActivity(ClientFactory clientFactory) {
        super(clientFactory.getWordListView(), "nav");
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget panel, final EventBus eventBus) {
        super.start(panel, eventBus);

        WordListView view = clientFactory.getWordListView();

        view.getHeader().setText("Word List");

        view.getBackbuttonText().setText("Home");

        view.getMainButtonText().setText("Nav");

        view.setWords(getWordList());

//        addHandlerRegistration(view.getBackbutton().addTapHandler(new TapHandler() {
//
//            @Override
//            public void onTap(TapEvent event) {
//                ActionEvent.fire(eventBus, ActionNames.BACK);
//            }
//        }));

        panel.setWidget(view);
    }

    private List<Topic> getWordList() {
        ArrayList<Topic> list = new ArrayList<Topic>();
        list.add(new Topic("About", 41324));
        list.add(new Topic("About", 125435));
        list.add(new Topic("About", 565));
        list.add(new Topic("About", 6867));
        list.add(new Topic("About", 789789));
        list.add(new Topic("About", 86345));
        list.add(new Topic("About", 45645));
        list.add(new Topic("About", 678768));
        list.add(new Topic("About", 12312321));
        list.add(new Topic("Words", 4564546));
        return list;
    }
}
