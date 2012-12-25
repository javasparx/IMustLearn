package com.mgwt.imustlearn.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.mgwt.imustlearn.client.activity.about.AboutPlace;
import com.mgwt.imustlearn.client.activity.home.HomeActivity;
import com.mgwt.imustlearn.client.activity.home.HomePlace;
import com.mgwt.imustlearn.client.activity.words.WordListActivity;
import com.mgwt.imustlearn.client.activity.words.WordListPlace;

public class TabletNavActivityMapper implements ActivityMapper {

    private final ClientFactory clientFactory;

    public TabletNavActivityMapper(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    //    private UIActivity uiActivity;
    private HomeActivity homeActivity;
    private WordListActivity wordListActivity;
//    private AnimationActivity animationActivity;

//    private Activity getUIActivity() {
//        if (uiActivity == null) {
//            uiActivity = new UIActivity(clientFactory);
//        }
//        return uiActivity;
//    }

    private Activity getHomeActivity() {
        if (homeActivity == null) {
            homeActivity = new HomeActivity(clientFactory);
        }
        return homeActivity;
    }

    private Activity getWordListActivity() {
        if (wordListActivity == null) {
            wordListActivity = new WordListActivity(clientFactory);
        }
        return wordListActivity;
    }

//    private Activity getAnimationActivity() {
//        if (animationActivity == null) {
//            animationActivity = new AnimationActivity(clientFactory);
//        }
//        return animationActivity;
//    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof HomePlace || place instanceof AboutPlace || place instanceof WordListPlace) {
            return getHomeActivity();
        }
//        if (place instanceof PullToRefreshPlace || place instanceof GroupedCellListPlace || place instanceof CarouselPlace || place instanceof UIPlace || place instanceof ScrollWidgetPlace
//                || place instanceof ElementsPlace || place instanceof FormsPlace || place instanceof ButtonBarPlace || place instanceof SearchBoxPlace || place instanceof TabBarPlace
//                || place instanceof ButtonPlace || place instanceof PopupPlace || place instanceof ProgressBarPlace || place instanceof SliderPlace || place instanceof ProgressIndicatorPlace) {
//            return getUIActivity();
//        }

        //TODO - add same to phoneMapper


//        if (place instanceof AnimationPlace) {
//            return getAnimationActivity();
//        }
//
//        if (place instanceof AnimationSlidePlace || place instanceof AnimationSlideUpPlace || place instanceof AnimationDissolvePlace || place instanceof AnimationFadePlace
//                || place instanceof AnimationFlipPlace || place instanceof AnimationPopPlace || place instanceof AnimationSwapPlace || place instanceof AnimationCubePlace) {
//            return getAnimationActivity();
//        }
        return getHomeActivity();
    }
}
