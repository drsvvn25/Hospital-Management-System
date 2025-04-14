import java.util.Map;

public class AppointmentBooking extends Thread {
    Map<String, Appointment> appointments;
    Appointment appointment;

    public AppointmentBooking(Map<String, Appointment> appointments, Appointment appointment) {
        this.appointments = appointments;
        this.appointment = appointment;
    }

    public void run() {
        synchronized (appointments) {
            if (appointments.containsKey(appointment.id)) {
                System.out.println("⚠️ Appointment ID already exists!");
            } else {
                appointments.put(appointment.id, appointment);
                System.out.println("✅ Appointment booked for " + appointment.patient.name +
                                   " with Dr. " + appointment.doctor.name +
                                   " on " + appointment.date);
            }
        }
    }
}
