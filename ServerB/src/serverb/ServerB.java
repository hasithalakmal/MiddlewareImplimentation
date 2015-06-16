/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverb;

/**
 *
 * @author Massa
 */
public class ServerB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        while(true){
                ServerSocketConfig ssc = new ServerSocketConfig();
                ssc.runserver5(8882);
            }
    }
    
}
