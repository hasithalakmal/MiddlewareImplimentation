/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1;

/**
 *
 * @author Massa
 */
public class MyClient {
    public static void main(String[] args) {
        ClientSocketConfig csc = new ClientSocketConfig();
        while(true){
        csc.runClient("127.0.0.1",8884);
        csc.runClient("127.0.0.2", 8883);
        csc.runClient("127.0.0.3", 8882);
        csc.runClient("127.0.0.3", 8881);
        csc.runClient("127.0.0.3", 8880);
        }
    }
}
