package q2;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList; 
import java.time.DayOfWeek;

/**
 * <p>This is the Class for Timesheet. It has instances for.
 * employee number (string), end week date (LocalDate).
 * and a list of TimesheetRow objects. All these attributes.
 * define a Timesheet object.</p>
 *
 * @author Billy Wei
 * @version fall23
 */
public class Timesheet {
    /** The instance variable for employee number. */
    private String empNum; 
    
    /** The instance variable for end date. */
    private LocalDate endWeek;
    
    /** The instance variable for details as. 
     * a list of TimeSheetRow objects */
    private List<TimesheetRow> details;
    
    /**
     * No parameter constructor for Timesheet class.
     * It initializes the instance variable details.
     * to an array list. This is essentially an.
     * empty time sheet object.
     */
    public Timesheet() {
        details = new ArrayList<TimesheetRow>();
    }
    
    /**
     * The constructor for Timesheet class that takes the.
     * paramters of employee number (empNum) and end of the.
     * week day (endWeek) as a String type and LocalDate.
     * type respectively. 
     * @param empNum (String).
     * @param endWeek (LocaleDate). 
     */
    public Timesheet(String empNum, LocalDate endWeek) {
        
        this.empNum = empNum; 
        
        if (endWeek.getDayOfWeek() != DayOfWeek.FRIDAY) {
            int daysToAddUp = DayOfWeek.FRIDAY.getValue() 
                    - endWeek.getDayOfWeek().getValue(); 
            this.endWeek = endWeek.plusDays(daysToAddUp);
        } else {
            this.endWeek = endWeek; 
        }
        
        this.details = new ArrayList<TimesheetRow>(); 
    }
    
    /**
     * getter for the employee number.
     * @return empNum as a string type.
     */
    public String getEmployeeNum() {
        return empNum;
    }
    
    /**
     * setter for the employee number.
     * @param employeeNum is a String.
     */
    public void setEmployeeNum(String employeeNum) {
        this.empNum = employeeNum; 
    }
    
    
    /**
     * getter for the end date called endWeek.
     * @return endWeek as a LocalDate object.
     */
    public LocalDate getEndWeek() {
        return endWeek;
    }
 
    /** 
     * setter for the end date called endWeek.
     * if end date is any other day outside of.
     * Friday, then it setter will throw an illegal.
     * argument exception.
     * @param endWeek must be Friday. 
     */
    public void setEndWeek(LocalDate endWeek) {
        if (endWeek.getDayOfWeek() != DayOfWeek.FRIDAY) {
            throw new IllegalArgumentException("End date must be Friday!"); 
        }
        this.endWeek = endWeek; 
    }
    
    
    /**
     * getter for the list of TimesheetRow objects.
     * @return details as a list of TimesheetRow objects.
     */
    public List<TimesheetRow> getListOfTimeSheetRow() {
        return details; 
    }
    
    /**
     * setter for the list of TimeSheetRow objects.
     * @param timeSheetRowObj as a list of timeSheetRow objects. 
     */
    public void setListOfTimeSheetRow(List<TimesheetRow> timeSheetRowObj) {
        details = timeSheetRowObj;
    }
    
    
    /**
     * The addRow method takes a Timesheet row and adds it.
     * to the end of the TimesheetRow list called details.
     * @param project is a TimesheetRow object.   
     */
    public void addRow(TimesheetRow project) {
        this.details.add(project); 
    }
    
    /**
     * toString is a method within the TimeSheet class.
     * When invoked, will return the employee number.
     * end day of the week, and each element in TimeSheetRow list 
     * details as a string. 
     * @return stringOutPut as a string.
     */
    public String toString() {
        StringBuilder stringOutPut = new StringBuilder();
        stringOutPut.append("Employee Number: ").append(empNum).append("\n");
        stringOutPut.append("End Week: ").append(endWeek).append("\n"); 
        stringOutPut.append("Details: ").append("\n");
        stringOutPut.append("\n");
        for (TimesheetRow row : details) {
            stringOutPut.append(row).append("\n");
        }
        System.out.println();
        return stringOutPut.toString(); 
    }
     
    /**
     * This is the main method (entry point) that gets called by the JVM.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        final float eight = 8.0f;
        final float sevenHalves = 7.5f;
        final float six = 6.0f;
        final float eightHalves = 8.5f;
        final float nineHalves = 9.0f;
        final float five = 5.0f;
        final float four = 4.0f; 
        final float seven = 7.0f;
        final float sixHalves = 6.5f;
        final float fourHalves = 4.5f;
        Timesheet currentTimesheet = new Timesheet("EMP018", LocalDate.now());
        
        TimesheetRow row1 = new TimesheetRow(1, "ProjectS", eight, sevenHalves,
                six, eightHalves, nineHalves, five, four);
        TimesheetRow row2 = new TimesheetRow(2, "ProjectT", 
                eightHalves, sevenHalves,
                seven, eight, sixHalves, six, fourHalves);
        
        currentTimesheet.addRow(row1);
        currentTimesheet.addRow(row2);
        
        System.out.println(currentTimesheet);
        //replace next line with your code:
        System.out.println();
        System.out.println("Question two was called and ran sucessfully.");
    }

}
