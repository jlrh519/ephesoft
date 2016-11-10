/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2015 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.gxt.admin.client.presenter.document.testextraction;

import com.ephesoft.gxt.admin.client.controller.BatchClassManagementController;
import com.ephesoft.gxt.admin.client.event.DisplayNoResultView;
import com.ephesoft.gxt.admin.client.view.document.testextraction.TestExtractionCompositeView;
import com.ephesoft.gxt.admin.client.view.document.testextraction.TestExtractionInlineView;
import com.ephesoft.gxt.core.client.util.ViewUtil;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.EventHandler;

@SuppressWarnings("rawtypes")
public class TestExtractionCompositePresenter<V extends TestExtractionCompositeView, T> extends TestExtractionInlinePresenter<V> {

	interface CustomEventBinder extends EventBinder<TestExtractionCompositePresenter> {
	}

	private static final CustomEventBinder eventBinder = GWT.create(CustomEventBinder.class);

	@Override
	public void injectEvents(EventBus eventBus) {
		eventBinder.bindEventHandlers(this, eventBus);
	}

	public TestExtractionCompositePresenter(BatchClassManagementController controller, V view) {
		super(controller, view);
	}

	public final void layout(T selectionParameter) {
		this.init(selectionParameter);
		this.bind();
		TestExtractionInlineView<?> centerPanelView = view.getCenterPanelView();
		ViewUtil.bindView(centerPanelView);
		// controller.setCurrentBindedPresenter(this);
		controller.setCenterPanelView(centerPanelView);
	}

	public void init(T selectionParameter) {
	}

	@Override
	public void bind() {
	}

	@EventHandler
	public void displayNoResult(DisplayNoResultView displayNoResultView) {
		controller.setCenterPanelView(null);
	}
}