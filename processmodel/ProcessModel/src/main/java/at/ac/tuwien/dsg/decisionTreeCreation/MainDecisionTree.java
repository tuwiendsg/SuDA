/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.decisionTreeCreation;

import at.ac.tuwien.dsg.controllerunit.DecisionTreeGeneration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;



/**
 *
 * @author Anindita
 */
public class MainDecisionTree
{
    public static DecisionTreeGeneration newTree=DecisionTreeGeneration.getInstance();
    LinkedList<String> eventNodeContent=MainRDFGraphAccess.getInstance("http://DataAnalyticServiceDemand.com#ResultQualityOfSampling").eventNodeContent();
    LinkedList<String> processEngineSet=new LinkedList<String>();
    
    public static void main(String []p)
   {
       //newTree=new DecisionTreeGeneration();
       MainDecisionTree tree=new MainDecisionTree();
       System.out.println("Decision tree is generated");
               tree.generateTree();
               System.out.println("View of the DecisionTree");
               newTree.desicionTreeShow();
   }
     
     
     public void generateTree()
     {
        
         
         processEngineSet.add("PE1");
         processEngineSet.add("PE2");
         processEngineSet.add("PE3");
         processEngineSet.add("PE4");
         processEngineSet.add("PE5");
         processEngineSet.add("PE6");
         //LinkedList<String> processEngineSet1=new LinkedList<String>();
         //String processEngineSet="PE1||PE2||PE3||PE4||PE5||PE6";
         newTree.createRootNode(1, "||"+processEngineSet+"||");
         newTree.eventNodeAdd(1, 2, eventNodeContent.get(0));
         
         List<LinkedList<String>> processEngineSubSet1=new SortingForDecisionNode().generateDecisionNode(processEngineSet, eventNodeContent.get(0));
         newTree.decisionNodeAddYesBranch(2, 3, "||"+processEngineSubSet1.get(0)+"||");
         newTree.decisionNodeAddNoBranch(2, 4, "||"+processEngineSubSet1.get(1)+"||");
         newTree.eventNodeAdd(3, 5, eventNodeContent.get(1));
         List<LinkedList<String>> processEngineSubSet2=new SortingForDecisionNode().generateDecisionNode(processEngineSubSet1.get(0), eventNodeContent.get(1));
         newTree.decisionNodeAddYesBranch(5, 6, "||"+processEngineSubSet2.get(0)+"||");
         newTree.decisionNodeAddNoBranch(5,7,"||"+processEngineSubSet2.get(1)+"||");
         newTree.eventNodeAdd(6, 8, eventNodeContent.get(2));
         List<LinkedList<String>> processEngineSubSet3=new SortingForDecisionNode().generateDecisionNode(processEngineSubSet2.get(0), eventNodeContent.get(2));
         
         newTree.decisionNodeAddYesBranch(8, 9, "||"+processEngineSubSet3.get(0)+"||");
         newTree.decisionNodeAddNoBranch(8, 10, "||"+processEngineSubSet3.get(1)+"||");
         
      
        
     }
     
}