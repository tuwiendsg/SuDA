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
import java.util.StringTokenizer;
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
    
    private static String RDFURI=null;  //this variable determines table name 
    
    
    public static RDFManipulationObject getInstance(String newRDFURI)
    {
        RDFURI=newRDFURI;
        return new RDFManipulationObject();
    }
    
    public String getVirtuosoIPAddress()
    {
        return "jdbc:virtuoso://"+new OperateProperty().getVirtuosoIP()+":1111";
    }
    
    public String getsubjectWithURI(String subject)
    {
        
        return new StringTokenizer(RDFURI,"#").nextToken()+"#"+subject;
    }
    
    public Query getSPARQL()
    {
        return QueryFactory.create("SELECT ?s ?p ?o FROM <"+RDFURI+"> WHERE { ?s ?p ?o }");
    }
    
    public VirtGraph getVirtGraph()
    {
        return new VirtGraph(RDFURI,getVirtuosoIPAddress(),"dba","dba");
    }
    
    public Node getSubjectNode(String subject)
    {
       return NodeFactory.createURI(getsubjectWithURI(subject)); 
    }
     public Node getPredicateNode(String predicate)
     {
         return NodeFactory.createURI(predicate);
     }
    
    public String queryResultSubject(String subject, String predicate)
    {
        String value="";
        
        
        if(getVirtGraph().isEmpty())
            {
               System.out.println("there have no content under the uri of subject");
            }
        else
           {
                System.out.println("graph.getCount() = " + getVirtGraph().getCount());  
                VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (getSPARQL(), getVirtGraph());
                ExtendedIterator iter=getVirtGraph().find(getSubjectNode(subject), getPredicateNode(predicate), Node.ANY);
                for(;iter.hasNext();)
                    {

                        Triple tr=(Triple)iter.next();
                        value=value+tr.getObject().toString().replace("\"", "");
                    }
          
        
                
        }
        	
        return value;
}

  

  public LinkedList<String> queryResultSubjectList(String subject, String predicate)
    {
        
        LinkedList<String> monitoringInformation=new LinkedList<String>();
        
        if(getVirtGraph().isEmpty())
            {
               System.out.println("there have no content under the uri of subject");
            }
        else
           {
                System.out.println("graph.getCount() = " + getVirtGraph().getCount());  
                VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (getSPARQL(), getVirtGraph());
                 ExtendedIterator iter=getVirtGraph().find(getSubjectNode(subject), getPredicateNode(predicate), Node.ANY);
                for(;iter.hasNext();)
                    {

                        Triple tr=(Triple)iter.next();
                        monitoringInformation.add(tr.getObject().toString().replace("\"", ""));
                        
                    }
          
        
                
        }
        
     
        return monitoringInformation;
}

}