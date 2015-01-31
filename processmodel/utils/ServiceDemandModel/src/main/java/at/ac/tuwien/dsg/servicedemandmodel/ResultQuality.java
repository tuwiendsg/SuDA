/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.servicedemandmodel;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
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
public class ResultQuality {
    
    public static String uri;
    public static String objectName;
    
    //for creating the object
    public static ResultQuality getInstance()
    {
        return new ResultQuality();
    }
    
    //for the rdf file creation
    public void modelCreation(HashMap information)
    {
      
      //for assigning of main resource
      Model model=ModelFactory.createDefaultModel();
      Resource demandResource=model.createResource(uri+objectName);
      
      //for assigning of sub resource
      Resource qualityResource=model.createResource(uri+"DataQuality");
      Property hasQuality=model.createProperty(uri+"DataQuality");
      demandResource.addProperty(hasQuality, qualityResource);
      
      //for the HashMap 
      Set informationSet=information.entrySet();
      Iterator i=informationSet.iterator();
     
      //for assigning the information of property
      while(i.hasNext())
      {
      Map.Entry informationMap=(Map.Entry)i.next();
      if(informationMap.getKey().equals("executionTime"))
      {
      Property analyticTime=model.createProperty(uri+"hasExecutionTime");
      demandResource.addProperty(analyticTime, informationMap.getValue().toString());                          
      }
      
      if(informationMap.getKey().equals("serviceCost"))
      {
      Property serviceCost=model.createProperty(uri+"hasServiceCost");
      demandResource.addProperty(serviceCost,informationMap.getValue().toString());                             
      }
      
      if(informationMap.getKey().equals("processType"))
      {
      Property processType=model.createProperty(uri+"hasProcessType");
      demandResource.addProperty(processType,informationMap.getValue().toString());                      
      }
      
      if(informationMap.getKey().equals("processedDataType"))
      {
      Property processType=model.createProperty(uri+"hasProcessedDataType");
      demandResource.addProperty(processType,informationMap.getValue().toString());                      
      }
     
      //under quality node
      if(informationMap.getKey().equals("completeness"))
      {
      Property locationProperty=model.createProperty(uri+"hasCompleteness");
      qualityResource.addProperty(locationProperty,informationMap.getValue().toString());                     
      }
      
      if(informationMap.getKey().equals("reliability"))
      {
      Property locationProperty=model.createProperty(uri+"hasReliability");
      qualityResource.addProperty(locationProperty,informationMap.getValue().toString());                   
      }
      
      if(informationMap.getKey().equals("accuracy"))
      {
      Property locationProperty=model.createProperty(uri+"hasAccuracy");
      qualityResource.addProperty(locationProperty,informationMap.getValue().toString());                     
      }
      
      if(informationMap.getKey().equals("consistency"))
      {
      Property locationProperty=model.createProperty(uri+"hasConsistency");
      qualityResource.addProperty(locationProperty,informationMap.getValue().toString());                     
      }
      
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
