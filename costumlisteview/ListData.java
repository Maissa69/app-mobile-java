package com.example.costumlisteview;

public class ListData {
    int  adress;
    int dateOfBirth, email, numberPhone;
    int firstname, image, lastname;

    public ListData(int firstname, int lastname, int dateOfBirth, int email, int image, int numberPhone, int adress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.image = image;
        this.numberPhone = numberPhone;
        this.adress = adress;
    }
}
