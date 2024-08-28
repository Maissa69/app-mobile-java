package com.example.navbotdialog;

import android.util.Log;
import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "project.db";
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your table here
        String query = "CREATE TABLE IF NOT EXISTS employees (" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " mat TEXT UNIQUE NOT NULL," +
                " firstname TEXT NOT NULL," +
                " lastname TEXT NOT NULL," +
                " dateOfBirth DATE NOT NULL," +
                " address TEXT NOT NULL," +
                " department TEXT NOT NULL," +
                " numberPhone TEXT NOT NULL," +
                " email TEXT UNIQUE NOT NULL," +
                " recruitmentDate DATE NOT NULL," +
                " image TEXT);";
        db.execSQL(query);
    }

    public long insertData(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("Employee", employee.toString());

        ContentValues values = new ContentValues();
        values.put("mat", employee.getMat());
        values.put("firstname", employee.getFirstname());
        values.put("lastname", employee.getLastname());
        values.put("dateOfBirth", employee.getDateOfBirth());
        values.put("address", employee.getAddress());
        values.put("department", employee.getDepartment());
        values.put("numberPhone", employee.getNumberPhone());
        values.put("email", employee.getEmail());
        values.put("recruitmentDate", employee.getRecruitmentDate());
        values.put("image", employee.getImage());
        long newRowId = db.insert("employees", null, values);
        db.close();
        return newRowId;
    }

    public int updateData(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mat", employee.getMat());
        values.put("firstname", employee.getFirstname());
        values.put("lastname", employee.getLastname());
        values.put("dateOfBirth", employee.getDateOfBirth());
        values.put("address", employee.getAddress());
        values.put("department", employee.getDepartment());
        values.put("numberPhone", employee.getNumberPhone());
        values.put("email", employee.getEmail());
        values.put("recruitmentDate", employee.getRecruitmentDate());
        values.put("image", employee.getImage());
        int rowsAffected = db.update("employees", values, "id = ?", new String[]{String.valueOf(getEmployeeId(employee.getMat()))});
        db.close();
        return rowsAffected;
    }


    // Delete data from the table
    public int deleteData(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsAffected = db.delete("employees", "id = ?", new String[]{String.valueOf(getEmployeeId(employee.getMat()))});
        db.close();
        return rowsAffected;
    }

    public int getEmployeeId(String mat) {
        int employeeId = -1; // Default value if not found
        SQLiteDatabase db = this.getReadableDatabase();

        // Define a projection that specifies which columns from the database you will actually use after this query.
        String[] projection = {"id"};

        // Filter results WHERE "mat" = ?
        String selection = "mat = ?";
        String[] selectionArgs = {mat};

        Cursor cursor = db.query(
                "employees",   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null                    // don't need the sort order since we are only retrieving the ID
        );

        if (cursor.moveToFirst()) {
            employeeId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        }
        cursor.close();
        return employeeId;
    }

    public ArrayList<Employee> filterEmployees(String mat, String name, String email,
                                               String phoneNumber, String address, String department) {
        ArrayList<Employee> employees = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Define a base query
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM employees WHERE 1=1");

        // Append filter conditions based on employee input
        if (mat != null && !mat.isEmpty()) {
            queryBuilder.append(" AND mat LIKE '").append(mat).append("%'");
        }
        if (name != null && !name.isEmpty()) {
            queryBuilder.append(" AND (firstname LIKE '%").append(name).append("%' OR lastname LIKE '%").append(name).append("%)");
        }
        if (email != null && !email.isEmpty()) {
            queryBuilder.append(" AND email LIKE '%").append(email).append("%'");
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            queryBuilder.append(" AND numberPhone LIKE '").append(phoneNumber).append("%'");
        }
        if (address != null && !address.isEmpty()) {
            queryBuilder.append(" AND address LIKE '%").append(address).append("%'");
        }
        if (department != null && !department.isEmpty()) {
            queryBuilder.append(" AND department LIKE '%").append(department).append("%'");
        }

        Cursor cursor = db.rawQuery(queryBuilder.toString(), null);

        while (cursor.moveToNext()) {
            String tmpMat = cursor.getString(cursor.getColumnIndexOrThrow("mat"));
            String tmpFirstname = cursor.getString(cursor.getColumnIndexOrThrow("firstname"));
            String tmpLastname = cursor.getString(cursor.getColumnIndexOrThrow("lastname"));
            String tmpDateOfBirth = cursor.getString(cursor.getColumnIndexOrThrow("dateOfBirth"));
            String tmpAddress = cursor.getString(cursor.getColumnIndexOrThrow("address"));
            String tmpDepartment = cursor.getString(cursor.getColumnIndexOrThrow("department"));
            String tmpNumberPhone = cursor.getString(cursor.getColumnIndexOrThrow("numberPhone"));
            String tmpEmail = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            String tmpRecruitmentDate = cursor.getString(cursor.getColumnIndexOrThrow("recruitmentDate"));
            String tmpImage = cursor.getString(cursor.getColumnIndexOrThrow("image"));

            // Create an Employee object
            Employee employee = new Employee(tmpMat, tmpFirstname, tmpLastname, tmpDateOfBirth, tmpAddress, tmpDepartment,
                    tmpNumberPhone, tmpEmail, tmpRecruitmentDate, tmpImage);
            employees.add(employee);
        }
        cursor.close();
        return employees;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If you need to upgrade the database version, handle it here
    }
}
