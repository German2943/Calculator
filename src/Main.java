import Model.Operation;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Operation op=new Operation("8*9*7+4");

        System.out.println(op.getResult());
    }
}