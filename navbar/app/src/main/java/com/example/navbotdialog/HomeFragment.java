package com.example.navbotdialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ListView listView;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListAdapter listAdapter;
    ListData listData;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listView = view.findViewById(R.id.listview);

        int[] imageList = {R.drawable.user, R.drawable.baground, R.drawable.person};
        int[] dateOfBirthList = {R.string.DateOfBirth1, R.string.DateOfBirth2, R.string.DateOfBirth3};
        int[] emailList = {R.string.email1, R.string.email2, R.string.email3};
        int[] numberPhoneList = {R.string.numberPhone1, R.string.numberPhone2, R.string.numberPhone3};
        int[] firstnameList = {R.string.firstname1, R.string.firstname2, R.string.firstname3};
        int[] lastnameList = {R.string.lastname1, R.string.lastname2, R.string.lastname3};
        int[] adressList = {R.string.adress1, R.string.adress2, R.string.adress3};

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(firstnameList[i], lastnameList[i], dateOfBirthList[i], emailList[i], imageList[i], numberPhoneList[i], adressList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(requireActivity(), dataArrayList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailedActivity.class);
                intent.putExtra("Firstname", getResources().getString(firstnameList[i]));
                intent.putExtra("Lastname", getResources().getString(lastnameList[i]));
                intent.putExtra("Date of birth", getResources().getString(dateOfBirthList[i]));
                intent.putExtra("Number phone", getResources().getString(numberPhoneList[i]));
                intent.putExtra("Email", getResources().getString(emailList[i]));
                intent.putExtra("Image", imageList[i]);
                intent.putExtra("Adress", getResources().getString(adressList[i]));
                startActivity(intent);
            }
        });

        return view;
    }
}
