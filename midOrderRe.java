package MiddleOrder;

import java.util.Stack;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value){
        this.value=value;
    }
}

public class midOrderRe {
    //递归实现中序遍历
    public static void midOrder(TreeNode BTree){
        if(BTree==null){
            return;
        }
            midOrder(BTree.left);               //左--根--右
            System.out.print(BTree.value+" ");
            midOrder(BTree.right);

    }

    //非递归实现中序遍历
    public static void midOrder1(TreeNode root){
        TreeNode cur=root;
        TreeNode top=null;
        Stack<TreeNode> stack=new Stack<>();
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);   //将左节点入栈
                cur=cur.left;
            }
            if(!stack.isEmpty()){
                top=stack.pop();
                System.out.print(top.value+" ");   //在出栈的时候打印
                cur=top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode[] node=new TreeNode[10];  //以数组形式生产一棵完全二叉树
        for(int i=0;i<10;i++){
            node[i]=new TreeNode(i);
        }
        for(int i=0;i<10;i++) {
            if (i * 2 + 1 < 10) {
                node[i].left = node[i * 2 + 1];
            }
            if (i * 2 + 2 < 10) {
                node[i].right = node[i * 2 + 2];
            }
        }
           // midOrder(node[0]);
            midOrder1(node[0]);
        }
    }

