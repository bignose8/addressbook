/**
 * 
 * 
 * Copyright (c) 2012 Ericsson (China) Communications Co.,Ltd. All rights reserved. The Copyright to the computer program(s) herein is the property of Ericsson
 * (China) Communications Co.,Ltd. The program(s) may be used and/or copied with the written permission from Ericsson AB or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.lz.ma.training.commands;

import com.lz.ma.training.AddressItem;
import com.lz.ma.training.IAddressBook;
import com.lz.ma.training.SimpleAddressBook;

/**
 * 
 * @author eliuzhe
 */
public class AbstractCommandTest {
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String NUMBER = "12345";
    protected IAddressBook<AddressItem> addressBook = new SimpleAddressBook();

    AbstractCommandTest() {
        addressBook.intertItem(new AddressItem(NAME, ADDRESS, NUMBER));
    }
}
