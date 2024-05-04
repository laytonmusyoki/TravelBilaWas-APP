package com.example.travelbilawas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckoutActivity extends AppCompatActivity {

    TextView category;
    ImageView imageView;
    TextView seats;
    TextView amount;
    TextView time;

    TextView total;
    TextView total2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout);

        androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("CheckOut");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        category=findViewById(R.id.category);
        seats=findViewById(R.id.seats);
        amount=findViewById(R.id.amount);
        time=findViewById(R.id.time);
        imageView=findViewById(R.id.imageview);
        total=findViewById(R.id.total);
        total2=findViewById(R.id.total2);

        Intent intent=getIntent();
        int img=intent.getExtras().getInt("image");
        String type=intent.getExtras().getString("category");
        String sits=intent.getExtras().getString("seats");
        String timeoftravel=intent.getExtras().getString("time");
        int price=intent.getExtras().getInt("amount");
        int quantity=intent.getExtras().getInt("intSits");

        String stringPrice= String.valueOf(price);

        int totalprice=price * quantity;
        String totalamount= String.valueOf(totalprice);

        imageView.setImageResource(img);
        category.setText(type);
        seats.setText(sits);
        amount.setText(stringPrice);
        time.setText(timeoftravel);
        total.setText(totalamount);
        total2.setText(totalamount);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}