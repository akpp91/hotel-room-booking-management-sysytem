package com.example.project_hotel_booking.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project_hotel_booking.R;
import com.example.project_hotel_booking.entity.Reservation;
import com.example.project_hotel_booking.entity.Room;

import java.util.List;

public class BookingListAdapter extends RecyclerView.Adapter<BookingListAdapter.ViewHolder> {

    private Context context;
    private List<Reservation> bookingItemList;
    private SharedPreferences sharedPreferences;

    public BookingListAdapter(Context context, List<Reservation> bookingItemList) {
        this.context = context;
        this.bookingItemList = bookingItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.booking_list, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Reservation bookingItem = bookingItemList.get(position);
        Room room = bookingItem.getRoom();

        if (room != null) {
            holder.textRoomType.setText(room.getRoomType());
        } else {
            holder.textRoomType.setText("Unknown Room Type");
        }
        holder.textRoomNumber.setText("Room Number: " + room.getRoomNumber());

        holder.btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    @Override
    public int getItemCount() {
        return bookingItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textRoomType, textRoomNumber;
        Button btn_detail;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);


            textRoomNumber = itemView.findViewById(R.id.textRoomNumber);
            textRoomType = itemView.findViewById(R.id.textRoomType);

            btn_detail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
