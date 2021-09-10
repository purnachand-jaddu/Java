package com.mentor.training.xmlparsing;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class MainClass
{

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        File file=new File("C:\\Users\\pjaddu\\Desktop\\Others\\CodeFormat.xml");
        saxParser.parse(file,new MyHandler());
    }
}
