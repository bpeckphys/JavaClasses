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
public class BusinessLead extends BusinessEmployee{
    private int headCount;
    
    /* 
     *  Constructs a new business lead employee object and takes in one parameter, 
     *  the name of the user and sets the base salary to 2 * accountant 
     *  employee base salary
     */
    public BusinessLead(String name){
        super(name);
        this.employeeBaseSalary = super.getBaseSalary() * 2;
        headCount = 10;
    }
    
    // Returns true if the number of direct reports is less than Manager's headcount
    public boolean hasHeadCount(){
        return false;
    }
    
    /*  Accepts reference to Accountant object and if Manager has headcount left
     *  adds them to their list of direct reports. If added, return true. Each
     *  time a report is added, increase bonus budget by 1.1 * report's base
     *  salary. If report is added, their supported team should be updated
     *  to reflect the Tech Lead reference given. If added, return true.
     */
    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        return false;
    }
    
    /*  Check if bonus requested fits in manager's budget. If so, employee gets
     *  bonus and manager's budget should be decreased by that amount and method
     *  should return true.
     */
    public boolean approveBonus(Employee e, double bonus){
        return false;
    }
}
