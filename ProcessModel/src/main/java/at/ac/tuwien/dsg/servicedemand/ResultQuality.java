/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.servicedemand;

//import static com.hp.hpl.jena.assembler.JA.Model;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
//import com.hp.hpl.jena.vocabulary.RDFS;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author dsg
 */
public class ResultQuality {
    

    public static void main(String []p)
    {
        
    
      String uri="http://DataAnalyticService.com#";
      String objectName="DataAnalyticServiceDemand";
      
      Model model=ModelFactory.createDefaultModel();
      //Resource moduleResource=model.createResource(uri+"SensoryModule");
      Resource demandResource=model.createResource(uri+objectName);
      //sensorResource.addProperty(RDFS.member, moduleResource);
      
      Property analyticTime=model.createProperty(uri+"analyticTime");
      demandResource.addProperty(analyticTime, "60sec/MB");
      
      //Resource gasSensor=model.createResource("http://www.eoc-inc.com/Cambridge/metal%20oxide%20gas%20sensors.htm");
      //sensorResource.addProperty(RDFS.seeAlso, gasSensor);
      
      
      Property serviceCost=model.createProperty(uri+"serviceCost");
      demandResource.addProperty(serviceCost,"5 euro/MB");
      
      Resource qualityResource=model.createResource(uri+"Quality");
      
      Property processType=model.createProperty(uri+"processType");
      qualityResource.addProperty(processType, "Batch Job Processing");
     
      Property locationProperty=model.createProperty(uri+"TaskNumber");
      qualityResource.addProperty(locationProperty, "2");
      
      Property hasQuality=model.createProperty(uri+"hasQuality");
      demandResource.addProperty(hasQuality, qualityResource);
      
      /////
      //Property monitoredgasName=model.createProperty(uri+"monitoredgasname");
     // Property monitoredgasconc=model.createProperty(uri+"monitoredgasconcentration");
     // sensorResource.addProperty(monitoredgasName, "Methane(CH4)");
      //sensorResource.addProperty(monitoredgasconc, "1000ppm");
             
      //Property position=model.createProperty(uri+"position");
      //Property board=model.createProperty(uri+"board");
      //Property sile=model.createProperty(uri+"silo");
      //Resource location=model.createResource(uri+"location"+objectName);
      //sensorResource.addProperty(position, "P3");
      //sensorResource.addProperty(board, "B1");
      //sensorResource.addProperty(sile, "S5");
      //sensorResource.addProperty(locationProperty, location);
      
      model.setNsPrefix("result", uri);
        model.write(System.out);
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
