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
/*
 * Class that models exceptions in trees
 */
 
public class BTreeException extends Exception {
    
    /*
     * Constructor without parameters
     */
    public BTreeException() {
        super();
    }
    
    /*
     * Constructor that receives the exception message
     */
    public BTreeException(String message) {
        super(message);
    }
    
}
