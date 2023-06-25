package medplus.models;

import java.time.LocalDate;

public class Administrative extends Staff {
    private String tasks;
    private String responsibilities;

    public Administrative(String sId, String n, String nId, String e, LocalDate dOB, int a, String cN, String jT,
            String dept,
            String t, String resp) {
        super(sId, n, nId, e, dOB, a, cN, jT, dept);
        tasks = t;
        responsibilities = resp;
    }

    // Setter functions
    public void setTasks(String t) {
        tasks = t;
    }

    public void setResponsibilities(String resp) {
        responsibilities = resp;
    }

    // Getter functions
    public String getTasks() {
        return tasks;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    @Override
    public String getAllData() {
        super.getAllData();
        return getTasks() + ", " + getResponsibilities();
    }
}
