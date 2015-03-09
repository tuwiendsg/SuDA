/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.ascertainOfProcessModel;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author dsg
 */
public class AscertainOfProcessModel {
    private static String uri="http://processsequence.com#";
    private String objectName="ProcessControlFlow";
    
    
    public static void main(String []p)
    {
        new AscertainOfProcessModel().modelCreation();
    }
    public void modelCreation()
    {
        //for assigning of main resource
      Model model=ModelFactory.createDefaultModel();
      Resource processResource=model.createResource(uri+objectName);
      
        ////Assign the data property of the first process node
      {
        Resource processTypeResource=model.createResource(uri+"P1");
        Property processTypeProperty=model.createProperty(uri+"hasObject");
        processResource.addProperty(processTypeProperty, processTypeResource);
        
        Property hasStartNodeProperty=model.createProperty(uri+"hasStartNode");
        processTypeResource.addProperty(hasStartNodeProperty, "START");
        
        Property hasEndNodeProperty=model.createProperty(uri+"hasEndNode");
        processTypeResource.addProperty(hasEndNodeProperty, uri+"P2");
        
        Property hasResultQualityProperty=model.createProperty(uri+"hasQualityOfResultModel");
        processTypeResource.addProperty(hasResultQualityProperty, "http://DataAnalyticServiceDemand.com#ResultQualityOfSampling");
        
        Property hasProcessTypeNameProperty=model.createProperty(uri+"hasProcessType");
        processTypeResource.addProperty(hasProcessTypeNameProperty, "Sampling");
    }
        ////Assign the data property of the second process node
        
        {
        Resource processTypeResource=model.createResource(uri+"P2");
        Property processTypeProperty=model.createProperty(uri+"hasObject");
        processResource.addProperty(processTypeProperty, processTypeResource);
        
        Property hasStartNodeProperty=model.createProperty(uri+"hasStartNode");
        processTypeResource.addProperty(hasStartNodeProperty, uri+"P1");
        
        Property hasEndNodeProperty=model.createProperty(uri+"hasEndNode");
        processTypeResource.addProperty(hasEndNodeProperty, "END");
        
        Property hasResultQualityProperty=model.createProperty(uri+"hasQualityOfResultModel");
        processTypeResource.addProperty(hasResultQualityProperty, "http://DataAnalyticServiceDemand.com#ResultQualityOfQuerying");
        
        Property hasProcessTypeNameProperty=model.createProperty(uri+"hasProcessType");
        
        processTypeResource.addProperty(hasProcessTypeNameProperty, "Querying");
    }
        
       
      
      //for rdf model
      model.setNsPrefix("process", uri);
      model.write(System.out);
      
      //for rdf file storage
      {   
        File f=new File("./ProcessAscertain");
            if(!f.exists())
            {
               f.mkdir();
               System.out.println("file created");
            }
          try
            {
                FileWriter fw=new FileWriter("./ProcessAscertain/"+objectName+".rdf");
                model.write(fw);
            }
          catch(Exception e)
            {
                System.out.println("exception occured : "+e);
            }
      
    }
      
      
      
    }
    }

