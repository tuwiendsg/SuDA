/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.decisionTreeCreation;

import at.ac.tuwien.dsg.controllerunit.DecisionTreeGeneration;
import java.util.LinkedList;



/**
 *
 * @author Anindita
 */
public class MainDecisionTree
{
    public static DecisionTreeGeneration newTree=DecisionTreeGeneration.getInstance();
    LinkedList<String> eventNodeContent=MainRDFGraphAccess.getInstance("http://DataAnalyticServiceDemand.com").eventNodeContent();
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
        //for(String s: eventNodeContent)
        {
         newTree.createRootNode(1, "||PE1||PE2||PE3||PE4||PE5||PE6||");
         newTree.eventNodeAdd(1, 2, eventNodeContent.get(0));
         newTree.decisionNodeAddYesBranch(2, 3, "||PE3||PE4||PE5||PE6||");
         newTree.decisionNodeAddNoBranch(2, 4, "||PE1||PE2||");
         newTree.eventNodeAdd(3, 5, eventNodeContent.get(1));
         newTree.decisionNodeAddYesBranch(5, 6, "||PE4||PE5||PE6||");
         newTree.decisionNodeAddNoBranch(5,7,"||PE3||");
         newTree.eventNodeAdd(6, 8, eventNodeContent.get(2));
         newTree.decisionNodeAddYesBranch(8, 9, "||PE4||PE5||");
         newTree.decisionNodeAddNoBranch(8, 10, "||PE6||");
         
        }
         /*newTree.createRootNode(1, "H||Z||L||T||");
         newTree.eventNodeAdd(1, 2, "meat?");
         newTree.decisionNodeAddYesBranch(2, 3, "||L||T||");
         newTree.decisionNodeAddNoBranch(2, 4, "||H||Z||");
         newTree.eventNodeAdd(3, 5, "stripes?");
         newTree.eventNodeAdd(4, 6, "stripes?");
         newTree.decisionNodeAddYesBranch(5, 7, "||T||");
         newTree.decisionNodeAddNoBranch(5, 8, "||L||");
         newTree.decisionNodeAddYesBranch(6, 9, "||Z||");
         newTree.decisionNodeAddNoBranch(6, 10, "||H||");*/
         
         
     }
}