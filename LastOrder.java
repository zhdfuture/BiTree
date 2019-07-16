import java.util.Stack;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value){
        this.value=value;
    }
}
public class LastOrder {

    //递归实现后序遍历
    public static void LastOrder(TreeNode BTree){
        if(BTree==null){
            return;
        }else{
            LastOrder(BTree.left);                    //左--右--根
            LastOrder(BTree.right);
            System.out.print(BTree.value+" ");
        }
    }


    //非递归实现后序遍历
    public static void LastOrder2(TreeNode root) {
        TreeNode cur = root;
        TreeNode top = null;
        TreeNode pre=null;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);   //将左节点入栈
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null||cur.right==pre) {
                System.out.print(cur.value + " ");
                stack.pop();
                pre=cur; //代表cur已打印
                cur=null;
            }
            else{
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
        //
        LastOrder2(node[0]);
          //LastOrder1(node[0]);
    }
}
