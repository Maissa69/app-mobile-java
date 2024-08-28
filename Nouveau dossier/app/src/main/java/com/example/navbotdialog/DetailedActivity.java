package com.example.navbotdialog;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.navbotdialog.databinding.ActivityDetailedBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailedActivity extends AppCompatActivity {

    ActivityDetailedBinding binding;

    BottomNavigationView deleteEditnav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize deleteEditnav by finding the view in the layout XML
        deleteEditnav = findViewById(R.id.deleteEditnav);

        // Check if deleteEditnav is not null before performing operations on it
        if (deleteEditnav != null) {
            deleteEditnav.setOnItemSelectedListener(item -> {
                if (item.getItemId() == R.id.delete){
                    // Appeler la fonction SQL pour la suppression
                } else if (item.getItemId() == R.id.edit) {
                    replaceFragment(new ModifyFragment());
                }
                return true;
            });
        }

        // Initialize data from Intent
        Intent intent = getIntent();
        if (intent != null) {
            String firstname = intent.getStringExtra("Firstname");
            String lastname = intent.getStringExtra("Lastname");
            String numberPhone = intent.getStringExtra("Number phone");
            String email = intent.getStringExtra("Email");
            String dateOfBirth = intent.getStringExtra("Date of birth");
<<<<<<< HEAD
            String adress = intent.getStringExtra("Adress");
            int image = intent.getIntExtra("Image", R.drawable.user);

            binding.detailFirstname.setText(firstname);
            binding.detailLastname.setText(lastname);
            binding.adressDetailed.setText(adress);
            binding.emailDetailed.setText(email);
            binding.NumberPhoneDetailed.setText(numberPhone);
            binding.dateOfBirthDetailed.setText(dateOfBirth);
            binding.detailImage.setImageResource(image);
=======
            String address = intent.getStringExtra("Address");
            int image = intent.getIntExtra("Image", R.drawable.user);


            biding.detailFirstname.setText(firstname);
            biding.detailLastname.setText(lastname);
            biding.adressDetailed.setText(address);
            biding.emailDetailed.setText(email);
            biding.NumberPhoneDetailed.setText(numberPhone);
            biding.dateOfBirthDetailed.setText(dateOfBirth);
            biding.detailImage.setImageResource(image);
>>>>>>> 3e2891e509a9295e8306f621722a0af09f50e513
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

}
