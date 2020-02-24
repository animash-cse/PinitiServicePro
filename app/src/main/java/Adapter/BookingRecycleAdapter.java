package Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ModelClass.BookingModelClass;
import bd.piniti.service_pro.R;


public class BookingRecycleAdapter extends RecyclerView.Adapter<BookingRecycleAdapter.MyViewHolder> {

    Context context;

    boolean showingfirst = true;
    int myPos = 0;

    private List<BookingModelClass> OfferList;


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final BookingModelClass lists = OfferList.get(position);

        String title = lists.getTitle();
        holder.title.setText(lists.getTitle());
        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog myDialog = new Dialog(context);
                LinearLayout yesButton, noButton;
                myDialog.setContentView(R.layout.cancel_popup);

                TextView servicetitle;
                servicetitle = myDialog.findViewById(R.id.service_title);
                servicetitle.setText(title);
                yesButton = myDialog.findViewById(R.id.yes);
                noButton = myDialog.findViewById(R.id.no);

                yesButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "12345"));
                        context.startActivity(intent);
                    }
                });
                noButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
            }
        });
        holder.help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog myDialog = new Dialog(context);
                LinearLayout chatButton, callButton;
                myDialog.setContentView(R.layout.help_popup);
                chatButton = myDialog.findViewById(R.id.chat);
                callButton = myDialog.findViewById(R.id.talk);

                chatButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Chat board not available now", Toast.LENGTH_LONG).show();
                    }
                });
                callButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "12345"));
                        context.startActivity(intent);
                    }
                });
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPos = position;
                notifyDataSetChanged();
            }
        });
    }


    public BookingRecycleAdapter(Context context, List<BookingModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public BookingRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_booking_list, parent, false);
        return new BookingRecycleAdapter.MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView title;
        TextView cancel;
        TextView help;


        public MyViewHolder(View view) {
            super(view);


            title = view.findViewById(R.id.title);
            cancel = view.findViewById(R.id.cancel);
            help = view.findViewById(R.id.need_help);
        }

    }

    @Override
    public int getItemCount() {
        return OfferList.size();
    }
}


