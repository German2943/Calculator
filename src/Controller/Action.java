package Controller;
import Model.Calculator;
import javax.swing.*;

public class Action {
    private Calculator calculator;

    public Action(){

    }
    public void setCalculator(Calculator calculator){
        this.calculator=calculator;
    }

    public void calculate(JTextField field){

        String result=calculator.Calculate(field.getText());
        try {
            Double.valueOf(result);
        } catch (Exception e) {
            result="SYNTAX ERROR";
        }
        refresh(field);
        field.setText(result);
    }

    public void refresh(JTextField field){
        field.setText("");
    }

    public void write(JTextField field, String text){
        if (field.getText().equals("SYNTAX ERROR")){
            refresh(field);
        }
        field.setText(field.getText()+text);
    }
}
