package q2;


/**
 * <p>This is the Class for TimesheetRow. It has the instances of.
 * a project (integer), work package (string), and the hours.
 * (long). The Class helps to define a TimesheetRow object.</p>
 *
 * @author Billy Wei
 * @version fall23
 */
public class TimesheetRow {
    /** Instance variable for project number, represented by a integer.
     * data type. */
    private int project; 
    
    /** Instance variable for a work package, represented by a string.
     * data type. */
    private String workPackage;
    
    /** Instance variable for hours worked (packed version), represented.
     *  by a long data type. */
    private long hours; 
    
    /** No argument constructor for TimesheetRow class.*/
    public TimesheetRow() {   
    }
    
    /** 
     * TimesheetRow constructor that takes a project as.
     * an integer, a work package as a string, and hours.
     * for each day of the week, represented a variable.
     * length parameter list of float values. 
     * @param project as an integer.
     * @param workPackage as a String.
     * @param hoursOfWeekArray as a variable.
     *        length parameter list of floats. 
     */
    public TimesheetRow(int project, 
            String workPackage, float... hoursOfWeekArray) {
        this.project = project;
        this.workPackage = workPackage;
        setHours(hoursOfWeekArray);
    }
    
    /**
     * The getter for project instance (a number) of a.
     * TimesheetRow object.
     * @return project as an integer. 
     */
    public int getProject() {
        return project;
    }
    
    /**
     * The setter for a project instance (a number) of a.
     * TimesheetRow object.
     * @param projectNum as an integer.
     */
    public void setProject(int projectNum) {
        project = projectNum; 
    }
    
    /**
     * The getter for a work package of a TimesheetRow object.
     * @return workPackage as a string data type. 
     */
    public String getWorkPackage() {
        return workPackage;
    }
    
    /**
     * The setter for a work package of a TimesheetRow object.
     * @param workPackage as a string data type.
     */
    public void setWorkPackage(String workPackage) {
        this.workPackage = workPackage; 
    }
    
    /**
     * The getter for the hours of a TimesheetRow object.
     * @return hours as a long data type. 
     */
    public long getHours() {
        return hours;
    }
    
    /**
     * The setter for the hours worked per day in a week for.
     * the TimesheetRow object.
     * @param hoursOfWeekArray as a float array.
     */
    public void setHours(float... hoursOfWeekArray) {
        final int seven = 7; 
        final double twentyFour = 24.0;
        final double ten = 10.0;
        final long eight = (long) 8.0; 
        final long zeroXFF = (long) 0xFF; 
        for (int i = 0; i < Math.min(hoursOfWeekArray.length, seven); i++) {
            // Ensures that hours are between 0.0 to 24.0.
            if (hoursOfWeekArray[i] < 0.0 || hoursOfWeekArray[i] > twentyFour) {
                throw new IllegalArgumentException("Invalid hours: " 
                        + hoursOfWeekArray[i]);
            }
            // Converting and packing the hours into the long variable.
            long hoursPacked = (long) (hoursOfWeekArray[i] * ten);
            hours |= (hoursPacked & zeroXFF) << (i * eight);
        }
    }
    
    /**
     * The method for retrieving the hours of a particular day of the.
     * week. The day is provided as a number, and the return.
     * is the hours worked on that day as a float.
     * @param dayOfWeek as an integer.
     * @return hours as a float from a specific day using.
     *         bit-mask operations. 
     */
    public float getHour(int dayOfWeek) {
        final long eight = (long) 8.0; 
        final long zeroXFF = (long) 0xFF; 
        final float ten = 10.0f;
        return (hours >> (dayOfWeek * eight) & zeroXFF) / ten;
    }
    
    /** 
     * The method for setting the hours for a particular day in.
     * the week. It takes the day of the week (an integer) and.
     * the hours worked for that day (a float) and sets it as.
     * an appropriate bit of hours. 
     * @param dayOfWeek as an integer representing the day of.
     *        the week.
     * @param hours as a float, representing the hours worked.
     *        on the project on the particular day.
     */
    public void setHour(int dayOfWeek, float hours) {
        final long eight = (long) 8.0; 
        final long zeroXFF = (long) 0xFF; 
        final float ten = 10.0f;
        // Creating a mask here to zero out the part of the hours.
        // (long) that we want to change.
        long mask = zeroXFF << (dayOfWeek * eight);
        // Here, we shift and place the shifted value.
        this.hours = (this.hours & ~mask) 
                | ((long) (hours * ten) << (dayOfWeek * eight));
    }
    
    /**
     * The toString method prints out all the instances of.
     * a TimesheetRow object (project, workPackage, and.
     * hours (long byte that represents the hours worked.
     * per day in a week) as a string.
     * @return result as a string. 
     */
    public String toString() {
        final int seven = 7; 
        StringBuilder timeSheetResult = new StringBuilder();
        timeSheetResult.append("Project - ").append(project).append("\n");
        timeSheetResult.append("Work Package: ").
            append(workPackage).append("\n");
        timeSheetResult.append("Project hours in a week: ");
        for (int i = 0; i < seven; i++) {
            timeSheetResult.append(getHour(i)).append(" ");
        }
        timeSheetResult.append("\n");
        return timeSheetResult.toString(); 
    }
    

}
