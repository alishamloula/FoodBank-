import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        // Create shared SystemManager
        SystemManager manager = new SystemManager();

        SwingUtilities.invokeLater(() -> {
            // Open primary window and manager dashboard
            new PrimaryWindow(manager);
            new SystemManagerGUI(manager);
        });
    }
}
