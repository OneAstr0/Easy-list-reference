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

public class EdibleMushrooms extends AppCompatActivity {
    private String[] ed = {"Подберёзовик", "Подосиновик", "Лисички", "Белый гриб"};
    private ArrayList<String> mushrooms = new ArrayList<String>();
    private ArrayList<String> selectEd = new ArrayList<String>();
    ListView listEd;
    EditText addEd;
    ImageButton btnAccept, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edible_mushrooms);
        listEd = findViewById(R.id.listEd);
        addEd = findViewById(R.id.addEd);
        btnAccept = findViewById(R.id.btnAccept);
        btnCancel = findViewById(R.id.btnCancel);
        Collections.addAll(mushrooms, ed);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, mushrooms);
        listEd.setAdapter(adapter);
        listEd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String edItem = adapter.getItem(position);
                if (listEd.isItemChecked(position)) {
                    selectEd.add(edItem);
                } else {
                    selectEd.remove(edItem);
                }
            }
        });
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edIn = addEd.getText().toString();
                if (!edIn.isEmpty()) {
                    mushrooms.add(edIn);
                    addEd.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < selectEd.size(); i++) {
                    adapter.remove(selectEd.get(i));
                }
                selectEd.clear();
                listEd.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });
    }
}