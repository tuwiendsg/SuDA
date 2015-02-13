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
public class RDFGraphAccessForDecisionNode {
    private static String RDFURI=null;
    
    public static RDFGraphAccessForDecisionNode getInstance(String newRDFURI)
    {
        RDFURI=newRDFURI;
        return new RDFGraphAccessForDecisionNode();
    }
    
   public int  conditionValue (String conditionName)
   {
      // int dataValue=Integer.parseInt(RDFManipulationObject.getInstance(RDFURI).queryResultSubject(conditionName, "hasDataValue"));
       //System.out.println("DataValue="+ dataValue);
       
       return Integer.parseInt(RDFManipulationObject.getInstance(RDFURI).queryResultSubject(conditionName, "hasDataValue"));
//return dataValue;
   }
   
   public LinkedList<String> setOfProcessEngine(String subjectName)
   {
       
       return RDFManipulationObject.getInstance(RDFURI).queryResultSubjectList(subjectName, "hasObject");
   }

}
