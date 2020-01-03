package com.example.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.library.R;

import java.util.ArrayList;
import java.util.List;

abstract public class BaseJumpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        initData();
    }

    private void initData() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        List<String> titles = new ArrayList<>();
        setData(titles);
        JumpAdapter mainAdapter = new JumpAdapter(titles);
        mainAdapter.setOnItemClickListener(new JumpAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                onItemClick(position);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);
    }

    abstract protected void onItemClick(int poisiton);

    abstract protected void setData(List<String> titles);
}