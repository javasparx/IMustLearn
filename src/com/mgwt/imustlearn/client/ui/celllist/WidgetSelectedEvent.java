package com.mgwt.imustlearn.client.ui.celllist;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.GwtEvent;


/**
 * This event is fired when a widget {@link com.googlecode.mgwt.ui.client.widget.celllist.Cell} is selected
 *
 * @author Javlon Eraliyev
 * @version $Id: $
 */
public class WidgetSelectedEvent extends GwtEvent<WidgetSelectedHandler> {

    private static final Type<WidgetSelectedHandler> TYPE = new Type<WidgetSelectedHandler>();
    private final int indexOfCell;
    private final Element targetElement;
    private final int indexOfWidget;

    /**
     * Construct a cell selected event
     *
     * @param indexOfCell   the indexOfCell of the cell that was selected
     * @param targetElement selected widget
     * @param indexOfWidget the indexOfCell of the widget that was selected
     */
    public WidgetSelectedEvent(int indexOfCell, int indexOfWidget, Element targetElement) {
        this.indexOfCell = indexOfCell;
        this.targetElement = targetElement;
        this.indexOfWidget = indexOfWidget;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type<WidgetSelectedHandler> getAssociatedType() {
        return TYPE;
    }

    /*
    * (non-Javadoc)
    *
    * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
    */

    /**
     * {@inheritDoc}
     */
    @Override
    protected void dispatch(WidgetSelectedHandler handler) {

        handler.onWidgetSelected(this);

    }

    /**
     * <p>
     * getType
     * </p>
     *
     * @return a {@link com.google.gwt.event.shared.GwtEvent.Type} object.
     */
    public static Type<WidgetSelectedHandler> getType() {
        return TYPE;
    }

    /**
     * get the indexOfCell of the selected widget
     *
     * @return the indexOfCell of the selected widget
     */
    public int getIndexOfCell() {
        return indexOfCell;
    }

    public Element getTargetElement() {
        return targetElement;
    }

    public int getIndexOfWidget() {
        return indexOfWidget;
    }

}
