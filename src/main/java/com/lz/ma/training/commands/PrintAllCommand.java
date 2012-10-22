/**
 * 
 * 
 * Copyright (c) 2012 Ericsson (China) Communications Co.,Ltd. All rights reserved. The Copyright to the computer program(s) herein is the property of Ericsson
 * (China) Communications Co.,Ltd. The program(s) may be used and/or copied with the written permission from Ericsson AB or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.lz.ma.training.commands;

import com.lz.ma.training.AddressItem;
import com.lz.ma.training.IAddressBook;
import com.lz.ma.training.SimpleAddressBook;

/**
 * 
 * @author eliuzhe
 */
public class PrintAllCommand extends AbstractCommand {

    /**
     * @param addressBook
     */
    public PrintAllCommand(IAddressBook<AddressItem> addressBook) {
        super(addressBook);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.commands.AbstractCommand#getCmdName()
     */
    @Override
    public String getCmdName() {
        return "-p";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.commands.AbstractCommand#excute()
     */
    @Override
    public String execute(String cmdStr) {
        String ret = null;
        if (addressBook.getItemsSize() == 0) {
            ret = SimpleAddressBook.NO_ITEM_TIPS;
        } else {
            ret = addressBook.printAllItems();
        }
        return ret;
    }

}
