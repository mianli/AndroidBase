package com.example.limian.recyclerviewtest;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.*;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by limian on 2017/7/20.
 */

public class FirstActivity extends Activity {

    List<String> datas = new ArrayList<>();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        for (int i = 0; i < 40; i++) {
            datas.add(String.format("item: %d", i));
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        final MyAdapter adapter = new MyAdapter(this, datas);
        mRecyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);


        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                //首先回调的方法 返回int表示是否监听该方向
                int dragFlags = ItemTouchHelper.UP|ItemTouchHelper.DOWN;//拖拽
                int swipeFlags = ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;//侧滑删除
                return makeMovementFlags(dragFlags,swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                //滑动事件
                Collections.swap(datas,viewHolder.getAdapterPosition(),target.getAdapterPosition());
                adapter.notifyItemMoved(viewHolder.getAdapterPosition(),target.getAdapterPosition());
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                //侧滑事件
                datas.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }

            @Override
            public boolean isLongPressDragEnabled() {
                //是否可拖拽
                return true;
            }
        });
        helper.attachToRecyclerView(mRecyclerView);
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
            MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false));
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas == null ? 0 : datas.size();
        }
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_imgv);
            textView = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }

}
