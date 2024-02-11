package q2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;


/**
 * This is the JUnit test for the Timesheet class.
 *
 * @author Billy Wei
 * @version fall23
 * 
 */
public class TimesheetTest {
    
    final Timesheet timesheet = new Timesheet("EMP001", LocalDate.now());
//    @BeforeAll
//    public void setUp() {
//        
//    }

    @Test
    public void testNoArgConstructor() {
        Timesheet emptyTimesheet = new Timesheet();
        assertNotNull(emptyTimesheet.getListOfTimeSheetRow());
        assertEquals(0, emptyTimesheet.getListOfTimeSheetRow().size());
    }
    
    @Test
    public void testParamConstructorWithValidDate() {
        LocalDate specificDate = LocalDate.of(2023, 12, 8);
        assertEquals(specificDate, timesheet.getEndWeek());
    }
    
    @Test
    public void testParamConstructorWithInvalidDate() {
        LocalDate specificDate = LocalDate.of(2023, 12, 8);
        Timesheet testTimesheet = new Timesheet("Penis", LocalDate.now());
        assertEquals(specificDate, testTimesheet.getEndWeek());
    }

    @Test
    public void testSetEndWeekWithInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            timesheet.setEndWeek(LocalDate.now().plusDays(2));
        });
    }

    @Test
    public void testSetEndWeekWithValidDate() {
        LocalDate newDate = LocalDate.of(2023, 12, 8); 
        timesheet.setEndWeek(newDate);
        assertEquals(newDate, timesheet.getEndWeek());
    }

    @Test
    public void testAddRow() {
        TimesheetRow row = new TimesheetRow(1, "ProjectA", 8.0f, 7.5f, 6.0f, 8.5f, 9.5f, 5.0f, 4.0f);
        timesheet.addRow(row);
        List<TimesheetRow> rows = timesheet.getListOfTimeSheetRow();
        assertEquals(1, rows.size());
        assertEquals(row, rows.get(0));
    }

    @Test
    public void testToString() {
        TimesheetRow row1 = new TimesheetRow(1, "ProjectA", 8.0f, 7.5f, 6.0f, 8.5f, 9.5f, 5.0f, 4.0f);
        TimesheetRow row2 = new TimesheetRow(2, "ProjectB", 7.0f, 6.5f, 7.5f, 8.0f, 6.5f, 6.0f, 4.5f);
        timesheet.addRow(row1);
        timesheet.addRow(row2);
        LocalDate specificDate = LocalDate.of(2023, 12, 8);


        String expected = "Employee Number: EMP001\n" +
                "End Week: " + specificDate + "\n" +
                "Details: \n" + "\n" +
                "Project - 1\n" +
                "Work Package: ProjectA\n" +
                "Project hours in a week: 8.0 7.5 6.0 8.5 9.5 5.0 4.0 \n" +
                "\n" +
                "Project - 2\n" +
                "Work Package: ProjectB\n" +
                "Project hours in a week: 7.0 6.5 7.5 8.0 6.5 6.0 4.5 \n" +
                "\n";
        assertEquals(expected, timesheet.toString());
    }
    
    @Test
    public void testGetEmployeeNum() {
        String EmpNum = timesheet.getEmployeeNum();
        assertEquals("EMP001", EmpNum);
    }
    
    @Test
    public void testSetEmployeeNum() {
        timesheet.setEmployeeNum("EMP002");
        String newEmpNum = timesheet.getEmployeeNum(); 
        assertEquals("EMP002", newEmpNum);
    }
    
}
