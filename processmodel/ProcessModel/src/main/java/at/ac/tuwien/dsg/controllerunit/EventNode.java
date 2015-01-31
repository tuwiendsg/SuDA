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

///This class is used to design the structure of Event Node to Desicion Tree
public class EventNode {
    public int nodeID;
    public String condition;
    public DecisionNode yesBranch;
    public DecisionNode noBranch;
    
    public EventNode()
    {
        
    }
    
    public EventNode(int newnodeID, String newCondition)
    {
        nodeID=newnodeID;
        condition=newCondition;
    }
}
