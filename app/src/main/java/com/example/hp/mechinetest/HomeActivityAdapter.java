package com.example.hp.mechinetest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 27-10-2017.
 */

public class HomeActivityAdapter extends RecyclerView.Adapter<HomeActivityAdapter.CategorysubClass> {
    private List<Data> person;
    Context context;


    public HomeActivityAdapter(ArrayList<Data> category) {
        this.person=category;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context=recyclerView.getContext();
    }
    @Override
    public HomeActivityAdapter.CategorysubClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.navdrawer, parent, false);
        HomeActivityAdapter.CategorysubClass viewholder= new HomeActivityAdapter.CategorysubClass(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(HomeActivityAdapter.CategorysubClass holder, int position) {

        final Data feedItem = person.get(position);
        holder.nav_name.setText(feedItem.getCategory());
        holder.id1.setText(feedItem.getCatId());
        holder.id2.setText(feedItem.getId());


       // Toast.makeText(context, feedItem.getCategory_id(), Toast.LENGTH_SHORT).show();



    }

    @Override
    public int getItemCount() {
        return person.size();
    }

    public class CategorysubClass extends RecyclerView.ViewHolder {

        protected TextView nav_name,id1,id2;


        public CategorysubClass(final View itemView) {
            super(itemView);


            nav_name = (TextView)itemView.findViewById(R.id.drawer_custom);
            id1 = (TextView)itemView.findViewById(R.id.id1);
            id2 = (TextView)itemView.findViewById(R.id.id2);

//            category_card.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//
//
//
//                }
//            });
        }


    }
    public HomeActivityAdapter(List<Data> person) {
        this.person=person;
    }
}


