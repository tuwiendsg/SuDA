/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.test;

//import at.ac.tuwien.dsg.app.graphretrieve.RDFManipulationSubject;
import at.ac.tuwien.dsg.grphStorage.GraphClean;
import at.ac.tuwien.dsg.grphStorage.RDFGraphStorage;
import java.util.LinkedList;


/**
 *
 * @author Anindita
 */
public class MainRDFGraph {
   public static void main(String []p)
   {
        String fileuri="http://DataAnalyticServiceDemand.com#ResultQualityOfSampling";
       
        //for clean the graph
           new GraphClean().graphRemove(fileuri);
        
       //for graph storage
            {
                String fileName="./example/ResultQualityOfSampling.rdf";
                try
                    {
                        RDFGraphStorage.getInstance(fileuri).GraphStore(fileName);
                        System.out.println("graph is stored");
                    }
                catch(Exception e)
                    {
                        System.out.println("exception occured="+e);
                    }
            }
        
   }
}
