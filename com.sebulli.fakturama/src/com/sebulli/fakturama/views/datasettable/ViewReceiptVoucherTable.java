/* 
 * Fakturama - Free Invoicing Software - http://fakturama.sebulli.com
 * 
 * Copyright (C) 2012 Gerd Bartelt
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Gerd Bartelt - initial API and implementation
 */


package com.sebulli.fakturama.views.datasettable;

import static com.sebulli.fakturama.Translate._;

import org.eclipse.swt.widgets.Composite;

import com.sebulli.fakturama.ContextHelpConstants;
import com.sebulli.fakturama.actions.NewReceiptVoucherAction;
import com.sebulli.fakturama.data.Data;
import com.sebulli.fakturama.data.DataSetReceiptVoucher;



/**
 * View with the table of all receipt vouchers
 * 
 * @author Gerd Bartelt
 * 
 */
public class ViewReceiptVoucherTable extends ViewVoucherTable{
	
	// ID of this view
	public static final String ID = "com.sebulli.fakturama.views.datasettable.viewReceiptVoucherTable";

	/**
	 * Creates the SWT controls for this workbench part.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		// Add the action to create a new entry
		addNewAction = new NewReceiptVoucherAction();

		// Name of the editor
		editor = "ReceiptVoucher";
		
		// Text of the column "name"
		customerSupplier = 	DataSetReceiptVoucher.CUSTOMERSUPPLIER;

		// Create the super part control
		super.createPartControl(parent, ContextHelpConstants.VOUCHER_TABLE_VIEW);

		// Name of this view
		this.setPartName(_("Receipt vouchers"));

		
		// Set the input of the table viewer and the tree viewer
		tableViewer.setInput(Data.INSTANCE.getReceiptVouchers());
		topicTreeViewer.setInput(Data.INSTANCE.getReceiptVouchers());
		
		
	}

}

