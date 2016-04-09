/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.tool;

import java.io.*;

/**
 *
 * @author Nilay
 */
public class checkerrorphpcode {
    
    public boolean varify(String code) throws IOException , InterruptedException, NullPointerException
    {
     String result="hi";
String fileurl = "C:/Users/Nilay/Documents/NetBeansProjects/phpperf/src/";
        try {
            PrintWriter writer = new PrintWriter(fileurl + "temp" + ".php", "UTF-8");
            writer.println("<?php " + code + " ?>");
            writer.close();
            System.out.println("file created!");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Error from php creator:"+e.getMessage());
        }
         String cmd="F:/projects/php-5.6.13-nts-Win32-VC11-x86/php.exe -f "+fileurl+"temp.php";
     
     try{
      
   // String cmd=config.path[0]+" -r '"+code+"'";
Process p=Runtime.getRuntime().exec(cmd); 
p.waitFor(); 
BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
String line=reader.readLine(); 
result="";
while(line!=null) 
{ 
System.out.println(line); 
result=result+line;
line=reader.readLine(); 
} 
 System.out.println("code exceution:"+result);
}
  catch(IOException | InterruptedException | NullPointerException e){
  System.out.println("Error on code exceution:"+e.getMessage());
  
  }
    
    if( !"".equals(result)) return true;
    else return false;
    
    } 
}
