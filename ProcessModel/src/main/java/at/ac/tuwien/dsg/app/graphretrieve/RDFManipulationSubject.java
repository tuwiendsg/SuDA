/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.app.graphretrieve;

import at.ac.tuwien.dsg.app.graphstorage.test.OperateProperty;
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
 * @author Anindita
 */
public class RDFManipulationSubject {
 
    public LinkedList<String> queryResultSubject(String object, String predicate)
    {
        
        LinkedList<String> monitoringInformation=new LinkedList<String>();
        OperateProperty operateProperty=new OperateProperty();
        String url=operateProperty.getGraphStorageURI();
        String username=operateProperty.getGraphStorageUserName();
        String password=operateProperty.getGraphStoragePassword();
        
        
        String storageName=operateProperty.getrdfURI();
        Query sparql = QueryFactory.create("SELECT ?s ?p ?o FROM <"+storageName+"> WHERE { ?s ?p ?o }");
        //String url="jdbc:virtuoso://"+Configuration.getConfig("VIRTUOSO.IP")+":"+Configuration.getConfig("VIRTUOSO.PORT");
        //String username=Configuration.getConfig("VIRTUOSO.USERNAME");
        //String password=Configuration.getConfig("VIRTUOSO.PASSWORD");
        VirtGraph graph=new VirtGraph(storageName,url,username,password);
        if(graph.isEmpty())
            {
                Logger.getLogger(RDFManipulationSubject.class.getName()).log(Level.SEVERE, null);
             }
        else
           {
                System.out.println("graph.getCount() = " + graph.getCount());  
                VirtuosoQueryExecution vqe = VirtuosoQueryExecutionFactory.create (sparql, graph);

                Node predicateNode=NodeFactory.createURI(predicate);
                Node objectNode=NodeFactory.createLiteral(object);
                
                ExtendedIterator iter=graph.find(Node.ANY, predicateNode, objectNode);
                for(;iter.hasNext();)
                    {

                        Triple tr=(Triple)iter.next();
                        String subject=tr.getSubject().toString();
                        monitoringInformation.add(subject);
                        
                    }
          
        
                
        }
        	
        return monitoringInformation;
}
}
  

