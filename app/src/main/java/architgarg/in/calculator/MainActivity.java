package architgarg.in.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView text1 = null;
    public TextView text2 = null;
    private float a = 0;
    private float b = 0;
    private float res = 0;
    private int flag = 0;
    private int noOfDots = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
    }

    public void button0Clicked(View view) {
        text1.append("0");
    }

    public void button1Clicked(View view) {
        text1.append("1");
    }

    public void button2Clicked(View view) {
        text1.append("2");
    }

    public void button3Clicked(View view) {
        text1.append("3");
    }

    public void button4Clicked(View view) {
        text1.append("4");
    }

    public void button5Clicked(View view) {
        text1.append("5");
    }

    public void button6Clicked(View view) {
        text1.append("6");
    }

    public void button7Clicked(View view) {
        text1.append("7");
    }

    public void button8Clicked(View view) {
        text1.append("8");
    }

    public void button9Clicked(View view) {
        text1.append("9");
    }


    public void buttonDotClicked(View view) {
        if (!text1.getText().toString().equals(" ") && noOfDots == 0) {
            text1.append(".");
            noOfDots = 1;
        }
    }

    public void buttonMultiplyClicked(View view) {
        if (flag == 0 && !text1.getText().toString().equals(" ")) {
            text1.append("X");
            flag = 1;
            noOfDots = 0;
        }
    }

    public void buttonDivideClicked(View view) {
        if (flag == 0 && !text1.getText().toString().equals(" ")) {
            text1.append("/");
            flag = 1;
            noOfDots = 0;
        }
    }

    public void buttonPlusClicked(View view) {
        if (flag == 0 && !text1.getText().toString().equals(" ")) {
            text1.append("+");
            flag = 1;
            noOfDots = 0;
        }
    }

    public void buttonMinusClicked(View view) {
        if (flag == 0 && !text1.getText().toString().equals(" ")) {
            text1.append("-");
            flag = 1;
            noOfDots = 0;
        }
    }

    public void buttonEqualClicked(View view) {

        char c = text1.getText().toString().charAt(text1. getText().toString().length() - 1);

        if (text1.getText() == null) {
            text1.setText(" ");
        } else if (!text1.getText().toString().contains("/") && !text1.getText().toString().contains(
                "X") && !text1.getText().toString().contains("-") && !text1.getText().toString().contains("+")) {
            text1.setText(text1.getText());
        } else if (c == '/' || c == 'X' || c == '-' || c == '+' || c == '.') {
            text2.setText("Error");
            text1.setText(" ");
            a = 0;
            b = 0;
            res = 0;
            flag = 0;
            noOfDots = 0;
        } else {
            String array[];
            if (text1.getText().toString().contains("/")) {
                array = text1.getText().toString().split("/");
            } else if (text1.getText().toString().contains("X")) {
                array = text1.getText().toString().split("X");
            } else if (text1.getText().toString().contains("-")) {
                array = text1.getText().toString().split("-");
            } else {
                array = text1.getText().toString().split("\\+");
            }

            array[0].replaceAll("\\s", " ");
            array[1].replaceAll("\\s", " ");

            a = Float.parseFloat(array[0].toString());
            b = Float.parseFloat(array[1].toString());

            if (text1.getText().toString().contains("/")) {
                res = a / b;
                Log.d("Archit", "res = " + res);
                text2.setText(Float.toString(res));
            } else if (text1.getText().toString().contains("X")) {
                res = a * b;
                text2.setText(Float.toString(res));
            } else if (text1.getText().toString().contains("-")) {
                res = a - b;
                Log.d("Archit", "res = " + res);
                text2.setText(Float.toString(res));
            } else {
                res = a + b;
                Log.d("Archit", "res = " + res);
                text2.setText(Float.toString(res));
            }
        }
    }

    public void buttonCEClicked(View view) {
        if (res == 0) {
            if (text1.getText().toString().length() > 0) {
                char c = text1.getText().toString().charAt(text1.getText().toString().length() - 1);
                String s = text1.getText().toString().substring(0, text1.getText().toString().length() - 1);
                text1.setText(s);
                text2.setText(" ");
                if (c == '/' || c == 'X' || c == '-' || c == '+' || c == '.') {
                    flag = 0;
                    noOfDots = 0;
                }
            }
        } else {
            text1.setText(" ");
            text2.setText(" ");
            a = 0;
            b = 0;
            res = 0;
            flag = 0;
            noOfDots = 0;
        }
    }
}


