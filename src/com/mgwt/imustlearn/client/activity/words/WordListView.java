package com.mgwt.imustlearn.client.activity.words;

import com.mgwt.imustlearn.client.Topic;
import com.mgwt.imustlearn.client.activity.general.GeneralView;

import java.util.List;

/**
 * User: JAVASPARX
 * Date: 25.12.12
 */
public interface WordListView extends GeneralView {

    public void setWords(List<Topic> words);

}
