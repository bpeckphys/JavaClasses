/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivebinarytree;

/*
 * Recursive implementation of Binary Trees
 */
 public class RecursiveBinaryTree {
    public static void main(String args[]) {
        try {
            BTree<String> colorGreen = new LBTree<String>("color=GREEN");
            BTree<String> colorYellow = new LBTree<String>("color=YELLOW");
            BTree<String> sizeBig = new LBTree<String>("size=BIG");
            BTree<String> sizeMedium = new LBTree<String>("size=MEDIUM");
            BTree<String> sizeSmall = new LBTree<String>("size=SMALL");
            BTree<String> shapeRound = new LBTree<String>("shape=ROUND");
            BTree<String> tasteSweet = new LBTree<String>("taste=SWEET");
            
            BTree<String> watermelon = new LBTree<String>("watermelon");
            BTree<String> apple = new LBTree<String>("apple");
            BTree<String> grape = new LBTree<String>("grape");
            BTree<String> lemon = new LBTree<String>("lemon");
            BTree<String> banana = new LBTree<String>("banana");
            BTree<String> cherry = new LBTree<String>("cherry");
            BTree<String> berry = new LBTree<String>("berry");
            BTree<String> orange = new LBTree<String>("orange");

            colorGreen.insert(sizeBig, BTree.LEFT);
            colorGreen.insert(colorYellow, BTree.RIGHT);
        
            sizeBig.insert(watermelon, BTree.LEFT);
            sizeBig.insert(sizeMedium, BTree.RIGHT);
                        
            colorYellow.insert(shapeRound, BTree.LEFT);
            colorYellow.insert(sizeSmall, BTree.RIGHT);
            
            sizeMedium.insert(apple, BTree.LEFT);
            sizeMedium.insert(grape, BTree.RIGHT);
            shapeRound.insert(lemon, BTree.LEFT);
            shapeRound.insert(banana, BTree.RIGHT);
            sizeSmall.insert(tasteSweet, BTree.LEFT);
            sizeSmall.insert(orange, BTree.RIGHT);
            
            tasteSweet.insert(cherry, BTree.LEFT);
            tasteSweet.insert(berry, BTree.RIGHT);

            System.out.println("INORDER: " + colorGreen.toStringInOrder());
            System.out.println("PREORDER: " + colorGreen.toStringPreOrder());
            System.out.println("POSTORDER: " + colorGreen.toStringPostOrder());
            System.out.println("SIZE=" + colorGreen.size());
            System.out.println("HEIGHT=" + colorGreen.height());
            
        } catch(Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}