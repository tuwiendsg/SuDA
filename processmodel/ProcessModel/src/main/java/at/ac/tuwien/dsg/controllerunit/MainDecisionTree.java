/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.controllerunit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author dsg
 */
public class MainDecisionTree
{
    public static DecisionTreeGeneration12 newTree=new DecisionTreeGeneration12();
     public static void main(String []p)
   {
       //newTree=new DecisionTreeGeneration();
       MainDecisionTree tree=new MainDecisionTree();
       System.out.println("Decision tree is generated");
               tree.generateTree();
               System.out.println("View of the DecisionTree");
               newTree.ouputDecisionTree();
   }
     
     
     public void generateTree()
     {
         
         newTree.createRootNode(1, "H||Z||L||T||");
         newTree.addEventNode(1, 2, "meat?");
         newTree.addYesDecisionNode(2, 3, "||L||T||");
         newTree.addNoDecisionNode(2, 4, "||H||Z||");
         newTree.addEventNode(3, 5, "stripes?");
         newTree.addEventNode(4, 6, "stripes?");
         newTree.addYesDecisionNode(5, 7, "||T||");
         newTree.addNoDecisionNode(5, 8, "||L||");
         newTree.addYesDecisionNode(6, 9, "||Z||");
         newTree.addNoDecisionNode(6, 10, "||H||");
         
         /*newTree.addYesNode(1, 2, "stripes?");
         newTree.addNoNode(1, 3, "stripes?");
         newTree.addYesNode(2, 4, "tiger");
         newTree.addNoNode(2, 5, "leopard");
         newTree.addYesNode(3, 6, "Zebra");
         newTree.addNoNode(3, 7, "Horse");
         /*newTree.createRootNode(1,"Does animal eat meat?");
        newTree.addYesNode(1,2,"Does animal have stripes?");
        newTree.addNoNode(1,3,"Does animal have stripes?");
        newTree.addYesNode(2,4,"Animal is a Tiger");
        newTree.addNoNode(2,5,"Animal is a Leopard");
        newTree.addYesNode(3,6,"Animal is a Zebra");
        newTree.addNoNode(3,7,"Animal is a Horse");*/
     }
}