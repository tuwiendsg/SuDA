/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisionTreeTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author dsg
 */
public class DecisionTree
{
    public static DecisionTreeGeneration newTree=new DecisionTreeGeneration();
     public static void main(String []p)
   {
       //newTree=new DecisionTreeGeneration();
       DecisionTree tree=new DecisionTree();
       System.out.println("Decision tree is generated");
               tree.generateTree();
               System.out.println("View of the DecisionTree");
               newTree.ouputDecisionTree();
   }
     
     
     public void generateTree()
     {
         
         newTree.createRootNode(1, "meat?");
         newTree.addYesNode(1, 2, "stripes?");
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