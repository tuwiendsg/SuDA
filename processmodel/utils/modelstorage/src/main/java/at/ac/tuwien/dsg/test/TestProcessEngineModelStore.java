/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.test;

import at.ac.tuwien.dsg.grphStorage.RDFGraphStorage;

/**
 *
 * @author Anindita
 */
public class TestProcessEngineModelStore {
    public static void main(String []p)
   {
        String fileuri="http://DataAnalyticServiceUnit.com";
       
        //for clean the graph
            //new GraphClean().graphRemove(fileuri);
        
       //for graph storage
            {
                String fileName="./ServiceModel/PE6.rdf";
                try
                    {
                        RDFGraphStorage.getInstance(fileuri).GraphStore(fileName);
                        System.out.println(fileName+" graph is stored under the table name "+fileuri);
                    }
                catch(Exception e)
                    {
                        System.out.println("exception occured="+e);
                    }
            }
        
   }
}
