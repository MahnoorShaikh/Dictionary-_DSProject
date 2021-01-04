 package project;
 import java.io.*; 
 import java.util.HashMap;
 import java.util.Map;
import java.util.Scanner;

 public class Project {
          //initizaition of varibales  
  int count=0; 
 String[] str = null;
 String[] A = null;
 
 //Doing Selection SOrt
 
     public String[] selectionsort(String[] arr){
     int minx=0;
      for (int i = 0; i <arr.length-1; i++) {
          minx=i;
          for (int j =i+1; j < arr.length; j++) {
              if(arr[j].compareTo( arr[minx] ) < 0){
                  minx=j;
              }  }
         
   String temp=arr[i];
          arr[i]=arr[minx];
          arr[minx]=temp;     }
      return arr;     }
     
 //Doing bubble sort    
  public String[] bubblesort(String[] arr){
      for (int i = 0; i < arr.length; i++) {
          for (int j = i+1; j < arr.length-1; j++) {
              if(arr[i].compareTo( arr[j] ) > 0){
                  String temp=arr[i];
                  arr[i]=arr[j];
                  arr[j]=temp;  }         }      }
                     return arr;       }
  
  //Doing inseration sort
public String[] insertionsort(String[] arr){
      for (int i = 1; i < arr.length-1; i++) {
          String value=arr[i];
          int counter=i;
          while(counter>0 && arr[counter-1].compareTo( value ) > 0){
              arr[counter]=arr[counter-1];
              counter-=1;          }
          arr[counter]=value;      }
      return arr;     }
     

//Doing Merge Sort
public void mergesort(String A[]){
         int n=A.length;
         if(n<2)
{  
  return;   }
     
         int half = n/2;         
         String[] left=new String[half];
         String[] right=new String[n-half];
         
         for(int i=0;i<half;i++)
             left[i]=A[i];
         
         for(int j=half;j<n;j++)
         { 
             right[j-half]=A[j];
         } 
         mergesort(left);
         mergesort(right);
         merge(left,right,A);              
     }
     
     //For merging 
     public void merge(String [] left,String[] right,String[] A)
     {
         
         int nl=left.length;
         int nr=right.length;
         int i=0;
         int j=0;
         int k=0;
                  
         while(i<nl && j<nr)
         {
             if(left[i].equals(right[j]) || left[i].compareTo(right[i])<0)
             {
                 A[k]=left[i];
                 i++;
             }
             
             else
             {
                 A[k]=right[j];
                 j++;
             }
             k++;         
         }
         
         while(i<nl)
         {
             A[k]=left[i];
             i++;
             k++;
         }
                   
         while(j<nr)
         {
             A[k]=right[j];
             j++;
             k++;
         }
         }
     
     //For Lineaar Search
   public void linearsearch(String value,String[] arr){
         for (int i = 0; i <arr.length; i++) {
            if(arr[i].equals(value)){
             System.out.println("Value Found ");        }}}
     
    
    //NOW WE WILL PERFORM HASHING
   
     public void hashing(String[] array){
         str=new String[array.length];
         int index=0;
         while (count<str.length) {
             
         String value=array[count];
         int ascicount=0;
         count++;
         char[] ch=value.toCharArray();
             for (int i = 0; i <ch.length; i++) {
               ascicount+=ch[i]; }     
             
 index=ascicount%str.length;
    if(str[index]==null){
       str[index]=value;}   
             
    else   {
                
        for (int i = 0; i <str.length; i++) {        
          if(str[index]==null){
                         str[index]=value;
                         break;                     }
  else{
          if(index==str.length-1){
                             index=0;     }
                         else
                         {
                             index++;}}}}}}
     
     //introducting word as key and taking input         
 public String search(String key){
  char[] ch=key.toCharArray();
    int asci_sum=0;
        
         for (int i = 0; i <ch.length; i++) {
             asci_sum+=(int)ch[i]; }
         
int index=asci_sum%str.length;
         for (int i = 0; i < str.length; i++) {
            if(str[index].equals(key)){                
                return key;           }
else{
                if(index==str.length-1)
                    index=0;
                else
                {
                   index++;}}}
               return null;   }
     
     
   //DOing binary search
     
 static String binarySearch(String[] arr, String value) 
    { 
        String x=value.toLowerCase();
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            int res = x.compareTo(arr[m]); 
  
            if (res == 0) 
                return x; 
  
            if (res > 0) 
                l = m + 1; 
  
           else
                r = m - 1; 
        } 
  
        return null; 
    } 
     
     
     
    public static void main(String[] args) 
    {
        Scanner obj1=new Scanner(System.in); //taking input
        Map<String,String> dic=new HashMap<>();
        BufferedReader reader;
        String line="";
        String[] Linesplit;
        int counter=0;
        String [] dicarray;
        String [] hasharray = null;
         
        try
        {   //Dictonary.txt is very every word is safe and key will be retrive from it
            reader=new BufferedReader(new FileReader("Dictionary.txt"));
            line=reader.readLine();
            while(line!=null)
            {
                
                 Linesplit=line.split("\t");
                 if(Linesplit.length==2)
                 {
                    dic.put(Linesplit[0], Linesplit[1]);
                    counter++;
                 }
                 
                 if(Linesplit.length>2 ||Linesplit.length==1)
                 {
                     System.out.println("Data Creates problem : ");
                     for(int i=0;i<Linesplit.length;i++)
                     {
                         System.out.print(Linesplit[i]+" ");
                     }
                     System.out.println("");
                 }
                 
                 line= reader.readLine();   
            }
           
            reader.close();
            
        
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
          System.out.println("Dictnory :Find what u want");
        System.out.println("DS PROJECT BY **RUBAB MAHNOOR**");
          System.out.println("Supervisor : Sir Saif Hassan ");
        
        System.out.println("Enter Value to Find ");
        String key=obj1.next();
        
        System.out.println(" find meaning with hashing method time is ");
        long starttime=System.currentTimeMillis();
        System.out.println(" Meaning of :" +key+" : "+dic.get(key));
        long endtime=System.currentTimeMillis();
        long result=endtime-starttime;
        System.out.println(" final time ofm hashing searched value is : "+result);
        
        
        dicarray=dic.keySet().toArray(new String[0]);
        Project obj=new Project();
        
         // Sorting Techniques
        long startselection = System.currentTimeMillis();
        obj.selectionsort(dicarray);
        long endselection = System.currentTimeMillis();
        long resultselection=endselection-startselection;
        System.out.println("Selection sort time : "+resultselection);
        
        long startbubble = System.currentTimeMillis();
        obj.bubblesort(dicarray);
        long endbubble = System.currentTimeMillis();
        long resultbubble=endbubble-startbubble;
        System.out.println("Bubble sort time : "+resultbubble);
        
        long startinsertion = System.currentTimeMillis();
        obj.bubblesort(dicarray);
        long endinsertion = System.currentTimeMillis();
        long resultinsertion=endinsertion-startinsertion;
        System.out.println("insertion sort time : "+resultinsertion);
        
        long startmerge = System.currentTimeMillis();
        obj.mergesort(dicarray);
        long endmerge = System.currentTimeMillis();
        long resultmerge=endmerge-startmerge;
        System.out.println("mergeSort sort time : "+resultmerge);
        
        // Searching Techniques
        
       
        
        long startlinear = System.currentTimeMillis();
        obj.linearsearch(key.toLowerCase(),dicarray);
        long endlinear = System.currentTimeMillis();
        long resultlinear=endlinear-startlinear;
        System.out.println("Linear Search time : "+resultlinear);
       
        
        
        
        
        obj.hashing(dicarray);
      
        long starthashing = System.currentTimeMillis();
        System.out.println("hashing : "+ obj.search(key.toLowerCase()));
        long endhasing = System.currentTimeMillis();
        long resulthashing=endhasing-starthashing;
        System.out.println("Hashing Search time : "+resulthashing);
        
        long startbinary = System.currentTimeMillis();
        System.out.println("binary is :"+obj.binarySearch(dicarray, key));
        System.out.println(" Meaning of word :" +key+" : "+dic.get(key));
        long endbinary = System.currentTimeMillis();
        long resultbinary=endbinary-startbinary;
        System.out.println("binary Search time taken: "+resultbinary);
        
        
        
        
        
     }
    
}
