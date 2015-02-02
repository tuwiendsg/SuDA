/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.grphStorage;

//import at.ac.tuwien.dsg.dataenrichment.Configuration;
//import at.ac.tuwien.dsg.app.graphstorage.test.OperateProperty;
import at.ac.tuwien.dsg.test.OperateProperty;
//import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.NodeFactory;
import com.hp.hpl.jena.graph.Triple;
//import com.hp.hpl.jena.mem.ModelMem;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDFS;
//import com.mkyoung.datamodel.OperateProperty;
import java.io.File;
import java.io.FileReader;
import virtuoso.jena.driver.VirtGraph;

/**
 *
 * @author Anindita
 */
public class RDFGraphStorage {
    private static String fileURI=null;

    public static RDFGraphStorage getInstance(String newFileURI) {
        fileURI=newFileURI;
        return new RDFGraphStorage();
    }
    
    
    
    
    public void GraphStore(String fileName)throws Exception 
    {
        
        //consider the rdf file
        File rdfFileName=new File(fileName);
        FileReader rdfFileRead=new FileReader(rdfFileName);
        
        
        Model model=ModelFactory.createDefaultModel();
        model.read(rdfFileRead,RDFS.getURI());
        
        StmtIterator iter=model.listStatements();
        Statement stmt;
        
        
       
        String url="jdbc:virtuoso://"+new OperateProperty().getVirtuosoIP()+":1111";
        VirtGraph virtgraph=new VirtGraph(fileURI,url,"dba","dba");
         
       
        
        while (iter.hasNext())
        {
            stmt=(Statement)iter.next();
            System.out.println("subject="+stmt.getSubject().getURI());
            System.out.println("Predicate="+stmt.getPredicate().getLocalName());
            System.out.println("object="+stmt.getObject().toString());
            virtgraph.add(new Triple(NodeFactory.createURI(stmt.getSubject().getURI())
                    ,NodeFactory.createURI(stmt.getPredicate().getLocalName())
                    ,NodeFactory.createLiteral(stmt.getObject().toString())));
        }
        
    }
}
