package q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is where you put your description about what this class does. You
 * don't have to write an essay but you should describe exactly what it does.
 * Describing it will help you to understand the programming problem better.
 *
 * @author Your Name goes here
 * @version 1.0
 */
public class TimesheetRowTest {

    @Test
    public void firstTest() {
        assertTrue(true);
    }
    
    
    @Test
    public void testNoArgConstructor() {
        // Testing the no-argument constructor
        TimesheetRow row = new TimesheetRow();
        assertEquals(0, row.getProject());
        assertNull(row.getWorkPackage());
        assertEquals(0, row.getHours());
    }

    @Test
    public void testParamConstructor() {
        // Testing the parameterized constructor
        TimesheetRow row = new TimesheetRow(2, "ProjectC", 8.0f, 7.5f, 6.0f, 8.5f, 9.0f, 5.0f, 4.0f);
        assertEquals(2, row.getProject());
        assertEquals("ProjectC", row.getWorkPackage());
        assertEquals(11314362626886480l, row.getHours()); // Packed hours
    }

    @Test
    public void testSetHours() {
        // Testing the setHours method
        TimesheetRow row = new TimesheetRow();
        row.setHours(8.0f, 7.5f, 6.0f, 8.5f, 9.0f, 5.0f, 4.0f);
        // Packed hours
        assertEquals(11314362626886480l, row.getHours()); 
    }
    
    @Test
    public void testSetHoursInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TimesheetRow row = new TimesheetRow();
            row.setHours(8.0f, 7.5f, 6.0f, 8.5f, 9.0f, 5.0f, 35.0f); 
        });
    }
    

    @Test
    public void testGetHour() {
        // Testing the getHour method
        TimesheetRow row = new TimesheetRow(3, "ProjectD", 8.0f, 7.5f, 6.0f, 8.5f, 9.0f, 5.0f, 4.0f);
        assertEquals(8.0f, row.getHour(0), 0.001);
        assertEquals(7.5f, row.getHour(1), 0.001);
        assertEquals(6.0f, row.getHour(2), 0.001);
        assertEquals(8.5f, row.getHour(3), 0.001);
        assertEquals(9.0f, row.getHour(4), 0.001);
        assertEquals(5.0f, row.getHour(5), 0.001);
        assertEquals(4.0f, row.getHour(6), 0.001);
    }

    @Test
    public void testSetHour() {
        // Testing the setHour method
        TimesheetRow row = new TimesheetRow();
        row.setHour(1, 7.5f);
        assertEquals(19200l, row.getHours()); // Packed hours for day 1 (index 1)
    }

    @Test
    public void testToString() {
        // Testing the toString method
        TimesheetRow row = new TimesheetRow(4, "ProjectE", 8.0f, 7.5f, 6.0f, 8.5f, 9.0f, 5.0f, 4.0f);
        String expected = "Project - 4\n" 
                + "Work Package: ProjectE\n" 
                + "Project hours in a week: 8.0 7.5 6.0 8.5 9.0 5.0 4.0 " + "\n";
        assertEquals(expected, row.toString());
    }
    
    @Test
    public void testSetProject() {
        TimesheetRow row = new TimesheetRow(4, "ProjectE", 8.0f, 7.5f, 6.0f, 8.5f, 9.0f, 5.0f, 4.0f);
        row.setProject(1);
        int newProjectNum = row.getProject();
        assertEquals(1, newProjectNum);

    }
    
    @Test
    public void testSetWorkPackage() {
        TimesheetRow row = new TimesheetRow(4, "ProjectE", 8.0f, 7.5f, 6.0f, 8.5f, 9.0f, 5.0f, 4.0f);
        row.setWorkPackage("ProjectP");
        String newWorkPage = row.getWorkPackage();
        assertEquals("ProjectP", newWorkPage);
    }
    
    
}
