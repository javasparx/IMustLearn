package com.mgwt.imustlearn.client.activity.words;

import com.googlecode.mgwt.ui.client.widget.CellList;
import com.googlecode.mgwt.ui.client.widget.celllist.BasicCell;
import com.googlecode.mgwt.ui.client.widget.celllist.HasCellSelectedHandler;
import com.mgwt.imustlearn.client.Topic;
import com.mgwt.imustlearn.client.activity.general.GeneralViewImpl;

import java.util.List;

/**
 * User: JAVASPARX
 * Date: 25.12.12
 */
public class WordListViewImpl extends GeneralViewImpl implements WordListView {

    private CellList<Topic> list;

    public WordListViewImpl() {

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

//        list.addCellSelectedHandler(new CellSelectedHandler() {
//            @Override
//            public void onCellSelected(CellSelectedEvent event) {
//
//                Topic topic = words.get(event.getIndex());
//
//                Window.alert(String.valueOf(topic.getCount()));
//            }
//        });

        scrollPanel.setWidget(list);

    }

    @Override
    public void setWords(List<Topic> words) {
        list.render(words);
    }

    @Override
    public HasCellSelectedHandler getCellSelectedHandler() {
        return list;
    }

}
