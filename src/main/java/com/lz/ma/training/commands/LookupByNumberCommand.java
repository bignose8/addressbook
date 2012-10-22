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
public class LookupByNumberCommand extends AbstractCommand {

    /**
     * @param addressBook
     */
    public LookupByNumberCommand(IAddressBook<AddressItem> addressBook) {
        super(addressBook);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.commands.AbstractCommand#getCmdName()
     */
    @Override
    public String getCmdName() {
        return "-l";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.commands.AbstractCommand#excute(java.lang.String)
     */
    @Override
    public String execute(String cmdStr) {
        String ret = null;
        AddressItem result = addressBook.lookupByNumber(cmdStr);
        if (null != result) {
            ret = "The look up result is " + result;
        } else {
            ret = "Cannot look up an item with phone number " + cmdStr;
        }
        return ret;
    }

}
