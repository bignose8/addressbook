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
public abstract class AbstractCommand {
    /**
     * 
     * @return the command name such as -q -h
     */
    abstract public String getCmdName();

    /**
     * 
     * @param cmdStr
     * @return the result after execution
     */
    abstract public String execute(String cmdStr);

    protected IAddressBook<AddressItem> addressBook;

    public AbstractCommand(IAddressBook<AddressItem> addressBook) {
        super();
        this.addressBook = addressBook;
    }
}
