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
public class ServerRouting {

    public String[] SplitWords(String x) {
        String[] words = x.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }
        return words;
    }

    public String getMethodName(String x) {
        ServerRouting sr = this;
        String[] words = sr.SplitWords(x);
        return words[0];
    }

    public String getValueFromArray(String x, int index) {
        ServerRouting sr = this;
        String[] words = sr.SplitWords(x);
        return words[index];
    }

    public String[] getMethodNameFromXML(String x, String y) {
        String[] methods = new String[10];
        try {
            ServerRouting sr = this;
            String[] words = new String[sr.getNumberOfWords(x)];
            words = sr.SplitWords(x);
            int counter = Integer.parseInt(words[2]);
            int NumberOfMethods = Integer.parseInt(y);
            // System.out.println(NumberOfMethods);
            int loop = 0, init = 1;

            while (loop < NumberOfMethods) {
                // System.out.println(words[init]);
                methods[loop] = words[init];
                //  System.out.println(methods[loop]);
                init = init + counter + 3;
                counter = Integer.parseInt(words[init + 1]);
                loop++;
            }
            return methods;
        } catch (Exception e) {
            //System.out.println("error");
            return methods;
        }
    }
    
    public String[] getMethodParaFromXML(String x, String y) {
        String[] methods = new String[10];
        try {
            ServerRouting sr = this;
            String[] words = new String[sr.getNumberOfWords(x)];
            words = sr.SplitWords(x);
            int counter = Integer.parseInt(words[2]);
            int NumberOfMethods = Integer.parseInt(y);
            // System.out.println(NumberOfMethods);
            int loop = 0, init = 2;

            while (loop < NumberOfMethods) {
                // System.out.println(words[init]);
                methods[loop] = words[init];
                //  System.out.println(methods[loop]);
                init = init + counter + 3;
                counter = Integer.parseInt(words[init]);
                loop++;
            }
            return methods;
        } catch (Exception e) {
            //System.out.println("error");
            return methods;
        }
    }

    public int getNumberOfArguments(String x) {
        ServerRouting sr = this;
        String[] words = sr.SplitWords(x);
        return words.length - 1;
    }

    public int getNumberOfWords(String x) {
        ServerRouting sr = this;
        String[] words = sr.SplitWords(x);
        return words.length;
    }

    public void printArray(String[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null) {
                break;
            }
            // System.out.println(">>>>>>>>>>>>");
            System.out.println(a[i]);
        }
        //  System.out.println("??????????????");
    }

    public String MethodRouter(String calledMeth) {
        String msg = null;
        ServerRouting sr = this;
        String methodname = sr.getMethodName(calledMeth);
        int numParaInGiven = sr.getNumberOfArguments(calledMeth);
        int numParaInReal = 0;
        XMLReader xml = new XMLReader();
        xml.readXML();
        String[] IP = xml.getIP();
        String[] Port = xml.getPort();
        String[] x = xml.getMethods();
        String[] y = xml.getNumberOfMethods();

        int serverID;
        for (serverID = 0; serverID < 3; serverID++) { //should change 3 to number of serbers
            if (msg != null) {
                break;
            }
            String[] methName = new String[Integer.parseInt(y[serverID])];
            String[] methPara = new String[Integer.parseInt(y[serverID])];
            methName = sr.getMethodNameFromXML(x[serverID].trim(), y[serverID].trim());
            methPara = sr.getMethodParaFromXML(x[serverID].trim(), y[serverID].trim());
            
            for (int i = 0; i < methName.length; i++) {
                if (methName[i] == null) {
                    break;
                }
                if (methName[i].equals(methodname)) {
                    numParaInReal = Integer.parseInt(methPara[i]);
                    if (numParaInGiven == numParaInReal) {
                        String Ip = IP[serverID];
                        String port = Port[serverID];
                        msg = Ip + " " + port;
                        break;
                    }else{
                        msg ="Number Of Arguments are not correct";
                    }

                }
            }
        }
        return msg;
    }
    
    
     public String MethodRouter2(String calledMeth) {
        String msg = null;
        ServerRouting sr = this;
        String methodname = sr.getMethodName(calledMeth);
        int numParaInGiven = sr.getNumberOfArguments(calledMeth);
        int numParaInReal = 0;
        XMLReader xml = new XMLReader();
        xml.readXML();
        String[] IP = xml.getIP();
        String[] Port = xml.getPort();
        String[] x = xml.getMethods();
        String[] y = xml.getNumberOfMethods();

        int serverID;
        for (serverID = 0; serverID < 3; serverID++) { //should change 3 to number of serbers
            if (msg != null) {
                break;
            }
            String[] methName = new String[Integer.parseInt(y[serverID])];
            String[] methPara = new String[Integer.parseInt(y[serverID])];
            methName = sr.getMethodNameFromXML(x[serverID].trim(), y[serverID].trim());
            methPara = sr.getMethodParaFromXML(x[serverID].trim(), y[serverID].trim());
            //sr.printArray(methName);
            for (int i = 0; i < methName.length; i++) {
                if (methName[i] == null) {
                    break;
                }
                if (methName[i].equals(methodname)) {
                   
                   // System.out.println(methPara[2] +" "+numParaInGiven);
                    numParaInReal = Integer.parseInt(methPara[i]);
                    if (numParaInGiven == numParaInReal) {
                     
                        String Ip = IP[serverID];
                        String port = Port[serverID];
                        msg = Ip + " " + port;
                        break;
                    }else{
                      
                        msg ="Number Of Arguments are not correct";
                    }

                }
            }
        }
        return msg;
    }

 /*   public static void main(String[] args) {
        String method = "mul 1 2";
        ServerRouting sr = new ServerRouting();
        String x = sr.MethodRouter2(method);
        System.out.println(x);
        System.out.println("IP is = "+sr.getValueFromArray(x, 0));
        System.out.println("Port is = "+sr.getValueFromArray(x, 1));
    }*/
    
    
    
}
