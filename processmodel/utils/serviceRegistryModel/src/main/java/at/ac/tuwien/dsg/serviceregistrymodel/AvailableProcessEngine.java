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
public class AvailableProcessEngine {
    public String uri="http://DataAnalyticProcessEngine.com#";
      public String objectName="ProcessEngineInformation";
      

    public static void main(String []p)
    {
        new AvailableProcessEngine().modelCreation();
    }
  
    //for the rdf file creation
    public void modelCreation()
    {
      
      //for assigning of main resource
      Model model=ModelFactory.createDefaultModel();
      Resource processEngineResource=model.createResource(uri+objectName);
      
      //////Sampling sub node creation
      {
        Resource processTypeResource=model.createResource(uri+"Sampling");
        Property processTypeProperty=model.createProperty(uri+"hasProcesType");
        processEngineResource.addProperty(processTypeProperty, processTypeResource);
        
        Property objectProperty=model.createProperty(uri+"hasObject");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticServiceUnit.com#PE1");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticServiceUnit.com#PE2");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticServiceUnit.com#PE3");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticServiceUnit.com#PE4");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticServiceUnit.com#PE5");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticServiceUnit.com#PE6");
        
    }
       
      //Clustering sub node creation
        {
        Resource processTypeResource=model.createResource(uri+"Clustering");
        Property processTypeProperty=model.createProperty(uri+"hasProcesType");
        processEngineResource.addProperty(processTypeProperty, processTypeResource);
        
        Property objectProperty=model.createProperty(uri+"hasObject");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticProcessUnit.com#PE7");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticProcessUnit.com#PE8");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticProcessUnit.com#PE9");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticProcessUnit.com#PE10");
        
       }
        
     //Quering sub node creation
        {
        Resource processTypeResource=model.createResource(uri+"Querying");
        Property processTypeProperty=model.createProperty(uri+"hasProcesType");
        processEngineResource.addProperty(processTypeProperty, processTypeResource);
        
        Property objectProperty=model.createProperty(uri+"hasObject");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticEngine.com#PE11");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticEngine.com#PE10");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticEngine.com#PE20");
        processTypeResource.addProperty(objectProperty, "http://DataAnalyticEngine.com#PE24");
        
    }
      
      //for rdf model
      model.setNsPrefix("engine", uri);
      model.write(System.out);
      
      //for rdf file storage
      {   
        File f=new File("./example_processengine");
            if(!f.exists())
            {
               f.mkdir();
               System.out.println("file created");
            }
          try
            {
                FileWriter fw=new FileWriter("./example_processengine/"+objectName+".rdf");
                model.write(fw);
                System.out.println("file is stored");
            }
          catch(Exception e)
            {
                System.out.println("exception occured : "+e);
            }
      
    }
      
      
      
    } 
}
