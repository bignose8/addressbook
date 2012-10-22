/**
 * 
 * 
 * Copyright (c) 2012 Ericsson (China) Communications Co.,Ltd. All rights reserved. The Copyright to the computer program(s) herein is the property of Ericsson
 * (China) Communications Co.,Ltd. The program(s) may be used and/or copied with the written permission from Ericsson AB or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.lz.ma.training;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.lz.ma.training.AddressItem;
import com.lz.ma.training.SimpleAddressBook;
import com.lz.ma.training.XMLUtil;

/**
 * 
 * @author eliuzhe
 */
public class XMLUtilTest {
    private void twoFileContentIsSameTest(InputStream src, InputStream wanted) throws IOException {
        BufferedReader readerTest = new BufferedReader(new InputStreamReader(src));
        BufferedReader readerWanted = new BufferedReader(new InputStreamReader(wanted));
        while (readerTest.ready()) {
            assertEquals("output result wrong", readerWanted.readLine(), readerTest.readLine());
        }
        readerTest.close();
    }

    /**
     * Test method for {@link com.lz.ma.training.XMLUtil#saveAddressBook(com.lz.ma.training.SimpleAddressBook)}.
     * 
     * @throws TransformerException
     * @throws TransformerFactoryConfigurationError
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws TransformerConfigurationException
     */
    @Test
    public void testSaveAddressBook() throws TransformerConfigurationException, ParserConfigurationException, IOException,
            TransformerFactoryConfigurationError, TransformerException {
        SimpleAddressBook book = new SimpleAddressBook();
        book.intertItem(new AddressItem("name1", "aaa1", "111"));
        XMLUtil.saveAddressBook(book);
        twoFileContentIsSameTest(new FileInputStream(XMLUtil.XML_FILE), XMLUtilTest.class.getResourceAsStream("/addressbooktestsave.xml"));
    }

    /**
     * Test method for {@link com.lz.ma.training.XMLUtil#loadAddressBook()}.
     * @throws TransformerException 
     * @throws TransformerFactoryConfigurationError 
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     * @throws TransformerConfigurationException 
     */
    @Test
    public void testLoadAddressBook() throws TransformerConfigurationException, ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
        SimpleAddressBook book = new SimpleAddressBook();
        XMLUtil.loadAddressBook(book);
        assertEquals("test load addressbook", "aaa1",book.list.get(0).getAddress());
        assertEquals("test load addressbook", "name1",book.list.get(0).getName());
        assertEquals("test load addressbook", "111",book.list.get(0).getPhoneNumber());
    }
    
    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDwon() throws Exception {
        File file = new File(XMLUtil.XML_FILE);
        if (file.exists()) {
            file.deleteOnExit();
        }
    }
}
