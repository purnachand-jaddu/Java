package com.mentor.training.xmlparsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler
{
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        System.out.println(qName);
    }
}
