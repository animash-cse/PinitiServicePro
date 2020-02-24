package Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ModelClass.BookingModelClass;
import bd.piniti.service_pro.R;


public class BookingHistoryRecycleAdapter extends RecyclerView.Adapter<BookingHistoryRecycleAdapter.MyViewHolder> {

    Context context;

    boolean showingfirst = true;
    int myPos = 0;

    private List<BookingModelClass> OfferList;


    public BookingHistoryRecycleAdapter(Context context, List<BookingModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public BookingHistoryRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history_booking_list, parent, false);

        return new BookingHistoryRecycleAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final BookingModelClass lists = OfferList.get(position);

        holder.accpt.setText(lists.getAccpt());
        holder.title.setText(lists.getTitle());
        holder.action.setText(lists.getAction());
        holder.rate.setText(lists.getRate());
        holder.feedback.setText(lists.getFeedback());
        holder.image.setImageResource(lists.getImage());
        if(position==0){
            holder.rate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog myDialog = new Dialog(context);
                    myDialog.setContentView(R.layout.rate_popup);
                    ImageView rate1, rate2,rate3,rate4,rate5;
                    rate1 = myDialog.findViewById(R.id.rate1);
                    rate2 = myDialog.findViewById(R.id.rate2);
                    rate3 = myDialog.findViewById(R.id.rate3);
                    rate4 = myDialog.findViewById(R.id.rate4);
                    rate5 = myDialog.findViewById(R.id.rate5);
                    rate1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "You Give Rate 1", Toast.LENGTH_LONG).show();
                            myDialog.dismiss();
                        }
                    });
                    rate2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "You Give Rate 2", Toast.LENGTH_LONG).show();
                            myDialog.dismiss();
                        }
                    });
                    rate3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "You Give Rate 3", Toast.LENGTH_LONG).show();
                            myDialog.dismiss();
                        }
                    });
                    rate4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "You Give Rate 4", Toast.LENGTH_LONG).show();
                            myDialog.dismiss();
                        }
                    });
                    rate5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, "You Give Rate 5", Toast.LENGTH_LONG).show();
                            myDialog.dismiss();
                        }
                    });

                    myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    myDialog.show();
                }
            });
            holder.feedback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog myDialog = new Dialog(context);
                    myDialog.setContentView(R.layout.feedback_popup);
                    TextView postButton = myDialog.findViewById(R.id.post_button);
                    EditText editText = myDialog.findViewById(R.id.edit_text);
                    postButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context, editText.getText().toString().trim(), Toast.LENGTH_LONG).show();
                            myDialog.dismiss();
                            Dialog fDialog = new Dialog(context);
                            fDialog.setContentView(R.layout.feedback_popup_display);
                            fDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            fDialog.show();

                        }
                    });
                    myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    myDialog.show();
                }
            });
        }
        if(position==1){
            holder.accpt.setTextColor(ContextCompat.getColor(context, R.color.red_color));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPos = position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return OfferList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView accpt;
        TextView title;
        TextView action;
        TextView rate;
        TextView feedback;
        ImageView image;


        public MyViewHolder(View view) {
            super(view);
            accpt = view.findViewById(R.id.accept);
            title = view.findViewById(R.id.title);
            action = view.findViewById(R.id.action_by);
            rate = view.findViewById(R.id.rate);
            feedback = view.findViewById(R.id.feedback);
            image = view.findViewById(R.id.image);


        }

    }

}


