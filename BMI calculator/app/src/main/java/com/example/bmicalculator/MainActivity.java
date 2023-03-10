package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight , edtHeightFt , edtHeightIn ;
        Button btn;
        TextView result;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.weight);
        edtHeightFt = findViewById(R.id.ft);
        edtHeightIn = findViewById(R.id.inch);
        llMain = findViewById(R.id.llMain);

        btn = findViewById(R.id.btn);
        result = findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //take numbers
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                // convert feet to inches
                int inches = ft*12 + in;

                //convert inches to cm || 1 inch = 2.53 Centimeter
                Double cm = inches*2.53;

                // 1 meter = 100 cm
                double totalM = cm/100;

                //calculate BMi
                double BMI = wt/(totalM*totalM);

                if(BMI>25){
                    result.setText("You're OverWeight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Overweight));
                }
                else if (BMI<18) {
                    result.setText("You're UnderWeight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Underweight));
                }
                else{
                    result.setText("You're Healthy!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });
    }
}