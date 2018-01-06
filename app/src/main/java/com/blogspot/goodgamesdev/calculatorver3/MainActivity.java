package com.blogspot.goodgamesdev.calculatorver3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonDot;

    Button buttonAdd;
    Button buttonSub;
    Button buttonMultiply;
    Button buttonDivide;

    Button buttonC;
    Button buttonEqual;

    TextView result;
    float valueOne, valueTwo;
    boolean isAdd, isSub, isMultiply, isDivide;


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("myResult", result.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        result.setText(savedInstanceState.getString("myResult"));
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
        buttonDot = findViewById(R.id.buttonDot);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        buttonC = findViewById(R.id.buttonC);
        buttonEqual = findViewById(R.id.buttonEqual);

        result = findViewById(R.id.resultTextView);




        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText() == "") {
                    return;
                } else {
                    result.setText(result.getText() + "0");
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText() + "9");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText().toString().contains(".") || result.getText() == "") {
                    return;
                } else {
                    result.setText(result.getText() + ".");
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result == null) {
                    result.setText("");
                } else {
                    valueOne = Float.parseFloat(result.getText() + "");
                    isAdd = true;
                    result.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(String.valueOf(result.getText()));
                isSub = true;
                result.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(String.valueOf(result.getText()));
                isMultiply = true;
                result.setText(null);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Float.parseFloat(String.valueOf(result.getText()));
                isDivide = true;
                result.setText(null);
            }
        });


        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText() == "") {
                    return;
                } else {
                    valueTwo = Float.parseFloat(result.getText() + "");
                }


                if (isAdd) {
                    float tempResult = valueOne + valueTwo;
                    if(tempResult % 1 == 0) {
                        int intTempResult = (int) tempResult;
                        result.setText(String.valueOf(intTempResult));
                    } else {
                        result.setText(String.valueOf(tempResult));
                    }
                    isAdd = false;
                }

                if (isSub) {
                    float tempResult = valueOne - valueTwo;
                    if(tempResult % 1 == 0) {
                        int intTempResult = (int) tempResult;
                        result.setText(String.valueOf(intTempResult));
                    } else {
                        result.setText(String.valueOf(tempResult));
                    }
                    isSub = false;
                }

                if(isMultiply) {
                    float tempResult = valueOne * valueTwo;
                    if(tempResult % 1 == 0) {
                        int intTempResult = (int) tempResult;
                        result.setText(String.valueOf(intTempResult));
                    } else {
                        result.setText(String.valueOf(tempResult));
                    }
                    isMultiply = false;
                }

                if (isDivide) {
                    if (valueTwo == 0) {
                        return;
                    } else {
                        float tempResult = valueOne / valueTwo;
                        if(tempResult % 1 == 0) {
                            int intTempResult = (int) tempResult;
                            result.setText(String.valueOf(intTempResult));
                        } else {
                            result.setText(String.valueOf(tempResult));
                        }
                    }
                    isDivide = false;
                }
            }
        });


//        public static void setNoDot () {
//
//        }






    }
}
