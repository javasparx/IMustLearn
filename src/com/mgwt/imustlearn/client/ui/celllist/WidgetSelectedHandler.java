package com.mgwt.imustlearn.client.ui.celllist;

import com.google.gwt.event.shared.EventHandler;

/**
 * Objects that implement this interface reveive {@link com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent}
 * events
 *
 * @author Javlon Eraliyev
 * @version $Id: $
 */
public interface WidgetSelectedHandler extends EventHandler {

    public void onWidgetSelected(WidgetSelectedEvent event);

}
