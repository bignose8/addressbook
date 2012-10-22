/**
 * 
 * 
 * Copyright (c) 2012 Ericsson (China) Communications Co.,Ltd. All rights reserved. The Copyright to the computer program(s) herein is the property of Ericsson
 * (China) Communications Co.,Ltd. The program(s) may be used and/or copied with the written permission from Ericsson AB or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.lz.ma.training.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.lz.ma.training.commands.LookupByNumberCommand;

/**
 * 
 * @author eliuzhe
 */
public class LookupByNumberCommandTest extends AbstractCommandTest {
    private LookupByNumberCommand cmd = new LookupByNumberCommand(addressBook);

    /**
     * Test method for {@link com.lz.ma.training.commands.LookupByNumberCommand#getCmdName()}.
     */
    @Test
    public void testGetCmdName() {
        assertEquals("lookup getname", "-l", cmd.getCmdName());
    }

    /**
     * Test method for {@link com.lz.ma.training.commands.LookupByNumberCommand#execute(java.lang.String)}.
     */
    @Test
    public void testExecute() {
        assertEquals("LookuptemByNumber execute", "The look up result is AddressItem [name=name, address=address, phoneNumber=12345]", cmd.execute(NUMBER));
        assertEquals("LookuptemByNumber execute", "Cannot look up an item with phone number 111", cmd.execute("111"));
    }

}
