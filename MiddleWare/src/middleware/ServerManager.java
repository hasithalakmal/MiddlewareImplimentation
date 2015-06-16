/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

/**
 *
 * @author Massa
 */
public class ServerManager {

    private static String[] IP = new String[10];
    private static String[] port = new String[10];
    private static String[] methods = new String[10];
    private int currentConnectionNumber = 0;

    public ServerManager() {
        XMLReader xml = new XMLReader();
        xml.readXML();
        IP = xml.getIP();
        port = xml.getPort();
        methods = xml.getMethods();
    }

    public void ConnectionDetailPrinter() {
        for (int i = 0; i < IP.length; i++) {
            if (IP[i] == null) {
                break;
            }
            System.out.println("IP is =" + IP[i]);
            System.out.println("Port is =" + port[i]);
            System.out.println("Methods are =" + methods[i]);

        }
    }

    public int getNextPort() {
        int i = -5;
        if (numberofConnections() == 0) {
            System.out.println("No Connections");
        } else {
            if (currentConnectionNumber < numberofConnections()) {
                i = Integer.parseInt(port[currentConnectionNumber]);
                currentConnectionNumber++;
            } else {
                currentConnectionNumber = 0;
                i = Integer.parseInt(port[currentConnectionNumber]);
                currentConnectionNumber++;
            }
        }

        return i;
    }

    public String getNextIP() {
        int i = -5;
        String ip = "No IP";
        if (numberofConnections() == 0) {
            System.out.println("No Connections");
        } else {
            if (currentConnectionNumber < numberofConnections()) {
                ip = IP[currentConnectionNumber];
                currentConnectionNumber++;
            } else {
                currentConnectionNumber = 0;
                ip = IP[currentConnectionNumber];
                currentConnectionNumber++;
            }
        }

        return ip;
    }

    public int numberofConnections() {
        int counter = 0;
        for (int i = 0; i < IP.length; i++) {
            if (IP[i] == null) {
                break;
            }
            counter++;
        }
        return counter;
    }

    public void runMWserverThread() {
        ServerManager sm = new ServerManager();
        ClientSocketConfig csc = new ClientSocketConfig();
       while(true){
            String method = "add 1 2";
            csc.runClient5(method);
       }
    }

    
    //this main method can send some massage ang get result for that....
 /*   public static void main(String[] args) {
        ServerManager sm = new ServerManager();
        ClientSocketConfig csc = new ClientSocketConfig();
       
            String method = "add 5 2";
            String x = csc.runClient5(method);
            System.out.println(x);
            x = csc.runClient5(method);
            
            method = "sub 7 3";
            x = csc.runClient5(method);
            System.out.println(x);
            x = csc.runClient5(method);
            
            method = "mul 3 5";
            x = csc.runClient5(method);
            System.out.println(x);
            x = csc.runClient5(method);
            
            method = "div 8 2";
            x = csc.runClient5(method);
            System.out.println(x);
             x = csc.runClient5(method);
    }*/

}
