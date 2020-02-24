package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ModelClass.HomeCategoryModelClass;
import bd.piniti.service_pro.All_Services_Activity;
import bd.piniti.service_pro.R;


public class ReviewRatingRecycleAdapter extends RecyclerView.Adapter<ReviewRatingRecycleAdapter.MyViewHolder> {

    Context context;


    private List<HomeCategoryModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView image;
        TextView title;


        public MyViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);


        }

    }


    public ReviewRatingRecycleAdapter(Context context, List<HomeCategoryModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public ReviewRatingRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review_rating_list, parent, false);


        return new ReviewRatingRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final HomeCategoryModelClass lists = OfferList.get(position);
        holder.image.setImageResource(lists.getImage());
        holder.title.setText(lists.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, All_Services_Activity.class);
                context.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


