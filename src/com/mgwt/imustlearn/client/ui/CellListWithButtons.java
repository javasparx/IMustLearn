/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.mgwt.imustlearn.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Node;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safecss.shared.SafeStyles;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.googlecode.mgwt.dom.client.event.tap.Tap;
import com.googlecode.mgwt.dom.client.event.touch.*;
import com.googlecode.mgwt.dom.client.recognizer.EventPropagator;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.theme.base.ListCss;
import com.googlecode.mgwt.ui.client.widget.touch.TouchWidget;
import com.mgwt.imustlearn.client.ui.celllist.*;

import java.util.LinkedList;
import java.util.List;

/**
 * A widget that renders its children as a list
 * <p/>
 * You can control the markup of the children by using the Cell interface, therefore you can render
 * any kind of arbitrary markup
 * <p/>
 * <h2>Styling</h2> The DOM will look like this:
 * <p/>
 * <pre>
 * &lt;ul class="mgwt-List">
 *  &lt;li class="mgwt-List-first">&lt;!-- your markup -->&lt;/li>
 *  &lt;li class="">&lt;!-- your markup -->&lt;/li>
 *  ...
 *  &lt;li class="mgwt-List-last">&lt;!-- your markup -->&lt;/li>
 * &lt;/ul>
 * </pre>
 * <p/>
 * These styles will be applied to the main ul element:
 * <p/>
 * <ul>
 * <li>.mgwt-List-round- if the list should be rendered with rounded corners</li>
 * </ul>
 * <p/>
 * These styles will be applied to one or more of the li elements:
 * <ul>
 * <li>.mgwt-List-selected - if the li got selected</li>
 * <li>.mgwt-List-group - if the element should be rendered as selectable (is has more content)</li>
 * </ul>
 *
 * @param <T> the type of the model to render
 * @author Daniel Kurka
 */
public class CellListWithButtons<T> extends Composite implements HasWidgetSelectedHandler {

    protected static final EventPropagator EVENT_PROPAGATOR = GWT.create(EventPropagator.class);

    /**
     * Standard li template
     *
     * @author Daniel Kurka
     */
    public interface Template extends SafeHtmlTemplates {
        /**
         * get the template
         *
         * @param idx          index of cell
         * @param classes      css classes
         * @param cellContents content
         * @return the safe html with values
         */
        @SafeHtmlTemplates.Template("<li __idx=\"{0}\" class=\"{1}\">{2}{3}</li>")
        SafeHtml li(int idx, String classes, SafeHtml cellContents, SafeHtml widgets);

    }

    public interface WidgetTemplate extends SafeHtmlTemplates {

        @SafeHtmlTemplates.Template("<div __w_index=\"{0}\" style=\"{2}\" class=\"overide-mgwt-BarButton {1}\">{3}</div>")
        SafeHtml div(int idx, String classes, SafeStyles css, String html);

    }

    /**
     * the li template instance
     */
    public static final Template LI_TEMPLATE = GWT.create(Template.class);
    public static final WidgetTemplate WIDGET_TEMPLATE = GWT.create(WidgetTemplate.class);

    private static class UlTouchWidget extends TouchWidget {

        public UlTouchWidget() {
            super();
            setElement(Document.get().createULElement());
        }

    }

    private class InternalTouchHandler implements TouchHandler {

        private boolean moved;
        private int index;
        private int idxButton = -1;
        private Element node;
        private int x;
        private int y;
        private boolean started;
        private Element originalElement;
        private boolean wasWidgetSelected = false;

        @Override
        public void onTouchCanceled(TouchCancelEvent event) {

        }

        @Override
        public void onTouchMove(TouchMoveEvent event) {
            Touch touch = event.getTouches().get(0);
            if (Math.abs(touch.getPageX() - x) > Tap.RADIUS || Math.abs(touch.getPageY() - y) > Tap.RADIUS) {
                moved = true;
                // deselect
                if (node != null) {
                    node.removeClassName(css.selected());
//                    stopTimer();
                }

            }

        }

        @Override
        public void onTouchEnd(TouchEndEvent event) {
            if (node != null) {
                node.removeClassName(css.selected());
//                stopTimer();
            }
            if (started && !moved && index != -1) {
                if (wasWidgetSelected && idxButton != -1) {
                    setIcons(originalElement, buttons[idxButton].getImageResource(), false);

                    fireSelectionAtIndex(index, originalElement, idxButton);
                } else {
                    fireSelectionAtIndex(index, originalElement, -1);
                }
            }
            node = null;
            started = false;

        }

        @Override
        public void onTouchStart(TouchStartEvent event) {
            started = true;

            x = event.getTouches().get(0).getPageX();
            y = event.getTouches().get(0).getPageY();

            if (node != null) {
                node.removeClassName(css.selected());
            }
            moved = false;
            index = -1;
            // Get the event target.
            EventTarget eventTarget = event.getNativeEvent().getEventTarget();
            if (eventTarget == null) {
                return;
            }

            // no textnode or element node
            if (!Node.is(eventTarget) && !Element.is(eventTarget)) {
                return;
            }

            // text node use the parent..
            if (Node.is(eventTarget) && !Element.is(eventTarget)) {
                Node target = Node.as(eventTarget);
                eventTarget = target.getParentElement().cast();
            }

            // no element
            if (!Element.is(eventTarget)) {
                return;
            }


            Element target = eventTarget.cast();

            originalElement = target;

            if (hasWidgets) {

                //If selected element is widget
                String widgetIndexPropertyName = "__w_index";

                if (originalElement.hasAttribute(widgetIndexPropertyName)) {

                    wasWidgetSelected = true;

                    String idxButtonString = originalElement.getAttribute(widgetIndexPropertyName);

                    idxButton = getIndexFromProperty(idxButtonString);

                    setIcons(originalElement, buttons[idxButton].getImageResource(), true);
                } else {
                    wasWidgetSelected = false;
                    idxButton = -1;
                }

            }

            // Find cell
            String idxString = "";
            while ((target != null) && ((idxString = target.getAttribute("__idx")).length() == 0)) {
                target = target.getParentElement();
            }

            index = getIndexFromProperty(idxString);

            node = target;
        }

        private int getIndexFromProperty(String idxString) {
            if (idxString.length() > 0) {

                try {
                    // see: http://code.google.com/p/mgwt/issues/detail?id=154
                    if (MGWT.getOsDetection().isBlackBerry()) {
//                        startTimer(node);
                        return (int) Long.parseLong(idxString);
                    } else {
//                        startTimer(node);
                        return Integer.parseInt(idxString);
                    }

                } catch (Exception ignored) {
                    return -1;
                }

            }
            return -1;
        }
    }

    public void setIcons(Element element, ImageResource icon, boolean active) {
        ImageResource highlight = MGWTStyle.getTheme().getMGWTClientBundle().getButtonBarHighlightImage();

        if (icon == null)
            return;

        if (!active) {
            element.getStyle().setBackgroundImage("url(" + icon.getSafeUri().asString() + ")");

            if (MGWT.getOsDetection().isRetina() || MGWT.getOsDetection().isIPadRetina()) {
                element.getStyle().setProperty("backgroundSize", (icon.getWidth() / 2) + "px " + (icon.getHeight() / 2) + "px");
            }
        } else {

            // don't set active state if we don't have a hightlight icon...
//            if (highlight == null) {
//                return;
//            }

            element.getStyle().setBackgroundImage("url(" + highlight.getSafeUri().asString() + "), url(" + icon.getSafeUri().asString() + ")");
            if (MGWT.getOsDetection().isRetina() || MGWT.getOsDetection().isIPadRetina()) {
                element.getStyle().setProperty("backgroundSize", (highlight.getWidth()) + "px " + (highlight.getHeight()) + "px, " + (icon.getWidth() / 2) + "px " + (icon.getHeight() / 2) + "px");
            }
        }

    }

    private UlTouchWidget main;
    private InternalTouchHandler internalTouchHandler;

    private LinkedList<HandlerRegistration> handlers = new LinkedList<HandlerRegistration>();
    protected final JCell<T> cell;
    protected CellButton[] buttons;
    protected final ListCss css;
    private SafeHtmlBuilder widgetsBuilder;

    private boolean hasWidgets;

    private boolean group = true;
    protected Timer timer;

    /**
     * Construct a CellListWithButtons
     *
     * @param cell the cell to use
     */
    public CellListWithButtons(JCell<T> cell, final CellButton... widgets) {
        this(cell, MGWTStyle.getTheme().getMGWTClientBundle().getListCss(), widgets);
    }

    /**
     * Construct a celllist with a given cell and css
     *
     * @param cell the cell to use
     * @param css  the css to use
     */
    public CellListWithButtons(JCell<T> cell, ListCss css, final CellButton... widgets) {
        //TODO change
        MGWTStyle.getTheme().getMGWTClientBundle().getButtonBarButtonCss().ensureInjected();

        hasWidgets = cell.hasWidgets();

        widgetsBuilder = new SafeHtmlBuilder();

        hasWidgets = (hasWidgets && (widgets.length > 0));

        if (hasWidgets) {

            buttons = widgets;

            for (int j = 0; j < widgets.length; j++) {

                final int finalJ = j;

                SafeStyles styles = new SafeStyles() {
                    @Override
                    public String asString() {
                        return "background-image:url(" + widgets[finalJ].getImageResource().getSafeUri().asString() + ");float:right;";
                    }
                };

                widgetsBuilder.append(WIDGET_TEMPLATE.div(
                        j,
                        MGWTStyle.getTheme().getMGWTClientBundle().getButtonBarButtonCss().barButton(),
                        styles,
                        "")
                );
            }
        }

        css.ensureInjected();
        this.cell = cell;
        this.css = css;
        main = new UlTouchWidget();

        initWidget(main);

        internalTouchHandler = new InternalTouchHandler();

        setStylePrimaryName(css.listCss());
    }

    /**
     * Should the CellListWithButtons be rendered with rounded corners
     *
     * @param round true to render with rounded corners, otherwise false
     */
    public void setRound(boolean round) {
        if (round) {
            addStyleName(css.round());
        } else {
            removeStyleName(css.round());
        }
    }


    public HandlerRegistration addWidgetSelectedHandler(WidgetSelectedHandler widgetSelectedHandler) {
        return addHandler(widgetSelectedHandler, WidgetSelectedEvent.getType());
    }

    /*
    * (non-Javadoc)
    *
    * @see com.google.gwt.user.client.ui.Composite#onAttach()
    */

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onAttach() {

        super.onAttach();

        handlers.add(main.addTouchCancelHandler(internalTouchHandler));
        handlers.add(main.addTouchEndHandler(internalTouchHandler));
        handlers.add(main.addTouchStartHandler(internalTouchHandler));
        handlers.add(main.addTouchMoveHandler(internalTouchHandler));

    }

    /*
    * (non-Javadoc)
    *
    * @see com.google.gwt.user.client.ui.Composite#onDetach()
    */

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onDetach() {

        super.onDetach();

        for (HandlerRegistration reg : handlers) {
            reg.removeHandler();
        }
        handlers.clear();
    }

    /**
     * Render a List of models in this cell list
     *
     * @param models the list of models to render
     */
    public void render(List<T> models, final CellButton... widgets) {
        SafeHtmlBuilder sb = new SafeHtmlBuilder();


        for (int i = 0; i < models.size(); i++) {

            final T model = models.get(i);

            SafeHtmlBuilder cellBuilder = new SafeHtmlBuilder();

            String clazz = "";

            if (group) {
                clazz += css.group() + " ";
            }

            if (i == 0) {
                clazz += css.first() + " ";
            }

            if (models.size() - 1 == i) {
                clazz += css.last() + " ";
            }

            cellBuilder.append(new SafeHtml() {
                @Override
                public String asString() {
                    return cell.getDisplayString(model);
                }
            });

            sb.append(LI_TEMPLATE.li(i, clazz, cellBuilder.toSafeHtml(), widgetsBuilder.toSafeHtml()));
        }

        final String html = sb.toSafeHtml().asString();

        getElement().setInnerHTML(html);

        if (models.size() > 0) {
            String innerHTML = getElement().getInnerHTML();
            if ("".equals(innerHTML.trim())) {
                fixBug(html);
            }
        }

    }


    /**
     * Set a selected element in the celllist
     *
     * @param index    the index of the element
     * @param selected true to select the element, false to deselect
     */
    public void setSelectedIndex(int index, boolean selected) {
        Node node = getElement().getChild(index);
        Element li = Element.as(node);
        if (selected) {
            li.addClassName(css.selected());
        } else {
            li.removeClassName(css.selected());
        }
    }

    /**
     * set this widget a group (by default rendered with an arrow)
     *
     * @param group group
     */
    public void setGroup(boolean group) {
        this.group = group;
    }

    /**
     * set this widget a group (by default rendered with an arrow)
     *
     * @return group
     */
    public boolean isGroup() {
        return group;
    }

    protected void fixBug(final String html) {
        new Timer() {

            @Override
            public void run() {
                getElement().setInnerHTML(html);
                String innerHTML = getElement().getInnerHTML();
                if ("".equals(innerHTML.trim())) {
                    fixBug(html);

                }

            }
        }.schedule(100);
    }

    protected void fireSelectionAtIndex(int indexOfCell, Element element, int indexOfWidget) {
        EVENT_PROPAGATOR.fireEvent(this, new WidgetSelectedEvent(indexOfCell, indexOfWidget, element));
    }

    protected void startTimer(final Element node) {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

        timer = new Timer() {

            @Override
            public void run() {
                node.addClassName(css.selected());
            }
        };
        timer.schedule(150);

    }

    protected void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

    }

}
