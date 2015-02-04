/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.serviceregistrymodel;

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
public class QualityOfServiceParameter {
    

     public String uri="http://DataAnalyticServiceUnit.com#";
      public String objectName="PE5";
      

    public static void main(String []p)
    {
        new QualityOfServiceParameter().modelCreation();
    }
  
    //for the rdf file creation
    public void modelCreation()
    {
      
      //for assigning of main resource
      Model model=ModelFactory.createDefaultModel();
      Resource demandResource=model.createResource(uri+objectName);
      
      ////Assign the data property of ExecutionTime sub class....
      {
      Resource executionTimeResource=model.createResource(uri+"ExecutionTime");
      Property hasObjectProperty=model.createProperty(uri+"hasObject");
      demandResource.addProperty(hasObjectProperty, executionTimeResource);
          
      Property timeValueProperty=model.createProperty(uri+"hasDataValue");
      executionTimeResource.addProperty(timeValueProperty, "19");
      
      Property timeUnitProperty=model.createProperty(uri+"hasDataUnit");
      executionTimeResource.addProperty(timeUnitProperty, "second");
      
     }
      
    ////Assign the data property of ExecutionCost sub class....
      {
          Resource serviceCostResource=model.createResource(uri+"ExecutionCost");
          Property hasObjectProperty=model.createProperty(uri+"hasObject");
          demandResource.addProperty(hasObjectProperty, serviceCostResource);
          
      
          
      Property costValueProperty=model.createProperty(uri+"hasDataValue");
      serviceCostResource.addProperty(costValueProperty, "45");
      
      Property timeUnitProperty=model.createProperty(uri+"hasDataUnit");
      serviceCostResource.addProperty(timeUnitProperty, "euro");
      
     }
      
     
     ////Assign the data property of DataAccuracy sub class....
      {
          
      Resource qualityResource=model.createResource(uri+"DataQuality");
      Property hasQuality=model.createProperty(uri+"DataQuality");
      demandResource.addProperty(hasQuality, qualityResource);
      
      
      Resource qualityAccuracyResource=model.createResource(uri+"DataAccuracy");
      Property accuracyObjectProperty=model.createProperty(uri+"hasObject");
      qualityResource.addProperty(accuracyObjectProperty, qualityAccuracyResource);
          
      
          
      Property accuracyValueProperty=model.createProperty(uri+"hasDataValue");
      qualityAccuracyResource.addProperty(accuracyValueProperty, "25");
      
      Property timeUnitProperty=model.createProperty(uri+"hasDataUnit");
      qualityAccuracyResource.addProperty(timeUnitProperty, "%");
      
      }
      
      //for rdf model
      model.setNsPrefix("result", uri);
      model.write(System.out);
      
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

      
      
