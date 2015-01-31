/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.tuwien.dsg.controllerunit;

/**
 *
 * @author dsg
 */
public class DecisionNode {
    public int nodeID;
    public String value=null;
    public EventNode decisionbranch=null;
    public DecisionNode rootNode=null;
    
    public DecisionNode()
    {
        
    }
    
    
    public DecisionNode(int newNodeID, String decisionValue)
    {
        nodeID=newNodeID;
        value=decisionValue;
    }
    
    public void createRootNode(int newNodeID, String newquestansNode)
   {
       rootNode=new DecisionNode( newNodeID, newquestansNode);
       System.out.println("rootnode is created");
   }
    
}
