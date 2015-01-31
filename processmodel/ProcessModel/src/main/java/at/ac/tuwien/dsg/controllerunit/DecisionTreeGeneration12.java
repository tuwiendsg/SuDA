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
public class DecisionTreeGeneration12 {
    //private int nodeID;
   //private String questansNode=null;
   //private String ansNode=null;
   //private DecisionNode yesBranch=null;
   //private DecisionNode noBranch=null;
   //private DecisionTreeGeneration12 rootNode=null;
   //private String decisionNode=null;
   //private DecisionNode decisionBranch=null;
   
   //static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
   /*public DecisionNode()
   {
       
   }
   public DecisionNode(int newNodeID, String newquestansNode)
   {
      nodeID=newNodeID;
      questansNode=newquestansNode;
     // ansNode=newansNode;
   }
   */
   public DecisionNode rootNode=null;
   public void createRootNode(int newNodeID, String newquestansNode)
   {
       rootNode=new DecisionNode( newNodeID, newquestansNode);
       System.out.println("root node is created");
   }
   
   ////////////EventNode
   
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
                  //return false;
              }
           }
           else{
               return  false;
           }
       }
   }
           //////////
            /*  else{
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
           /////////////////
           
       }
   }*/
   
   
   
   /////////////////////////Event Node
   
   
   
   ////////////////////////DecisionNode
   
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
               
               //////////
               /*if(searchTreeAndAddYesDecisionNode(currentNode.yesBranch, existingNodeID, newNodeID, newDecisionNode))
               {
                   return  true;
               }
               */
           
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
               //////////////////////
               
           }
           else{
                   return false;
               }
       }
                 
   }
   
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
               //System.out.println("ERROR: "+existingNodeID+"  This ID have no existence");
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
   
   
   
   
   
   
   
   
   
   
   ///////////////////Add Decision Node at the No Branch of Event Node
   
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
               
               /////////////////////
               /*if(searchTreeAndAddNoDecisionNode(currentNode.noBranch, existingNode, nodeID, newDecisionNode))
                       {
                           return true;
                       }*/
               
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
            //////////////////////   
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
   
   
   
   
   
   public void ouputDecisionTree()
   {
       viewDecisionTree("1", rootNode);
   }
   private void viewDecisionTree(String tag, DecisionNode currentNode)
   {
       if(currentNode==null)
       {
           System.out.println("There have no node");
           return;
       }
       else
       {
           viewDecisionTree12(tag, currentNode.decisionbranch);
           System.out.println("  nodeid   "+tag+"  content "+currentNode.value);
           
       }
   }
   private void viewDecisionTree12(String tag, EventNode currentNode)
   {
       if(currentNode==null)
       {
           return;
       }
       else{
       viewDecisionTree("["+tag+".1]", currentNode.yesBranch);
       viewDecisionTree("["+tag+".2]", currentNode.noBranch);
       System.out.println("  nodeid   "+tag+"  content "+currentNode.condition);
       }
       
   }
   
   
  
}
