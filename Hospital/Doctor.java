public class Doctor extends User {
    String specialization;

    public Doctor(String id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }
}
