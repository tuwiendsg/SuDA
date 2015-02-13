/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.decisionTreeCreation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Anindita
 */
//RDFURI="http://DataAnalyticServiceUnit.com#"
public class SortingForDecisionNode {
    public static String RDFURI=null;
    
    public static SortingForDecisionNode getInstance(String newRDFURI)
    {
        RDFURI=newRDFURI;
       return new SortingForDecisionNode();
    }
    
    
    public List<LinkedList<String>> generateDecisionNode(LinkedList<String> processEngineSet, String eventNodeContent)
     {
         LinkedList<String> processEngineSubSetYes=new LinkedList<String>();
         LinkedList<String> processEngineSubSetNo=new LinkedList<String>();
         List<LinkedList<String>> processEngineSubSet=new ArrayList<LinkedList<String>>();
         StringTokenizer st=new StringTokenizer(eventNodeContent," ");
         String conditionName =st.nextToken();
         String condition=st.nextToken();
         int conditionValue=Integer.parseInt(st.nextToken());
         String conditionUnit=st.nextToken();
         if(condition.toLowerCase().equals("lessthan") || condition.equals("<"))
         {
             for(int i=0;i<processEngineSet.size();i++)
             {
             int value=RDFGraphAccessForDecisionNode.getInstance(RDFURI+processEngineSet.get(i)).conditionValue(conditionName);
             if(value < conditionValue)
             {
                 processEngineSubSetYes.add(processEngineSet.get(i));
             }
             else{
                 processEngineSubSetNo.add(processEngineSet.get(i));
             }
             }
         }
         else if (condition.toLowerCase().equals("greaterthan") || condition.equals(">")) {
                 for(int i=0;i<processEngineSet.size();i++)
             {
             int value=RDFGraphAccessForDecisionNode.getInstance(RDFURI+processEngineSet.get(i)).conditionValue(conditionName);
             if(value > conditionValue)
             {
                 processEngineSubSetYes.add(processEngineSet.get(i));
             }
             else{
                 processEngineSubSetNo.add(processEngineSet.get(i));
             }
             }
         }
         else if (condition.toLowerCase().equals("greaterandequal") || condition.equals(">=")) {
                 for(int i=0;i<processEngineSet.size();i++)
             {
             int value=RDFGraphAccessForDecisionNode.getInstance(RDFURI+processEngineSet.get(i)).conditionValue(conditionName);
             if(value >= conditionValue)
             {
                 processEngineSubSetYes.add(processEngineSet.get(i));
             }else{
                 processEngineSubSetNo.add(processEngineSet.get(i));
             }
             }
         }
         else if (condition.toLowerCase().equals("lessandequal") || condition.equals("<=")) {
                 for(int i=0;i<processEngineSet.size();i++)
             {
             int value=RDFGraphAccessForDecisionNode.getInstance(RDFURI+processEngineSet.get(i)).conditionValue(conditionName);
             if(value <= conditionValue)
             {
                 processEngineSubSetYes.add(processEngineSet.get(i));
             }
             else{
                 processEngineSubSetNo.add(processEngineSet.get(i));
             }
             }
         }
         else if (condition.toLowerCase().equals("equal") || condition.equals("=")) {
                 for(int i=0;i<processEngineSet.size();i++)
             {
             int value=RDFGraphAccessForDecisionNode.getInstance(RDFURI+processEngineSet.get(i)).conditionValue(conditionName);
             if(value==conditionValue)
             {
                 processEngineSubSetYes.add(processEngineSet.get(i));
             }
             else{
                 processEngineSubSetNo.add(processEngineSet.get(i));
             }
             }
         }
         else{
         System.out.println("ERROR: Unknown condition symbol="+condition);
     }
         
         processEngineSubSet.add(processEngineSubSetYes);
         processEngineSubSet.add(processEngineSubSetNo);
         //processEngineSet=processEngineSubSet;
         return processEngineSubSet;
     }
}
