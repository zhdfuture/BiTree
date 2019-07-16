import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    char value;  //数据域
    Node left;  //左孩子节点
    Node right;   //右孩子节点

    //}
    public Node(char value) {
        this.value = value;
    }
}
    //链式二叉树
    public class BinaryTree implements BinaryTr {

        public void preOrderRe(Node Btree) {  //递归
            if (Btree == null) {
                return;
            }
            System.out.print(Btree.value + " ");  //先根
            Node leftTree = Btree.left;
            Node rightTree = Btree.right;
            //再左
            preOrderRe(leftTree);
            preOrderRe(rightTree);
        }

        public void midOrder(Node BTree) {
            if (BTree == null) {
                return;
            }
            midOrder(BTree.left);               //左--根--右
            System.out.print(BTree.value + " ");
            midOrder(BTree.right);

        }

        public int i = 0;

        @Override
        public Node createTestTree(String str) {  //创建一棵二叉树，递归，先序遍历的方式
            Node root = null;
            //1.若对应字符不是#号，创建一个节点

            if (str.charAt(i) != '#') {
                root = new Node(str.charAt(i));
                i++;
                root.left = createTestTree(str);
                root.right = createTestTree(str);
            } else {        //2.若是#，则直接下标++
                i++;
            }
            return root;
        }


        @Override
        public int getSize(Node root) {
            if (root == null) {
                return 0;
            }
            return getSize(root.left) + getSize(root.right) + 1;
        }


        @Override
        public int getLeafSize(Node root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            return getLeafSize(root.left) + getLeafSize(root.right);
        }

        @Override
        public int getKLevelSize(Node root, int k) {
            if (root == null) {
                return 0;
            }
            if (k == 1) {
                return 1;
            }
            return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);

        }

        @Override
        public Node find(Node root, int value) {  //根据先序遍历找
            if (root == null) {
                return null;
            }
            if (root.value == value) {
                return root;
            }
            Node r = find(root.left, value);
            if (r != null) {
                return r;
            }
            r = find(root.right, value);
            if (r != null) {
                return r;
            }
            return null;
        }

        @Override
        public int height(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int RightHeight = height(root.right);
            return Math.max(leftHeight, RightHeight) + 1;
        }
     public int binaryTreeComplete(Node root) {

         Queue<Node> queue = new LinkedList<>();
         if (root != null) {
             queue.offer(root);
         }
         while (!queue.isEmpty()) {
//             Node cur=queue.poll();
//             if(cur!=null){
//                 queue.offer(cur.left);
//                 queue.offer(cur.right);
//             }else{
//                 break;
//             }
//             if(queue.poll()!=null){
//                 return -1;
//             }
//         }
             Node cur=queue.peek();
             if (cur != null) {
                 System.out.println(cur.value + "");
             }
             queue.poll();
             if (cur.left != null) {
                 queue.offer(cur.left);
             }
             if (cur.right != null) {
                 queue.offer(cur.right);
             }
             if (cur.left == null) {
                 break;
             }
         }
             if(!queue.isEmpty()){
                 return -1;
             }
             return 0;
         }

         public boolean isSameTree(Node p,Node q){

            return false;
         }

   public static void main(String[] args) {
        BinaryTree  binaryTree=new BinaryTree();
       String str="ABC##DE#G##F###";

        Node root=binaryTree.createTestTree(str);
       //midOrder(root);
        System.out.println(binaryTree.getSize(root));
        System.out.println(binaryTree.getLeafSize(root));
        System.out.println(binaryTree.getKLevelSize(root,5));
        Node r1=binaryTree.find(root,'C');

        System.out.println(r1.value);
        System.out.println(binaryTree.height(root));
       System.out.println(binaryTree.binaryTreeComplete(root));

    }
}


    interface BinaryTr {
        Node createTestTree(String str);  //根据字符串创建二叉树

        int getSize(Node root);  //节点个数

        int getLeafSize(Node root);

        int getKLevelSize(Node root, int k);

        Node find(Node root, int value);

        int height(Node root);  //二叉树的高度
    }

