import org.junit.Before;
import org.junit.Test;
import java.util.function.Consumer;
import static org.junit.Assert.*;

public class AppointmentBSTTest {
    private AppointmentBST bst;

    @Before
    public void setUp() {
        bst = new AppointmentBST();
    }

    @Test
    public void testInsertAndInOrderTraversal() {
        bst.addAppointment(new PatientAppointment(1, "A", "09:00"));
        bst.addAppointment(new PatientAppointment(2, "B", "08:30"));
        bst.addAppointment(new PatientAppointment(3, "C", "10:15"));

        StringBuilder sb = new StringBuilder();
        bst.inOrderTraversal(bst.getRoot(), sb::append);

        String expected =
                "2, B, 08:30\n" +
                        "1, A, 09:00\n" +
                        "3, C, 10:15\n";
        assertEquals(expected, sb.toString());
    }

    @Test
    public void testNoDuplicates() {
        bst.addAppointment(new PatientAppointment(1, "A", "09:00"));
        bst.addAppointment(new PatientAppointment(1, "A", "09:00"));  // duplicate

        assertNotNull(bst.getRoot());
        assertNull(bst.getRoot().left);
        assertNull(bst.getRoot().right);
    }
}
