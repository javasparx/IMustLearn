package com.mgwt.imustlearn.client.activity.words;

import com.google.gwt.user.client.Window;
import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.celllist.BasicCell;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent;
import com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedHandler;
import com.mgwt.imustlearn.client.Topic;
import com.mgwt.imustlearn.client.activity.general.GeneralViewImpl;

import java.util.List;

/**
 * User: JAVASPARX
 * Date: 25.12.12
 */
public class WordListViewImpl extends GeneralViewImpl implements WordListView {

    private CellList<Topic> list;
    private List<Topic> words;

    public WordListViewImpl() {

//        list = new CellList<Topic>(new Cell<Topic>() {
//            @Override
//            public void render(SafeHtmlBuilder safeHtmlBuilder, Topic model) {
//
//            }
//
//            @Override
//            public boolean canBeSelected(Topic model) {
//                return false;  //To change body of implemented methods use File | Settings | File Templates.
//            }
//        });

        list = new CellList<Topic>(new BasicCell<Topic>() {
            @Override
            public String getDisplayString(Topic model) {
                return model.getName();
            }

            @Override
            public boolean canBeSelected(Topic model) {
                return true;
            }

        });

//        list = new CellList<Topic>(new AbstractCell<Topic>() {
//            @Override
//            public void render(Context context, Topic value, SafeHtmlBuilder sb) {
//                if (value==null){
//                    return;
//                }
//
//
//            }
//        });
//
//        selectionModel = new SingleSelectionModel<Topic>(providesKey);

        list.addCellSelectedHandler(new CellSelectedHandler() {
            @Override
            public void onCellSelected(CellSelectedEvent event) {

                Topic topic = words.get(event.getIndex());

                Window.alert(String.valueOf(topic.getCount()));
            }
        });

        scrollPanel.setWidget(list);

    }

    @Override
    public void setWords(List<Topic> words) {
        this.words = words;
        list.render(words);
    }
}
