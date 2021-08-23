package com.example.android.studentrecord;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.studentrecord.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding b ;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        db = new DatabaseHelper(this);

        b.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = db.insertData(b.editTextName.getText().toString(),b.editTextEmail.getText().toString(),b.editTextCC.getText().toString());
                if(isInserted==true) {
                    Toast.makeText(MainActivity.this, "Data Inserted!", Toast.LENGTH_SHORT).show();
                    b.editTextId.setText("");
                    b.editTextName.setText("");
                    b.editTextCC.setText("");
                    b.editTextEmail.setText("");
                }
                else
                    Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

        b.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = db.updateData(b.editTextId.getText().toString(),b.editTextName.getText().toString(),b.editTextEmail.getText().toString(),b.editTextCC.getText().toString());
                if(isUpdated==true) {
                    Toast.makeText(MainActivity.this, "Data Updated!", Toast.LENGTH_SHORT).show();
                    b.editTextId.setText("");
                    b.editTextName.setText("");
                    b.editTextCC.setText("");
                    b.editTextEmail.setText("");
                }
                else
                    Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

        b.buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = b.editTextId.getText().toString();
                if(id.isEmpty()){
                    b.editTextId.setError("Enter ID");
                    return;
                }

                Cursor cursor = db.getData(id);
                //Initialize data as null so that no garbage value is there
                String data = null;

                if(cursor.moveToNext()){
                    data = "ID: "+cursor.getString(0)+"\n"+
                            "Name: "+cursor.getString(1)+"\n"+
                            "Email: "+cursor.getString(2)+"\n"+
                            "Course Count: "+cursor.getString(3)+"\n";
                }
                showMessage("Data: ",data);
            }
        });

        b.buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.getAllData();
                StringBuffer buffer = new StringBuffer();

                //If database is empty
                if(cursor.getCount()==0){
                    showMessage("Error!","Nothing found in DB");
                    return;
                }

                while(cursor.moveToNext()) {
                    buffer.append("ID: " + cursor.getString(0) + "\n");
                    buffer.append("Name: " + cursor.getString(1) + "\n");
                    buffer.append("Email: " + cursor.getString(2) + "\n");
                    buffer.append("Course Count: " + cursor.getString(3) + "\n\n");
                }
                showMessage("All Data: ",buffer.toString());
            }
        });

        b.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = b.editTextId.getText().toString();
                if(id.isEmpty()){
                    b.editTextId.setError("Enter ID");
                    return;
                }

                Integer isDeleted = db.deleteData(id);
                if(isDeleted>0){
                    Toast.makeText(MainActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "OOPPPSSS!!", Toast.LENGTH_SHORT).show();
            }
        });
//        showMessage("test","testing done!!");
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}