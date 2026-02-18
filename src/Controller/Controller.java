package Controller;
import Model.Calculator;
import View.*;
public class Controller {
    private Action action;
    private Calculator calculator;
    private Viewport frame;


    public Controller(){
        this.action=new Action();
        this.frame=new Viewport(action);
        this.calculator=new Calculator();
        action.setCalculator(calculator);
        frame.setVisible(true);


    }


}
