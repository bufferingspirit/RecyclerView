package com.example.admin.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 8/10/2017.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder> {

    List<Food> foodList = new ArrayList<>();
    private static String TAG = "FoodListAdapter: ";
    Context context;

    //Context context;

    public FoodListAdapter(List<Food> foodList){
        this.foodList = foodList;
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDishName, tvPrice, tvCalories, tvRating;

        public ViewHolder(View itemView) {
            super(itemView);

            tvDishName = (TextView) itemView.findViewById(R.id.tvFoodName);
            tvPrice = (TextView) itemView.findViewById(R.id.tvFoodPrice);
            tvCalories = (TextView) itemView.findViewById(R.id.tvFoodCalories);
            tvRating = (TextView) itemView.findViewById(R.id.tvFoodRating);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodlist_item, parent, false);
        return new ViewHolder(view);
    }

   // private int lastPosition = -1;
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        /*Hif(position>lastPosition){
            Animation animation = AnimationUtils.loadAnimation()
        }*/
        Log.d(TAG, "onBindViewHolder: " + position);
        final Food food = foodList.get(position);
        holder.tvDishName.setText(food.getDishName());
        holder.tvCalories.setText(String.valueOf(food.getCalories()));
        holder.tvPrice.setText(String.valueOf(food.getPrice()));
        holder.tvRating.setText(String.valueOf(food.getRating()));

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("food", food);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
