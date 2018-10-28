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
public class TechnicalEmployee extends Employee {
    private static int baseSalary = 75000;
    public int codeChecks;
    
    /* 
     *  Constructs a new technical employee object and takes in one parameter, 
     *  the name of the user and sets the base salary to 75000
     */
    public TechnicalEmployee(String name){
        super(name, baseSalary);
        codeChecks = 0;
    }
    
    //  Returns a string representation of the Employee's Status including check ins
    public String employeeStatus(){
        return super.employeeStatus() + " has " + getSuccessfulCheckIns() + " successful check ins";
    }
    
    // Returns the current count of code check ins for this SoftwareEngineer
    public int getSuccessfulCheckIns(){
        return codeChecks;
    }
}
