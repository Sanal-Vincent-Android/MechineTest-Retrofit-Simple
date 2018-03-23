package com.example.hp.mechinetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements INavigationdrawerControllerCallback {
    RecyclerView nav_rv;
    private INavigationdrawerController inavdrawcontroller;
    private List<Data> category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nav_rv=(RecyclerView)findViewById(R.id.nav_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        nav_rv.setLayoutManager(layoutManager);
        inavdrawcontroller = new HomeActivityController(getApplicationContext(), this);
        inavdrawcontroller.navigationdrawers("BhArAt383STGOPPArmAr");
    }

    @Override
    public void navigationsuccess(ArrayList<Data> navdrawerlist) {
        this.category = navdrawerlist;
        HomeActivityAdapter adaptercategory = new HomeActivityAdapter(navdrawerlist);
        nav_rv.setAdapter(adaptercategory);

    }
}
