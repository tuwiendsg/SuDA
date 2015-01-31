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
public class DecisionTreeGeneration {
   private int nodeID;
   private String questansNode=null;
   //private String ansNode=null;
   private DecisionTreeGeneration yesBranch=null;
   private DecisionTreeGeneration noBranch=null;
   private DecisionTreeGeneration rootNode=null;
   
   static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
   public DecisionTreeGeneration()
   {
       
   }
   public DecisionTreeGeneration(int newNodeID, String newquestansNode)
   {
      nodeID=newNodeID;
      questansNode=newquestansNode;
     // ansNode=newansNode;
   }
   
   public void createRootNode(int newNodeID, String newquestansNode)
   {
       rootNode=new DecisionTreeGeneration( newNodeID, newquestansNode);
       System.out.println("rootnode is created");
   }
   
   public boolean searchDecisionTreeAndAddYesNode(DecisionTreeGeneration currentNode, int existingNodeID, int newNodeID, String questandans )
   {
       if(currentNode.nodeID==existingNodeID)
       {
           if(currentNode.yesBranch==null)
           {
               currentNode.yesBranch=new DecisionTreeGeneration(newNodeID,questandans);
               System.out.println(newNodeID+" is added under the yes branch of "+existingNodeID);
           }
           else{
               System.out.println("Warning: overwritten of yes branch");
               currentNode.yesBranch=new DecisionTreeGeneration(newNodeID,questandans);
           }
           return true;
       }
          else{
           if(currentNode.yesBranch!=null)
           {
               if(searchDecisionTreeAndAddYesNode(currentNode.yesBranch, existingNodeID, newNodeID, questandans))
               {
                   return  true;
               }
               
           
           else{
               if(currentNode.noBranch!=null)
               {
                   if(searchDecisionTreeAndAddYesNode(currentNode.noBranch, existingNodeID, newNodeID, questandans))
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
   
   public void addYesNode(int existingNodeID,int nodeID, String newquestans)
   {
      if(rootNode!=null)
      {
         if(searchDecisionTreeAndAddYesNode(rootNode, existingNodeID, nodeID, newquestans))
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
  
      
   public boolean searchTreeAndAddNoNode(DecisionTreeGeneration currentNode, int existingNode, int nodeID, String questans)
   {
       if(currentNode.nodeID==existingNode)
       {
           if(currentNode.noBranch==null)
           {
               currentNode.noBranch=new DecisionTreeGeneration(nodeID, questans);
               System.out.println(nodeID+"  is added under the No branch of "+existingNode);
           }
           else{
               System.out.println("Warning: overlapping the existant no node");
               currentNode.noBranch=new DecisionTreeGeneration(nodeID, questans);
           }
           return true;
       }
       else{
           if(currentNode.noBranch!=null)
           {
               if(searchTreeAndAddNoNode(currentNode.noBranch, existingNode, nodeID, questans))
                       {
                           return true;
                       }
               
           else{
               if(currentNode.yesBranch!=null)
               {
                   if(searchTreeAndAddNoNode(currentNode.yesBranch, existingNode, nodeID, questans))
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
   
   public void addNoNode(int existingNode, int nodeID, String questans)
   {
       if(rootNode!=null)
       {
      if(searchTreeAndAddNoNode(rootNode, existingNode, nodeID, questans))
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
   
   public void ouputDecisionTree()
   {
       viewDecisionTree("1", rootNode);
   }
   private void viewDecisionTree(String tag, DecisionTreeGeneration currentNode)
   {
       if(currentNode==null)
       {
           //System.out.println("There have no node");
           return;
       }
       else
       {
           System.out.println("  nodeid   "+tag+"  content "+currentNode.questansNode);
           viewDecisionTree("["+tag+".1]", currentNode.yesBranch);
           viewDecisionTree("["+tag+".2]", currentNode.noBranch);
       }
   }
   
   
  
}
