/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.servicedemand;

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
public class ResultQuality {
    

    public static void main(String []p)
    {
        
    
      String uri="http://DataAnalyticServiceDemand.com#";
      String objectName="DataAnalyticServiceDemand";
      Model model=ModelFactory.createDefaultModel();
      
      //for the rdf file creation
      {
      Resource demandResource=model.createResource(uri+objectName);
      
      Property analyticTime=model.createProperty(uri+"analyticTime");
      demandResource.addProperty(analyticTime, "60sec/MB");
      
      Property serviceCost=model.createProperty(uri+"serviceCost");
      demandResource.addProperty(serviceCost,"5 euro/MB");
      
      Resource qualityResource=model.createResource(uri+"Quality");
      
      Property processType=model.createProperty(uri+"processType");
      qualityResource.addProperty(processType, "Batch Job Processing");
     
      Property locationProperty=model.createProperty(uri+"TaskNumber");
      qualityResource.addProperty(locationProperty, "2");
      
      Property hasQuality=model.createProperty(uri+"hasQuality");
      demandResource.addProperty(hasQuality, qualityResource);
      
      model.setNsPrefix("result", uri);
      model.write(System.out);
    }
      
      //for rdf file storage
      {   
        File f=new File("./example");
            if(!f.exists())
            {
               f.mkdir();
               System.out.println("file created");
            }
          try
            {
                FileWriter fw=new FileWriter("./example/"+objectName+".rdf");
                model.write(fw);
            }
          catch(Exception e)
            {
                System.out.println("exception occured : "+e);
            }
      
    }
      
      
      
    }
    
}
