/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author bpeck
 */
public class BinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
          // First, create nodes. For instance, as follows: 
            BTree<String> colorGreen = new DummyTree<String>("color=GREEN");
            BTree<String> sizeBig = new DummyTree<String>("size=BIG");
            BTree<String> colorYellow = new DummyTree<String>("color=YELLOW");
            BTree<String> fruitWatermelon = new DummyTree<String>("fruit=WATERMELON");
            BTree<String> sizeMedium = new DummyTree<String>("size=MEDIUM");
            BTree<String> shapeRound = new DummyTree<String>("shape=ROUND");
            BTree<String> sizeSmall = new DummyTree<String>("size=SMALL");
            BTree<String> fruitApple = new DummyTree<String>("fruit=APPLE");
            BTree<String> fruitGrape = new DummyTree<String>("fruit=GRAPE");
            BTree<String> fruitLemon = new DummyTree<String>("fruit=LEMON");
            BTree<String> fruitBanana = new DummyTree<String>("fruit=BANANA");
            BTree<String> tasteSweet = new DummyTree<String>("taste=SWEET");
            BTree<String> fruitOrange = new DummyTree<String>("fruit=ORANGE");
            BTree<String> fruitCherry = new DummyTree<String>("fruit=CHERRY");
            BTree<String> fruitBerry = new DummyTree<String>("fruit=BERRY");
            
            // ...
            
            // Then connect nodes. For instance, as follows:
            colorGreen.insert(sizeBig, BTree.LEFT);
            colorGreen.insert(colorYellow, BTree.RIGHT);
            sizeBig.insert(fruitWatermelon, BTree.LEFT);
            sizeBig.insert(sizeMedium, BTree.RIGHT);
            colorYellow.insert(shapeRound, BTree.LEFT);
            colorYellow.insert(sizeSmall, BTree.RIGHT);
            sizeMedium.insert(fruitApple, BTree.LEFT);
            sizeMedium.insert(fruitGrape, BTree.RIGHT);
            shapeRound.insert(fruitLemon, BTree.LEFT);
            shapeRound.insert(fruitBanana, BTree.RIGHT);
            sizeSmall.insert(tasteSweet, BTree.LEFT);
            sizeSmall.insert(fruitOrange, BTree.RIGHT);
            tasteSweet.insert(fruitCherry, BTree.LEFT);
            tasteSweet.insert(fruitBerry, BTree.RIGHT);
            // ...
        
            // Print the tree and its size and height
            System.out.println(colorGreen.toStringInOrder());
            System.out.println("The tree has size: " + colorGreen.size() + " and"
                    + " height: " + colorGreen.height());
        
        } catch(Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }
    
}
