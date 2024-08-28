package com.example.navbotdialog;

public class ListData {
    Integer image;
    String dateOfBirth, email, numberPhone;
    String firstname, address, lastname;

    public ListData(String firstname, String lastname, String dateOfBirth, String email, String image, String numberPhone, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.image = Integer.parseInt(image);
        this.numberPhone = numberPhone;
        this.address = address;
    }
}
