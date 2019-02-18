/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivebinarytree;

/**
 *
 * @author bpeck
 */
public class LBTree<E> implements BTree<E> {
    
    // Attribute that represents the root node (recursive definition)
    private LBNode<E> root;

    /*
     * Constructor of an empty tree
     */
    public LBTree() {
        root = null;
    }
    
    /* 
     * Constructor
     */
    public LBTree(E info) {
        root = new LBNode<E>(info, new LBTree<E>(), new LBTree<E>());
    }
 
    /*
     * Checks if the tree is empty
     */
    public boolean isEmpty() {
        return (root == null);
    }
    
    /*
     * Returns the information stored in the node
     */
    public E getInfo() throws BTreeException {
        if (isEmpty()) {
            throw new BTreeException("Empty trees do not have info");
        }
        return root.getInfo();
    }
    
    /*
     * Returns left and right subtrees
     */
    public BTree<E> getLeft() throws BTreeException {
        // ... (to complete)
        System.out.println("Returns the left subtree");
        return null;
    }
    
    public BTree<E> getRight() throws BTreeException {
        // ... (to complete)
        System.out.println("Returns the right subtree");
        return null;
    }

    /* 
     * Inserts a given tree as a subtree in the given side
     */
    public void insert(BTree<E> tree, int side) throws BTreeException {
        if (isEmpty()) {
            throw new BTreeException("Empty trees do not have a left or right child");
        }
        if(side==LEFT) {
            if (!root.getLeft().isEmpty()) {
                throw new BTreeException("Left subtree is not empty");
            }  
            root.setLeft(tree);
        } else {
            // ... (to complete)
        }
    }
    
    /*
     * Tree traversals (dummy implementations)
     */
    public String toStringPreOrder() {
        System.out.println("Traverses the ["+root.getInfo()+"] tree in preorder");
        return "";
    }
    
    public String toStringInOrder() {
        System.out.println("Traverses the ["+root.getInfo()+"] tree in order");
        return "";
    }
    
    public String toStringPostOrder() {
        System.out.println("Traverses the ["+root.getInfo()+"] tree in postorder");
        return "";
    }
    
    /*
     * Tree properties (dummy implementations)
     */
    public int size() {
        System.out.println("Returns the size of ["+root.getInfo()+"] tree");
        return -1;
    }
    
    public int height() {
        System.out.println("Returns the height of ["+root.getInfo()+"] tree");
        return -1;
    }
    
}
