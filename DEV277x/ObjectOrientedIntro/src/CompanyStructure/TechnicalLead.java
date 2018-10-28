/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompanyStructure;
import java.util.*;

/**
 *
 * @author bpeck
 */
public class TechnicalLead extends TechnicalEmployee{
    private int headCount;
    public ArrayList<SoftwareEngineer> directReports;
    private BusinessLead employeeManager;
    
    /* 
     *  Constructs a new technical lead employee object and takes in one parameter, 
     *  the name of the user and sets the base salary to 1.3 * technical 
     *  employee base salary
     */
    public TechnicalLead(String name){
        super(name);
        setBaseSalary(super.getBaseSalary() * 1.3);
        headCount = 4;
        directReports = new ArrayList<>();
    }
    
    // Returns true if number of direct reports is less than Lead's headcount
    public boolean hasHeadCount(){
        if (directReports == null){
            return true;
        }else{
            return directReports.size() < headCount;
        }
    }
    
    /*  Accepts reference to SoftwareEngineer and if Lead has head count left
     *  adds this employee to their list of direct reports. If added return true
     */
    public boolean addReport(SoftwareEngineer e){
        if (hasHeadCount()){
            directReports.add(e);
            e.setManager(this);
            return true;
        }else{
            return false;
        }
    }
    
    /*  Checks if passed employee reports to Lead and if code access is true.
     *  Return true if both are true, else return false
     */
    public boolean approveCheckIn(SoftwareEngineer e){
        return ((e.getManager().getEmployeeID() == this.getEmployeeID()) && e.getCodeAccess());
    }
    
    /*  Check if bonus amount requested would be approved by BusinessLead that
     *  supports TechLead. If yes, employee gets bonus and true is returned
     */
    public boolean requestBonus(Employee e, double bonus){
        if (employeeManager == null){
            return false;
        }else{
            return getManager().approveBonus(e, bonus);
        }
    }
    
    /*  Returns a string representation of the Lead's Status including all of
     *  their direct reports.
     */
    public String getTeamStatus(){
        String directReportsString = "";
        for (int i = 0; i < directReports.size(); i++){
            directReportsString += "\n\t" + directReports.get(i).employeeStatus();
        }
        return super.employeeStatus() + " and is managing:" + directReportsString;
    }

// Returns the employee's manager
    public BusinessLead getManager(){
        return employeeManager;
    }
}
