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

import com.lz.ma.training.commands.SaveCommand;

/**
 * 
 * @author eliuzhe
 */
public class SaveCommandTest extends AbstractCommandTest {
    private SaveCommand cmd = new SaveCommand(addressBook);

    /**
     * Test method for {@link com.lz.ma.training.commands.SaveCommand#getCmdName()}.
     */
    @Test
    public void testGetCmdName() {
        assertEquals("save xml getname", "-s", cmd.getCmdName());
    }

    /**
     * Test method for {@link com.lz.ma.training.commands.SaveCommand#execute(java.lang.String)}.
     */
    @Test
    public void testExecute() {
        assertEquals("save xml execute", "the addressbook is saved in addressbook.xml", cmd.execute(""));
    }

}
