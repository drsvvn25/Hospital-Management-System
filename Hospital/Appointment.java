public class Appointment {
    String id;
    Patient patient;
    Doctor doctor;
    String date;

    public Appointment(String id, Patient patient, Doctor doctor, String date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }
}
