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
public class Accountant extends BusinessEmployee{
    private TechnicalLead teamSupported;
    private BusinessLead employeeManager;
    
    /* 
     *  Constructs a new accountant object and takes in one parameter, 
     *  the name of the user and sets the bonusBudget to 0 and team to null
     */
    public Accountant(String name){
        super(name);
        bonusBudget = 0;
        teamSupported = null;
    }
    
    // Returns reference to TechnicalLead that this Accountant is supporting or null
    public TechnicalLead getTeamSupported(){
        return this.teamSupported;
    }
    
    /*  Saves passed reference to TechnicalLead. Updates Accountant's bonus budget
     *  to the total of each SoftwareEngineer's base salary that reports to that
     *  TechnicalLead plus 10%.
     */
    public void supportTeam(TechnicalLead lead){
        teamSupported = lead;
        for (int i = 0; i < teamSupported.directReports.size(); i++){
            bonusBudget += (teamSupported.directReports.get(i).getBaseSalary() * 1.1);
        }
    }
    
    /*  Takes suggested bonus and checks if there is enough room in the budget.
     *  If the bonus is greater than remaining budget return false, otherwise true
     *  If the accountant is not supporting a team, return false
     */
    public boolean approveBonus(double bonus){
        if (this.teamSupported == null){
            return false;
        }
        if (bonus > bonusBudget){
            return false;
        }else{
            bonusBudget -= bonus;
            return true;
        }
    }
    
    /*  Returns a string representation of the Employee's Status including
     *  the size of their current managed budget
     */
    public String employeeStatus(){
        return super.employeeStatus() + " is supporting " + this.teamSupported;
    }
    
    // Returns the employee's manager
    public BusinessLead getManager(){
        return employeeManager;
    }
    
    // Sets the employee's manager
    public void setManager(BusinessLead manager){
        employeeManager = manager;
    }
}
