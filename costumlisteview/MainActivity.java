package com.example.costumlisteview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.costumlisteview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageListe = {R.drawable.user, R.drawable.baground, R.drawable.person};
        int[] dateOfBirthListe = {R.string.DateOfBirth1, R.string.DateOfBirth2, R.string.DateOfBirth3};
        int[] emailListe = {R.string.email1, R.string.email2, R.string.email3};
        int[] numberPhoneListe = {R.string.numberPhone1, R.string.numberPhone2, R.string.numberPhone3};
        int[] firstnamListe = {R.string.firstname1, R.string.firstname2, R.string.firstname3};
        int[] lastnamListe = {R.string.lastname1, R.string.lastname2, R.string.lastname3};
        int[] adressListe = {R.string.adress1, R.string.adress2, R.string.adress3};

        for(int i = 0; i < imageListe.length; i++){

            listData = new ListData(firstnamListe[i], lastnamListe[i], dateOfBirthListe[i], emailListe[i], imageListe[i], numberPhoneListe[i], adressListe[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("Firstname",firstnamListe[i]);
                intent.putExtra("Lastname",lastnamListe[i]);
                intent.putExtra("date of birth",dateOfBirthListe[i]);
                intent.putExtra("Number phone",numberPhoneListe[i]);
                intent.putExtra("Email",emailListe[i]);
                intent.putExtra("Image", imageListe[i]);
                intent.putExtra("Adress",adressListe[i]);
                startActivity(intent);
            }
        });
    }
}