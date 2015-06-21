package dahampasala;

import java.util.Date;

/**
 *
 * @author Thilanka Bowala <Thilanka Bowala at GIGABYTE>
 */
public class Student {
    private int regID;
    private String firstName, lastName, address, gender, admissionClass;
    private Date dateOfBirth, registeredDate;

    public int getRegID() {
        return regID;
    }

    public void setRegID(int regID) {
        this.regID = regID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdmissionClass() {
        return admissionClass;
    }

    public void setAdmissionClass(String admissionClass) {
        this.admissionClass = admissionClass;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
    
}
