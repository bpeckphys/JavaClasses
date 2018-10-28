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
    private static int employeeIDCount = 0;
    private int employeeID;
    private String employeeName;
    private double employeeBaseSalary;
    private Employee employeeManager;
    
    /* 
     *  Constructs a new employee object and takes in two parameters, 
     *  one for the name of the user and one for their base salary
     */
    public Employee(String name, double baseSalary){
        employeeIDCount ++;
        employeeID = employeeIDCount;
        employeeName = name;
        employeeBaseSalary = baseSalary;
        employeeManager = null;
    }
    
    //  Returns the employee's current salary
    public double getBaseSalary(){
        return employeeBaseSalary;
    }
    
    // Sets the employee's current salary
    public void setBaseSalary(double newSalary){
        employeeBaseSalary = newSalary;
    }
    
    // Returns the employee's current name
    public String getName(){
        return employeeName;
    }
    
    // Returns the employee's ID
    public int getEmployeeID(){
        return employeeID;
    }
    
    // Returns the employee's manager
    public Employee getManager(){
        return employeeManager;
    }
    
    // Sets the employee's manager
    public void setManager(Employee manager){
        employeeManager = manager;
    }
    
    // Checks if two employee ID's are equal
    public boolean equals(Employee other){
        if (this.employeeID == other.getEmployeeID()){
            return true;
        }else{
            return false;
        }
    }
    
    // Returns a string that represents the Employee ID followed by their name
    public String toString(){
        String employee = this.getEmployeeID() + " " + this.getName();
        return employee;
    }
    
    // Returns a string representation of the Employee's Status
    public String employeeStatus(){
        return toString();
    }
}
