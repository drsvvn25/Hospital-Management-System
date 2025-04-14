public class Patient extends User {
    int age;

    public Patient(String id, String name, int age) {
        super(id, name);
        this.age = age;
    }

    public class Prescription {
        String medicine;
        String dosage;

        public Prescription(String medicine, String dosage) {
            this.medicine = medicine;
            this.dosage = dosage;
        }

        public void showPrescription() {
            System.out.println("Prescription for " + name + ":");
            System.out.println("Medicine: " + medicine);
            System.out.println("Dosage: " + dosage);
        }
    }
}
