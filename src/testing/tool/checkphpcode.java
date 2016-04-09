/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.tool;

/**
 *
 * @author Nilay
 */
public class checkphpcode {
    
  public  boolean isPresent( String sentence)
{
    if(sentence.indexOf("echo") >= 0 || sentence.indexOf("print") >= 0)
        return true;
    else
        return false;
}
    
}
