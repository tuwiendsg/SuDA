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
public class EventNodeAddition {
    
    public static DecisionNode rootNode=null;
    
    public static EventNodeAddition getInstance(DecisionNode newRootNode)
    {
        rootNode=newRootNode;
        return new EventNodeAddition();
    }
    
    
    
    
    public void addEventNode(int existingNodeID, int nodeID, String newCondition)
   {
       if(rootNode==null)
       {
           System.out.println("there have no root node ");
       }
       else{
           if(searchTreeAndAddEventNode(rootNode, existingNodeID, nodeID, newCondition))
           {
              System.out.println(nodeID+"  is added with the desicion of "+existingNodeID);
           }
           else{
               System.out.println("there have no existence of existing node");
           }
       }
       
       
   }
   
   public boolean searchTreeAndAddEventNode(DecisionNode currentNode, int existingNodeID, int nodeID, String newCondition)
   {
       if(currentNode.nodeID==existingNodeID)
           {
               if(currentNode.decisionbranch==null)
               {
               currentNode.decisionbranch=new EventNode(nodeID, newCondition);
               System.out.println(nodeID+"  This eventnode is added with the decision node  "+existingNodeID);
               }
               else{
                   currentNode.decisionbranch=new EventNode(nodeID, newCondition);
                  System.out.println("Warning: "+nodeID+"  This eventnode is added with the decision node  "+existingNodeID);  
               }
               return true;
           }
           else{
               if(currentNode.decisionbranch!=null)
               {
                   if(searchEventSubTreeAndAddEventNode12(currentNode.decisionbranch, existingNodeID, nodeID, newCondition))
                   {
                       return true;
                   }
                   else{
                       return false;
                   }
                   
               }
               else{
                   return false;
               }
           }
   }
   public boolean searchEventSubTreeAndAddEventNode12(EventNode currentNode, int existingNodeID, int nodeID, String newCondition)
   {
       if(currentNode.nodeID==existingNodeID)
       {
           System.out.println(existingNodeID+" represents the event node not the decision node");
           return false;
       }
       else{
           if(currentNode.yesBranch!=null)
           {
              if(searchTreeAndAddEventNode(currentNode.yesBranch, existingNodeID, nodeID, newCondition)) 
              {
                  return true;
              }
              else{
                  if(currentNode.noBranch!=null)
                  {
                      if(searchTreeAndAddEventNode(currentNode.noBranch, existingNodeID, nodeID, newCondition)) 
              {
                  return true;
              }
                      else{
                          return false;
                      }
                  }
                  else{
                      return false;
                  }
                  
              }
           }
           else{
               return  false;
           }
       }
   }
           
}
