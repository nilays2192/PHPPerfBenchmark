/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.tool;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import config.config;
/**
 *
 * @author Nilay
 */
public class phpcreator {

    public void createfile(String filename, String value) {
        String code1 = "<?php "
                + "require('config.php');"
                + "$time_taken = array();"
                + "$i = 0;$start = microtime(true);"
                + "$start1=$start + $min_time;"
                + "while(microtime(true) <= $start1 || $i <= $min_testcases){"
                + "if($i > 100000) break;"
                + "$check = microtime(true);";
        String code2 = "$time_taken[$i]=microtime(true) - $check;"
                + "$i++;"
                + "}"
                + "$i--;"
                + "$average1 = (array_sum($time_taken) / count($time_taken))*1000000;"
                + "$result=Array($average1,$i,phpversion());print_r($i.'-'.$average1.'-'.phpversion().'Time taken=='.((microtime(true)-$start)/1000000)).'seconds';"
                + "$file=$PATH.'results/"+filename+"'.phpversion().'.txt';"
                + "$j=0;"
                + "foreach($time_taken as $write1)"
                + "{ "
                + "$time_taken[$j]=$write1.',';"
                + "$j++;"
                + "}"
                + "file_put_contents($file,$time_taken);"
                + "?>";

        config  config=new config();
                try {
            PrintWriter writer = new PrintWriter(config.PATH +"PHPfiles/"+ filename + ".php", "UTF-8");
            writer.println(code1 + value + code2);
            writer.close();
            System.out.println(config.PATH +"PHPfiles/"+ filename + ".php file has been created without any intrrupt.");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Error from php creator:" + e.getMessage());
        }
    }
}
