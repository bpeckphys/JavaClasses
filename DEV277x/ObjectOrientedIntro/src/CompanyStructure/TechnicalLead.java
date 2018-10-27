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
public class TechnicalLead extends TechnicalEmployee{
    private int headCount;
    
    /* 
     *  Constructs a new technical lead employee object and takes in one parameter, 
     *  the name of the user and sets the base salary to 1.3 * technical 
     *  employee base salary
     */
    public TechnicalLead(String name){
        super(name);
        this.employeeBaseSalary = super.getBaseSalary() * 1.3;
        headCount = 4;        
    }
    
    // Returns true if number of direct reports is less than Lead's headcount
    // TODO: implement this function
    public boolean hasHeadCount(){
        return true;
    }
    
    /*  Accepts reference to SoftwareEngineer and if Lead has head count left
     *  adds this employee to their list of direct reports. If added return true
     *  
     *  TODO: implement this function
     */
    public boolean addReport(SoftwareEngineer e){
        return false;
    }
    
    /*  Checks if passed employee reports to Lead and if code access is true.
     *  Return true if both are true, else return false
     *  
     *  TODO: implement this function
     */
    public boolean approveCheckIn(SoftwareEngineer e){
        return false;
    }
    
    /*  Check if bonus amount requested would be approved by BusinessLead that
     *  supports TechLead. If yes, employee gets bonus and true is returned
     *  
     *  TODO: implement this function
    */
    public boolean requestBonus(Employee e, double bonus){
        return false;
    }
    
    /*  Returns a string representation of the Lead's Status including all of
     *  their direct reports.
     */
    public String getTeamStatus(){
        return super.employeeStatus() + " and is managing:/n";
    }
}
