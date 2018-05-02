package jp.techacademy.takuya.sunohara.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.design.widget.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText text1;
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (EditText)findViewById(R.id.text1);

        text2 = (EditText)findViewById(R.id.text2);

        Button plusButton = (Button)findViewById(R.id.plusButton);
        plusButton.setOnClickListener(this);

        Button minusButton = (Button)findViewById(R.id.minusButton);
        minusButton.setOnClickListener(this);

        Button multiplyButton = (Button)findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(this);

        Button divideButton = (Button)findViewById(R.id.divideButton);
        divideButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, SecondActivity.class);

        //入力欄が2つとも埋まっているか判定
        if (!text1.getText().toString().equals("")  && !text2.getText() .toString().equals("")) {

            double value1 = Double.parseDouble(text1.getText().toString());
            double value2 = Double.parseDouble(text2.getText().toString());

            if (v.getId() == R.id.plusButton) {
                double resultValue = value1 + value2;
                intent.putExtra("result", resultValue);
                startActivity(intent);

            } else if (v.getId() == R.id.minusButton) {
                double resultValue = value1 - value2;
                intent.putExtra("result", resultValue);
                startActivity(intent);

            } else if (v.getId() == R.id.multiplyButton) {
                double resultvalue = value1 * value2;
                intent.putExtra("result", resultvalue);
                startActivity(intent);

            } else {
                double resultValue = value1 / value2;
                intent.putExtra("result", resultValue);
                startActivity(intent);
            }

        } else {
            Snackbar.make(v, "数字を入力してください。", Snackbar.LENGTH_LONG)
                    .show();
        }

    }
}
