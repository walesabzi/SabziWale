package com.sabziwale.sabziwale;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import org.w3c.dom.Text;

import java.util.List;

public class VegetablesAdapter extends RecyclerView.Adapter<VegetablesAdapter.VegetablesViewHolder>{

    //Context will be used to inflate the layout
    Context mCtx;
    List<Vegetables> vegetablesList;


    public VegetablesAdapter(Context mCtx, List<Vegetables> vegetablesList) {
        this.mCtx = mCtx;
        this.vegetablesList = vegetablesList;
    }





    @NonNull
    @Override
    public VegetablesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.vegetable_list,parent,false);

        VegetablesViewHolder vegetablesViewHolder = new VegetablesViewHolder(view);

        //error was here I forgot to pass the value
        return vegetablesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VegetablesViewHolder holder, int position) {

        Vegetables vegetables = vegetablesList.get(position);

        holder.veg_name.setText(vegetables.getVeg_name());
        holder.veg_price.setText(String.valueOf(vegetables.getVeg_price()));

        Picasso.get().load(vegetables.getImage()).into(holder.vegetableImage);

        //holder.vegetableImage.setImageDrawable(mCtx.getDrawable(vegetables.getImage()));
        //holder.vegetableImage.setImageURI(Uri.parse(vegetables.getImage()));
        //  holder.vegetableImage.

    }

    @Override
    public int getItemCount() {

        return vegetablesList.size();
    }

    class VegetablesViewHolder extends RecyclerView.ViewHolder{

        ImageView vegetableImage;
        TextView veg_name;
        TextView veg_price;
        Button btn_Plus, btn_Minus;
        Button btn_continue;
        TextView qty_value;
        int qty=0;



        public VegetablesViewHolder(final View itemView) {
            super(itemView);

            vegetableImage = itemView.findViewById(R.id.imageViewveg_image);
            veg_name= itemView.findViewById(R.id.textViewveg_name);
            veg_price = itemView.findViewById(R.id.textViewveg_price);
            btn_Plus = itemView.findViewById(R.id.buttonPlus_button);
            btn_Minus = itemView.findViewById(R.id.buttonMinus_button);
            btn_continue = itemView.findViewById(R.id.buttonContinue);
            qty_value = itemView.findViewById(R.id.textViewveg_qtynumber);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"Item Pressed "+getAdapterPosition(),Toast.LENGTH_SHORT).show();
                }
            });

//            btn_Plus.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                  qty++;
//                  qty_value.setText(""+qty);
//                }
//            });
//            btn_Minus.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    qty--;
//                    qty_value.setText(""+qty);
//                }
//            });
//            btn_continue.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(itemView.getContext(),"COntinue button pressed",Toast.LENGTH_SHORT).show();
//                }
//            });

        }


    }




}
