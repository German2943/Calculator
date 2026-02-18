package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalcBtn extends JButton {

    public CalcBtn(Color color, Runnable action){
        super();
        setBackground(color);

        addActionListener(e -> action.run());
        setFont(new Font("Segoe UI", Font.BOLD, 24));
    }

}
