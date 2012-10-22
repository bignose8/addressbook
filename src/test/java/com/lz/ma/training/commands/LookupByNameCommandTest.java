/**
 * 
 * 
 * Copyright (c) 2012 Ericsson (China) Communications Co.,Ltd. All rights reserved. The Copyright to the computer program(s) herein is the property of Ericsson
 * (China) Communications Co.,Ltd. The program(s) may be used and/or copied with the written permission from Ericsson AB or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.lz.ma.training.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lz.ma.training.commands.LookupByNameCommand;

/**
 * 
 * @author eliuzhe
 */
public class LookupByNameCommandTest extends AbstractCommandTest{
    private LookupByNameCommand cmd = new  LookupByNameCommand(addressBook);
    /**
     * Test method for {@link com.lz.ma.training.commands.LookupByNameCommand#getCmdName()}.
     */
    @Test
    public void testGetCmdName() {
        assertEquals("lookup getname", "-L", cmd.getCmdName());
    }

    /**
     * Test method for {@link com.lz.ma.training.commands.LookupByNameCommand#execute(java.lang.String)}.
     */
    @Test
    public void testExecute() {
        assertEquals("LookuptemByName execute", "The look up result is AddressItem [name=name, address=address, phoneNumber=12345]",
                cmd.execute(NAME));
        assertEquals("LookuptemByName execute", "Cannot look up an item with name 111", cmd.execute("111"));
    }

}
