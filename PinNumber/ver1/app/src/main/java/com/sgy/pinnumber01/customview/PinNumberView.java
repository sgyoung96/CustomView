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

        /* init views - findViewById 사용 x */
        group_pin = binding.groupPin;
        group_number = binding.groupNumber;
        vg_pin = binding.vgPin;
        vg_number = binding.vgNumber;
        number_01 = binding.number01;
        number_02 = binding.number02;
        number_03 = binding.number03;
        number_04 = binding.number04;
        number_05 = binding.number05;
        number_06 = binding.number06;
        number_07 = binding.number07;
        number_08 = binding.number08;
        number_09 = binding.number09;
        number_0 = binding.number0;
        number_blank = binding.numberBlank;
        number_back = binding.numberBack;

        pinLst.add(binding.pin01);
        pinLst.add(binding.pin02);
        pinLst.add(binding.pin03);
        pinLst.add(binding.pin04);
        pinLst.add(binding.pin05);
        pinLst.add(binding.pin06);

        vg_number = findViewById(R.id.vg_number);

        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.PinNumberView);
            count = typedArray.getInteger(0, 0);
//            mNumber = typedArray.getString(0);
            typedArray.recycle();
            setPinNumber();
        }
    }

//    @Override
//    protected void onFinishInflate() { // view 가 로딩(?)이 완료됐을 때
//        super.onFinishInflate();
//        setPinNumber();
//        setSelected(count, true);
//        setPinNumber();
//    }


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
        if (mNumber.length() > 6) {
            mNumber = "";
            count = 0;
        } else {
            binding.number0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNumber.length() < 6) {
                        mNumber = mNumber + "0";
                        count++;
                        setSelected(count, false);
                    } else if (mNumber.length() == 6) {
                        mNumber = mNumber;
                        count = count;
                        setSelected(count, false);
                    } else {
                        return;
                    }
                }
            });
            binding.number01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNumber.length() < 6) {
                        mNumber = mNumber + "1";
                        count++;
                        setSelected(count, true);
                    } else if (mNumber.length() == 6) {
                        mNumber = mNumber;
                        count = count;
                        setSelected(count, true);
                    } else {
                        return;
                    }
                }
            });
            binding.number02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNumber.length() < 6) {
                        mNumber = mNumber + "2";
                        count++;
                        setSelected(count, true);
                    } else if (mNumber.length() == 6) {
                        mNumber = mNumber;
                        count = count;
                        setSelected(count, true);
                    } else {
                        return;
                    }
                }
            });
            binding.number03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNumber.length() < 6) {
                        mNumber = mNumber + "3";
                        count++;
                        setSelected(count, true);
                    } else if (mNumber.length() == 6) {
                        mNumber = mNumber;
                        count = count;
                        setSelected(count, true);
                    } else {
                        return;
                    }
                }
            });
            binding.number04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNumber.length() < 6) {
                        mNumber = mNumber + "4";
                        count++;
                        setSelected(count, true);
                    } else if (mNumber.length() == 6) {
                        mNumber = mNumber;
                        count = count;
                        setSelected(count, true);
                    } else {
                        return;
                    }
                }
            });
            binding.number05.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNumber.length() < 6) {
                        mNumber = mNumber + "5";
                        count++;
                        setSelected(count, true);
                    } else if (mNumber.length() == 6) {
                        mNumber = mNumber;
                        count = count;
                        setSelected(count, true);
                    } else {
                        return;
                    }
                }
            });
            binding.number06.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNumber.length() < 6) {
                        mNumber = mNumber + "6";
                        count++;
                        setSelected(count, true);
                    } else if (mNumber.length() == 6) {
                        mNumber = mNumber;
                        count = count;
                        setSelected(count, true);
                    } else {
                        return;
                    }
                }
            });
            binding.number07.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNumber.length() < 6) {
                        mNumber = mNumber + "7";
                        count++;
                        setSelected(count, true);
                    } else if (mNumber.length() == 6) {
                        mNumber = mNumber;
                        count = count;
                        setSelected(count, true);
                    } else {
                        return;
                    }
                }
            });
            binding.number08.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNumber.length() < 6) {
                        mNumber = mNumber + "8";
                        count++;
                        setSelected(count, true);
                    } else if (mNumber.length() == 6) {
                        mNumber = mNumber;
                        count = count;
                        setSelected(count, true);
                    } else {
                        return;
                    }
                }
            });
            binding.number09.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNumber.length() < 6) {
                        mNumber = mNumber + "9";
                        count++;
                        setSelected(count, true);
                    } else if (mNumber.length() == 6) {
                        mNumber = mNumber;
                        count = count;
                        setSelected(count, true);
                    } else {
                        return;
                    }
                }
            });
            binding.numberBlank.setOnClickListener(new View.OnClickListener() { // 동작이 없으므로 추후 삭제 (클릭 리스너를 안 달면 됨)
                @Override
                public void onClick(View v) {
                    return;
                }
            });
            binding.numberBack.setOnClickListener(new View.OnClickListener() { // String index out of range: -1
                @Override
                public void onClick(View v) {
                    if (mNumber.length() >= 2) { // 두칸이 되기 전까지 다음 로직
                        count--;
                        mNumber = mNumber.substring(0, mNumber.length() - 1);
                        setSelected(count, true);
                    } else if (mNumber.length() == 1) { // 한칸일 때 count = 0 으로
                        count--;
                        mNumber = "";
                        setSelected(count, true);
                    } else if (mNumber.length() == 0) {
                        count = 0;
                        mNumber = "";
                        setSelected(count, true);
                    }
                }
            });
        }

        return mNumber;
    }
}
