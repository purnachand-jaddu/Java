package com.mentor.training;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

//plugin to check block names abc to abc(symbol name) && abc1 to abc(symbol name) and update its symbol ID's
public class BlockModifications
{
    private static String removeLastCharacter(String str)
    {
        String result = null;
        if ((str != null) && (str.length() > 0))
        {
            result = str.substring(0, str.length() - 1);
        }
        return result;
    }

    public static void main(String[] args)
    {
        try
        {
            /*Reading a file*/
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();


            File newSymbolsFile = new File("/Users/pjaddu/Desktop/AssetGods/BlockModifications.xml");
            DocumentBuilder newSymbolDocumentBuilder = dbFactory.newDocumentBuilder();
            Document updatedFile = newSymbolDocumentBuilder.parse(newSymbolsFile);
            NodeList newSymbolList = updatedFile.getElementsByTagName("symbol");
            NodeList newBlockList = updatedFile.getElementsByTagName("block");
            int newSymbolLength = newSymbolList.getLength();
            int newBlockLength = newBlockList.getLength();


            for (int j = 0; j < newBlockLength; j++)
            {
                Node block = newBlockList.item(j);
                Node currentBlock = block.getAttributes().getNamedItem("name");
                String currentBlockName = currentBlock.getNodeName();
                NodeList childList = block.getChildNodes();
                int childLength = childList.getLength();
                Node nodeToBeChanged = null;
                for (int i = 0; i < childLength; i++)
                {
                    Node child = childList.item(i);
                    if ("symbolref".equals(child.getNodeName()))
                    {
                        nodeToBeChanged = child;
                        break;
                    }
                }
                if (nodeToBeChanged != null)
                {
                    for (int i = 0; i < newSymbolLength; i++)
                    {
                        String lastRemovedFromCurrentBlockName = removeLastCharacter(currentBlockName);
                        Node symbol = newSymbolList.item(i);
                        String symbolId = symbol.getAttributes().getNamedItem("id").getNodeValue();
                        if (symbol.getNodeName().equalsIgnoreCase(currentBlockName) || symbol.getNodeName().equalsIgnoreCase(lastRemovedFromCurrentBlockName))
                        {
                            nodeToBeChanged.getAttributes().getNamedItem("symbol").setNodeValue(symbolId);
                            break;
                        }
                    }
                }
//                    for(int k=0;k<childList.getLength();k++)
//                    {
//                        if(childList.item(k).getNodeName().equalsIgnoreCase("symbolref")) {
//                            String SymbolRefname = searchedSymbolName.getNodeValue();
//                            for(int l=3;l>=0;l--)
//                            {
//                                String newSymbolRefname=removeLastCharacter(SymbolRefname);
//                                for(int i=0;i<newSymbolLength;i++)
//                                {
//                                    Node id = newSymbolList.item(i).getAttributes().getNamedItem("id");
//                                if((newSymbolRefname.equalsIgnoreCase(newSymbolList.item(i).getAttributes().getNamedItem("name").getNodeValue()))||SymbolRefname.equalsIgnoreCase(newSymbolList.item(i).getAttributes().getNamedItem("name").getNodeValue()))
//                                {
//                                    childList.item(k).getAttributes().getNamedItem("symbol").setNodeValue(id.getNodeValue());
//                                    break;
//                                }
//
//                            }
//							 SymbolRefname = newSymbolRefname;
//
//
//                        }
//                    }
//                }
            }



            /* Creating a new File from updated attributes*/
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(updatedFile);
            StreamResult streamResult = new StreamResult(new File("/Users/pjaddu/Desktop/AssetGods/ModifiedBlockUIDS.xml"));
            transformer.transform(domSource, streamResult);


        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Really??");
        }
    }
}
