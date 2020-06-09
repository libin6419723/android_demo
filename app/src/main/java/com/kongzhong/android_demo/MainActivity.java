package com.kongzhong.android_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List <Demo> demoList = new ArrayList<>();
    RecyclerView rv;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        demoList.add(new Demo("test", "testring", null));
        demoList.add(new Demo("test2", "testring", null));
        demoList.add(new Demo("test3", "testpaing", null));
        demoList.add(new Demo("test", "testring", null));
        demoList.add(new Demo("test2", "testring", null));
        demoList.add(new Demo("test3", "testpaing", null));
        demoList.add(new Demo("test", "testring", null));
        demoList.add(new Demo("test2", "testring", null));
        demoList.add(new Demo("test3", "testpaing", null));
        demoList.add(new Demo("test", "testring", null));
        demoList.add(new Demo("test2", "testring", null));
        demoList.add(new Demo("test3", "testpaing", null));
        rv = this.findViewById(R.id.rv_main);
        DemoAdapter adapter  = new DemoAdapter(demoList);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }

    public class Demo {
        public String mName;
        public String mTitle;
        public Class<Activity> mActivity;
        public Demo(String name, String title, Class<Activity> activity) {
            mName = name;
            mTitle = title;
            mActivity= activity;
        }
    }
    public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {

        private List<Demo> mDemoList;
        RecyclerView recyclerView;

        public DemoAdapter(List<Demo> demoList) {
            mDemoList = demoList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Demo demo = mDemoList.get(position);
            holder.tvTitle.setText(demo.mTitle);
        }

        @Override
        public int getItemCount() {
            return mDemoList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvTitle;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvTitle = itemView.findViewById(R.id.demo_title);
            }
        }
    }
}
