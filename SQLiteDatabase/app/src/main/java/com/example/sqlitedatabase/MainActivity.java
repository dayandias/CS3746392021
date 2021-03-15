package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    StudentDatabase stuDb;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        stuDb = new StudentDatabase(this);
        db = stuDb.getWritableDatabase();
    }


    public void saveData(View view) {

        ContentValues value = new ContentValues();
        String nameStu = editText.getText().toString();

        if(nameStu.isEmpty()){
            Toast toast = Toast.makeText(this,R.string.error_toast, Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            value.put("name", nameStu);
            long newItem = db.insert("student", null, value);
            Toast toast = Toast.makeText(this, R.string.insert_toast, Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void deleteData(View view) {

        String nameStu = editText.getText().toString();

        if(nameStu.isEmpty()) {
            Toast toast = Toast.makeText(this, R.string.error_toast, Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            db.delete("student", "name=?", new String[]{nameStu});
            Toast toast = Toast.makeText(this, R.string.del_toast, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}