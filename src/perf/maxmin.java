/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package perf;

/**
 *
 * @author Nilay
 */
public class maxmin {
    
    public double[] maxmin(double values[])
    {
    
   double max=values[0],min=values[0];
   int N=values.length,i=0;
   for(i=0;i<N;i++)
   {
    if(values[i]>=max)
       max=values[i];
   
   if(values[i]<min)
       min=values[i];
   
   }
   
   double []result={max,min};
   return result;
   
    }
   
  public boolean match(double values[],double current)
  {
  
      for(int i=0;i<values.length;i++)
      {
      if(values[i]==current)
      {
     
          return false;
          
      }
      }
      return true;
  }
    public double[] avg(double values[])
    {
    double avg=0;
    int counter=0;
    for(int i=0;i<values.length;i++)
    {
                if(values[i] !=0)
        {
            avg=avg+values[i];
            counter++;
        }
    }
    avg=avg/counter;
    double error_avg=0;
   for(int temp=0;temp<counter;temp++)
{
error_avg=error_avg+Math.abs(values[temp]-avg);
}
   
    double []result={avg,counter,(error_avg/counter)};
    return result;
    }
    
   
}
