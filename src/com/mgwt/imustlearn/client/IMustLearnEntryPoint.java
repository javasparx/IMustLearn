package com.mgwt.imustlearn.client;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.mvp.client.AnimationMapper;
import com.googlecode.mgwt.mvp.client.history.MGWTPlaceHistoryHandler;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.dialog.TabletPortraitOverlay;
import com.googlecode.mgwt.ui.client.layout.MasterRegionHandler;
import com.googlecode.mgwt.ui.client.layout.OrientationRegionHandler;
import com.googlecode.mgwt.ui.client.util.SuperDevModeUtil;
import com.mgwt.imustlearn.client.activity.home.HomePlace;
import com.mgwt.imustlearn.client.css.AppBundle;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class IMustLearnEntryPoint implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
//        final Button button = new Button("Click me");
//        final Label label = new Label();
//
//        button.addClickHandler(new ClickHandler() {
//            public void onClick(ClickEvent event) {
//                if (label.getText().equals("")) {
//                    imustlearnService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
//                } else {
//                    label.setText("");
//                }
//            }
//        });
//
//        // Assume that the host HTML has elements defined whose
//        // IDs are "slot1", "slot2".  In a real app, you probably would not want
//        // to hard-code IDs.  Instead, you could, for example, search for all
//        // elements with a particular CSS class and replace them with widgets.
//        //
//        RootPanel.get().add(button);
//        RootPanel.get().add(label);

        GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {

            @Override
            public void onUncaughtException(Throwable e) {
                Window.alert("uncaught: " + e.getMessage());
                String s = buildStackTrace(e, "RuntimeExceotion:\n");
                Window.alert(s);
                e.printStackTrace();

            }
        });

        new Timer() {

            @Override
            public void run() {
                start();

            }
        }.schedule(1);
    }

    private void start() {

        // MGWTColorScheme.setBaseColor("#56a60D");
        // MGWTColorScheme.setFontColor("#eee");
        //
        // MGWTStyle.setTheme(new MGWTColorTheme());
        //
        // MGWTStyle.setDefaultBundle((MGWTClientBundle)
        // GWT.create(MGWTStandardBundle.class));
        // MGWTStyle.getDefaultClientBundle().getMainCss().ensureInjected();

        // MGWTStyle.setTheme(new CustomTheme());

        SuperDevModeUtil.showDevMode();

        MGWTSettings.ViewPort viewPort = new MGWTSettings.ViewPort();
        viewPort.setTargetDensity(MGWTSettings.ViewPort.DENSITY.MEDIUM);
        viewPort.setUserScaleAble(false).setMinimumScale(1.0).setMinimumScale(1.0).setMaximumScale(1.0);

        MGWTSettings settings = new MGWTSettings();
        settings.setViewPort(viewPort);
        settings.setIconUrl("logo.png");
        settings.setAddGlosToIcon(true);
        settings.setFullscreen(true);
        settings.setPreventScrolling(true);

        MGWT.applySettings(settings);

        final ClientFactory clientFactory = new ClientFactoryImpl();

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);

        if (MGWT.getOsDetection().isTablet()) {

            // very nasty workaround because GWT does not corretly support
            // @media
            StyleInjector.inject(AppBundle.INSTANCE.css().getText());

            createTabletDisplay(clientFactory);
        } else {

            createPhoneDisplay(clientFactory);

        }

        AppHistoryObserver historyObserver = new AppHistoryObserver();

        MGWTPlaceHistoryHandler historyHandler = new MGWTPlaceHistoryHandler(historyMapper, historyObserver);

        historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new HomePlace());
        historyHandler.handleCurrentHistory();

    }

    private void createPhoneDisplay(ClientFactory clientFactory) {
        AnimatableDisplay display = GWT.create(AnimatableDisplay.class);

        PhoneActivityMapper appActivityMapper = new PhoneActivityMapper(clientFactory);

        PhoneAnimationMapper appAnimationMapper = new PhoneAnimationMapper();

        AnimatingActivityManager activityManager = new AnimatingActivityManager(appActivityMapper, appAnimationMapper, clientFactory.getEventBus());

        activityManager.setDisplay(display);

        RootPanel.get().add(display);
    }

    private void createTabletDisplay(ClientFactory clientFactory) {
        SimplePanel navContainer = new SimplePanel();
        navContainer.getElement().setId("nav");
        navContainer.getElement().addClassName("landscapeonly");
        AnimatableDisplay navDisplay = GWT.create(AnimatableDisplay.class);

        final TabletPortraitOverlay tabletPortraitOverlay = new TabletPortraitOverlay();

        new OrientationRegionHandler(navContainer, tabletPortraitOverlay, navDisplay);
        new MasterRegionHandler(clientFactory.getEventBus(), "nav", tabletPortraitOverlay);

        ActivityMapper navActivityMapper = new TabletNavActivityMapper(clientFactory);

        AnimationMapper navAnimationMapper = new TabletNavAnimationMapper();

        AnimatingActivityManager navActivityManager = new AnimatingActivityManager(navActivityMapper, navAnimationMapper, clientFactory.getEventBus());

        navActivityManager.setDisplay(navDisplay);

        RootPanel.get().add(navContainer);

        SimplePanel mainContainer = new SimplePanel();
        mainContainer.getElement().setId("main");
        AnimatableDisplay mainDisplay = GWT.create(AnimatableDisplay.class);

        TabletMainActivityMapper tabletMainActivityMapper = new TabletMainActivityMapper(clientFactory);

        AnimationMapper tabletMainAnimationMapper = new TabletMainAnimationMapper();

        AnimatingActivityManager mainActivityManager = new AnimatingActivityManager(tabletMainActivityMapper, tabletMainAnimationMapper, clientFactory.getEventBus());

        mainActivityManager.setDisplay(mainDisplay);
        mainContainer.setWidget(mainDisplay);

        RootPanel.get().add(mainContainer);

    }


    private String buildStackTrace(Throwable t, String log) {
        return "disabled";
        // if (t != null) {
        // log += t.getClass().toString();
        // log += t.getMessage();
        // //
        // StackTraceElement[] stackTrace = t.getStackTrace();
        // if (stackTrace != null) {
        // StringBuffer trace = new StringBuffer();
        //
        // for (int i = 0; i < stackTrace.length; i++) {
        // trace.append(stackTrace[i].getClassName() + "." + stackTrace[i].getMethodName() + "("
        // + stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber());
        // }
        //
        // log += trace.toString();
        // }
        // //
        // Throwable cause = t.getCause();
        // if (cause != null && cause != t) {
        //
        // log += buildStackTrace(cause, "CausedBy:\n");
        //
        // }
        // }
        // return log;
    }
}
