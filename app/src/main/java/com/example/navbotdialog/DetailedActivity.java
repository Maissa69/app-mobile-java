package com.example.navbotdialog;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

            String adress = intent.getStringExtra("Adress");
            int image = intent.getIntExtra("Image", R.drawable.user);

            binding.detailFirstname.setText(firstname);
            binding.detailLastname.setText(lastname);
            binding.adressDetailed.setText(adress);
            binding.emailDetailed.setText(email);
            binding.NumberPhoneDetailed.setText(numberPhone);
            binding.dateOfBirthDetailed.setText(dateOfBirth);
            binding.detailImage.setImageResource(image);

        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_Home, fragment);
        fragmentTransaction.commit();
    }

    public void onMailIconClick(View view, String email ) {

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + email));


        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        } else {

            Toast.makeText(this, "Aucune application de messagerie n'est disponible", Toast.LENGTH_SHORT).show();
        }
    }

    public void onPhoneIconClick(View view, String numberPhone) {

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + numberPhone));

        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        } else {

            Toast.makeText(this, "Aucune application d'appel n'est disponible", Toast.LENGTH_SHORT).show();
        }
    }
}
