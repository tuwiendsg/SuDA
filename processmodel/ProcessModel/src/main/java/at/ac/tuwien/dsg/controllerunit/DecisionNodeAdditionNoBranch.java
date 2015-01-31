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

///////////////////Add Decision Node at the No Branch of Event Node

public class DecisionNodeAdditionNoBranch {
    
    public static DecisionNode rootNode;
 
//used to create the object of this class   
  public static DecisionNodeAdditionNoBranch getInstance(DecisionNode newRootNode)
    {
        rootNode=newRootNode;
        return new DecisionNodeAdditionNoBranch();
    }
  
//used to find the place for new Decision Node and also assign it   
  public void addNoDecisionNode(int existingNode, int nodeID, String newDecisionNode)
   {
       if(rootNode!=null)
       {
      if(searchTreeAndAddNoDecisionNode(rootNode.decisionbranch, existingNode, nodeID, newDecisionNode))
      {
          System.out.println(nodeID+" is added in no branch under the existing node="+existingNode);
      }
      else{
          System.out.println("existing node id is not exist"); 
      }
          }
       
       else{
           System.out.println("There have no root node.");
       }
   }
   
 //     
   public boolean searchTreeAndAddNoDecisionNode(EventNode currentNode, int existingNode, int nodeID, String newDecisionNode)
   {
       if(currentNode.nodeID==existingNode)
       {
           if(currentNode.noBranch==null)
           {
               currentNode.noBranch=new DecisionNode(nodeID, newDecisionNode);
               System.out.println(nodeID+"  is added under the No branch of "+existingNode);
           }
           else{
               System.out.println("Warning: overlapping the existant no node");
               currentNode.noBranch=new DecisionNode(nodeID, newDecisionNode);
           }
           return true;
       }
       else{
           if(currentNode.noBranch!=null)
           {
               if(searchSubTreeAndAddNoDecisionNode12(currentNode.noBranch, existingNode, nodeID, newDecisionNode))
               {
                   return true;
               }
               
               else{
               if(currentNode.yesBranch!=null)
               {
                   if(searchSubTreeAndAddNoDecisionNode12(currentNode.yesBranch, existingNode, nodeID, newDecisionNode))
                   {
                       return true;
                   }
                   else{
                       return  false;
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
   
   public boolean searchSubTreeAndAddNoDecisionNode12(DecisionNode currentNode, int existingNode, int nodeID, String newDecisionNode)
   {
       if(currentNode.nodeID==existingNode)
       {
           System.out.println("ERROR: "+existingNode+"  represents the nodeID of Decision Node not the EventNode");
           return false;
       }
       else{
           if(currentNode.decisionbranch==null)
           {
               System.out.println("ERROR: "+existingNode+"  This node have no existence");
               return false;
           }
           else
           {
              if(searchTreeAndAddNoDecisionNode(currentNode.decisionbranch, existingNode, nodeID, newDecisionNode)) 
              {
                  return true;
              }
              else{
                  
                      return false;
                  
              }
              }
           }
       
   }
   
   
   
   
   
}
