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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Anindita
 */
public class AnalyticServiceUnit {
    public static String uri;
    public static String objectName;
    
    //for create the object
    public static AnalyticServiceUnit getInstance()
    {
        return new AnalyticServiceUnit();
    }
    
    //for designing the rdf model
   public void serviceModel(HashMap information)
    {
        Model model=ModelFactory.createDefaultModel();
        Resource serviceResource=model.createResource(uri+objectName);
        
        Set informationSet=information.entrySet();
        Iterator i =informationSet.iterator();
        
        ////for designing the property of rdf model
        while(i.hasNext())
        {
            Map.Entry informationMap = (Map.Entry)i.next();
            
      
            if(informationMap.getKey().equals("analyticTime"))
                {
                     Property analyticTime=model.createProperty(uri+"analyticTime");
                     serviceResource.addProperty(analyticTime,informationMap.getValue().toString());           
                }
      
            if(informationMap.getKey().equals("serviceCost"))
                {
                    Property serviceCost=model.createProperty(uri+"serviceCost");
                    serviceResource.addProperty(serviceCost,informationMap.getValue().toString());             
                }
      
            if(informationMap.getKey().equals("processType"))
                {
                    Property processType=model.createProperty(uri+"processType");
                    serviceResource.addProperty(processType, informationMap.getValue().toString());                    
                }
     
            if(informationMap.getKey().equals("taskName"))
                {
                    Property actionProperty=model.createProperty(uri+"taskName");
                    serviceResource.addProperty(actionProperty, informationMap.getValue().toString());                  
                }
        }
      
        model.setNsPrefix("service", uri);
        model.write(System.out);
    
    
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
