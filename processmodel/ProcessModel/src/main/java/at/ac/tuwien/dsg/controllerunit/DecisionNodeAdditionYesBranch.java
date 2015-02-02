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
public class DecisionNodeAdditionYesBranch {
    public static DecisionNode rootNode=null;
    
  ///////create the object of this class.....  
    public static DecisionNodeAdditionYesBranch getInstance(DecisionNode newRootNode)
    {
      rootNode=newRootNode;
        return new DecisionNodeAdditionYesBranch();
    }
    
    
    
    
 ///////////////////Add Decision Node at the Yes Branch if root node is exist... 
   public void addYesDecisionNode(int existingNodeID,int nodeID, String newDecisionNode)
   {
      if(rootNode!=null)
      {
         if(searchTreeAndAddYesDecisionNode(rootNode.decisionbranch, existingNodeID, nodeID, newDecisionNode))
         {
             System.out.println(nodeID+"  is added on the yes branch of existing NodeId="+existingNodeID);
         }
         else{
             System.out.println(existingNodeID+"   is not exist");
         }
                 
      }
      else{
          System.out.println("There have no existence of rootnode");
      }
   }
  
   ////search the tree and findout the yes branch of event node will be empty....
   public boolean searchTreeAndAddYesDecisionNode(EventNode currentNode, int existingNodeID, int newNodeID, String newDecisionNode )
   {
       if(currentNode.nodeID==existingNodeID)
       {
           if(currentNode.yesBranch==null)
           {
               currentNode.yesBranch=new DecisionNode(newNodeID,newDecisionNode);
               System.out.println(newNodeID+" is added under the yes branch of "+existingNodeID);
           }
           else{
               System.out.println("Warning: overwritten of yes branch");
               currentNode.yesBranch=new DecisionNode(newNodeID,newDecisionNode);
           }
           return true;
       }
          else{
           if(currentNode.yesBranch!=null)
           {
               if(searchSubTreeAndAddYesDecisionNode12(currentNode.yesBranch, existingNodeID, newNodeID, newDecisionNode))
               {
                   return true;
               }
               
            else{
               if(currentNode.noBranch!=null)
               {
                   if(searchSubTreeAndAddYesDecisionNode12(currentNode.noBranch, existingNodeID, newNodeID, newDecisionNode))
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
                   return false;
               }
       }
                 
   }
   
   ////////For the searching of tree if decision node is occured...
   public boolean searchSubTreeAndAddYesDecisionNode12(DecisionNode currentNode, int existingNodeID, int nodeID, String value)
   {
       if(currentNode.nodeID==existingNodeID)
       {
          System.out.println("ERROR: "+existingNodeID+"  represents the nodeID of DecisionNode not the EventNode");
          return false;
       }
       else{
           if(currentNode.decisionbranch==null)
           {
              return  false;
           }
           else{
               if(searchTreeAndAddYesDecisionNode(currentNode.decisionbranch, existingNodeID, nodeID, value))
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
