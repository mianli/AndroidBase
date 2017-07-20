package com.example.limian.recyclerviewtest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by limian on 2017/7/20.
 */

public class SecondActivity extends Activity{

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            datas.add(String.format("item: %d", i));
        }

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(new MyAdapter(this, datas));
        DividerGridItemDecoration dividerGridItemDecoration = new DividerGridItemDecoration(this);
        mRecyclerView.addItemDecoration(dividerGridItemDecoration);
    }

    private static class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private Context context;
        private List<String> datas;

        public MyAdapter(Context context, List<String> datas) {
            this.context = context;
            this.datas = datas;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_grid_item, parent, false));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
//            ViewGroup.LayoutParams lp = holder.container.getLayoutParams();
//            lp.height = new Random().nextInt(300) + 300;
//            holder.container.setLayoutParams(lp);
            holder.textView.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas == null ? 0 : datas.size();
        }
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {

        public ViewGroup container;
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            container = (ViewGroup) itemView.findViewById(R.id.grid_item_container);
            imageView = (ImageView) itemView.findViewById(R.id.grid_item_imgv);
            textView = (TextView) itemView.findViewById(R.id.grid_item_tv);
        }
    }
}
