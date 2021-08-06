package com.example.android.customtoast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hbd(View view) {
        //Long version of writing Toast Message
//        Context context = getApplicationContext();
//        CharSequence msg = "Happy Bday Dear!";
//        int duration = Toast.LENGTH_SHORT;
//
//        Toast toast = Toast.makeText(context,msg,duration);
//        toast.show();


        showCustomToast();
//        showCustomToast("Namastey!!");
    }

    public void showCustomToast(){
        //To inflate any layout file in another file
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_layout,(ViewGroup) findViewById(R.id.toast_root));

        //To have text other than the default text
//        TextView toastText = layout.findViewById(R.id.text);
//        toastText.setText(s);

        //To have image other than the default image
//        ImageView toastImage = layout.findViewById(R.id.cake);
        
//        toastImage.setImageDrawable(getResources().getDrawable(R.drawable.ic_hand));
//          toastImage.setImageResource(R.drawable.ic_hand);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM,0,40);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}