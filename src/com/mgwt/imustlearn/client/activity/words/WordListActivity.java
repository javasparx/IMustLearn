package com.mgwt.imustlearn.client.activity.words;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.mgwt.imustlearn.client.ClientFactory;
import com.mgwt.imustlearn.client.Topic;
import com.mgwt.imustlearn.client.activity.general.GeneralActivity;
import com.mgwt.imustlearn.client.activity.wordForm.WordFormPlace;
import com.mgwt.imustlearn.client.event.ActionEvent;
import com.mgwt.imustlearn.client.event.ActionNames;

import java.util.ArrayList;

/**
 * User: JAVASPARX
 * Date: 25.12.12
 */
public class WordListActivity extends GeneralActivity {

    private final ClientFactory clientFactory;
    private ArrayList<Topic> topics;

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

        addHandlerRegistration(view.getBackbutton().addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent event) {
                ActionEvent.fire(eventBus, ActionNames.BACK);
            }
        }));

        addHandlerRegistration(view.getCellSelectedHandler().addCellSelectedHandler(
                new CellSelectedHandler() {

                    @Override
                    public void onCellSelected(CellSelectedEvent event) {
                        Topic topic = topics.get(event.getIndex());


//                        Window.alert(String.valueOf(topic.getCount()));

                        clientFactory.getPlaceController().goTo(new WordFormPlace(String.valueOf(topic.getCount())));

                    }
                }));

        panel.setWidget(view);
    }


    private ArrayList<Topic> getWordList() {
        topics = new ArrayList<Topic>();
        topics.add(new Topic("About", 41324));
        topics.add(new Topic("About", 125435));
        topics.add(new Topic("About", 565));
        topics.add(new Topic("About", 6867));
        topics.add(new Topic("About", 789789));
        topics.add(new Topic("About", 86345));
        topics.add(new Topic("About", 45645));
        topics.add(new Topic("About", 678768));
        topics.add(new Topic("About", 12312321));
        topics.add(new Topic("Words", 4564546));
        return topics;
    }
}
