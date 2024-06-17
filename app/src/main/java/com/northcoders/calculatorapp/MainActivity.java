package com.northcoders.calculatorapp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);
        Button zero = findViewById(R.id.zero);
        Button subtract = findViewById(R.id.subtract);
        Button add = findViewById(R.id.add);
        Button percentage = findViewById(R.id.percentage);
        Button ac = findViewById(R.id.ac);
        Button period = findViewById(R.id.period);
        Button delete = findViewById(R.id.delete);
        Button multi = findViewById(R.id.multi);
        TextView calcValues = findViewById(R.id.calcValues);
        Button brackets = findViewById(R.id.brackets);
        Button division = findViewById(R.id.division);
        Button equals = findViewById(R.id.equals);

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String buttonText = b.getText().toString();
                if (calcValues.getText().toString().equals("NaN")) {
                    calcValues.setText("");
                }

                switch (buttonText) {
                    case "=":
                        Expression e = new Expression(calcValues.getText().toString());
                        double ans = e.calculate();
                        if (ans % 1 == 0) {
                            calcValues.setText(String.valueOf(((int) ans)));
                        } else {
                            calcValues.setText(String.valueOf(ans));
                        }
                        break;

                    case "AC":
                        calcValues.setText("");
                        break;

                    case "Delete":
                        calcValues.setText(calcValues.getText().toString().replaceAll(".$", ""));
                        break;

                    case "()":
                        if (calcValues.getText().toString().matches(".*\\((?!.*\\).*).*$")) {
                            calcValues.setText(calcValues.getText().toString().concat(")"));
                        } else {
                            calcValues.setText(calcValues.getText().toString().concat("("));
                        }
                        break;

                    default:
                        calcValues.setText(calcValues.getText().toString().concat(buttonText));
                }
            }
        };

        one.setOnClickListener(buttonClickListener);
        two.setOnClickListener(buttonClickListener);
        three.setOnClickListener(buttonClickListener);
        four.setOnClickListener(buttonClickListener);
        five.setOnClickListener(buttonClickListener);
        six.setOnClickListener(buttonClickListener);
        seven.setOnClickListener(buttonClickListener);
        eight.setOnClickListener(buttonClickListener);
        nine.setOnClickListener(buttonClickListener);
        zero.setOnClickListener(buttonClickListener);
        subtract.setOnClickListener(buttonClickListener);
        add.setOnClickListener(buttonClickListener);
        percentage.setOnClickListener(buttonClickListener);
        ac.setOnClickListener(buttonClickListener);
        period.setOnClickListener(buttonClickListener);
        delete.setOnClickListener(buttonClickListener);
        multi.setOnClickListener(buttonClickListener);
        brackets.setOnClickListener(buttonClickListener);
        division.setOnClickListener(buttonClickListener);
        equals.setOnClickListener(buttonClickListener);
    }


}

