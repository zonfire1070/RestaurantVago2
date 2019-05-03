package com.example.restaurantvago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.LinkedList;

public class aptzrMenu extends AppCompatActivity{

    private ListView listView;
    private LinkedList<MenuItems> foodItems;
    private customAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aptzr_menu);
        getIntent();
        listView = (ListView)findViewById(R.id.list);
        setData();
        setListViewAdapter();
    }

    private void setListViewAdapter() {
        adapter = new customAdapter(this, R.layout.even_listview, foodItems);
        listView.setAdapter(adapter);
    }

    private void setData() {
        foodItems = new LinkedList<MenuItems>();

        foodItems.add(new MenuItems("Buffalo Wings", R.drawable.buffalo));
        foodItems.add(new MenuItems("Cheese Curds", R.drawable.curds));
        foodItems.add(new MenuItems("Onion Rings", R.drawable.onion));
        foodItems.add(new MenuItems("Pretzel Sticks", R.drawable.pretzel));
        foodItems.add(new MenuItems("Pulled Pork Sliders", R.drawable.pulled));

    }
}

