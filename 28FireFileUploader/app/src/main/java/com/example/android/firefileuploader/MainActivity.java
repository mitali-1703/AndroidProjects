package com.example.android.firefileuploader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    StorageReference mStorage;
    private static final int GALLERY_REQUEST = 5;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        mStorage = FirebaseStorage.getInstance().getReference();
        progressDialog = new ProgressDialog(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);

                //Setting images of all types i.e. png,jpeg,jpg etc.
                intent.setType("image/*");
                startActivityIfNeeded(intent,GALLERY_REQUEST);
            }
        });
    }

    //When the above method provides expected result then what should happen--->
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_REQUEST){
            progressDialog.setMessage("UPLOADING....");
            Uri uri = data.getData();
            progressDialog.show();

            //Setting image onto imageView using the uri of the image provided by Uri
            imageView.setImageURI(uri);
            StorageReference fileName = mStorage.child("Photos/"+uri.getLastPathSegment()+".jpg");
            fileName.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(MainActivity.this, "UPLOAD SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "UPLOAD FAILED", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}