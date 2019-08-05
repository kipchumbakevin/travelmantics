package com.ecommerce.travelmantics;
import android.app.DownloadManager;
import android.content.Intent;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.View;


import com.ecommerce.travelmantics.ob_box.ObjectBox;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.query.Query;


public class ProductListActivity extends AppCompatActivity {

    public static ArrayList<Product> mProductArrayList = new ArrayList<>();

    RecyclerView mRecyclerView;
    int position = 78;
    private Box<Product> mProductBox;
    private Query<Product> mProductQuery;
    ProductListAdapter mProductListAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_list);
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.product_list_recyclerView);
        mProductListAdapter = new ProductListAdapter(ProductListActivity.this, mProductArrayList);
        mRecyclerView.setAdapter(mProductListAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(ProductListActivity.this, 2));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.ic_add);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent i = new Intent(ProductListActivity.this, ProductActivity.class);
                startActivity(i);
            }

        });
        Log.d("Start", "Activity onCreate and position variable = " + position);
        initObjectBox();
    }

    private void initObjectBox() {
        mProductBox = ObjectBox.get().boxFor(Product.class);
    }

    private void updateProducts() {
        mProductArrayList.clear();
        mProductQuery = mProductBox.query().order(Product_.__ID_PROPERTY).build();
        List<Product> products = mProductQuery.find();
        mProductArrayList.addAll(products);
        mProductListAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Start", "Activity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Start", "Activity onResume");
        updateProducts();
    }

    @Override
    protected void onPause() {
        super.onPause();
        position = 80;
        Log.d("Start", "Activity onPause and position variable= " + position);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Start", "Activity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Start", "Activity onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", position);
    }
}
