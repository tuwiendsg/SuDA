/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.decisionTreeCreation;

import at.ac.tuwien.dsg.app.graphretrieve.RDFManipulationObject;
import java.util.LinkedList;

/**
 *
 * @author Anindita
 */
public class MainRDFGraphAccess {
    
    private static String RDFURI=null;
    
    public static MainRDFGraphAccess getInstance(String newRDFURI)
    {
        RDFURI=newRDFURI;
        return new MainRDFGraphAccess();
    }
    
   public LinkedList<String>  eventNodeContent ()
   {
       LinkedList<String> eventCondition=new LinkedList<String>();
       
       ////////size allocation for event node.......
       {
       int listSize=3;
       for(int i=0; i<listSize;i++)
       {
           eventCondition.add(null);
       }
      }
       
       
       
       //Data Collection for ExecutionTime Event Node generation
       {
       String dataValue=RDFManipulationObject.getInstance(RDFURI).queryResultSubject("ExecutionTime", "hasDataValue");
       System.out.println("DataValue="+ dataValue);
       
       String dataConditionValue=RDFManipulationObject.getInstance(RDFURI).queryResultSubject("ExecutionTime", "hasDataCondition");
       System.out.println("dataConditionValue="+ dataConditionValue);
       
       String dataUnit=RDFManipulationObject.getInstance(RDFURI).queryResultSubject("ExecutionTime", "hasDataUnit");
       System.out.println("DataUnit="+ dataUnit);
       
       int priorityValue=Integer.parseInt(RDFManipulationObject.getInstance(RDFURI).queryResultSubject("ExecutionTime", "hasPriority"));
       System.out.println("priorityValue="+ priorityValue);
       
       eventCondition.set((priorityValue-1), "ExecutionTime "+dataConditionValue.replace(" ", "")+" "+dataValue+" "+dataUnit);
       }
       
       //Data Collection for ExecutionCost Event Node generation
       {
       String dataValue=RDFManipulationObject.getInstance(RDFURI).queryResultSubject("ExecutionCost", "hasDataValue");
       System.out.println("DataValue="+ dataValue);
       
       String dataConditionValue=RDFManipulationObject.getInstance(RDFURI).queryResultSubject("ExecutionCost", "hasDataCondition");
       System.out.println("dataConditionValue="+ dataConditionValue);
       
       String dataUnit=RDFManipulationObject.getInstance(RDFURI).queryResultSubject("ExecutionCost", "hasDataUnit");
       System.out.println("dataConditionValue="+ dataUnit);
       
       int priorityValue=Integer.parseInt(RDFManipulationObject.getInstance(RDFURI).queryResultSubject("ExecutionCost", "hasPriority"));
       System.out.println("priorityValue="+ priorityValue);
       
       eventCondition.set((priorityValue-1), "ExecutionCost "+dataConditionValue.replace(" ", "")+" "+dataValue+" "+dataUnit);
       }
       
       //Data Collection for ExecutionTime Event Node generation
       {
       String dataValue=RDFManipulationObject.getInstance(RDFURI).queryResultSubject("DataAccuracy", "hasDataValue");
       System.out.println("DataValue="+ dataValue);
       
       String dataConditionValue=RDFManipulationObject.getInstance(RDFURI).queryResultSubject("DataAccuracy", "hasDataCondition");
       System.out.println("dataConditionValue="+ dataConditionValue);
       
        String dataUnit=RDFManipulationObject.getInstance(RDFURI).queryResultSubject("DataAccuracy", "hasDataUnit");
       System.out.println("dataConditionValue="+ dataUnit);
       
       int priorityValue=Integer.parseInt(RDFManipulationObject.getInstance(RDFURI).queryResultSubject("DataAccuracy", "hasPriority"));
       System.out.println("priorityValue="+ priorityValue);
       
       eventCondition.set((priorityValue-1), "DataAccuracy "+dataConditionValue.replace(" ", "")+" "+dataValue+" "+dataUnit);
       }
       
      return eventCondition;
   }

       
}

