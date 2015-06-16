/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;

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
    public boolean isCreateSocket(String IPadress, int x) {
        try {
            clientSocket = new Socket(IPadress, x);
            boolean isConnected = clientSocket.isConnected();
            if (isConnected) {
                System.out.println("Client is listing on port : " + x);
                return true;
            } else {
              //  System.err.println("Client is listing on port - else: " + x);
                return false;
            }
        } catch (IOException ex) {
           // System.err.println("Client couden't listing on port - catch: " + x);
            return false;
        }
    }

    //Creating output stream 
    public boolean createOutputStream() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
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
            return "Client Error In reding";
        }
    }

    // write stream
    public void WriteServer(String msg) {
        out.println(msg);
    }

    //close input stream
    public boolean closeInputStream() {
        try {
            in.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    //close output stream
    public boolean closeOutputStream() {
        try {
            out.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    //close Socket
    public boolean closeSocket() {
        try {
            clientSocket.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String getUserInput() {
        Scanner x = new Scanner(System.in);
        String msg = x.nextLine();
        return msg;
    }

    public void runClient(String IP, int x) {
        ClientSocketConfig csc = this;
        boolean b = csc.isCreateSocket(IP, x);
        if (b) {
            csc.createinputStream();
            csc.createOutputStream();
            while (true) {
                System.out.print("Enter Your Message :");
                String msg = csc.getUserInput();
                csc.WriteServer(msg);
                if (msg.equals("bye")) {
                    break;
                }
                String msg2 = csc.ReadServer();
                System.out.println(msg2);
            }

            csc.closeInputStream();
            csc.closeOutputStream();
            csc.closeSocket();
        } else {
            System.err.println("Client Error in create connection");
        }

    }

    public void runClient2(String IP, int x) {
        ClientSocketConfig csc = this;
        boolean b = csc.isCreateSocket(IP, x);
        if (b) {
            csc.createinputStream();
            csc.createOutputStream();

            System.out.print("Enter Your Message :");
            String msg = csc.getUserInput();
            csc.WriteServer(msg);
            String msg2 = csc.ReadServer();
            System.out.println(msg2);

            csc.closeInputStream();
            csc.closeOutputStream();
            csc.closeSocket();
        } else {
            System.err.println("Error in create connection");
        }

    }

    public void runClient3(String IP, int x) {
        ClientSocketConfig csc = this;

        boolean b = csc.isCreateSocket(IP, x);
        if (b) {
            b = csc.createinputStream();
            if (b) {
                b = csc.createOutputStream();
                if (b) {
                    boolean logic = true;
                    while (logic) {
                        System.out.print("Enter Your Message :");
                        String msg = csc.getUserInput();

                        csc.WriteServer(msg);
                        if (msg.equals("bye")) {
                            logic = false;
                        } else {
                            String msg2 = csc.ReadServer();
                            if (msg2.equals("Client Error In reding")) {
                                System.err.println("rending error");
                                logic = false;
                            }
                            System.out.println(msg2);
                        }
                    }

                    b = csc.closeInputStream();
                    if (b) {
                        System.out.println("closeInputStream");
                        b = csc.closeOutputStream();
                        if (b) {
                            System.out.println("closeOutputStream");
                            b = csc.closeSocket();
                            if (b) {
                                System.out.println("Socket is closed perfectly");
                            } else {
                                System.err.println("Client Error in closeSocket()");
                            }
                        } else {
                            System.err.println("Client Error in closeOutputStream()");
                        }
                    } else {
                        System.err.println("Client Error in closeInputStream()");
                    }
                } else {
                    System.err.println("Client Error in createOutputStream()");
                }
            } else {
                System.err.println("Client Error in createinputStream()");
            }
        } else {
            System.err.println("Client Error in isCreateSocket()");
        }

    }

    public void runClient4(String IP, int x, String caller) {
        ClientSocketConfig csc = this;
        ServerRouting sr = new ServerRouting();
        String route = sr.MethodRouter(caller);
        String IPAdress;
        int PortNumber;
        boolean b = csc.isCreateSocket(IP, x);
        if (b) {
            b = csc.createinputStream();
            if (b) {
                b = csc.createOutputStream();
                if (b) {
                    boolean logic = true;
                    while (logic) {
                        //  System.out.print("Enter Your Message :");
                        String msg = route;
                        if (msg == null || msg.equals("Number Of Arguments are not correct")) {
                            System.err.println("Your message is noi a valid massage");
                            logic = false;
                        } else {

                            IPAdress = sr.getValueFromArray(route, 0);
                            PortNumber = Integer.parseInt(sr.getValueFromArray(route, 1));

                            if (PortNumber == x) {
                                csc.WriteServer(caller);
                            } else {
                                csc.WriteServer("bye");
                                logic = false;
                            }
                            String msg2 = csc.ReadServer();
                            if (msg2.equals("Client Error In reding")) {
                                System.err.println("rending error");
                                logic = false;
                            }
                            System.out.println(msg2);
                        }
                    }

                    b = csc.closeInputStream();
                    if (b) {
                        System.out.println("closeInputStream");
                        b = csc.closeOutputStream();
                        if (b) {
                            System.out.println("closeOutputStream");
                            b = csc.closeSocket();
                            if (b) {
                                System.out.println("Socket is closed perfectly");
                            } else {
                                System.err.println("Client Error in closeSocket()");
                            }
                        } else {
                            System.err.println("Client Error in closeOutputStream()");
                        }
                    } else {
                        System.err.println("Client Error in closeInputStream()");
                    }
                } else {
                    System.err.println("Client Error in createOutputStream()");
                }
            } else {
                System.err.println("Client Error in createinputStream()");
            }
        } else {
            System.err.println("Client Error in isCreateSocket()");
        }

    }

    public String runClient5(String caller) {
        ClientSocketConfig csc = this;
        ServerRouting sr = new ServerRouting();
        String route = sr.MethodRouter(caller);
        //System.out.println(route);
        String msg = route;
        String responce="";
        if (msg == null || msg.equals("Number Of Arguments are not correct")) {
            responce = "Your message is noi a valid massage";
            System.err.println("Your message is not a valid massage");
        } else {
            String IPAdress;
            int PortNumber;
            IPAdress = sr.getValueFromArray(route, 0);
            PortNumber = Integer.parseInt(sr.getValueFromArray(route, 1));
           // System.out.println("IP = "+ IPAdress+" Port = "+PortNumber);
            boolean b = csc.isCreateSocket("127.0.0.1", PortNumber);
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
        }
        
        return responce;
    }
}
