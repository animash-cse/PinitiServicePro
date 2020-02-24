package Adapter;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ModelClass.HomeCategoryModelClass;
import bd.piniti.service_pro.R;
import bd.piniti.service_pro.activitys.EditProfileActivity;
import bd.piniti.service_pro.activitys.SettingActivity;
import bd.piniti.service_pro.location.TermsCondition;
import bd.piniti.service_pro.notification.NotificationActivity;


public class ProfileRecycleAdapter extends RecyclerView.Adapter<ProfileRecycleAdapter.MyViewHolder> {

    Context context;
    private List<HomeCategoryModelClass> OfferList;

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final HomeCategoryModelClass lists = OfferList.get(position);
        holder.image.setImageResource(lists.getImage());
        holder.title.setText(lists.getTitle());

        if (position == 0) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(context, EditProfileActivity.class);
                    context.startActivity(intent1);
                }
            });
        }
        if (position == 1) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(context, SettingActivity.class);
                    context.startActivity(intent1);
                }
            });
        }
        if (position == 2) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(context, NotificationActivity.class);
                    context.startActivity(intent1);
                }
            });
        }
        if (position == 3) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

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
        }

        if (position == 4) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        context.startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=bd.piniti.service")));
                    } catch (ActivityNotFoundException e) {
                        context.startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=bd.piniti.service")));
                    }
                }
            });
        }

        if(position == 5){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = "Find your local services with the Piniti Service app and make life easier. \nDownload the app from google play store.\nDownload Link: https://play.google.com/store/apps/details?id=bd.piniti.service";
                    String shareSub = "Piniti Service App";
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    context.startActivity(Intent.createChooser(sharingIntent, "Share using"));
                }
            });
        }
        if (position == 7) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(context, TermsCondition.class);
                    context.startActivity(intent1);
                }
            });
            holder.linear.setVisibility(View.GONE);
        } else {

            holder.linear.setVisibility(View.VISIBLE);
        }
    }

    public ProfileRecycleAdapter(Context context, List<HomeCategoryModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public ProfileRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_profile_list, parent, false);


        return new ProfileRecycleAdapter.MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        LinearLayout linear;

        public MyViewHolder(View view) {
            super(view);

            image = view.findViewById(R.id.image);
            title = view.findViewById(R.id.title);
            linear = view.findViewById(R.id.linear);
        }

    }

    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


