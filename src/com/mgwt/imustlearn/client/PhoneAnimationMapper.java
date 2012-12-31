/* * Javlon Eraliyev * */
package com.mgwt.imustlearn.client;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.mgwt.imustlearn.client.activity.about.AboutPlace;
import com.mgwt.imustlearn.client.activity.words.WordListPlace;

/**
 * @author Daniel Kurka
 */
public class PhoneAnimationMapper implements AnimationMapper {

    @Override
    public Animation getAnimation(Place oldPlace, Place newPlace) {

        if (newPlace instanceof AboutPlace) {
            return Animation.POP;
        }

        if (newPlace instanceof WordListPlace) {
            return Animation.FLIP;
        }

        //TODO - add animation switch
//        if (oldPlace instanceof UIPlace && newPlace instanceof HomePlace) {
//            return Animation.SLIDE_REVERSE;
//        }

//        if (oldPlace instanceof AboutPlace && newPlace instanceof HomePlace) {
//            return Animation.SLIDE_UP_REVERSE;
//        }
//
//        if (oldPlace instanceof HomePlace && newPlace instanceof AboutPlace) {
//            return Animation.SLIDE_UP;
//        }
//
//        if (oldPlace instanceof HomePlace && newPlace instanceof AnimationPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof HomePlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof AnimationPlace && newPlace instanceof HomePlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof ScrollWidgetPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof ScrollWidgetPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof ElementsPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof ElementsPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof FormsPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof FormsPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof ButtonBarPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof ButtonBarPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof SearchBoxPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof SearchBoxPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof TabBarPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof TabBarPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof ButtonPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof ButtonPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof PopupPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof PopupPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof ProgressBarPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof ProgressBarPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof ProgressIndicatorPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof ProgressIndicatorPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof SliderPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof SliderPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof PullToRefreshPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof PullToRefreshPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof CarouselPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof CarouselPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        if (oldPlace instanceof UIPlace && newPlace instanceof GroupedCellListPlace) {
//            return Animation.SLIDE;
//        }
//
//        if (oldPlace instanceof GroupedCellListPlace && newPlace instanceof UIPlace) {
//            return Animation.SLIDE_REVERSE;
//        }
//
//        // animation
//
//        if (oldPlace instanceof AnimationSlidePlace && newPlace instanceof AnimationPlace) {
//            return Animation.SLIDE_REVERSE;
//        }

        // if (oldPlace instanceof AnimationCubePlace && newPlace instanceof
        // AnimationPlace) {
        // return Animation.CUBE_REVERSE;
        // }
        //
        // if (oldPlace instanceof AnimationPlace && newPlace instanceof
        // AnimationCubePlace) {
        // return Animation.CUBE;
        // }

//        if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationSlideUpPlace) {
//            return Animation.SLIDE_UP;
//        }
//
//        if (oldPlace instanceof AnimationSlideUpPlace && newPlace instanceof AnimationPlace) {
//            return Animation.SLIDE_UP_REVERSE;
//        }
//
//        if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationDissolvePlace) {
//            return Animation.DISSOLVE;
//        }
//
//        if (oldPlace instanceof AnimationDissolvePlace && newPlace instanceof AnimationPlace) {
//            return Animation.DISSOLVE_REVERSE;
//        }
//
//        if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationFadePlace) {
//            return Animation.FADE;
//        }
//
//        if (oldPlace instanceof AnimationFadePlace && newPlace instanceof AnimationPlace) {
//            return Animation.FADE_REVERSE;
//        }
//        if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationFlipPlace) {
//            return Animation.FLIP;
//        }
//
//        if (oldPlace instanceof AnimationFlipPlace && newPlace instanceof AnimationPlace) {
//            return Animation.FLIP_REVERSE;
//        }
//
//        if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationPopPlace) {
//            return Animation.POP;
//        }
//
//        if (oldPlace instanceof AnimationPopPlace && newPlace instanceof AnimationPlace) {
//            return Animation.POP_REVERSE;
//        }
//
//        if (oldPlace instanceof AnimationPlace && newPlace instanceof AnimationSwapPlace) {
//            return Animation.SWAP;
//        }
//
//        if (oldPlace instanceof AnimationSwapPlace && newPlace instanceof AnimationPlace) {
//            return Animation.SWAP_REVERSE;
//        }

        return Animation.SLIDE;

    }
}
