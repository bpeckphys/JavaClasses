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
public class BusinessLead extends BusinessEmployee{
    private int headCount;
    public ArrayList<Accountant> directReports;
    
    /* 
     *  Constructs a new business lead employee object and takes in one parameter, 
     *  the name of the user and sets the base salary to 2 * accountant 
     *  employee base salary
     */
    public BusinessLead(String name){
        super(name);
        setBaseSalary(super.getBaseSalary() * 2);
        headCount = 10;
        directReports = new ArrayList<>();
    }
    
    // Returns true if the number of direct reports is less than Manager's headcount
    public boolean hasHeadCount(){
        if (directReports == null){
            return true;
        }else{
            return directReports.size() < headCount;
        }
    }
    
    /*  Accepts reference to Accountant object and if Manager has headcount left
     *  adds them to their list of direct reports. If added, return true. Each
     *  time a report is added, increase bonus budget by 1.1 * report's base
     *  salary. If report is added, their supported team should be updated
     *  to reflect the Tech Lead reference given. If added, return true.
     */
    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if (hasHeadCount()){
            directReports.add(e);
            e.setManager(this);
            e.supportTeam(supportTeam);
            bonusBudget += (e.getBaseSalary() * 1.1);
            return true;
        }else{
            return false;
        }
    }
    
    /*  Check if the bonus amount would fit in current BusinessLead's budget.
     *  If so, decrease BusinessLead's budget and return true.
     */
    public boolean requestBonus(Employee e, double bonus){
        if (bonus < bonusBudget){
            bonusBudget -= bonus;
            return true;
        }else{
            return false;
        }
    }
    
    /*  Looks through the Accountants the BusinessLead Manages. If any of them
     *  support the Tech Lead that is the manager of the passed employee then
     *  consult the Accountants budget. If the team can afford the bonus, reward
     *  it and return true.
     */
    public boolean approveBonus(Employee e, double bonus){
        if (directReports == null){
            return false;
        }
        for (int i = 0; i < directReports.size(); i++){
            for (int j = 0; j < directReports.get(i).getTeamSupported().directReports.size(); j++){
                Employee currentEmployee = directReports.get(i).getTeamSupported().directReports.get(j);
                if (e.equals(currentEmployee)){
                    if (directReports.get(i).approveBonus(bonus)){
                        return true;
                    }
                }
            }
        }
        return false;
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
}
