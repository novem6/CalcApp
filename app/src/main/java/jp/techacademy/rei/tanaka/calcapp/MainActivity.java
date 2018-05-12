package jp.techacademy.rei.tanaka.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button plusButton = findViewById(R.id.plusButton);
       plusButton.setOnClickListener(this);

       Button minusButton = findViewById(R.id.minusButton);
       minusButton.setOnClickListener(this);

       Button multipliedButton = findViewById(R.id.multipliedButton);
       multipliedButton.setOnClickListener(this);

       Button dividedButton = findViewById(R.id.dividedButton);
       dividedButton.setOnClickListener(this);
    }

    public void onClick(View v){
        EditText mFirstNumber = findViewById(R.id.firstNumber);
        double number1;
        if (mFirstNumber.getText().toString().equals("")){
             number1 = 0;
        } else  {
            String sNumber1 = String.valueOf(mFirstNumber);
            number1 = Double.parseDouble(sNumber1);
        }

        EditText mSecondNumber = findViewById(R.id.secondNumber);
        double number2;
        if (mSecondNumber.getText().toString().equals("")){
            number2 = 0;
        } else {
            String sNumber2 = String.valueOf(mSecondNumber);
            number2 = Double.parseDouble(sNumber2);
        }

        double result = 0;

        if (v.getId() == R.id.plusButton) {
            result = number1 + number2;
        }else if (v.getId() == R.id.minusButton){
            result = number1 - number2;
        }else if (v.getId() == R.id.multipliedButton){
            result = number1 * number2;
        }else if(v.getId() == R.id.dividedButton){
            result = number1 / number2;
        }

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("RESULT", result);
        startActivity(intent);
    }
}
