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
public class DecisionTreeView {
    
    public static DecisionNode rootNode=null;
    
    public static DecisionTreeView getInstance(DecisionNode newRootNode)
    {
        rootNode=newRootNode;
        return new DecisionTreeView();
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
