package com.example.travelbilawas;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<ModelClass> bookingList;
    public Adapter(List<ModelClass> bookingList){
        this.bookingList=bookingList;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.booking,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int resource=bookingList.get(position).getImage();
        String types=bookingList.get(position).getCategory();
        String sits=bookingList.get(position).getSeats();
        String timeoftravel=bookingList.get(position).getTime();
        String state=bookingList.get(position).getStatus();
        int price=bookingList.get(position).getAmount();
        int intSeats=bookingList.get(position).getSits();
        String pricestring= String.valueOf(price);

        holder.sendData(resource,types,sits,pricestring,timeoftravel,state);
        holder.checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),CheckoutActivity.class);
                intent.putExtra("image",resource);
                intent.putExtra("category",types);
                intent.putExtra("seats",sits);
                intent.putExtra("time",timeoftravel);
                intent.putExtra("status",state);
                intent.putExtra("amount",price);
                intent.putExtra("intSits",intSeats);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView category;
        private TextView seats;
        private TextView time;
        private TextView status;
        private TextView amount;
        private LinearLayout checkout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);
            category=itemView.findViewById(R.id.category);
            seats=itemView.findViewById(R.id.seats);
            time=itemView.findViewById(R.id.time);
            status=itemView.findViewById(R.id.status);
            amount=itemView.findViewById(R.id.amount);
            checkout=itemView.findViewById(R.id.checkout);
        }

        public void sendData(int resource, String types, String sits,String pricestring, String timeoftravel, String state) {
            imageView.setImageResource(resource);
            category.setText(types);
            seats.setText(sits);
            amount.setText(pricestring);
            time.setText(timeoftravel);
            status.setText(state);
        }
    }
}
