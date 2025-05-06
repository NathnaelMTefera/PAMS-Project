import java.util.function.Consumer;

public class AppointmentBST {
    private AppointmentNode root;

    public AppointmentBST() {
        root = null;
    }

    public void addAppointment(PatientAppointment appointment) {
        root = insertRec(root, appointment);
    }

    private AppointmentNode insertRec(AppointmentNode root, PatientAppointment appointment) {

        // 1. Base case
        if (root == null) {
            return new AppointmentNode(appointment);
        }

        // 2. Compare by appointmentTime
        int cmp = appointment
                .getAppointmentTime()
                .compareTo(root.data.getAppointmentTime());

        // 3. Recurse left for earlier, right for later; ignore equal times
        if (cmp < 0) {
            root.left  = insertRec(root.left,  appointment);
        } else if (cmp > 0) {
            root.right = insertRec(root.right, appointment);
        }

        // 4. Return this node
        return root;


    }

    public void inOrderTraversal(AppointmentNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    public void inOrderTraversal(AppointmentNode node, Consumer<String> consumer) {
        if (node != null) {
            inOrderTraversal(node.left, consumer);
            consumer.accept(node.data.toString() + "\n");
            inOrderTraversal(node.right, consumer);
        }
    }


    public AppointmentNode getRoot() {
        return root;
    }
}
