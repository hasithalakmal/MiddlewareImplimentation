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
       
           String x = csc.runClient5("127.0.0.1", 9876,"add 5 6");
           System.out.println(x);
           x = csc.runClient5("127.0.0.1", 9876,"add 5 6");
           
           x = csc.runClient5("127.0.0.1", 9876,"sub 3 5");
           System.out.println(x);
           x = csc.runClient5("127.0.0.1", 9876,"sub 3 5");
           
           x = csc.runClient5("127.0.0.1", 9876,"mul 5 6");
           System.out.println(x);
           x = csc.runClient5("127.0.0.1", 9876,"mul 5 6");
           
           x = csc.runClient5("127.0.0.1", 9876,"div 8 2");
           System.out.println(x);
           x = csc.runClient5("127.0.0.1", 9876,"div 8 2");
           
           x = csc.runClient5("127.0.0.1", 9876,"add 1 2");
           System.out.println(x);
           x = csc.runClient5("127.0.0.1", 9876,"add 1 2");
        
    }
}
