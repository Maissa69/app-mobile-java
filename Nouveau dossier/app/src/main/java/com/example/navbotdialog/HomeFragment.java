package com.example.navbotdialog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private MyDBHelper dbHelper;

    public HomeFragment(MyDBHelper dbH) {
        // Required empty public constructor
        this.setDBHelper(dbH);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listView = view.findViewById(R.id.listview);

        // Obtain writable database instance
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        init();

        /* int[] imageList = {R.drawable.user, R.drawable.baground, R.drawable.person};
        int[] dateOfBirthList = {R.string.DateOfBirth1, R.string.DateOfBirth2, R.string.DateOfBirth3};
        int[] emailList = {R.string.email1, R.string.email2, R.string.email3};
        int[] numberPhoneList = {R.string.numberPhone1, R.string.numberPhone2, R.string.numberPhone3};
        int[] firstnameList = {R.string.firstname1, R.string.firstname2, R.string.firstname3};
        int[] lastnameList = {R.string.lastname1, R.string.lastname2, R.string.lastname3};
        int[] adressList = {R.string.adress1, R.string.adress2, R.string.adress3}; */

        ArrayList<Employee> employees = dbHelper.filterEmployees(null, null, null,
                                            null, null, null);

        // Iterate over filteredEmployees and assign values to variables
        for (Employee employee : employees) {
            // send the fields of each employee into listData
            listData = new ListData(employee.getFirstname(), employee.getLastname(), employee.getDateOfBirth(),
                    employee.getEmail(), employee.getImage(), employee.getNumberPhone(), employee.getAddress());
            dataArrayList.add(listData);
        }
        /*
        for (int i = 0; i < employees.length; i++) {
            listData = new ListData(firstnameList[i], lastnameList[i], dateOfBirthList[i], emailList[i], imageList[i], numberPhoneList[i], adressList[i]);
            dataArrayList.add(listData);
        } */

        // Set the adapter for listView
        listAdapter = new ListAdapter(requireActivity(), dataArrayList);
        listView.setAdapter(listAdapter);

        // Set item click listener for listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the clicked item's data
                ListData clickedItem = dataArrayList.get(i);

                // Create an intent to start DetailedActivity and pass the clicked item's data
                Intent intent = new Intent(getActivity(), DetailedActivity.class);
                intent.putExtra("Firstname", clickedItem.firstname);
                intent.putExtra("Lastname", clickedItem.lastname);
                intent.putExtra("Date of birth", clickedItem.dateOfBirth);
                intent.putExtra("Number phone", clickedItem.numberPhone);
                intent.putExtra("Email", clickedItem.email);
                intent.putExtra("Image", clickedItem.image);
                intent.putExtra("Address", clickedItem.address);

                // Start DetailedActivity
                startActivity(intent);
            }
        });

        return view;
    }

    public void init()
    {
        Integer imageRes = R.drawable.person;
        Employee youcef = new Employee("123","Youcef", "Aitsaid", "12/12/2002", "cite 2 juillet el mohamadia",
                "info", "0551343221", "youcef@gmail.com", "01/01/2003", Integer.toString(imageRes));

        imageRes = R.drawable.baground;
        Employee maissa = new Employee("456","Maissa", "Gherbi", "12/12/2001", "Belouizdad Belcourt",
                "info", "0551343222", "maissa@gmail.com", "01/01/2002", Integer.toString(imageRes));

        imageRes = R.drawable.user;
        Employee douaa = new Employee("789","Douaa", "Maachou", "12/12/2004", "La maison blanche",
                "info", "0770090521", "douaa2004@gmail.com", "01/01/2005", Integer.toString(imageRes));
        dbHelper.insertData(youcef);
        dbHelper.insertData(maissa);
        dbHelper.insertData(douaa);
    }
    public void setDBHelper(MyDBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }
}
