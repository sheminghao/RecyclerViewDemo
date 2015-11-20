package com.example.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }

    private void loadData() {
        for (int i = 0; i < 30; i++) {
            if (i % 3 == 0) {
                datas.add("内容内容内容内容内容内容" + i);
            } else {
                datas.add("内容" + i);
            }
        }
        adapter.setDatas(datas);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, 1));
        adapter = new MyAdapter(this, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        int index = recyclerView.getChildAdapterPosition(v);
        datas.remove(index);
        adapter.notifyItemRemoved(index);
    }
}
