/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.controllerunit;



/**
 *
 * @author Anindita
 */
public class MainDecisionTree
{
    public static DecisionTreeGeneration newTree=DecisionTreeGeneration.getInstance();
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
         
         newTree.createRootNode(1, "H||Z||L||T||");
         newTree.eventNodeAdd(1, 2, "meat?");
         newTree.decisionNodeAddYesBranch(2, 3, "||L||T||");
         newTree.decisionNodeAddNoBranch(2, 4, "||H||Z||");
         newTree.eventNodeAdd(3, 5, "stripes?");
         newTree.eventNodeAdd(4, 6, "stripes?");
         newTree.decisionNodeAddYesBranch(5, 7, "||T||");
         newTree.decisionNodeAddNoBranch(5, 8, "||L||");
         newTree.decisionNodeAddYesBranch(6, 9, "||Z||");
         newTree.decisionNodeAddNoBranch(6, 10, "||H||");
         
         
     }
}