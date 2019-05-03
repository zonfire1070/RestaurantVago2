package com.example.restaurantvago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.LinkedList;

public class burgerMenu extends AppCompatActivity {

    private ListView listView;
    private LinkedList<MenuItems> foodItems;
    private customAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_menu);
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

        foodItems.add(new MenuItems("Breakfast Burger", R.drawable.breakfast));
        foodItems.add(new MenuItems("John Hancock", R.drawable.cheeseburger));
        foodItems.add(new MenuItems("Big Kahuna", R.drawable.mac));
        foodItems.add(new MenuItems("Plain Jane", R.drawable.plainjane));
        foodItems.add(new MenuItems("Skyscraper", R.drawable.skyscraper));
        foodItems.add(new MenuItems("Veggie Burger", R.drawable.veggie));
    }
}