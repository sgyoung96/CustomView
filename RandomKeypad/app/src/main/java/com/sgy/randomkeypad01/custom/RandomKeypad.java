package com.sgy.randomkeypad01.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.sgy.randomkeypad01.databinding.LayoutCustomNumPadBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;

public class RandomKeypad extends ConstraintLayout {

    public interface OnSetNumber {
        void setNumberText(String mNum);
    }

    private OnSetNumber listener;

    public void setListener(OnSetNumber listener) {
        this.listener = listener;
    }

    private final String TAG = RandomKeypad.class.getSimpleName();
    private LayoutCustomNumPadBinding binding = null;

    private String mNum = "";             // set 의 전체 값을 출력해 오기 위해서 임시로 선언한 문자열

    /* 랜덤 버튼 */
    private final Integer[] nums = { 0,1,2,3,4,5,6,7,8,9 };
    private final List<Integer> numArray = new ArrayList<>();

    public RandomKeypad(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initKeyPad(context, attrs);
    }

    private void initKeyPad(Context context, AttributeSet attrs) {
        binding = LayoutCustomNumPadBinding.inflate(LayoutInflater.from(context), this, true);
        numArray.addAll(Arrays.asList(nums));

        setRandomNumber();              // random 키패드 클릭 시 랜덤으로 숫자 키패드에 0~9 사이 랜덤 숫자 할당
        setNumber();                    // 숫자 키패드 누를 시마다 입력값을 문자열에 저장
        deleteNum();                    // delete 버튼 누를 때마다 문자열의 마지막 문자 삭제
    }

    private void setRandomNumber() {
        binding.tvRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(numArray);
                binding.tvNum0.setText(String.valueOf(numArray.get(0)));
                String temp = "1";
                Integer.parseInt(temp);
                binding.tvNum01.setText(numArray.get(1) + "");
                binding.tvNum02.setText(numArray.get(2) + "");
                binding.tvNum03.setText(numArray.get(3) + "");
                binding.tvNum04.setText(numArray.get(4) + "");
                binding.tvNum05.setText(numArray.get(5) + "");
                binding.tvNum06.setText(numArray.get(6) + "");
                binding.tvNum07.setText(numArray.get(7) + "");
                binding.tvNum08.setText(numArray.get(8) + "");
                binding.tvNum09.setText(numArray.get(9) + "");
            }
        });
    }

    private void setNumber() {
        binding.tvNum0.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText(binding.tvNum0.getText().toString());
            }
        });
        binding.tvNum01.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText(binding.tvNum01.getText().toString());
            }
        });
        binding.tvNum02.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText(binding.tvNum02.getText().toString());
            }
        });
        binding.tvNum03.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText(binding.tvNum03.getText().toString());
            }
        });
        binding.tvNum04.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText(binding.tvNum04.getText().toString());
            }
        });
        binding.tvNum05.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText(binding.tvNum05.getText().toString());
            }
        });
        binding.tvNum06.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText(binding.tvNum06.getText().toString());
            }
        });
        binding.tvNum07.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText(binding.tvNum07.getText().toString());
            }
        });
        binding.tvNum08.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText(binding.tvNum08.getText().toString());
            }
        });
        binding.tvNum09.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText(binding.tvNum09.getText().toString());
            }
        });
    }

    private void deleteNum() {
        binding.tvDelete.setOnClickListener(v -> {
            if( null != listener ) {
                listener.setNumberText("삭제");
            }
        });
    }
}
