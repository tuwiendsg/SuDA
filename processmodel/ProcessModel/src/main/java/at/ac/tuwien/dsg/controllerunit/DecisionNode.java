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


//// This class is used to design the structure of Desicion Node to Deciion Tree

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
    
    
    
}
