package zh.TreeBianli;
//根据中序遍历和后序遍历来创建二叉树  --后是又树的根，所以先构建右数，再构建左树
public class BuildTree1 {
    public int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||inorder==null){
            return null;
        }
        postIndex=postorder.length-1;
        return buildTreeChild(inorder,postorder,0,inorder.length-1);

    }
    public TreeNode buildTreeChild(int[] inOder, int[] postOrder, int StartIn, int EndIn) {
        if (StartIn > EndIn) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postIndex]);
        int rootIndex =findIndexOfInoreder(inOder,postOrder[postIndex],StartIn,EndIn);
        postIndex--;
        root.right = buildTreeChild(inOder,postOrder,rootIndex + 1, EndIn);
        root.left =buildTreeChild(inOder,postOrder,StartIn,rootIndex - 1);

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
}
