/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.tool;

import config.config;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Nilay
 */
public class calculateresult {

    public String result(String filename, String path) {
        String lineoutput = "";
        try {
            config config = new config();
            Process p = Runtime.getRuntime().exec(path + " -f " + config.PATH + "PHPfiles/" + filename + ".php");
           int pro= p.waitFor();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            String line = reader.readLine();
//            while (line != null) {
//                lineoutput = lineoutput + line;
//                line = reader.readLine();
//            }
            //  System.out.println(line);
           
           if(pro==0)
           {
           System.out.println("Results generated in text file!");
          
           }

           
        } catch (Exception e) {
            System.out.println("Error on calculating results:" + e.getMessage());
        }
        return lineoutput;
    }
}
