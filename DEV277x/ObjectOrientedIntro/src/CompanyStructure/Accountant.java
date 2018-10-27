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
    
    /* 
     *  Constructs a new accountant object and takes in one parameter, 
     *  the name of the user and sets the bonusBudget to 0 and team to null
     */
    public Accountant(String name){
        super(name);
        super.getBonusBudget();
        teamSupported = null;
    }
    
    // Returns reference to TechnicalLead that this Accountant is supporting or null
    public TechnicalLead getTeamSupported(){
        return this.teamSupported;
    }
    
    /*  Saves passed reference to TechnicalLead. Updates Accountant's bonus budget
     *  to the total of each SoftwareEngineer's base salary that reports to that
     *  TechnicalLead plus 10%.
     *  
     *  TODO: finish implementing this function
     */
    public void supportTeam(TechnicalLead lead){
        this.teamSupported = lead;
        this.bonusBudget = super.getBonusBudget() + 1;
    }
    
    /*  Takes suggested bonus and checks if there is enough room in the budget.
     *  If the bonus is greater than remaining budget return false, otherwise true
     *  If the accountant is not supporting a team, return false
     */
    public boolean approveBonus(double bonus){
        if (this.teamSupported == null){
            return false;
        }
        if (bonus > this.bonusBudget){
            return false;
        }else{
            return true;
        }
    }
    
    /*  Returns a string representation of the Employee's Status including
     *  the size of their current managed budget
     */
    public String employeeStatus(){
        return super.employeeStatus() + " is supporting " + this.teamSupported;
    }
}
