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

import com.lz.ma.training.commands.DeleteByNameCommand;

/**
 * 
 * @author eliuzhe
 */
public class DeleteByNameCommandTest extends AbstractCommandTest {

    private DeleteByNameCommand cmd = new DeleteByNameCommand(addressBook);

    /**
     * Test method for {@link com.lz.ma.training.commands.DeleteByNameCommand#getCmdName()}.
     */
    @Test
    public void testGetCmdName() {
        assertEquals("delete getname", "-D", cmd.getCmdName());
    }

    /**
     * Test method for {@link com.lz.ma.training.commands.DeleteByNameCommand#execute(java.lang.String)}.
     */
    @Test
    public void testExecute() {
        assertEquals("delete execute", "One item AddressItem [name=name, address=address, phoneNumber=12345]is deleted successfully", cmd.execute(NAME));
        assertEquals("delete execute", "Cannot find an item with name 111", cmd.execute("111"));
    }

}
