package bst;

/**
 *
 * @author Saber
 */
public class BST {//Binary Search Tree

    static class Node {

        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Tree {

        Node root;

        void insert(int val) {
            Node newNode = new Node(val);
            if (root == null) {
                root = newNode;
            } else {
                Node current = root;
                Node parent;
                while (true) {
                    parent = current;
                    if (val < current.data) {
                        current = current.left;
                        if (current == null) {
                            parent.left = newNode;
                            return;
                        }
                    } else {
                        current = current.right;
                        if (current == null) {
                            parent.right = newNode;
                            return;
                        }
                    }
                }
            }
        }

        boolean find(int key) {
            Node current = root;
            while (current.data != key) {
                if (key < current.data) {
                    current = current.left;
                } else {
                    current = current.right;
                }
                if (current == null) {
                    return false;
                }
            }
            return true;
        }

        int getMax() {
            Node current = root;
            while (current.right != null) {
                current = current.right;
            }
            return current.data;
        }

        int getMin() {
            Node current = root;
            while (current.left != null) {
                current = current.left;
            }
            return current.data;
        }

        void inOrder(Node localRoot) {
            if (localRoot != null) {
                inOrder(localRoot.left);
                System.out.println(localRoot.data);
                inOrder(localRoot.right);
            }
        }

        void preOrder(Node localRoot) {
            if (localRoot != null) {
                System.out.println(localRoot.data);
                inOrder(localRoot.left);
                inOrder(localRoot.right);
            }
        }

        void postOrder(Node localRoot) {
            if (localRoot != null) {
                inOrder(localRoot.left);
                inOrder(localRoot.right);
                System.out.println(localRoot.data);

            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);

        tree.postOrder(tree.root);
//        if (tree.find(10) == false) {
//            System.out.println("not");
//        } else {
//            System.out.println("found");
//        }
//        System.out.println(tree.getMax());
//        System.out.println(tree.getMin());
    }
}
