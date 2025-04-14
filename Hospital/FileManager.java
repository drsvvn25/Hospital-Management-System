import java.io.*;
import java.util.Scanner;

public class FileManager {
    public static void savePatient(Patient p) {
        try {
            FileWriter fw = new FileWriter("patients.txt", true);
            fw.write(p.id + "," + p.name + "," + p.age + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving patient: " + e.getMessage());
        }
    }

    public static void saveBill(String patientName, double amount) {
        try {
            FileWriter fw = new FileWriter("bills.txt", true);
            fw.write(patientName + "," + amount + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving bill: " + e.getMessage());
        }
    }

    public static void viewAllBills() {
        try {
            File billFile = new File("bills.txt");
            if (!billFile.exists() || billFile.length() == 0) {
                System.out.println(" No billing records found.");
                return;
            }

            Scanner scanner = new Scanner(billFile);
            System.out.println("\n=== All Bills ===");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    System.out.println("Patient: " + parts[0] + " | Amount: ₹" + parts[1]);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading bill file: " + e.getMessage());
        }
    }
}
