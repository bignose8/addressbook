/**
 * 
 * 
 * Copyright (c) 2012 Ericsson (China) Communications Co.,Ltd. All rights reserved. The Copyright to the computer program(s) herein is the property of Ericsson
 * (China) Communications Co.,Ltd. The program(s) may be used and/or copied with the written permission from Ericsson AB or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.lz.ma.training;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;

import com.lz.ma.training.AddressItem;
import com.lz.ma.training.SimpleAddressBook;

/**
 * 
 * @author eliuzhe
 */
public class SimpleAddressBookTest {
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String NUMBER = "12345";

    private SimpleAddressBook addressBook;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        addressBook = new SimpleAddressBook();
        addressBook.intertItem(new AddressItem(NAME, ADDRESS, NUMBER));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#lookupByName(java.lang.String)}.
     */
    @Test
    public void testLookupByName() {
        assertNotNull("lookupByname wrong", addressBook.lookupByName(NAME));
        assertNull("lookupByname wrong", addressBook.lookupByName("111"));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#lookupByNumber(java.lang.String)}.
     */
    @Test
    public void testLookupByNumber() {
        assertNotNull("lookupByNumber wrong", addressBook.lookupByNumber(NUMBER));
        assertNull("lookupByNumber", addressBook.lookupByNumber("aaa"));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#intertItem(com.lz.ma.training.AddressItem)}.
     */
    @Test
    public void testIntertItem() {
        addressBook.intertItem(new AddressItem("name2", "address2", "number2"));
        assertNotNull("insertItem wrong", addressBook.lookupByNumber("number2"));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#deleteItemByName(java.lang.String)}.
     */
    @Test
    public void testDeleteItemByName() {
        assertNull("deleteItemByName", addressBook.deleteItemByName("111"));
        addressBook.deleteItemByName(NAME);
        assertNull("deleteItemByName", addressBook.lookupByName(NAME));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#deleteItemByNumber(java.lang.String)}.
     */
    @Test
    public void testDeleteItemByNumber() {
        assertNull("deleteItemByNumber", addressBook.deleteItemByNumber("111"));
        addressBook.deleteItemByNumber(NUMBER);
        assertNull("deleteItemByNumber", addressBook.lookupByNumber(NUMBER));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#handleLogic(java.lang.String)}.
     * 
     * @throws Exception
     */
    @Test
    public void testHandleLogicHelp() throws IndexOutOfBoundsException {
        assertEquals("handleLogicHelp branch error", SimpleAddressBook.COPYRIGHTS + "\n" + SimpleAddressBook.HELP, addressBook.handleLogic("-h"));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#handleLogic(java.lang.String)}.
     * 
     * @throws Exception
     */
    @Test
    public void testHandleLogicPrint() throws IndexOutOfBoundsException {
        assertEquals("handleLogicPrint branch error", SimpleAddressBook.NO_ITEM_TIPS, new SimpleAddressBook().handleLogic("-p"));
        assertEquals("handleLogicPrint branch error", "AddressItem [name=name, address=address, phoneNumber=12345]\n", addressBook.handleLogic("-p"));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#handleLogic(java.lang.String)}.
     * 
     * @throws Exception
     */
    @Test
    public void testHandleLogicInsertItem() throws IndexOutOfBoundsException {
        assertEquals("HandleLogicInsertItem branch error", "One item is inserted successfully", addressBook.handleLogic("-i newname,newaddress,newnumber"));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#handleLogic(java.lang.String)}.
     * 
     * @throws Exception
     */
    @Test
    public void testHandleLogicDeleteItemByName() throws IndexOutOfBoundsException {
        assertEquals("HandleLogicDeleteItemByName branch error", "One item AddressItem [name=name, address=address, phoneNumber=12345]is deleted successfully",
                addressBook.handleLogic("-D " + NAME));
        assertEquals("HandleLogicDeleteItemByName branch error", "Cannot find an item with name 111", addressBook.handleLogic("-D 111"));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#handleLogic(java.lang.String)}.
     * 
     * @throws Exception
     */
    @Test
    public void testHandleLogicDeleteItemByNumber() throws IndexOutOfBoundsException {
        assertEquals("HandleLogicDeleteItemByNumber branch error",
                "One item AddressItem [name=name, address=address, phoneNumber=12345]is deleted successfully", addressBook.handleLogic("-d " + NUMBER));
        assertEquals("HandleLogicDeleteItemByNumber branch error", "Cannot find an item with phone number 111", addressBook.handleLogic("-d 111"));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#handleLogic(java.lang.String)}.
     * 
     * @throws Exception
     */
    @Test
    public void testHandleLogicLookuptemByName() throws IndexOutOfBoundsException {
        assertEquals("HandleLogicLookuptemByName branch error", "The look up result is AddressItem [name=name, address=address, phoneNumber=12345]",
                addressBook.handleLogic("-L " + NAME));
        assertEquals("HandleLogicLookuptemByName branch error", "Cannot look up an item with name 111", addressBook.handleLogic("-L 111"));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#handleLogic(java.lang.String)}.
     * 
     * @throws Exception
     */
    @Test
    public void testHandleLogicLookuptemByNumber() throws IndexOutOfBoundsException {
        assertEquals("HandleLogicLookuptemByNumber branch error", "The look up result is AddressItem [name=name, address=address, phoneNumber=12345]",
                addressBook.handleLogic("-l " + NUMBER));
        assertEquals("HandleLogicLookuptemByNumber branch error", "Cannot look up an item with phone number 111", addressBook.handleLogic("-l 111"));
    }

    /**
     * Test method for {@link com.lz.ma.training.SimpleAddressBook#run()}.
     * <p>
     * Test whether the output is correct, the input ,wanted output and actual output are stored in a file so it's easy to extend
     * 
     * @throws ExecutionException
     * @throws InterruptedException
     * 
     * @throws Exception
     */
    @Test
    public void testRun() throws IOException, InterruptedException, ExecutionException {
        File file = new File("testoutput.txt");
        PrintStream ps = new PrintStream(file);
        addressBook.run(SimpleAddressBook.class.getResourceAsStream("/input.txt"), ps);
        ps.close();
        BufferedReader readerTest = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        BufferedReader readerWanted = new BufferedReader(new InputStreamReader(SimpleAddressBook.class.getResourceAsStream("/outputwanted.txt")));
        while (readerTest.ready()) {
            assertEquals("output result wrong", readerWanted.readLine(), readerTest.readLine());
        }
        readerTest.close();
        file.deleteOnExit();
    }
}
