package com.sgy.randomkeypad01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

import com.sgy.randomkeypad01.custom.RandomKeypad;
import com.sgy.randomkeypad01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding = null;

    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.vgKeypad.setListener(mNum -> {
            result = binding.tvText.getText().toString();
            if(mNum.equals("삭제")) {
                if (binding.tvText.getText().length() <= 0) {
                    binding.tvText.setText("");
                } else {
                    binding.tvText.setText(result.substring(0, result.length() - 1));
                }
            } else {
                result += mNum;
                binding.tvText.setText(result);
            }
        });
    }
}