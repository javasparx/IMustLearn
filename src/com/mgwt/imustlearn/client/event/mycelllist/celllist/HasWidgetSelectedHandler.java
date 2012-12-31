/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.mgwt.imustlearn.client.event.mycelllist.celllist;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Classes that implement this interface produce {@link com.googlecode.mgwt.ui.client.widget.celllist.CellSelectedEvent}
 * events.
 *
 * @author Javlon Eraliyev
 * @version $Id: $
 */
public interface HasWidgetSelectedHandler {

    public HandlerRegistration addWidgetSelectedHandler(WidgetSelectedHandler cellSelectedHandler);

}