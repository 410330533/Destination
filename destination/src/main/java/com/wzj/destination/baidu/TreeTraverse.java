package com.wzj.destination.baidu;

import java.util.Stack;

public class TreeTraverse {
    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void preorderIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            if(p != null){
                System.out.print(p.val + " ");  //前序，当p不为空时就进行操作
                stack.push(p);
                p = p.left;
            }else{
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        System.out.println();
    }

    public static void inorderIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                p = p.left;
            }else {
                TreeNode node = stack.pop();
                System.out.print(node.val + " ");   //中序，当p为空时进行操作（前序与中序的代码相同，只是print的位置（操作的位置）不同）
                p = node.right;
            }
        }
        System.out.println();
    }

    public static void postorderIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = root;  //表示当前节点的孩子节点是否遍历过，如果遍历过则当前节点可以输出
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if ((node.left == null && node.right == null) || node.left == pre || node.right == pre){
                System.out.print(node.val + " ");
                stack.pop();
                pre = node; //输出当前节点，出栈，并将pre指向当前节点
            }else{
                if (node.right != null) stack.push(node.right); //先添加右节点，后添加左节点，因为栈是后进先出的。我们希望出栈的顺序是先左后右
                if (node.left != null) stack.push(node.left);
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);


        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n1.right = n3;
        n3.right = n6;

        TreeTraverse.preorderIteration(n1);
        TreeTraverse.inorderIteration(n1);
        TreeTraverse.postorderIteration(n1);
    }

}
