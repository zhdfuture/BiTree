package zh.TreeBianli;

import java.util.Stack;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value){
        this.value=value;
    }
}
public class PreOrder {
    public static void preOrderRe(TreeNode Btree){  //递归
        if(Btree==null){
            return;
        }
        System.out.print(Btree.value+" ");  //先根
        TreeNode leftTree=Btree.left;
        TreeNode rightTree=Btree.right;
        //再左
            preOrderRe(leftTree);
            preOrderRe(rightTree);
        }



    //非递归实现先序遍历
    public static void preOrderFi(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                System.out.print(cur.value+" ");
                stack.push(cur);
                cur=cur.left;
            }
            if(!stack.isEmpty()){
                cur=stack.pop();
                cur=cur.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode[] node=new TreeNode[10];  //以数组形式生产一棵完全二叉树
        for(int i=0;i<10;i++){
            node[i]=new TreeNode(i);
        }
        for(int i=0;i<10;i++){
            if(i*2+1<10){
                node[i].left=node[i*2+1];
            }
            if(i*2+2<10){
                node[i].right=node[i*2+2];
            }
        }
       // preOrderRe(node[0]);
        preOrderFi(node[0]);
    }
}
