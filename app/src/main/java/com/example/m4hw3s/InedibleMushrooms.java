package com.example.m4hw3s;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class InedibleMushrooms extends AppCompatActivity {
    private String[] ed = {"Поганка бледная", "Мухомор обыкновенный"};
    private ArrayList<String> mushroomsIned = new ArrayList<String>();
    private ArrayList<String> selectIned = new ArrayList<String>();
    ListView listIned;
    EditText addIned;
    ImageButton btnAccept, btnCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inedible_mushrooms);

        listIned = findViewById(R.id.listIned);
        addIned = findViewById(R.id.addIned);
        btnAccept = findViewById(R.id.btnAccept);
        btnCancel = findViewById(R.id.btnCancel);
        Collections.addAll(mushroomsIned, ed);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, mushroomsIned);
        listIned.setAdapter(adapter);
        listIned.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String edItem = adapter.getItem(position);
                if (listIned.isItemChecked(position)) {
                    selectIned.add(edItem);
                } else {
                    selectIned.remove(edItem);
                }
            }
        });
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edIn = addIned.getText().toString();
                if (!edIn.isEmpty()) {
                    mushroomsIned.add(edIn);
                    addIned.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < selectIned.size(); i++) {
                    adapter.remove(selectIned.get(i));
                }
                selectIned.clear();
                listIned.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });

    }
}