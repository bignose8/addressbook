/**
 * 
 * 
 * Copyright (c) 2012 Ericsson (China) Communications Co.,Ltd. All rights reserved. The Copyright to the computer program(s) herein is the property of Ericsson
 * (China) Communications Co.,Ltd. The program(s) may be used and/or copied with the written permission from Ericsson AB or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.lz.ma.training;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.lz.ma.training.AddressItem;

/**
 * 
 * @author eliuzhe
 */
public class AddressItemTest {
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String NUMBER = "12345";
    public AddressItem addressItem;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        addressItem = new AddressItem(NAME, ADDRESS, NUMBER);
    }

    /**
     * Test method for {@link com.lz.ma.training.AddressItem#getName()}.
     */
    @Test
    public void testGetName() {
        assertEquals("getName wrong", NAME, addressItem.getName());
    }

    /**
     * Test method for {@link com.lz.ma.training.AddressItem#setName(java.lang.String)}.
     */
    @Test
    public void testSetName() {
        addressItem.setName("name1");
        assertEquals("setName wrong", "name1", addressItem.getName());
    }

    /**
     * Test method for {@link com.lz.ma.training.AddressItem#getAddress()}.
     */
    @Test
    public void testGetAddress() {
        assertEquals("getAddress wrong", ADDRESS, addressItem.getAddress());
    }

    /**
     * Test method for {@link com.lz.ma.training.AddressItem#setAddress(java.lang.String)}.
     */
    @Test
    public void testSetAddress() {
        addressItem.setAddress("address1");
        assertEquals("setAddress wrong", "address1", addressItem.getAddress());
    }

    /**
     * Test method for {@link com.lz.ma.training.AddressItem#getPhoneNumber()}.
     */
    @Test
    public void testGetPhoneNumber() {
        assertEquals("getPhoneNumber wrong", NUMBER, addressItem.getPhoneNumber());
    }

    /**
     * Test method for {@link com.lz.ma.training.AddressItem#setPhoneNumber(java.lang.String)}.
     */
    @Test
    public void testSetPhoneNumber() {
        addressItem.setPhoneNumber("111");
        assertEquals("setPhoneNumber wrong", "111", addressItem.getPhoneNumber());
    }

    /**
     * Test method for {@link com.lz.ma.training.AddressItem#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("toString wrong", "AddressItem [name=name, address=address, phoneNumber=12345]", addressItem.toString());
    }
}
