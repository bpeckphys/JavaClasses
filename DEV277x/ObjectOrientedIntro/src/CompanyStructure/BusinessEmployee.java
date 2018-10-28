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
public class BusinessEmployee extends Employee {
    private static int baseSalary = 50000;
    public double bonusBudget;
    
    /* 
     *  Constructs a new technical employee object and takes in one parameter, 
     *  the name of the user and sets the base salary to 75000
     */
    public BusinessEmployee(String name){
        super(name, baseSalary);
        bonusBudget = 0;
    }
    
    /*  Establishes a running tally for the remaining bonusBudget for the team
     *  that this employee supports.
     */
    public double getBonusBudget(){
        return bonusBudget;
    }
    
    /*  Returns a string representation of the Employee's Status including
     *  the size of their current managed budget
     */
    public String employeeStatus(){
        return super.employeeStatus() + " with a budget of " + getBonusBudget();
    }
}
