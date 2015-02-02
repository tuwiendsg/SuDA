/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.servicedemandmodel;

/**
 *
 * @author dsg
 */


import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;
import com.hp.hpl.jena.vocabulary.RDFS;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Anindita
 */
public class QualityOfResultModel {
     public String uri="http://DataAnalyticServiceDemand.com#";
      public String objectName="ResultQualityOfSampling";
      

    public static void main(String []p)
    {
        new QualityOfResultModel().modelCreation();
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
      executionTimeResource.addProperty(timeValueProperty, "20");
      
      Property timeUnitProperty=model.createProperty(uri+"hasDataUnit");
      executionTimeResource.addProperty(timeUnitProperty, "second");
      
     Property timeConditionProperty=model.createProperty(uri+"hasDataCondition");
      executionTimeResource.addProperty(timeConditionProperty, "less than");
      
      Property priorityProperty=model.createProperty(uri+"hasPriority");
      executionTimeResource.addProperty(priorityProperty, "2");
    }
      
    ////Assign the data property of ExecutionCost sub class....
      {
          Resource serviceCostResource=model.createResource(uri+"ExecutionCost");
          Property hasObjectProperty=model.createProperty(uri+"hasObject");
          demandResource.addProperty(hasObjectProperty, serviceCostResource);
          
      
          
      Property costValueProperty=model.createProperty(uri+"hasDataValue");
      serviceCostResource.addProperty(costValueProperty, "50");
      
      Property timeUnitProperty=model.createProperty(uri+"hasDataUnit");
      serviceCostResource.addProperty(timeUnitProperty, "euro");
      
     Property timeConditionProperty=model.createProperty(uri+"hasDataCondition");
      serviceCostResource.addProperty(timeConditionProperty, "less than");
      
      Property priorityProperty=model.createProperty(uri+"hasPriority");
      serviceCostResource.addProperty(priorityProperty, "1");
      
      
      }
      
     ////Assign the data property of Processed data size sub class....
      {
       Resource dataSizeResource=model.createResource(uri+"ProcessedDataSize");
       Property hasObjectProperty=model.createProperty(uri+"hasObject");
       demandResource.addProperty(hasObjectProperty, dataSizeResource);
          
      Property upperDataSizeProperty=model.createProperty(uri+"hasUpperProcessedDataSize");
      dataSizeResource.addProperty(upperDataSizeProperty,"2"); 
      
      Property lowerDataSizeProperty=model.createProperty(uri+"hasLowerProcessedDataSize");
      dataSizeResource.addProperty(lowerDataSizeProperty, "1");
      
      Property timeUnitProperty=model.createProperty(uri+"hasDataUnit");
      dataSizeResource.addProperty(timeUnitProperty, "MB");
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
      qualityAccuracyResource.addProperty(accuracyValueProperty, "50");
      
      Property timeUnitProperty=model.createProperty(uri+"hasDataUnit");
      qualityAccuracyResource.addProperty(timeUnitProperty, "%");
      
     Property timeConditionProperty=model.createProperty(uri+"hasDataCondition");
      qualityAccuracyResource.addProperty(timeConditionProperty, "greater than");
      
      Property priorityProperty=model.createProperty(uri+"hasPriority");
      qualityAccuracyResource.addProperty(priorityProperty, "3");
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

      
      