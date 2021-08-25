package codegym.model.bean;

public class PersonalInformation {
    private String name;
    private int birthYear;
    private String gender;
    private String nationality;
    private int idCard;
    private String transportVehicle;
    private String dayStart;
    private String dayEnd;
    private String visitPlace;
    private String address;
    private int phone;
    private String email;
    private String symptom;
    private String history;


    public PersonalInformation(String name, int birthYear, String gender, String nationality,
                               int idCard, String transportVehicle, String dayStart, String dayEnd,
                               String visitPlace, String address, int phone, String email, String symptom,
                               String history) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.transportVehicle = transportVehicle;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.visitPlace = visitPlace;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptom = symptom;
        this.history = history;
    }

    public PersonalInformation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getTransportVehicle() {
        return transportVehicle;
    }

    public void setTransportVehicle(String transportVehicle) {
        this.transportVehicle = transportVehicle;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getVisitPlace() {
        return visitPlace;
    }

    public void setVisitPlace(String visitPlace) {
        this.visitPlace = visitPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
