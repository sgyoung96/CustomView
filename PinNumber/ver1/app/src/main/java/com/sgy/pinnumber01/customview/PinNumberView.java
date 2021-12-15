package com.sgy.pinnumber01.customview;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.sgy.pinnumber01.R;
import com.sgy.pinnumber01.databinding.LayoutPinNumberBinding;

import java.util.ArrayList;

public class PinNumberView extends ConstraintLayout {

    public LayoutPinNumberBinding binding = null;
    private int count = 0;                  // 몇번 눌렀는지 체크
    private String mNumber = "";            // 입력값 String +
    private boolean isFinished = false;     // 입력이 완료되었는지에 대한 체크

    public ArrayList<ImageView> pinLst = new ArrayList<>(); // pin 이미지 담는 array

    public PinNumberView(Context context) {
        super(context);
        initView(context, null);
    }

    public PinNumberView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public PinNumberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        binding = LayoutPinNumberBinding.inflate(LayoutInflater.from(context), this, true);

        pinLst.add(binding.pin01);
        pinLst.add(binding.pin02);
        pinLst.add(binding.pin03);
        pinLst.add(binding.pin04);
        pinLst.add(binding.pin05);
        pinLst.add(binding.pin06);

        if (attributeSet != null) {
            setPinNumberInput();
        }
    }

    /**
     * 사용자가 입력한 키보드 값(pin 숫자 문자열 반환)
     *
     * @return
     */
    public String getPinNumber() {
        return mNumber;
    }

    private void setPinNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    /**
     * 사용자가 입력을 완료했는지 가져오는 값
     *
     * @return
     */
    public boolean getFinished() {
        return isFinished;
    }

    /**
     * 문자열의 길이가 6개인지(사용자 입력이 완료되었는지) 확인
     *
     * @param isFinish
     */
    public void setFinished(boolean isFinish) {
        this.isFinished = isFinish;
    }

    /**
     * 사용자 입력값에 따라서 pin 이미지 변화
     */
    public void setPinSelected() {
        int yellow = R.drawable.icon_star_yellow;
        int black = R.drawable.icon_star_black;

        /* ImageView 하드코딩 막도록 사용 */
        for (int i = 0; i < pinLst.size(); i++) {
            pinLst.get(i).setImageResource(yellow);
            if ((binding.etPin.getText().length() - 1) < i) {
                pinLst.get(i).setImageResource(black);
            }
        }
    }

    /**
     * Pin 번호 입력 시마다 호출하는 함수 (실시간 체크)
     */
    private void setPinNumberInput() {
        binding.etPin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setPinNumber(binding.etPin.getText().toString());
                setPinSelected();
                if (binding.etPin.getText().length() == pinLst.size()) {
                    setFinished(true);
                } else {
                    if (binding.etPin.getText().length() > 6) {
                        binding.etPin.setText("");
                        setFinished(false);
                    }
                    setFinished(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
