package com.example.navbotdialog;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navbotdialog.databinding.ActivityDetailedBinding;


public class DetailedActivity extends AppCompatActivity {

    ActivityDetailedBinding biding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        biding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(biding.getRoot());

        Intent intent = getIntent();
        if (intent != null) {
            int firstname = intent.getIntExtra("Firstname", R.string.firstname1);
            int lastname = intent.getIntExtra("Lastname", R.string.lastname1);
            int numberPhone = intent.getIntExtra("Number phone", R.string.numberPhone1 );
            int email = intent.getIntExtra("Email", R.string.email1);
            int dateOfBirth = intent.getIntExtra("Date of birth", R.string.DateOfBirth1);
            int adress = intent.getIntExtra("Adress", R.string.adress1);
            int image = intent.getIntExtra("Image", R.drawable.user);


            biding.detailFirstname.setText(firstname);
            biding.detailLastname.setText(lastname);
            biding.adressDetailed.setText(adress);
            biding.emailDetailed.setText(email);
            biding.NumberPhoneDetailed.setText(numberPhone);
            biding.dateOfBirthDetailed.setText(dateOfBirth);
            biding.detailImage.setImageResource(image);
        }
    }
}