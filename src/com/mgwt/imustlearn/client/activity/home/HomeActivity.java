package com.mgwt.imustlearn.client.activity.home;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.MGWTAbstractActivity;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.mgwt.imustlearn.client.ClientFactory;
import com.mgwt.imustlearn.client.Topic;
import com.mgwt.imustlearn.client.activity.about.AboutPlace;
import com.mgwt.imustlearn.client.activity.words.WordListPlace;

import java.util.ArrayList;
import java.util.List;

/**
 * User: JAVASPARX
 * Date: 25.12.12
 */
public class HomeActivity extends MGWTAbstractActivity {

    private final ClientFactory clientFactory;

    public HomeActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        HomeView view = clientFactory.getHomeView();

        view.setTitle("Home");
        view.setRightButtonText("about");

        view.getFirstHeader().setText("IMustLearn");

        view.setTopics(createTopicsList());

        addHandlerRegistration(view.getCellSelectedHandler().addCellSelectedHandler(
                new CellSelectedHandler() {

                    @Override
                    public void onCellSelected(CellSelectedEvent event) {
                        int index = event.getIndex();
                        if (index == 0) {
                            clientFactory.getPlaceController().goTo(new AboutPlace());
                            return;
                        }
                        if (index == 1) {
                            clientFactory.getPlaceController().goTo(new WordListPlace());
                        }

                    }
                }));

        panel.setWidget(view);

    }

    private List<Topic> createTopicsList() {
        ArrayList<Topic> list = new ArrayList<Topic>();
        list.add(new Topic("About", 5));
        list.add(new Topic("Words", 5));
        return list;
    }
}
