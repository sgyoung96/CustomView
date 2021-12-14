package com.sgy.pinnumber01.customview;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;

import com.sgy.pinnumber01.MainActivity;
import com.sgy.pinnumber01.R;
import com.sgy.pinnumber01.databinding.LayoutPinNumberBinding;

import java.util.ArrayList;

public class PinNumberView extends ConstraintLayout {

    private LayoutPinNumberBinding binding = null;
    private int count = 0;
    private String mNumber = "";
    private boolean isFinished = false;

    /* intent 시킬 변수 */
    private MainActivity main = new MainActivity();

    /* PinNumberView 에 선언한 xml 요소들 초기화 */
    public Group group_pin;
    public Group group_number;
    public ConstraintLayout vg_pin;
    public ConstraintLayout vg_number;

    public ArrayList<ImageView> pinLst = new ArrayList<>();
    public TextView number_01;
    public TextView number_02;
    public TextView number_03;
    public TextView number_04;
    public TextView number_05;
    public TextView number_06;
    public TextView number_07;
    public TextView number_08;
    public TextView number_09;
    public TextView number_0;
    public TextView number_blank;
    public TextView number_back;

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

    public PinNumberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
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
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.PinNumberView);
            count = typedArray.getInteger(0, 0);
            typedArray.recycle();
            setPinNumber();
        }
    }

    public void setSelected(int select) {
        setSelected(select, false);
    }

    public int getSelected() {
        return count;
    }

    public String getNumber() {
        return setPinNumber();
    }

    public void setFinished(boolean isFinish) {

    }

    public boolean getFinished() {
        return isFinished;
    }

    private void setSelected(int select, boolean force) {
        if (force || count != select) {
            if (count < 0 || count > 6) {
                count = 0;
                return;
            }

            int yellow = R.drawable.icon_star_yellow;
            int black = R.drawable.icon_star_black;

            isFinished = false;

            /* ImageView 하드코딩 막도록 사용 */
            for(int i = 0; i < pinLst.size(); i++) {
                pinLst.get(i).setImageResource(yellow);
                if((count-1) < i) {
                    pinLst.get(i).setImageResource(black);
                    if((count) == pinLst.size()) {
                        isFinished = true;
                    }
                }
            }
        }
    }

    private String setPinNumber() {
        return "";
    }
}
