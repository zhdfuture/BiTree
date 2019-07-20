package zh.TreeBianli;

import java.util.Stack;

public class BuildTree {
    public int preIndex=0;

    private TreeNode buildTreeChild(int[] preorder,int[] inorder,int startIn,int endIn) {
        if (startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        //找preorder[preIndex]在中序遍历的数组当中的下标
        int rootIndex=findIndexOfInoreder(inorder,preorder[preIndex],startIn,endIn);
        preIndex++;
        root.left =buildTreeChild(preorder ,inorder,startIn,rootIndex - 1);
        root.right = buildTreeChild(preorder, inorder,rootIndex + 1, endIn);
        return root;
    }

    public int findIndexOfInoreder(int[] inOder, int val, int StartIn, int EndIn) {
        for (int i = StartIn; i <=EndIn; i++) {
            if (inOder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null){
            return null;
        }
        return buildTreeChild(preorder,inorder,0,inorder.length-1);

    }
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
        BuildTree test=new BuildTree();
        int[] preOder={3,9,20,15,7};
        int[] midOder={9,3,15,20,7};
       TreeNode root= test.buildTree(preOder,midOder);
        midOrder1(root);

    }
}
