package medplus.models;

import java.time.LocalDate;

public interface Person {
    public String getName();

    public void setName(String name);

    public LocalDate getDateOfBirth();

    public void setDateOfBirth(LocalDate dob);
}
