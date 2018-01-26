package com.lighterletter.www.thelist;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lighterletter.www.thelist.databinding.ActivityMainBinding;
import com.lighterletter.www.thelist.exercise.inventory.ProductActivity;
import com.lighterletter.www.thelist.exercise.kennel.KennelActivity;
import com.lighterletter.www.thelist.numbers.NumberMainActivity;

/**
 * Created by john on 1/25/18.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.numbers.setOnClickListener(this);
        binding.kennel.setOnClickListener(this);
        binding.inventory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.numbers:
                startActivity(new Intent(this, NumberMainActivity.class));
                break;
            case R.id.inventory:
                startActivity(new Intent(this, ProductActivity.class));
                break;
            case R.id.kennel:
                startActivity(new Intent(this, KennelActivity.class));
                break;
        }
    }
}
