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
import com.lz.ma.training.XMLUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author eliuzhe
 */
public class ReadCommand extends AbstractCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadCommand.class);
    /**
     * @param addressBook
     */
    public ReadCommand(IAddressBook<AddressItem> addressBook) {
        super(addressBook);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.commands.AbstractCommand#getCmdName()
     */
    @Override
    public String getCmdName() {
        return "-r";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.commands.AbstractCommand#execute(java.lang.String)
     */
    @Override
    public String execute(String cmdStr) {
        try {
            XMLUtil.loadAddressBook((SimpleAddressBook) addressBook);
        } catch (Exception e) {
            /**
             * Too many unnecessary exception so I combine into one
             */
            LOGGER.info("read xml file error!");
        }
        return "address book is read from xml file successfully";
    }

}
