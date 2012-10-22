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

import com.lz.ma.training.commands.DeleteByNumberCommand;

/**
 * 
 * @author eliuzhe
 */
public class DeleteByNumberCommandTest  extends AbstractCommandTest{

    private DeleteByNumberCommand cmd = new DeleteByNumberCommand(addressBook);
    
    /**
     * Test method for {@link com.lz.ma.training.commands.DeleteByNumberCommand#getCmdName()}.
     */
    @Test
    public void testGetCmdName() {
        assertEquals("delete getname", "-d",cmd.getCmdName());
    }

    /**
     * Test method for {@link com.lz.ma.training.commands.DeleteByNumberCommand#execute(java.lang.String)}.
     */
    @Test
    public void testExecute() {
        assertEquals("delete execute", "One item AddressItem [name=name, address=address, phoneNumber=12345]is deleted successfully",cmd.execute(NUMBER));
        assertEquals("delete execute", "Cannot find an item with phone number 111",cmd.execute("111"));
    }

}
