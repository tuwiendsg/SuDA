/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.app.graphstorage.test;

import at.ac.tuwien.dsg.app.graphretrieve.RDFManipulationSubject;
import java.util.LinkedList;


/**
 *
 * @author Anindita
 */
public class MainRDFGraph {
   public static void main(String []p)
   {
       //graph retrival
       RDFManipulationSubject subject=new RDFManipulationSubject();
       LinkedList<String> subjectname=subject.queryResultSubject("Visualization", "taskName");
       for(int i=0;i<subjectname.size();i++)
       {
           System.out.println("subjectName="+ subjectname.get(i));
       }
       
       //for graph storage
       //for clean the graph
       
       /*String fileuri="http://DataAnalyticService.com";
        new GraphClean().graphRemove(fileuri);
       
       String fileName="./example/DataAnalyticServiceDemand.rdf";
       
        try
        {
        new RDFGraphStorage().GraphStore(fileName,fileuri);
        }
        catch(Exception e)
        {
            System.out.println("exception occured="+e);
        }*/
        /*String fileuri="http://DataAnalyticServiceUnit.com";
       new GraphClean().graphRemove(fileuri);
       //
       String fileName="./example2/AnalyticServiceUnit1.rdf";
       
        try
        {
        new RDFGraphStorage().GraphStore(fileName,fileuri);
        }
        catch(Exception e)
        {
            System.out.println("exception occured="+e);
        }
        
        //
        String fileName2="./example2/AnalyticServiceUnit2.rdf";
       
        try
        {
        new RDFGraphStorage().GraphStore(fileName2,fileuri);
        }
        catch(Exception e)
        {
            System.out.println("exception occured="+e);
        }
        
        //
        String fileName3="./example2/AnalyticServiceUnit3.rdf";
       
        try
        {
        new RDFGraphStorage().GraphStore(fileName3,fileuri);
        }
        catch(Exception e)
        {
            System.out.println("exception occured="+e);
        }*/
   }
}
