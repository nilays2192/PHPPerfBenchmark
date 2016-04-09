/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kmeans;

import perf.maxmin;

/**
 *
 * @author Nilay
 */
public class kmeans {
    
    public double[][] kmeans(double arr[], int cluster)
    {
     
    
    int i,n=0,i1;
 int N=arr.length;
 double a[]=new double[cluster];
 double m[]=new double[cluster];
//double a,b,c=0,m1,m2,m3;
boolean flag=true;
double sum[]=new double[cluster];
//double sum1,sum2,sum3;
double clusters[][]=new double[cluster][N];
maxmin val=new maxmin();
int cen1= 0;int cen2=0;
   try{
do
    
{
         
    if(val.match(a, arr[cen2]))
    {
        a[cen1]=arr[cen2];
        m[cen1]=a[cen1];
        System.out.println("\n"+a[cen1]);
    cen1++;
    }
   
    cen2++;

}while(cen1<cluster);


for(i=0;i<N;i++)
    System.out.print(arr[i]+ "\t");
System.out.println();

do
{
     System.gc();
   for(int t=0;t<N;t++)
   {
       for(i=0;i<cluster;i++)
       {
   clusters[i][t]=0;
   sum[i]=0;
       }
   }
  //  sum1=sum2=sum3=0;
 n++;
 int k[]=new int[cluster];
 for(i=0;i<cluster;i++)
 {
 k[i]=0;
 }
 //int k=0,j=0,l=0;

 for(i=0;i<N;i++)
 {
     int condition=1;
   
   for(i1=0;i1<cluster-1;i1++)
 {
  //  condition=cluster;
 if(Math.abs(arr[i]-m[i1])<=Math.abs(arr[i]-m[i1+1]))
    {   clusters[i1][k[i1]]=arr[i];
        k[i1]++;
        condition=-1;
        break;
    }
 else
     condition=1;
     
    
 }
     
      if(condition==1)
      {
      clusters[cluster-1][k[cluster-1]]=arr[i];
        k[cluster-1]++;
      }
 }

    System.out.println();
    for(i1=0;i1<cluster;i1++)
    {
    for(i=0;i<k[i1];i++)
        sum[i1]=sum[i1]+clusters[i1][i];
        }
    for(i=0;i<cluster;i++)
    {
    a[i]=m[i];
    m[i]=sum[i]/k[i];
    }
    int temp=0;
 for(i=0;i<cluster;i++)
 {
 if(m[i]==a[i])
 {temp++;}
  }
 if(temp==cluster)
 {
 flag=false;
 }
 else
 {
 flag=true;
 }
  
for(i=0;i<cluster;i++)
{
System.out.println("\nAfter iteration "+ n +" , cluster-"+i+" :\n");
for(i1=0;i1<N;i1++)
 
    System.out.print(clusters[i][i1]+ "\t");       
    
}

}while(flag);

 
  
        }catch(Exception e)
        {
        System.out.println("\n"+e.getMessage());
        } return clusters;
    }
  
}
