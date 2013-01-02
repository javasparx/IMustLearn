package com.mgwt.imustlearn.client.activity.wordForm;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.widget.*;
import com.googlecode.mgwt.ui.client.widget.buttonbar.ButtonBar;
import com.googlecode.mgwt.ui.client.widget.buttonbar.PlusButton;
import com.mgwt.imustlearn.client.model.Language;
import com.mgwt.imustlearn.client.model.Media;
import com.mgwt.imustlearn.client.model.Translation;
import com.mgwt.imustlearn.client.ui.celllist.*;

import java.util.ArrayList;

/**
 * User: JAVASPARX
 * Date: 26.12.12
 */
public class WordFormViewImpl implements WordFormView {

    private LayoutPanel main;
    private HeaderButton headerCancelButton;
    private HeaderButton headerSaveButton;
    private HTML title = new HTML("Edit Word");
    private WidgetList wordPanel;
    private WidgetList mediaPanel;
    private ScrollPanel scrollPanel;
    private WidgetList content;

    private CellListWithHeader<Translation> translationCellList;
    private CellListWithHeader<Media> mediaCellList;

    private ArrayList<Translation> translations = new ArrayList<Translation>();
    private ArrayList<Media> medias = new ArrayList<Media>();

    public WordFormViewImpl() {

        main = new LayoutPanel();
        scrollPanel = new ScrollPanel();
        HeaderPanel headerPanel = new HeaderPanel();
        ButtonBar buttonBar = new ButtonBar();


        PlusButton plusButton = new PlusButton();
        plusButton.addTapHandler(new TapHandler() {
            @Override
            public void onTap(TapEvent event) {
                translations.add(new Translation("New tr", Language.UZ));
                translationCellList.getCellList().render(translations);
                scrollPanel.refresh();
            }
        });

        buttonBar.add(plusButton);


        main.add(headerPanel);
        main.add(scrollPanel);
        main.add(buttonBar);


        headerPanel.setCenterWidget(title);

        headerCancelButton = new HeaderButton();
        headerCancelButton.setRoundButton(true);

        headerSaveButton = new HeaderButton();
        headerSaveButton.setRoundButton(true);

        headerPanel.setRightWidget(headerSaveButton);
        headerPanel.setLeftWidget(headerCancelButton);


//        content.add(scrollPanel);


//         scrollPanel.setWidget(content);


//        main.add(headerPanel);
//        main.add(content);

//        wordPanel = new WidgetList();
//        wordPanel.setRound(true);

//        mediaPanel = new WidgetList();
//        mediaPanel.setRound(true);

//        scrollPanel.setWidget(wordPanel);
//        content.add(wordPanel);
//        content.add(mediaPanel);

        translationCellList = new CellListWithHeader<Translation>(new JCell<Translation>() {
            @Override
            public boolean hasWidgets() {
                return true;
            }

            @Override
            public String getDisplayString(Translation model) {
                return model.getText();
            }


        }, new ComposeButton(), new TrashButton());

        translationCellList.getCellList().setGroup(false);

        mediaCellList = new CellListWithHeader<Media>(new JCell<Media>() {
            @Override
            public boolean hasWidgets() {
                return true;
            }

            @Override
            public String getDisplayString(Media model) {
                return model.getPath();
            }
        });


        translationCellList.getHeader().setText("Translations");

        mediaCellList.getHeader().setText("Media");

//        translationCellList.setRound(true);

        content = new WidgetList();

        content.add(translationCellList);
        content.add(mediaCellList);

        scrollPanel.setWidget(content);


//        content.add(translationCellList);

//        translationCellList.render();


//        buttonBar.add(new ActionButton());


        ////////////////////////////////

//        container = new FlowPanel();
//
//        HTML header = new HTML("Contact Data");
//        header.addStyleName(MGWTStyle.getTheme().getMGWTClientBundle().getListCss().listHeader());
//
//        container.add(header);
//
//        textBox = new MTextBox();
//
//        WidgetList widgetList;
//        widgetList = new WidgetList();
//        widgetList.setRound(true);
//
//        // lets put in some widgets
//        widgetList.add(new FormListEntry("Word", textBox));
//        widgetList.add(new FormListEntry("Translation", new MTextBox()));
//        widgetList.add(new FormListEntry("Example", new MTextBox()));
//
//        container.add(widgetList);
//
//        scrollPanel.setScrollingEnabledX(false);
//        scrollPanel.setWidget(container);
//        // workaround for android formfields jumping around when using
//        // -webkit-transform
//        scrollPanel.setUsePos(MGWT.getOsDetection().isAndroid());


    }

//    private

    @Override
    public void setBackButtonText(String text) {
        headerCancelButton.setText(text);
    }

    @Override
    public HasTapHandlers getBackButton() {
        return headerCancelButton;
    }

    @Override
    public void setForwardButtonText(String text) {
        headerSaveButton.setText(text);
    }

    @Override
    public HasTapHandlers getForwardButton() {
        return headerSaveButton;
    }

    @Override
    public void setTitle(String text) {
        title.setText(text);
    }

    @Override
    public Widget asWidget() {
        return main;
    }

    @Override
    public void setWords(final ArrayList<Translation> translations) {
//        wordPanel.clear();
        this.translations = translations;

        translationCellList.getCellList().render(translations);

        translationCellList.getCellList().addWidgetSelectedHandler(new WidgetSelectedHandler() {

            @Override
            public void onWidgetSelected(WidgetSelectedEvent event) {
                int idx = event.getIndexOfWidget();
                int idxCell = event.getIndexOfCell();
                if (idx == 1) {
                    translations.remove(idxCell);
                    translationCellList.getCellList().render(translations);
                    scrollPanel.refresh();
                }
            }
        });
    }

    @Override
    public void setMedias(ArrayList<Media> medias) {
//        mediaPanel.clear();
        this.medias = medias;

        mediaCellList.getCellList().render(medias, new TrashButton());

        mediaCellList.getCellList().addWidgetSelectedHandler(new WidgetSelectedHandler() {
            @Override
            public void onWidgetSelected(WidgetSelectedEvent event) {

            }
        });
    }
}
