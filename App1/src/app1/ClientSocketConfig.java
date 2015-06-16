/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Massa
 */
public class ClientSocketConfig {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
      
    //create socket
    public boolean isCreateSocket(String IPadress,int x) {
        try {
            clientSocket = new Socket(IPadress,x);
            System.err.println("Server is listing on port : " + x);
            return true;
        } catch (IOException ex) {
           // System.err.println("Server couden't listing on port : " + x);
            return false;
        }
    }
    
    //Creating output stream 
    public boolean createOutputStream() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(),true);
           // System.out.println("Create outpot stream");
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    //Creating input stream 
    public boolean createinputStream() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //System.out.println("Create outpot stream");
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    // read stream
    public String ReadServer() {
        try {
            String s = in.readLine();
            return s;
        } catch (IOException ex) {
            return "Error In reding";
        }
    }

    // write stream
    public void WriteServer(String msg) {
            out.println(msg); 
    }
    
    //close input stream
    public boolean closeInputStream(){
        try {
            in.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    //close output stream
    public boolean closeOutputStream(){
        try {
            out.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    //close Socket
    public boolean closeSocket(){
        try {
            clientSocket.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public String getUserInput(){
        Scanner x = new Scanner(System.in);
        String msg = x.nextLine();
        return msg;
    }
    
    public void runClient(String IP,int x){
        ClientSocketConfig csc = this;
        boolean b = csc.isCreateSocket(IP,x);
        if(b){
            csc.createinputStream();
            csc.createOutputStream();
            while(true){
                System.out.print("Enter Your Message :");
                String msg =csc.getUserInput();
                csc.WriteServer(msg);
                if(msg.equals("bye")){
                    break;
                }
                String msg2 = csc.ReadServer();
                System.out.println(msg2);
            }
            
            csc.closeInputStream();
            csc.closeOutputStream();
            csc.closeSocket();
        }else{
            System.err.println("Error in create connection");
        }
        
    }
    
    public String runClient5(String IP,int port,String caller) {
        ClientSocketConfig csc = this;
        String responce="";
       
            String IPAdress = IP;
            int PortNumber = port;
           
            boolean b = csc.isCreateSocket(IPAdress, PortNumber);
            if (b) {
                b = csc.createinputStream();
                if (b) {
                    b = csc.createOutputStream();
                    if (b) {
                        //function starts from hear......
                       // System.out.println("Enter to coding area....");
                        csc.WriteServer(caller);
                        responce = csc.ReadServer();
                       // System.out.println("leving from coding area....");
                        //function ends from hear
                        b = csc.closeInputStream();
                        if (b) {
                           // System.out.println("closeInputStream");
                            b = csc.closeOutputStream();
                            if (b) {
                                //System.out.println("closeOutputStream");
                                b = csc.closeSocket();
                                if (b) {
                                   // System.out.println("Socket is closed perfectly");
                                } else {
                                   // System.err.println("Client Error in closeSocket()");
                                }
                            } else {
                               // System.err.println("Client Error in closeOutputStream()");
                            }
                        } else {
                           // System.err.println("Client Error in closeInputStream()");
                        }
                    } else {
                       // System.err.println("Client Error in createOutputStream()");
                    }
                } else {
                  //  System.err.println("Client Error in createinputStream()");
                }
            } else {
               // System.err.println("Client Error in isCreateSocket()");
            }
        
        
        return responce;
    }
}
