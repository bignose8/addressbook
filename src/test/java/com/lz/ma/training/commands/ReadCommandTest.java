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

import com.lz.ma.training.commands.ReadCommand;

/**
 * 
 * @author eliuzhe
 */
public class ReadCommandTest extends AbstractCommandTest {
    private ReadCommand cmd = new ReadCommand(addressBook);

    /**
     * Test method for {@link com.lz.ma.training.commands.ReadCommand#getCmdName()}.
     */
    @Test
    public void testGetCmdName() {
        assertEquals("read xml getname", "-r", cmd.getCmdName());
    }

    /**
     * Test method for {@link com.lz.ma.training.commands.ReadCommand#execute(java.lang.String)}.
     */
    @Test
    public void testExecute() {
        assertEquals("read xml execute", "address book is read from xml file successfully", cmd.execute(""));
    }

}
