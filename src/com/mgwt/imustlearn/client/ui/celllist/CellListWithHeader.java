package com.mgwt.imustlearn.client.ui.celllist;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.theme.base.ListCss;
import com.mgwt.imustlearn.client.ui.CellListWithButtons;

/**
 * A cell list with a header text
 *
 * @author Javlon Eraliyev
 * @version $Id: $
 */
public class CellListWithHeader<T> extends Composite {
    private FlowPanel main;
    private CellListWithButtons<T> cellList;
    private HTML header;

    /**
     * Construct a JCell list
     *
     * @param JCell the JCell to use for this JCell list
     */
    public CellListWithHeader(JCell<T> JCell, CellButton... buttons) {
        this(JCell, MGWTStyle.getTheme().getMGWTClientBundle().getListCss(), buttons);
    }

    /**
     * Construct a JCell list with a given JCell and css
     *
     * @param JCell the JCell to use
     * @param css   the css to use
     */
    public CellListWithHeader(JCell<T> JCell, ListCss css, CellButton... buttons) {
        css.ensureInjected();
        main = new FlowPanel();

        initWidget(main);

        header = new HTML();
        header.setStylePrimaryName(css.listHeader());
        main.add(header);

        cellList = new CellListWithButtons<T>(JCell, buttons);
        main.add(cellList);
    }

    /**
     * Get the header of the cell list
     *
     * @return the header of the cell list
     */
    public HasText getHeader() {
        return header;
    }

    /**
     * Get the cell list
     *
     * @return the cell list
     */
    public CellListWithButtons<T> getCellList() {
        return cellList;
    }
}
