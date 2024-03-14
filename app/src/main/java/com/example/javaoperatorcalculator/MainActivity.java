package com.example.javaoperatorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    int firstNum;
    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      Button  b0 = findViewById(R.id.b0);
        Button b00 = findViewById(R.id.b00);
        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);
        Button b4 = findViewById(R.id.b4);
        Button b5 = findViewById(R.id.b5);
        Button b6 = findViewById(R.id.b6);
        Button b7 = findViewById(R.id.b7);
        Button b8 = findViewById(R.id.b8);
        Button b9 = findViewById(R.id.b9);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button bdot = findViewById(R.id.bdot);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivision = findViewById(R.id.btnDivision);
        Button bEqual = findViewById(R.id.bEqual);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnMod = findViewById(R.id.btnMod);
        Button btnRightShift = findViewById(R.id.btnRigthShift);
        Button btnLeftShift = findViewById(R.id.btnLeftShift);
        Button bEor = findViewById(R.id.bEOR);
        Button bAnd = findViewById(R.id.bAnd);
        Button bOr = findViewById(R.id.bOr);

       TextView tvFrame=findViewById(R.id.tvFrame);

       btnClear.setOnClickListener(view ->{
           firstNum=0;
           tvFrame.setText("0");
       });

        ArrayList<Button> nums =new ArrayList<>();
        nums.add(b0);
        nums.add(b1);
        nums.add(b2);
        nums.add(b3);
        nums.add(b4);
        nums.add(b5);
        nums.add(b6);
        nums.add(b7);
        nums.add(b8);
        nums.add(b9);
        nums.add(b00);

        for(Button b:nums)
        {
            b.setOnClickListener(view ->{
                if(!tvFrame.getText().toString().equals("0"))
                {
                    tvFrame.setText(tvFrame.getText().toString() + b.getText().toString());
                } else {
                    tvFrame.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> oper = new ArrayList<>();
        oper.add(btnPlus);
        oper.add(btnSubtract);
        oper.add(btnMultiply);
        oper.add(btnDivision);
        oper.add(btnMod);
        oper.add(bEor);
        oper.add(btnRightShift);
        oper.add(btnLeftShift);
        oper.add(bOr);
        oper.add(bEqual);
        oper.add(bAnd);
        oper.add(btnBack);

        for(Button b: oper)
        {
            b.setOnClickListener(view ->{
                firstNum=Integer.parseInt(tvFrame.getText().toString());
                operation = b.getText().toString();
                tvFrame.setText("0");
            });
        }

        btnBack.setOnClickListener(view -> {
            String num=tvFrame.getText().toString();
            if (num.length()>1)
            {
                tvFrame.setText(num.substring(0,num.length()-1));
            } else if (num.length()==1 && !num.equals("0")) {
                    tvFrame.setText("0");
            }
        });

        bdot.setOnClickListener(view ->{
            if(!tvFrame.getText().toString().contains("."))
            {
                tvFrame.setText(tvFrame.getText().toString() + ".");
            }
        });
        bEqual.setOnClickListener(view ->{
            int secondNum=Integer.parseInt(tvFrame.getText().toString());
            int result;
            switch (operation)
            {
                case "+":
                    result=firstNum+secondNum;
                    break;
                case "-":
                    result=firstNum-secondNum;
                    break;
                case "*":
                    result=firstNum*secondNum;
                    break;
                case "/":
                    result=firstNum/secondNum;
                    break;
                case "%":
                    result=firstNum%secondNum;
                    break;
                case "^":
                    result=firstNum^secondNum;
                    break;
                case ">>":
                    result=firstNum>>secondNum;
                    break;
                case "<<":
                    result=firstNum<<secondNum;
                    break;
                case "|":
                    result=firstNum|secondNum;
                    break;
                case "&":
                    result=firstNum&secondNum;
                    break;
                default:
                    result=firstNum+secondNum;

            }
            tvFrame.setText(String.valueOf(result));
            firstNum=result;
        });
    }

}



