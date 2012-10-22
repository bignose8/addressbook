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

import com.lz.ma.training.SimpleAddressBook;
import com.lz.ma.training.commands.QuitCommand;

/**
 * 
 * @author eliuzhe
 */
public class QuitCommandTest  extends AbstractCommandTest{
    private QuitCommand cmd = new QuitCommand(addressBook);
    /**
     * Test method for {@link com.lz.ma.training.commands.QuitCommand#getCmdName()}.
     */
    @Test
    public void testGetCmdName() {
        assertEquals("quit getname", "-q", cmd.getCmdName());
    }

    /**
     * Test method for {@link com.lz.ma.training.commands.QuitCommand#execute(java.lang.String)}.
     */
    @Test
    public void testExecute() {
        assertEquals("quit execute", SimpleAddressBook.QUIT, cmd.execute(""));
    }

}
