/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 *
 * @author Massa
 */
public class XMLReader {

    private static String host;
    private static String databasename;
    private static String username;
    private static String password;

    private static String[] IP = new String[10];
    private static String[] port = new String[10];
    private static String[] methods = new String[10];
    private String[] NumberOfMethods = new String[10];

    /**
     * @param args the command line arguments
     */
    /*  public static void main(String[] args) {
     XMLReader xml = new XMLReader();
     xml.readXML();
     String[] x = xml.getIP();
     String[] y = xml.getPort();
     String[] z = xml.getMethods();
     for (int i = 0; i < x.length; i++) {
     if (x[i] == null) {
     break;
     }
     System.out.println("IP is =" +x[i]);
     System.out.println("Port is =" +y[i]);
     System.out.println("Methods are =" +z[i]);

     }
        
     }*/
    public void readXML() {
        try {

            File fXmlFile = new File(".\\src\\Config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            // System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("ServerConfig");

            //   System.out.println("----------------------------");
            // System.out.println(nList.getLength());
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    /*  System.out.println("Server Name : " + eElement.getAttribute("id"));
                     System.out.println("IP : " + eElement.getElementsByTagName("IP").item(0).getTextContent());
                     System.out.println("port : " + eElement.getElementsByTagName("port").item(0).getTextContent());
                     System.out.println("Methods : " + eElement.getElementsByTagName("methods").item(0).getTextContent());  */
                    IP[temp] = eElement.getElementsByTagName("IP").item(0).getTextContent();
                    port[temp] = eElement.getElementsByTagName("port").item(0).getTextContent();
                    NumberOfMethods[temp] = eElement.getElementsByTagName("numberOfMethods").item(0).getTextContent();
                    methods[temp] = eElement.getElementsByTagName("methods").item(0).getTextContent();


                    /*    host = eElement.getElementsByTagName("host").item(0).getTextContent();
                     databasename = eElement.getElementsByTagName("databasename").item(0).getTextContent();
                     username = eElement.getElementsByTagName("username").item(0).getTextContent();
                     password = eElement.getElementsByTagName("password").item(0).getTextContent();  */
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getHost() {
        return host;
    }
    

    public String getDatabasename() {
        return databasename;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getIP() {
        return IP;
    }

    public String[] getPort() {
        return port;
    }

    public String[] getMethods() {
        return methods;
    }

    public String[] getNumberOfMethods() {
        return NumberOfMethods;
    }
    

  /*  public static void main(String[] args) {
        XMLReader xml = new XMLReader();
        ServerRouting sr = new ServerRouting();
        xml.readXML();
        String[] x = xml.getMethods();
        String[] y = xml.getNumberOfMethods();*/
     /*   for (int i = 0; i < x.length; i++) {
            if (x[i] == null) {
                break;
            }
            String[] methName = sr.getMethodNameFromXML(x[i].trim(), y[i].trim());
            sr.printArray(methName);
            System.out.println(i);
        }*/
        /*   int serverID=0;
           String[] methName = new String[Integer.parseInt(y[serverID])];
           methName = sr.getMethodNameFromXML(x[serverID].trim(), y[serverID].trim());
           sr.printArray(methName);
          
        
        

    }*/
}
