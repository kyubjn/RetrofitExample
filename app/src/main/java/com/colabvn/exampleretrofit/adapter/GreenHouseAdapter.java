package com.colabvn.exampleretrofit.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.colabvn.exampleretrofit.R;
import com.colabvn.exampleretrofit.activity.MainActivity;
import com.colabvn.exampleretrofit.model.GreenHouse;

import java.util.ArrayList;

public class GreenHouseAdapter  extends RecyclerView.Adapter<GreenHouseAdapter.GreenHouseViewHolder>{
    public ArrayList<GreenHouse> mData = new ArrayList<>();
    public LayoutInflater layoutInflater;
    public MainActivity mainActivity;
    private Activity mActivity;
    public GreenHouseAdapter(MainActivity activity, int width, ArrayList<GreenHouse> data) {
        this.mData = data;
        this.mainActivity = activity;
        layoutInflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @NonNull
    @Override
    public GreenHouseAdapter.GreenHouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_greenhouse, null);
        return new GreenHouseViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull GreenHouseAdapter.GreenHouseViewHolder holder, int position) {
        final GreenHouse greenHouse = mData.get(holder.getAdapterPosition());
        holder.tvName.setText(greenHouse.getName());
    }

    @Override
    public int getItemCount() {
        if (mData == null || mData.isEmpty()) {
            return 0;
        } else {
            return mData.size();
        }
    }

    public class GreenHouseViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public GreenHouseViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.garden_name);

        }

    }
}
