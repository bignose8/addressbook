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

/**
 * 
 * @author eliuzhe
 */
public class DeleteByNameCommand extends AbstractCommand {

    /**
     * @param addressBook
     */
    public DeleteByNameCommand(IAddressBook<AddressItem> addressBook) {
        super(addressBook);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.commands.AbstractCommand#getCmdName()
     */
    @Override
    public String getCmdName() {
        return "-D";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.commands.AbstractCommand#excute(java.lang.String)
     */
    @Override
    public String execute(String cmdStr) {
        String ret = null;
        AddressItem item = addressBook.deleteItemByName(cmdStr);
        if (null != item) {
            ret = "One item " + item + "is deleted successfully";
        } else {
            ret = "Cannot find an item with name " + cmdStr;
        }
        return ret;
    }

}
