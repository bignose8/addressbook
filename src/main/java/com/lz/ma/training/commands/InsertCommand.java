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
public class InsertCommand extends AbstractCommand {

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.commands.AbstractCommand#getCmdName()
     */
    @Override
    public String getCmdName() {
        return "-i";
    }

    /**
     * @param addressBook
     */
    public InsertCommand(IAddressBook<AddressItem> addressBook) {
        super(addressBook);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.commands.AbstractCommand#excute()
     */
    @Override
    public String execute(String cmdStr) {
        String[] strs = cmdStr.split(",");
        addressBook.intertItem(new AddressItem(strs[0], strs[1], strs[2]));
        return "One item is inserted successfully";
    }

}
