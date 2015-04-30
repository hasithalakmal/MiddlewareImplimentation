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
public class MyServer {

    public static void main(String[] args) {
        ServerSocketConfig ssc = new ServerSocketConfig();
        while (true) {
            ssc.runserver(8880);
            ssc.runserver(8881);
            ssc.runserver(8882);
            ssc.runserver(8883);
            ssc.runserver(8884);
        }

    }

}
