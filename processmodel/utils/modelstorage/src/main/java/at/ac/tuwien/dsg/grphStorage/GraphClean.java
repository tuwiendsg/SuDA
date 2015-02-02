/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.grphStorage;

//import at.ac.tuwien.dsg.app.graphstorage.test.OperateProperty;
//import at.ac.tuwien.dsg.dataenrichment.Configuration;
import at.ac.tuwien.dsg.test.OperateProperty;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.mkyoung.datamodel.OperateProperty;
import virtuoso.jena.driver.VirtGraph;

/**
 *
 * @author Anindita
 */
public class GraphClean {
    public void graphRemove(String fileURI)
    {
         
        String url="jdbc:virtuoso://"+ new OperateProperty().getVirtuosoIP()+":1111";
        
        
        //String url="jdbc:virtuoso://"+Configuration.getConfig("VIRTUOSO.IP")+":"+Configuration.getConfig("VIRTUOSO.PORT");
        
        VirtGraph virtgraph=new VirtGraph(fileURI,url,"dba","dba");
         
        if(!virtgraph.isEmpty())
            {
                Logger.getLogger(GraphClean.class.getName()).log(Level.SEVERE, null);
                System.out.println("clean the graph");
                virtgraph.clear();
            }
         else
            {
                System.out.println("do not need to clean the graph");
            }
    }
}
