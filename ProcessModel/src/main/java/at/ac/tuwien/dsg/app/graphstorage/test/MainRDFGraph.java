/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.app.graphstorage.test;

import at.ac.tuwien.dsg.app.graphstorage.*;


/**
 *
 * @author Anindita
 */
public class MainRDFGraph {
   public static void main(String []p)
   {
       //String fileuri="http://windtunnel.com";
       //for clean the graph
       String fileuri="http://DataAnalyticService.com";

       new GraphClean().graphRemove(fileuri);
       String fileName="./example/DataAnalyticServiceDemand.rdf";
       
        try
        {
        new RDFGraphStorage().GraphStore(fileName,fileuri);
        }
        catch(Exception e)
        {
            System.out.println("exception occured="+e);
        }
        
       
   }
}
