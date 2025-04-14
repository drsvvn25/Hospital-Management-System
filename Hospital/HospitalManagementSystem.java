import java.util.*;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Doctor> doctors = new ArrayList<>();
        List<Patient> patients = new ArrayList<>();
        Map<String, Appointment> appointments = new HashMap<>();

        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Generate Prescription & Add Bill");
            System.out.println("5. View Appointments by Doctor");
            System.out.println("6. View All Bills");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String pid = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int page = sc.nextInt();
                    sc.nextLine();

                    Patient newPatient = new Patient(pid, pname, page);
                    patients.add(newPatient);
                    FileManager.savePatient(newPatient);
                    System.out.println("Patient added!");
                    break;

                case 2:
                    System.out.print("Enter Doctor ID: ");
                    String did = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter Specialization: ");
                    String spec = sc.nextLine();

                    Doctor newDoctor = new Doctor(did, dname, spec);
                    doctors.add(newDoctor);
                    System.out.println("Doctor added!");
                    break;

                case 3:
                    if (patients.isEmpty() || doctors.isEmpty()) {
                        System.out.println("Add at least one doctor and patient first.");
                        break;
                    }

                    System.out.print("Enter Appointment ID: ");
                    String aid = sc.nextLine();

                    System.out.println("Available Patients:");
                    for (int i = 0; i < patients.size(); i++) {
                        System.out.println(i + ": " + patients.get(i).name);
                    }
                    System.out.print("Choose patient index: ");
                    int pIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Available Doctors:");
                    for (int i = 0; i < doctors.size(); i++) {
                        System.out.println(i + ": " + doctors.get(i).name + " (" + doctors.get(i).specialization + ")");
                    }
                    System.out.print("Choose doctor index: ");
                    int dIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter appointment date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    Appointment appt = new Appointment(aid, patients.get(pIndex), doctors.get(dIndex), date);
                    AppointmentBooking booking = new AppointmentBooking(appointments, appt);
                    booking.start();
                    break;

                case 4:
                    if (patients.isEmpty()) {
                        System.out.println("No patients found.");
                        break;
                    }

                    System.out.println("Patients:");
                    for (int i = 0; i < patients.size(); i++) {
                        System.out.println(i + ": " + patients.get(i).name);
                    }
                    System.out.print("Select patient index: ");
                    int px = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter medicine name: ");
                    String med = sc.nextLine();
                    System.out.print("Enter dosage: ");
                    String dose = sc.nextLine();

                    Patient selected = patients.get(px);
                    Patient.Prescription pres = selected.new Prescription(med, dose);
                    pres.showPrescription();

                    System.out.print("Enter billing amount for this prescription: ₹");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    FileManager.saveBill(selected.name, amount);
                    System.out.println("Bill saved for " + selected.name);
                    break;

                case 5:
                    if (appointments.isEmpty()) {
                        System.out.println("No appointments booked yet.");
                        break;
                    }

                    Map<String, List<Appointment>> docWise = new HashMap<>();
                    for (Appointment a : appointments.values()) {
                        docWise.putIfAbsent(a.doctor.name, new ArrayList<>());
                        docWise.get(a.doctor.name).add(a);
                    }

                    for (Map.Entry<String, List<Appointment>> entry : docWise.entrySet()) {
                        System.out.println("\nDoctor: " + entry.getKey());
                        for (Appointment a : entry.getValue()) {
                            System.out.println(" Patient: " + a.patient.name + " | Date: " + a.date + " | ID: " + a.id);
                        }
                    }
                    break;

                case 6:
                    FileManager.viewAllBills();
                    break;

                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
