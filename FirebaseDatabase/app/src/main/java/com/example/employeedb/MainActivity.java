package com.example.employeedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference db;
    EditText fname, lname;
    TextView tv_db;
    int count = 0;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance().getReference("employees");

        fname = findViewById(R.id.first_name);
        lname = findViewById(R.id.last_name);
        tv_db = findViewById(R.id.tv_db);

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ID = (int) snapshot.getChildrenCount();
                Employee employ;

                count = 0;
                StringBuilder value = new StringBuilder();
                for (DataSnapshot ds: snapshot.getChildren()){
                    employ = (Employee)ds.getValue(Employee.class);
                    Log.i("MAINACTIVITY", count + " - First Name: " + employ.getFirstName() + " Last Name: " + employ.getLastName());
                    value.append(employ.toString(Integer.toString(count)));
                    count+=1;
                }
                tv_db.setText((value));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("MAINACTIVITY", "Failed to read value", error.toException());
            }
        });

    }

    public void insertEmp(View view) {

        String ID = Integer.toString(count);
        String f_n = fname.getText().toString();
        String l_n = lname.getText().toString();

        if(!f_n.isEmpty() && !l_n.isEmpty()){

            Log.i("ADDING TO DATABASE", "ID= " + ID);
            Log.i("ADDING TO DATABASE", "First name= " + f_n);
            Log.i("ADDING TO DATABASE", "Last name= " + l_n);

            Employee employ = new Employee(f_n, l_n);
            db.child(String.valueOf(count)).setValue(employ);
            fname.setText("");
            lname.setText("");

        }
    }
}