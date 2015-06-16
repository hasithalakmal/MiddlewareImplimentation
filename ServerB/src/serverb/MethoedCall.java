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
public class MethoedCall {

    public String[] SplitWords(String x) {
        String[] words = x.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }
        return words;
    }

    public String getMethodName(String x) {
        MethoedCall sr = this;
        String[] words = sr.SplitWords(x);
        return words[0];
    }

    public String getValueFromArray(String x, int index) {
        MethoedCall sr = this;
        String[] words = sr.SplitWords(x);
        return words[index];
    }

    public int getNumberOfArguments(String x) {
        MethoedCall sr = this;
        String[] words = sr.SplitWords(x);
        return words.length - 1;
    }

    public int getNumberOfWords(String x) {
        MethoedCall sr = this;
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

    public String methodCaller(String caller) {
        MethoedCall sr = this;
        ServerMethods sm = new ServerMethods();
        String result = "error";
        String methname = sr.getMethodName(caller);
        switch (methname) {
            case "sub": {
                float x = Float.parseFloat(sr.getValueFromArray(caller, 1));
                float y = Float.parseFloat(sr.getValueFromArray(caller, 2));
                float z = sm.sub(x, y);
                result = Float.toString(z);
                break;
            }
            
           
            default:{
                result = caller;
            }

        }

        return result;
    }

}
