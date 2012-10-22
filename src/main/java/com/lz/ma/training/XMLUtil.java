package com.lz.ma.training;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author eliuzhe
 */
public class XMLUtil {
    public static final String XML_FILE = "addressbook.xml";

    /**
     * 
     * @param addressBook
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws TransformerConfigurationException
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerException
     */
    public static void saveAddressBook(SimpleAddressBook addressBook) throws ParserConfigurationException, IOException, TransformerConfigurationException,
            TransformerFactoryConfigurationError, TransformerException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement("addressbook");
        List<AddressItem> list = addressBook.list;
        for (Iterator<AddressItem> iterator = list.iterator(); iterator.hasNext();) {
            AddressItem addressItem = iterator.next();
            Element item = doc.createElement("item");
            Element name = doc.createElement("name");
            name.setTextContent(addressItem.getName());
            item.appendChild(name);
            Element address = doc.createElement("address");
            address.setTextContent(addressItem.getAddress());
            item.appendChild(address);
            Element number = doc.createElement("number");
            number.setTextContent(addressItem.getPhoneNumber());
            item.appendChild(number);
            root.appendChild(item);
        }
        doc.appendChild(root);
        outputXML(doc, new FileOutputStream(XML_FILE));
    }

    /**
     * 
     * @return the addressbook from xml file
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws TransformerConfigurationException
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerException
     */
    public static void  loadAddressBook(SimpleAddressBook book) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException,
            TransformerFactoryConfigurationError, TransformerException {
        book.list.clear();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(XML_FILE);
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getElementsByTagName("item");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element e = (Element) nodeList.item(i);
            String name = e.getElementsByTagName("name").item(0).getTextContent();
            String addr = e.getElementsByTagName("address").item(0).getTextContent();
            String number = e.getElementsByTagName("number").item(0).getTextContent();
            book.intertItem(new AddressItem(name, addr, number));
        }
    }

    /**
     * @param document
     * @throws TransformerConfigurationException
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerException
     * @throws IOException
     */
    private static void outputXML(Document document, OutputStream out) throws TransformerConfigurationException, TransformerFactoryConfigurationError,
            TransformerException, IOException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new StringWriter());
        transformer.transform(source, result);
        out.write(result.getWriter().toString().getBytes());
    }
}
