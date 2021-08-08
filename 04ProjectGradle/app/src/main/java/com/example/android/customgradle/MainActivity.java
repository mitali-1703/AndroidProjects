package com.example.android.customgradle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        switch(view.getId()){
            case R.id.error:
                Toasty.error(this,"Login failed", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.success:
                Toasty.success(this,"Login successful",Toast.LENGTH_SHORT).show();
                break;

            case R.id.info:
                Toasty.info(this,"Information",Toast.LENGTH_SHORT).show();
                break;

            case R.id.warning:
                Toasty.warning(this,"Warning",Toast.LENGTH_SHORT).show();
                break;

            case R.id.image:
                Toasty.normal(this,"Project done",Toast.LENGTH_SHORT, ContextCompat.getDrawable(this,R.drawable.ic_person)).show();
                break;
        }
    }
}

