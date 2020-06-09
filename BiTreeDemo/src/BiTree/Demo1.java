package BiTree;

public class Demo1 {
    private static Node tree;
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.insertNode(1);
        demo1.insertNode(2);
        demo1.insertNode(3);
        demo1.insertNode(4);
        demo1.preorderTraversal(tree);
        demo1.findMax(tree);
    }

    //前序遍历--------根左右
    public void preorderTraversal(Node root) {
        if (root == null) return;
        System.out.println(root.data + "    ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    //中序遍历--------左根右
    public void inorderTraversal(Node root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }

    //后序遍历--------左右根
    public void postorderTraversal(Node root) {
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.data);
    }

    //插入节点
    public void insertNode(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
            if (data < p.data) {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    //     删除节点
    //     情况分析:
    //     1、只有根节点,删除根节点
    //     2、删除的节点无子节点或者只有一个节点
    //     3、删除的节点有两个子节点(找到右子树最小值,替换最小值进行删除)
    public void delete(int data) {
        //指向删除的节点
        //a1
        Node p = tree;
        //记录 p 的父节点20,默认为 null
        //a1
        Node pp = null;

        //先寻找该数据的结点(根节点为删除节点)
        while(p != null && p.data != data) {
            //记录删除节点的父节点
            pp = p;
            if(data > p.data) {
                p = p.right;
            }else {
                p = p.left;
            }
        }

        //如果树为空树,直接返回
        if(p == null) return;

        //情况一:删除的节点有两个子节点
        if(p.left != null && p.right != null) {
            //查找右子树中最小的节点
            //在右子树没有子节点时,默认右子树为最小节点
            Node minP = p.right;
            //右子树的父节点就是 p
            Node minPP = p;
            //判断右子树是否有左子节点(左子节点小于根节点,最小值存在左子树中)
            while(minP.left != null) {
                //如果有子节点,最小值等于父节点
                minPP = minP;
                //最小节点变为,上一节点的左子树
                minP = minP.left;
            }
            //最小数与删除数据替换
            p.data = minP.data;
            //p 指向删除的结点
            p = minP;
            //父节点赋值给删除节点的父节点
            pp = minPP;
        }

        //准备对上边节点进行删除
        //情况二:删除的节点是叶子节点或者仅有一个节点
        Node child;// 记录 p 的子节点
        if(p.left != null) {
            child = p.left;
        }else if(p.right != null) {
            child = p.right;
        }else {
            //删除节点无节点的情况
            //a1
            child = null;
        }

        //根节点为删除节点,删除根节点
        if(pp == null) {
            //a1
            tree = child;
        }else if(pp.left == p) {
            pp.left = child;
        }else {
            pp.right = child;
        }
    }
    //寻找最大节点
    public void findMax(Node root){
        if(root == null)    return;
        Node p = root;
        while(p.right != null){
            p = p.right;
        }
        System.out.println(p.data);
    }
    //寻找最小节点
    public void findMin(Node root){
        if(root == null)    return;
        Node p = root;
        while(p.left != null){
            p = p.left;
        }
        System.out.println(p.data);
    }
    class Node{
        /*
         * 声明树节点
         * */
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data=data;
        }
        public Node(){

        }
    }
}
