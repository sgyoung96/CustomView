package com.sgy.pinnumber01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.sgy.pinnumber01.contract.PinNumberListener;
import com.sgy.pinnumber01.customview.PinNumberView;
import com.sgy.pinnumber01.databinding.ActivityMainBinding;

/**
 * 1. 화면 켜지자마자 포커스를 받으면 숫자 키패드 올리기
 * 2. 임의의 pin 번호를 지정해서 해당 번호가 맞으면 화면 전환
 */
public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding binding = null;
    private final String pw = "123456";
    private boolean isFinished = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        binding.viewPinNumber.binding.etPin.postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.viewPinNumber.binding.etPin.requestFocus();
                inputMethodManager.showSoftInput(binding.viewPinNumber.binding.etPin, 0);
            }
        }, 100);

        binding.viewPinNumber.binding.etPin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.viewPinNumber.getFinished()) {
                    if (binding.viewPinNumber.getPinNumber().equals(pw)) {
                        goHomeActivity();
                    } else {
                        Toast.makeText(MainActivity.this, "PIN 번호를 다시 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void goHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}