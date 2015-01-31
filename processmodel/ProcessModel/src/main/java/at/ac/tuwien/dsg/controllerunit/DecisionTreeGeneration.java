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
public class DecisionTreeGeneration {
    public DecisionNode rootNode=null;

    public static DecisionTreeGeneration getInstance() {
        return new DecisionTreeGeneration();
    }
    
    
    
   public void createRootNode(int newNodeID, String newquestansNode)
   {
       rootNode=new DecisionNode( newNodeID, newquestansNode);
       System.out.println("root node is created");
   }
   
   public void decisionNodeAddYesBranch(int existingNodeID, int nodeID, String decisionValue)
   {
       DecisionNodeAdditionYesBranch.getInstance(rootNode).addYesDecisionNode(existingNodeID, nodeID, decisionValue);
   }
   
   public void decisionNodeAddNoBranch(int existingNodeID, int nodeID, String decisionValue)
   {
     DecisionNodeAdditionNoBranch.getInstance(rootNode).addNoDecisionNode(existingNodeID, nodeID, decisionValue);
   }
   public void eventNodeAdd(int existingNodeID, int nodeID, String eventValue)
   {
       EventNodeAddition.getInstance(rootNode).addEventNode(existingNodeID, nodeID, eventValue);
   }
   
   public void desicionTreeShow()
   {
       DecisionTreeView.getInstance(rootNode).ouputDecisionTree();
   }
   
}
