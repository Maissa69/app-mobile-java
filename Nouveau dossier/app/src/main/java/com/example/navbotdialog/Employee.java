package com.example.navbotdialog;

public class Employee {
    private String mat;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String address;
    private String department;
    private String numberPhone;
    private String email;
    private String recruitmentDate;
    private String image;

    public Employee(String mat, String firstname, String lastname, String dateOfBirth, String address,
                    String department, String numberPhone, String email, String recruitmentDate, String image) {
        this.mat = mat;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.department = department;
        this.numberPhone = numberPhone;
        this.email = email;
        this.recruitmentDate = recruitmentDate;
        this.image = image;
    }

    // Getters and setters
    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(String recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "mat='" + mat + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", email='" + email + '\'' +
                ", recruitmentDate='" + recruitmentDate + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
