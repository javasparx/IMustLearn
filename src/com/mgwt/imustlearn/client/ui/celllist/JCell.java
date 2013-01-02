package com.mgwt.imustlearn.client.ui.celllist;

/**
 * A JCell represents a small amount of html when rendered
 *
 * @author Javlon Eraliyev
 * @version $Id: $
 */
public interface JCell<T> {

    public boolean hasWidgets();

    /**
     * Called when the cell needs to render itself
     *
     * @param model the current model for the cell
     */
    public abstract String getDisplayString(T model);

}
