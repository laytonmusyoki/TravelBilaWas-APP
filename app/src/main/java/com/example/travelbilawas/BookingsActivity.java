package com.example.travelbilawas;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class BookingsActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    Adapter adapter;

    List<ModelClass> bookingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bookings);


        androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Bookings");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bottomNavigationView=findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        initData();
        initRecyclerView();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initData() {
        bookingList=new ArrayList<>();
        bookingList.add(new ModelClass(R.drawable.solo,"Solo Booking","1 seat",600,"3:30am","Pending..."));
        bookingList.add(new ModelClass(R.drawable.parcel,"Parcel Sending","5 Parcels",400,"1:44 pm","Pending..."));
        bookingList.add(new ModelClass(R.drawable.institute,"Institution Booking","120 seats",1500,"5:30am","Pending..."));
        bookingList.add(new ModelClass(R.drawable.event1,"Event Booking","20 seats",600,"3:24 pm","Pending..."));
    }

    private void initRecyclerView() {
        recyclerView=findViewById(R.id.recycler);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new Adapter(bookingList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id=menuItem.getItemId();
        if(id==R.id.bookings){
            menuItem.setChecked(true);
            Intent intent=new Intent(BookingsActivity.this,BookingsActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.profile){
            Intent intent=new Intent(BookingsActivity.this,ProfileActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.home){
            Intent intent=new Intent(BookingsActivity.this,MainActivity.class);
            startActivity(intent);
        }
        return false;
    }
}