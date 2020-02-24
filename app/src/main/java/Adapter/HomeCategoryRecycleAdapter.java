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
import bd.piniti.service_pro.AddUserInformations.Categorys;
import bd.piniti.service_pro.All_Services_Activity;
import bd.piniti.service_pro.R;


public class HomeCategoryRecycleAdapter extends RecyclerView.Adapter<HomeCategoryRecycleAdapter.MyViewHolder> {

    Context context;

    private List<HomeCategoryModelClass> OfferList;

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final HomeCategoryModelClass lists = OfferList.get(position);
        holder.image.setImageResource(lists.getImage());
        holder.title.setText(lists.getTitle());

        if(position==8){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(context, Categorys.class);
                    context.startActivity(intent1);
                }
            });
        }else {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, All_Services_Activity.class);
                    intent.putExtra("layout", position);
                    context.startActivity(intent);
                }
            });
        }
    }


    public HomeCategoryRecycleAdapter(Context context, List<HomeCategoryModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public HomeCategoryRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_category_list, parent, false);

        return new HomeCategoryRecycleAdapter.MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;

        public MyViewHolder(View view) {
            super(view);

            image = view.findViewById(R.id.image);
            title = view.findViewById(R.id.title);
        }

    }
    
    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


