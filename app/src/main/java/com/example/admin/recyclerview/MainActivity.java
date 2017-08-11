package com.example.admin.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    List<Food> foodList = new ArrayList<>();

    RecyclerView rvFoodList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    FoodListAdapter foodListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFoodList = (RecyclerView) findViewById(R.id.rvFoodList);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvFoodList.setLayoutManager(layoutManager);
        rvFoodList.setItemAnimator(itemAnimator);
        foodListAdapter = new FoodListAdapter(foodList);
        rvFoodList.setAdapter(foodListAdapter);

        initFoodList();
        foodListAdapter.notifyDataSetChanged();

    }




    private void initFoodList() {
        foodList.add(new Food("Buger", 12, 300, 4.5));
        foodList.add(new Food("Pizza", 10, 400, 3.3));
        foodList.add(new Food("Soup", 15, 349, 2.2));
        foodList.add(new Food("Steak", 20, 240, 5));
    }
}
