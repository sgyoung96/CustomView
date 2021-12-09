package com.sgy.pinnumber01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sgy.pinnumber01.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}