package com.example.hw82;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    public static final String BUNDLE_KEY_OPERATOR = "operator";
    public static final String BUNDLE_KEY_NUM1 = "num1";
    public static final String BUNDLE_KEY_NUM2 = "num2";
    private Button mBtn1,mBtn2,mBtn3,mBtn4,mBtn5,mBtn6,mBtn7,mBtn8,mBtn9,mBtn0
            ,mbtn_add,mBtn_diff,mBtn_multi,mBtn_dev,mbtn_dot,mBtn_equal,mBtn_delet;
    private TextView mTxt_Result;
    private float mNum1,mNum2;
    private String mOp="";
    private boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();
        if (savedInstanceState != null) {
            Log.d(TAG, "saveInstanceState: " + savedInstanceState);
            mOp = savedInstanceState.getString(BUNDLE_KEY_OPERATOR);
            mNum1=savedInstanceState.getFloat(BUNDLE_KEY_NUM1);
            mNum2=savedInstanceState.getFloat(BUNDLE_KEY_NUM2);
        }

    }

    public void setNum(int num){
        String tempt=mTxt_Result.getText().toString();
        if (mOp == "") {
            if (tempt.equalsIgnoreCase("0"))
                mTxt_Result.setText(num + "");
            else
                mTxt_Result.setText(tempt + num + "");
        }
        else {
            if (flag == false) {
                mTxt_Result.setText(num + "");
                flag = true;
            }
            else {
                mTxt_Result.setText(tempt+num);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: "+mOp);
        outState.putString(BUNDLE_KEY_OPERATOR,mOp);
        Log.d(TAG, "onSaveInstanceState: "+mNum1);
        outState.putFloat(BUNDLE_KEY_NUM1,mNum1);
        Log.d(TAG, "onSaveInstanceState: "+mNum2);
        outState.putFloat(BUNDLE_KEY_NUM2,mNum2);

    }

    private void setListeners() {
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(1);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(2);

            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(3);

            }
        });
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(4);

            }
        });
        mBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(5);

            }
        });
        mBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(6);

            }
        });
        mBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(7);

            }
        });
        mBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(8);
            }
        });
        mBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(9);

            }
        });
        mBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum(0);

            }
        });
        mbtn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNum1=Float.parseFloat(mTxt_Result.getText().toString());
                mOp="+";

            }
        });
        mBtn_diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNum1=Float.parseFloat(mTxt_Result.getText().toString());
                mOp="-";

            }
        });
        mBtn_dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNum1=Float.parseFloat(mTxt_Result.getText().toString());
                mOp="/";

            }
        });
        mBtn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNum1=Float.parseFloat(mTxt_Result.getText().toString());
                mOp="*";

            }
        });
        mBtn_delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNum1 = mNum2 = 0;
                mOp = "";
                mTxt_Result.setText("");
                flag=false;
            }
        });
        mbtn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        mBtn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNum2=Float.parseFloat(mTxt_Result.getText().toString());
                float result = 0;
                if (mOp == "+")
                    result=mNum1+mNum2;
                else if (mOp == "-")
                    result= mNum1-mNum2;
                else if (mOp == "*")
                    result= mNum1*mNum2;
                else if (mOp == "/")
                    result= mNum1/mNum2;
                mTxt_Result.setText(result+"");
                mNum1 = mNum2 = 0;
                mOp = "";
            }
        });
    }

    private void findViews() {
        mBtn1=findViewById(R.id.button1);
        mBtn2=findViewById(R.id.button2);
        mBtn3=findViewById(R.id.button3);
        mBtn4=findViewById(R.id.button4);
        mBtn5=findViewById(R.id.button5);
        mBtn6=findViewById(R.id.button6);
        mBtn7=findViewById(R.id.button7);
        mBtn8=findViewById(R.id.button8);
        mBtn9=findViewById(R.id.button9);
        mBtn0=findViewById(R.id.button0);
        mbtn_add=findViewById(R.id.button_add);
        mBtn_diff=findViewById(R.id.button_diff);
        mBtn_multi=findViewById(R.id.button_multi);
        mBtn_dev=findViewById(R.id.button_dev);
        mbtn_dot=findViewById(R.id.button_dot);
        mBtn_equal=findViewById(R.id.button_equal);
        mBtn_delet=findViewById(R.id.button_delet);
        mTxt_Result=findViewById(R.id.txt_show_result);
    }
}