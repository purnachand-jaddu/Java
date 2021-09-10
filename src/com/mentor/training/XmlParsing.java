package com.mentor.training;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;

public class XmlParsing
{

    public static void main(String[] args)
    {
        try {
            /*Reading a file*/
            File file = new File("/Users/pjaddu/Desktop/AssetsGods/v2 components for symbol ids.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document libraryParts = dBuilder.parse(file);

            File oldSymbolsFile = new File("/Users/pjaddu/Desktop/AssetsGods/IEC version-2 Symbol Library merged library.xml");
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document oldSymbolsDocument = builder.parse(oldSymbolsFile);
            NodeList oldSymbolList = oldSymbolsDocument.getElementsByTagName("symbol");
            int oldSymbolLength = oldSymbolList.getLength();

            FileWriter writer = new FileWriter("/Users/pjaddu/Desktop/FileToBeWritten.xml");

            NodeList libraryGraphic = libraryParts.getElementsByTagName("librarygraphic");
            for (int i = 0; i < libraryGraphic.getLength(); i++) {
                Node item = libraryGraphic.item(i);
                Node symbol_id = item.getAttributes().getNamedItem("symbol_id");
                String textContent = symbol_id.getTextContent();
                for (int j = 0; j < oldSymbolLength; j++) {
                    String id = oldSymbolList.item(j).getAttributes().getNamedItem("id").getTextContent();
                    if (id.equals(textContent)) {
                        String name = oldSymbolList.item(j).getAttributes().getNamedItem("name").getTextContent();
                        writer.append(name);
                        writer.append("\n");
                        break;
                    }
                }

            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Really??");
        }
    }
}
