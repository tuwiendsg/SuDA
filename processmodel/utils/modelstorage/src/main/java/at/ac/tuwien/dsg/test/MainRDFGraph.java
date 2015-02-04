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
        //String fileuri="http://DataAnalyticServiceDemand.com#ResultQualityOfSampling"; //for user's demand
        //String fileuri="http://DataAnalyticServiceUnit.com#PE6"; //for process engine
        String fileuri="http://DataAnalyticProcessEngine.com#ProcessEngineInformation"; // for the information of process engine
       
        //for clean the graph
           /////////////////////new GraphClean().graphRemove(fileuri);
        
       //for graph storage
            {
                //String fileName="./example/ResultQualityOfSampling.rdf"; ////for user's demand
               // String fileName="./ServiceModel/PE6.rdf"; //for process engine
                String fileName="./example/ProcessEngineInformation.rdf";   // for the information of process engine
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
