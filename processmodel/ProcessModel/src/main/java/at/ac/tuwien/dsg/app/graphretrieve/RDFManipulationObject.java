/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.app.graphretrieve;

import at.ac.tuwien.dsg.decisionTreeCreation.OperateProperty;
import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.NodeFactory;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

/**
 *
 * @author dsg
 */
public class RDFManipulationObject {
    
    private static String RDFURI=null;  //this variable determines table name and URI of RDF file
    
    public static RDFManipulationObject getInstance(String newRDFURI)
    {
        RDFURI=newRDFURI;
        return new RDFManipulationObject();
    }
    
    public String queryResultSubject(String subject, String predicate)
    {
        
        //LinkedList<String> monitoringInformation=new LinkedList<String>();
        String value=null;
        
        //OperateProperty operateProperty=new OperateProperty();
        //String SubjectAccessURI=operateProperty.getrdfURIForAccess();
        String virtuosoIPAddress="jdbc:virtuoso://"+new OperateProperty().getVirtuosoIP()+":1111";
        //String username=operateProperty.getGraphStorageUserName();
        //String password=operateProperty.getGraphStoragePassword();
        
        
        String subjectwithURI=RDFURI+"#"+subject;
        
        
       
        
        //String storageName=operateProperty.getrdfURITable();
        Query sparql = QueryFactory.create("SELECT ?s ?p ?o FROM <"+RDFURI+"> WHERE { ?s ?p ?o }");
        
        
        
        VirtGraph graph=new VirtGraph(RDFURI,virtuosoIPAddress,"dba","dba"); 
        if(graph.isEmpty())
            {
               System.out.println("there have no content under the uri of subject");
            }
        else
           {
                System.out.println("graph.getCount() = " + graph.getCount());  
                VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, graph);

                Node subjectNode=NodeFactory.createURI(subjectwithURI);
                Node predicateNode=NodeFactory.createURI(predicate);
                
                ExtendedIterator iter=graph.find(subjectNode, predicateNode, Node.ANY);
                for(;iter.hasNext();)
                    {

                        Triple tr=(Triple)iter.next();
                        value=tr.getObject().toString().replace("\"", "");
                    }
          
        
                
        }
        	
        return value;
}
}
  



