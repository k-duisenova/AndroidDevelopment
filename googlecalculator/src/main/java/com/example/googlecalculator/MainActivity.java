package com.example.googlecalculator;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonPlus, buttonMinus, buttonMulti, buttonDiv, buttonSqr, buttonClr, buttonDel, buttonEquals, buttonDot, buttonPercent;
    Button buttonSqrt;
    Button buttonFactorial, buttonPower, buttonRoot, buttonSin, buttonCos, buttonTan, buttonLn, buttonLog, buttonPi, buttonEx;
    TextView text;
    String process = "";
    String textDisplay;
    boolean longClicked;
    double valueOne = 0;
    double valueTwo = 0;
    double res = 0;
    char operation;
    private boolean isOperationClicked = false;
    private boolean isResultCalculated = false;
    private boolean isCleared = false;

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        valueOne = savedInstanceState.getDouble("valueOne");
        valueTwo = savedInstanceState.getDouble("valueTwo");
        res = savedInstanceState.getDouble("res");
        longClicked = savedInstanceState.getBoolean("longClicked");
        process = savedInstanceState.getString("process");
        operation = savedInstanceState.getChar("operation");
        isOperationClicked = savedInstanceState.getBoolean("isOperationClicked");
        isResultCalculated = savedInstanceState.getBoolean("isResultCalculated");
        isCleared = savedInstanceState.getBoolean("isCleared");
        textDisplay = savedInstanceState.getString("text");
        text.setText(textDisplay);
    }

    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putDouble("valueOne", valueOne);
        outState.putDouble("valueTwo", valueTwo);
        outState.putDouble("res", res);
        outState.putBoolean("longClicked", longClicked);
        outState.putString("process", process);
        outState.putChar("operation", operation);
        outState.putBoolean("isOperationClicked", isOperationClicked);
        outState.putBoolean("isResultCalculated", isResultCalculated);
        outState.putBoolean("isCleared", isCleared);
        outState.putString("text", text.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonPlus = findViewById(R.id.plus_button);
        buttonMinus = findViewById(R.id.minus_button);
        buttonMulti = findViewById(R.id.multiply_button);
        buttonDel = findViewById(R.id.del_button);
        buttonDiv = findViewById(R.id.divide_button);
        buttonSqr = findViewById(R.id.sqr_button);
        buttonSqrt = findViewById(R.id.sqrt_button);
        buttonClr = findViewById(R.id.clear_button);
        buttonEquals = findViewById(R.id.res_button);
        buttonDot = findViewById(R.id.dot_button);
        buttonPercent = findViewById(R.id.percent_button);

        buttonSin = findViewById(R.id.sin_button);
        buttonCos = findViewById(R.id.cos_button);
        buttonTan = findViewById(R.id.tan_button);
        buttonPower = findViewById(R.id.power_button);
        buttonRoot = findViewById(R.id.root_button);
        buttonFactorial = findViewById(R.id.factorial_button);
        buttonPi = findViewById(R.id.pi);
        /*buttonEx = findViewById(R.id.exponential);*/
        buttonLn = findViewById(R.id.ln_button);
        buttonLog = findViewById(R.id.log_button);

        text = findViewById(R.id.text_view);


        buttonClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
                isCleared = true;
            }
        });
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = text.getText().toString();
                if(txt.length()>0 && text.getText()!="0"){
                    if(txt.equals("error")) {
                        text.setText("");
                    }
                    else {
                        txt = txt.substring(0, txt.length() - 1);
                        text.setText(txt);
                    }
                }
                isCleared = false;
            }
        });
        buttonDel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                text.setText("");
                isCleared = true;
                return longClicked = true;
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResultCalculated || text.getText() == "error") {
                    buttonClr.performClick();
                    text.append("0");
                    isResultCalculated = false;
                } else text.append("0");
                isOperationClicked = false;
                isCleared = false;
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().equals("0")){
                    text.setText("1");
                } else if (isResultCalculated || text.getText() == "error") {
                    buttonClr.performClick();
                    text.append("1");
                    isResultCalculated = false;
                }
                else text.append("1");
                isOperationClicked = false;
                isCleared = false;

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().equals("0")){
                    text.setText("2");
                } else if (isResultCalculated || text.getText() == "error") {
                    buttonClr.performClick();
                    text.append("2");
                    isResultCalculated = false;
                }
                else text.append("2");
                isOperationClicked = false;
                isCleared = false;

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().equals("0")){
                    text.setText("3");
                } else if (isResultCalculated || text.getText() == "error") {
                    buttonClr.performClick();
                    text.append("3");
                    isResultCalculated = false;
                }
                else text.append("3");
                isOperationClicked = false;
                isCleared = false;

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().equals("0")){
                    text.setText("4");
                } else if (isResultCalculated || text.getText() == "error") {
                    buttonClr.performClick();
                    text.append("4");
                    isResultCalculated = false;
                }
                else text.append("4");
                isOperationClicked = false;
                isCleared = false;

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().equals("0")){
                    text.setText("5");
                } else if (isResultCalculated || text.getText() == "error") {
                    buttonClr.performClick();
                    text.append("5");
                    isResultCalculated = false;
                }
                else text.append("5");
                isOperationClicked = false;
                isCleared = false;

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().equals("0")){
                    text.setText("6");
                } else if (isResultCalculated || text.getText() == "error") {
                    buttonClr.performClick();
                    text.append("6");
                    isResultCalculated = false;
                }
                else text.append("6");
                isOperationClicked = false;
                isCleared = false;

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().equals("0")){
                    text.setText("7");
                } else if (isResultCalculated || text.getText() == "error") {
                    buttonClr.performClick();
                    text.append("7");
                    isResultCalculated = false;
                }
                else text.append("7");
                isOperationClicked = false;
                isCleared = false;

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().equals("0")){
                    text.setText("8");
                } else if (isResultCalculated || text.getText() == "error") {
                    buttonClr.performClick();
                    text.append("8");
                    isResultCalculated = false;
                }
                else text.append("8");
                isOperationClicked = false;
                isCleared = false;

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().equals("0")){
                    text.setText("9");
                } else if (isResultCalculated || text.getText() == "error") {
                    buttonClr.performClick();
                    text.append("9");
                    isResultCalculated = false;
                }
                else text.append("9");
                isOperationClicked = false;
                isCleared = false;

            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = text.getText().toString();
                if (isResultCalculated || text.getText() == "error"){
                    buttonClr.performClick();
                    text.append("0.");
                }
                if(s.isEmpty()){
                    text.append("0.");
                }else
                if(!s.contains(".")){
                    text.append(".");
                }
                isCleared = false;

            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText() == "error"){
                    return;
                }
                if (text.getText().equals("")){
                    return;
                }
                if (isOperationClicked == false){

                    try {
                        operation = '+';
                        isOperationClicked = true;
                        valueOne = Double.parseDouble(text.getText().toString());
                        text.setText("");
                    } catch (NumberFormatException nfe){
                        text.setText("error");
                    }
                } else {
                    operation = '+';
                }
                if (isOperationClicked){
                    return;
                }
                isCleared = false;

            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText() == "error"){
                    return;
                }
                if (text.getText().equals("")){
                    return;
                }
                if (isOperationClicked == false){
                    operation = '-';
                    try {
                        isOperationClicked = true;
                        valueOne = Double.parseDouble(text.getText().toString());
                        text.setText("");
                    } catch (NumberFormatException nfe){
                        text.setText("error");
                    }

                } else {
                    operation = '-';
                }
                if (isOperationClicked){
                    return;
                }
                isCleared = false;

            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText() == "error"){
                    return;
                }
                if (text.getText().equals("")){
                    return;
                }
                if (isOperationClicked == false){
                    operation = '*';
                    try {

                        isOperationClicked = true;
                        valueOne = Double.parseDouble(text.getText().toString());
                        text.setText("");
                    } catch (NumberFormatException nfe){
                        text.setText("error");
                    }

                } else {
                    operation = '*';
                }
                if (isOperationClicked){
                    return;
                }
                isCleared = false;

            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText() == "error"){
                    return;
                }
                if (text.getText().equals("")){
                    return;
                }
                if (isOperationClicked == false){
                    operation = '/';
                    try {
                        valueOne = Double.parseDouble(text.getText().toString());
                        isOperationClicked = true;
                        text.setText("");
                    } catch(NumberFormatException nfe){
                        text.setText("error");
                    }

                } else {
                    operation = '/';
                }
                if (isOperationClicked){
                    return;
                }
                isCleared = false;

            }
        });
        buttonSqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText() == "error"){
                    return;
                }
                if (isOperationClicked){
                    return;
                }
                if(text.getText()!=""){
                    try {
                        valueOne = Double.parseDouble(text.getText().toString());
                        res = valueOne*valueOne;
                        process = String.valueOf(res);
                        text.setText(process);
                    } catch (NumberFormatException nfe){
                        text.setText("error");
                    }

                    isResultCalculated = true;
                }
                isCleared = false;

            }
        });
        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText() == "error"){
                    return;
                }
                if (isOperationClicked){
                    return;
                }
                if(text.getText()!=""){
                    try {
                        valueOne = Double.parseDouble(text.getText().toString());
                        res=Math.sqrt(valueOne);
                        process=String.valueOf(res);
                        text.setText(process);
                    } catch (NumberFormatException nfe){
                        text.setText("error");
                    }


                    isResultCalculated = true;
                }
                isCleared = false;

            }
        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText() == "error"){
                    return;
                }
                if (isOperationClicked){
                    return;
                }
                if (text.getText() != ""){
                    try {
                        valueOne= Double.parseDouble(text.getText().toString());
                        res = valueOne/100;
                        process = String.valueOf(res);
                        text.setText(process);
                    } catch (NumberFormatException nfe){
                        text.setText("error");
                    }

                    isResultCalculated = true;
                }
                isCleared = false;

            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCleared){
                    return;
                }
                if (isOperationClicked && (!isResultCalculated) && (text.getText()=="")){
                    return;
                }
                if (isResultCalculated){
                    return;
                }
                if (text.getText()==""){
                    return;
                }
                if (text.getText().equals("error")) {
                    return;
                } else {
                    valueTwo = Double.parseDouble(text.getText().toString());
                    switch (operation){
                        case '+':
                            res = valueOne+valueTwo;
                            process = String.valueOf(res);
                            text.setText(process);
                            break;
                        case '-':
                            res = valueOne-valueTwo;
                            process = String.valueOf(res);
                            text.setText(process);
                            break;
                        case '*':
                            res = valueOne*valueTwo;
                            process = String.valueOf(res);
                            text.setText(process);
                            break;
                        case 'p':
                            res = Math.pow(valueOne, valueTwo);
                            process = String.valueOf(res);
                            text.setText(process);
                            break;
                        case '/':
                            if(valueTwo != 0){
                                res = valueOne/valueTwo;
                                process = String.valueOf(res);
                                text.setText(process);
                                break;
                            } else {
                                text.setText("error");
                                break;
                            }
                        case 'r':
                            if (valueTwo == 0){
                                text.setText("error");
                                break;
                            } else {
                                res = Math.pow(valueOne, 1/valueTwo);
                                process = String.valueOf(res);
                                text.setText(process);
                            }
                            break;
                    }

                    isResultCalculated = true;
                    isOperationClicked = false;
                }

            }
        });
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            buttonSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isOperationClicked){
                        return;
                    }
                    if(text.getText()!=""){
                        try {
                            valueOne = Double.parseDouble(text.getText().toString());
                            res = Math.sin(Math.toRadians(valueOne));
                            process = String.valueOf(res);
                            text.setText(process);
                        } catch (NumberFormatException nfe){
                            text.setText("error");
                        }

                        isResultCalculated = true;
                    }
                    isCleared = false;
                }
            });
            buttonCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isOperationClicked){
                        return;
                    }
                    if(text.getText()!=""){
                        try {
                            valueOne = Double.parseDouble(text.getText().toString());
                            res = Math.cos(Math.toRadians(valueOne));
                            process = String.valueOf(res);
                            text.setText(process);
                        } catch (NumberFormatException nfe){
                            text.setText("error");
                        }

                        isResultCalculated = true;
                    }
                    isCleared = false;
                }
            });
            buttonTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isOperationClicked){
                        return;
                    }
                    if(text.getText()!=""){
                        try {
                            valueOne = Double.parseDouble(text.getText().toString());
                            res = Math.tan(Math.toRadians(valueOne));
                            process = String.valueOf(res);
                            text.setText(process);
                        } catch (NumberFormatException nfe){
                            text.setText("error");
                        }

                        isResultCalculated = true;
                    }
                    isCleared = false;
                }
            });
            buttonFactorial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isOperationClicked){
                        return;
                    }
                    if(text.getText()!=""){
                        res = 1;
                        try {
                            if (valueOne < 0){
                                text.setText("error");
                            } else {
                                if (valueOne == 0){
                                    res = 1;
                                } else {
                                    for (int i = 1; i <= valueOne; i++) {
                                        res *= i;
                                    }
                                }
                            }
                            process = String.valueOf(res);
                            text.setText(process);
                        } catch (NumberFormatException nfe){
                            text.setText("error");
                        }

                        isResultCalculated = true;
                    }
                    isCleared = false;

                }
            });
            buttonLn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isOperationClicked){
                        return;
                    }
                    if (text.getText() != ""){
                        try {
                            res = Math.log1p(valueOne);
                            process = String.valueOf(res);
                            text.setText(process);
                        } catch (NumberFormatException nfe){
                            text.setText("error");
                        }
                        isResultCalculated = true;
                    }
                    isCleared = false;
                }
            });
            buttonLog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isOperationClicked){
                        return;
                    }
                    if (text.getText() != ""){
                        try {
                            res = Math.log(valueOne);
                            process = String.valueOf(res);
                            text.setText(process);
                        } catch (NumberFormatException nfe){
                            text.setText("error");
                        }
                        isResultCalculated = true;
                    }
                    isCleared = false;
                }
            });
            buttonPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(text.getText().toString().equals("0")){
                        text.setText(String.valueOf(Math.PI));
                    } else if (isResultCalculated) {
                        buttonClr.performClick();
                        text.append(String.valueOf(Math.PI));
                        isResultCalculated = false;
                    }
                    else text.append(String.valueOf(Math.PI));
                    isOperationClicked = false;
                    isCleared = false;

                }
            });
            buttonPower.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (text.getText().equals("")){
                        return;
                    }
                    if (isOperationClicked == false){
                        operation = 'p';
                        try {
                            isOperationClicked = true;
                            valueOne = Double.parseDouble(text.getText().toString());
                            text.setText("");
                        } catch (NumberFormatException nfe){
                            text.setText("error");
                        }

                    } else {
                        operation = 'p';
                    }
                    if (isOperationClicked){
                        return;
                    }
                    isCleared = false;
                }
            });
            buttonRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (text.getText().equals("")){
                        return;
                    }
                    if (isOperationClicked == false){
                        operation = 'r';
                        try {
                            isOperationClicked = true;
                            valueOne = Double.parseDouble(text.getText().toString());
                            text.setText("");
                        } catch (NumberFormatException nfe){
                            text.setText("error");
                        }

                    } else {
                        operation = 'r';
                    }
                    if (isOperationClicked){
                        return;
                    }
                    isCleared = false;
                }
            });
        }


    }
}