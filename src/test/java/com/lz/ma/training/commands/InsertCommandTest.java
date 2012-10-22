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

import com.lz.ma.training.commands.InsertCommand;

/**
 * 
 * @author eliuzhe
 */
public class InsertCommandTest extends AbstractCommandTest{
    private InsertCommand cmd = new InsertCommand(addressBook);
    /**
     * Test method for {@link com.lz.ma.training.commands.InsertCommand#getCmdName()}.
     */
    @Test
    public void testGetCmdName() {
        assertEquals("insert getname", "-i", cmd.getCmdName());
    }

    /**
     * Test method for {@link com.lz.ma.training.commands.InsertCommand#execute(java.lang.String)}.
     */
    @Test
    public void testExecute() {
        assertEquals("InsertItem execute", "One item is inserted successfully", cmd.execute("newname,newaddress,newnumber"));
    }

}
