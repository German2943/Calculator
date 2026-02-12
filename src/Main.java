import Model.Calculator;
import Model.Operation;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String r="-(1+-2(3*-----4))";
        Calculator c=new Calculator(r);
        System.out.println(c.collisionManagement(r));


    }
}