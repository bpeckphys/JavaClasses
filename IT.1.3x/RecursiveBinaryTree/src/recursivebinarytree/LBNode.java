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
public class LBNode<E> {

    // Attributes
    private E info;
    private BTree<E> left;
    private BTree<E> right;
    
    /*
     * Constructor
     */
    public LBNode(E info, BTree<E> left, BTree<E> right) {
        // ... (to complete)
        System.out.println("Creating a tree with ["+info+"]");
        this.info = info;
    }
    
    /* 
     * Access methods
     */
    public E getInfo() {
        return this.info;
    }
    
    public void setInfo(E info) {
        this.info = info;
    }
    
    public BTree<E> getLeft() {
        // ... (to complete)
        System.out.println("Returns the left node");
        return null;
    }
    
    public void setLeft(BTree<E> left) {
        // ... (to complete)
        this.left = left;
    }
    
    public BTree<E> getRight() {
        // ... (to complete)
        System.out.println("Returns the right node");
        return null;
    }
    
    public void setRight(BTree<E> right) {
        // ... (to complete)
        this.right = right;
    }

}

