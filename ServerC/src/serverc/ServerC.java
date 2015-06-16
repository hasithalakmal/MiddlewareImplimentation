/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverc;

/**
 *
 * @author Massa
 */
public class ServerC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /*   ServerSocketConfig ssc = new ServerSocketConfig();
          ssc.initConnection(8883);
       while (true) {
           String msg = ssc.ReadClient();
           System.out.println(msg);
           ssc.WriteClient("mama massa"); 
           if(msg.equals("bye")){
               ssc.finishConnection();
           }
        } */
       
    /*    while (true) {
            ServerSocketConfig ssc = new ServerSocketConfig();
            ssc.initConnection(8883);
            String msg = ssc.ReadClient();
            System.out.println(msg);
            ssc.WriteClient("mama massa");
            ssc.finishConnection();
        }  */
        
          while(true){
                ServerSocketConfig ssc = new ServerSocketConfig();
                ssc.runserver5(8883);
            }
        
    }
    
}
