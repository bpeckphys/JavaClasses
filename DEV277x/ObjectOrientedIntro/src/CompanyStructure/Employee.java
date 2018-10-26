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
public class Employee {
    public static int employeeID = 0;
    public static String employeeName;
    public double employeeBaseSalary;
    
    /* 
     *  Constructs a new employee object and takes in two parameters, 
     *  one for the name of the user and one for their base salary
     */
    public Employee(String name, double baseSalary){
        employeeID ++;
        employeeName = name;
        employeeBaseSalary = baseSalary;
    }
    
    //  Returns the employee's current salary
    public double getBaseSalary(){
        return this.employeeBaseSalary;
    }
    
    // Returns the employee's current name
    public String getName(){
        return this.employeeName;
    }
    
    // Returns the employee's ID
    public int getEmployeeID(){
        return this.employeeID;
    }
}
