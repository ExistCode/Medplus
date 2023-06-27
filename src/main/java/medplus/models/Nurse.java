package medplus.models;

import java.time.LocalDate;

public class Nurse extends Staff {
    private String certification;
    private int yearsOfExperience;
    private String specialization;
    private String shift;

    public Nurse(String sId, String n, String nId, String e, LocalDate dOB, int a, String cN, String jT, String dept,
            String cert, int exp, String spec, String sh) {
        super(sId, n, nId, e, dOB, a, cN, jT, dept);
        certification = cert;
        yearsOfExperience = exp;
        specialization = spec;
        shift = sh;
    }

    // Setter functions
    public void setCertification(String cert) {
        certification = cert;
    }

    public void setYearsOfExperience(int exp) {
        yearsOfExperience = exp;
    }

    public void setSpecialization(String spec) {
        specialization = spec;
    }

    public void setShift(String sh) {
        shift = sh;
    }

    // Getter functions
    public String getCertification() {
        return certification;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getShift() {
        return shift;
    }

    @Override
    public String getAllData() {
        super.getAllData();
        return getCertification() + ", " + getYearsOfExperience() + ", " + getSpecialization() + ", " + getShift();
    }

}
