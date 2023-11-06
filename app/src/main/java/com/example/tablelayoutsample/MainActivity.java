package com.example.tablelayoutsample.;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView calculatorScreen;
    private String currentInput = "";
    private String operator = "";
    private double memoryValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorScreen = findViewById(R.id.calculatorScreen);

    }
    public void onFuncClck(View view) {
        String buttonText = ((Button) view).getText().toString();
        switch (buttonText) {
            case "MC":
                memoryValue = 0;
                break;
            case "MR":
                currentInput = String.valueOf(memoryValue);
                break;
            case "MS":
                memoryValue = Double.parseDouble(currentInput);
                break;
            case "M+":
                memoryValue += Double.parseDouble(currentInput);
                break;
            case "M-":
                memoryValue -= Double.parseDouble(currentInput);
                break;
            case "+-":
                if (!currentInput.isEmpty()) {
                    double num = Double.parseDouble(currentInput);
                    currentInput = String.valueOf(-num);
                }
                break;
            case "CE":
                currentInput = "";
                break;
            case "<--":
                // nezinojau kaip sita normaliai padaryt
                if (!currentInput.isEmpty()) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                }
                break;
            case "DEL":
                currentInput = "";
                operator = "";
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operator = buttonText;
                break;
        }

        updateCalculatorScreen();
    }
    public void onNumberClck(View view) {
        String digit = ((Button) view).getText().toString();
        currentInput += digit;
        updateCalculatorScreen();
    }
    public void onEqualClck(View view) {
        if (!operator.isEmpty()) {
            double result = calculateResult();
            currentInput = String.valueOf(result);
            operator = "";
            updateCalculatorScreen();
        }
    }
    public void onDelOneClck(View view) {
    }
    public void onClearClck(View view) {
    }
    public void onDelClck(View view) {
    }
    private void updateCalculatorScreen() {
        calculatorScreen.setText(currentInput);
    }
    private double calculateResult() {
        double num1 = Double.parseDouble(currentInput);
        double num2 = memoryValue;
        switch (operator) {
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
        }
        return num1;
    }
}
