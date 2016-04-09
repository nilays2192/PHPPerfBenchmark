/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import perf.maxmin;

/**
 *
 * @author Nilay
 */
public class kmeans_results {
    public double[][] results(String filename)
    {
    
    String everything="";
  try{
      BufferedReader br = new BufferedReader(new FileReader("C:/Users/Nilay/Documents/NetBeansProjects/phpperf/src/result/"+filename));
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
    everything = sb.toString();
            System.out.println(everything);
  }catch(Exception e)
  {
  System.out.println(e.getMessage());
  }
   String value[]=everything.split(",");
  
int N=value.length-2;
System.out.println(N);
int v;
double arr[]=new double[N];
try{
for(v=0;v<N;v++)
{
arr[v]=Double.parseDouble(value[v])*1000000;

}


}catch(Exception e1)
{}
Arrays.sort(arr);
   int cluster=1;
   boolean flag=true;
   maxmin val=new maxmin();
   double clusters[][];
   double result[];
   do
   {
       int counter=cluster++;
       System.gc();
   kmeans k=new kmeans();
    clusters=k.kmeans(arr, cluster);
    int br=0;
 for(int i=0;i<counter;i++)
 {
    br=0;
     result=val.avg(clusters[i]);
     double per=(100*result[1])/N;
     if(result[2]<1 || per<5.0)
     {
       br++;
       
     }
    
 //System.out.println("\navg of cluster-"+i+" is:"+result[0]+"number of values is:"+per+"% and average error is:"+result[2]+"micro sec");

 }  
  if(br==cluster)
  {
         flag=false;
   System.out.println("\n===System didn't generate optimum results with cluster-"+cluster+".=====\n");      
  }
   }while(flag && cluster<6);
   
   return clusters;
   
    }
    
}
