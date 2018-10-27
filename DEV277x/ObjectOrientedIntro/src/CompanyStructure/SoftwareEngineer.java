/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompanyStructure;

/**
 *
 * @author bpeck
 */
public class SoftwareEngineer extends TechnicalEmployee{
    private static boolean codeAccess;
    
    /* 
     *  Constructs a new software engineer object and takes in one parameter, 
     *  the name of the user and sets the base salary to 75000
     */
    public SoftwareEngineer(String name){
        super(name);
        codeAccess = false;
    }
    
    // Returns whether this SoftwareEngineer has access to change the code base
    public boolean getCodeAccess(){
        return this.codeAccess;
    }
    
    // Allows external code to update the SoftwareEngineer's code privleges
    public void setCodeAccess(boolean access){
        codeAccess = access;
    }
    
    /*  Check if this SoftwareEngineer's manager approves of checkin. If so,
     *  increase successful checkin count and return "true". If not, change
     *  codeAccess to false and return "false".
     *  
     *  TODO: implement this function
     */
    public boolean checkInCode(){
        return false;
    }
}
