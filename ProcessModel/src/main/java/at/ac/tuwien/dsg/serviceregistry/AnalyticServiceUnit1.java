/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.serviceregistry;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Anindita
 */
public class AnalyticServiceUnit1 {
    public static void main(String []p)
    {
        
    
      String uri="http://DataAnalyticServiceUnit.com#";
      String objectName="AnalyticServiceUnit1";
      Model model=ModelFactory.createDefaultModel();
      
      //for the rdf file creation
      {
      Resource serviceResource=model.createResource(uri+objectName);
      
      Property analyticTime=model.createProperty(uri+"analyticTime");
      serviceResource.addProperty(analyticTime, "60sec/MB");
      
      Property serviceCost=model.createProperty(uri+"serviceCost");
      serviceResource.addProperty(serviceCost,"5 euro/MB");
      
      Property processType=model.createProperty(uri+"processType");
      serviceResource.addProperty(processType, "Batch Job Processing");
     
      Property actionProperty=model.createProperty(uri+"taskName");
      serviceResource.addProperty(actionProperty, "Sampling");
     
      model.setNsPrefix("service", uri);
      model.write(System.out);
    }
      
      //for rdf file storage
      {   
        File f=new File("./example2");
            if(!f.exists())
            {
               f.mkdir();
               System.out.println("file created");
            }
          try
            {
                FileWriter fw=new FileWriter("./example2/"+objectName+".rdf");
                model.write(fw);
            }
          catch(Exception e)
            {
                System.out.println("exception occured : "+e);
            }
      
    }
      
      
      
    }
    
}
