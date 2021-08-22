package com.example.android.recyclercards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ItemsList> ItemsList;
    Button button1,button2;
    EditText editText1,editText2;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRandomData();
        configRV();

        button1 = findViewById(R.id.buttonadd);
        button2 = findViewById(R.id.buttondelete);
        editText1 = findViewById(R.id.edittextadd);
        editText2 = findViewById(R.id.edittextdelete);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editText1.getText().toString();
                if(value.isEmpty()){
                    editText1.setError("Please enter a number");
                    return;
                }
                int position= Integer.parseInt(editText1.getText().toString());
                addCard(position);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editText2.getText().toString();
                if(value.isEmpty()){
                    editText2.setError("Please enter a number");
                    return;
                }
                int position= Integer.parseInt(editText2.getText().toString());
                deleteCard(position);
            }
        });
    }

    private void getRandomData() {
        ItemsList = new ArrayList<>();
        ItemsList.add(new ItemsList(R.drawable.node,"Clicked at Studio"));
        ItemsList.add(new ItemsList(R.drawable.oner,"Clicked at Italy"));
        ItemsList.add(new ItemsList(R.drawable.twor,"Clicked at Venice"));
        ItemsList.add(new ItemsList(R.drawable.threer,"Clicked at Rome"));
        ItemsList.add(new ItemsList(R.drawable.fourr,"Clicked at Spain"));
        ItemsList.add(new ItemsList(R.drawable.fiver,"Clicked at India"));
        ItemsList.add(new ItemsList(R.drawable.sixr,"Clicked at Bhutan"));
    }

    private void configRV() {
        //Config on RV
        recyclerView = findViewById(R.id.recyclerView);

        //For improved performance if many users are there on your app
//        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new ItemsAdapter(ItemsList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void addCard(int position){
        ItemsList.add(position,new ItemsList(R.drawable.node,"Added new card"));
//        adapter.notifyDataSetChanged();------>Reloads all the items in the list again but its not a wrong method
        adapter.notifyItemInserted(position);
    }
    public void deleteCard(int position){
        ItemsList.remove(position);
        adapter.notifyItemRemoved(position);

    }

}