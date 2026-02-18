package View;
import Controller.Controller;
import Controller.Action;

import javax.swing.*;
import java.awt.*;


public class Viewport  extends JFrame{
    private CalcBtn dividedBtn;
    private CalcBtn equalsBtn;
    private JPanel jPanel1;
    private JTextField jTextField1;
    private CalcBtn minusBtn;
    private CalcBtn n1;
    private CalcBtn n2;
    private CalcBtn n3;
    private CalcBtn n4;
    private CalcBtn n5;
    private CalcBtn n6;
    private CalcBtn n7;
    private CalcBtn n8;
    private CalcBtn n9;
    private CalcBtn n0;
    private CalcBtn plusBtn;
    private CalcBtn timesBtn;
    private CalcBtn parenthesisOpen;
    private CalcBtn parenthesisClose;
    private CalcBtn dotBtn;
    private CalcBtn refreshBtn;


    public Viewport(Action action){
        Color orange=new Color (0xFF7F11);
        Color gray= new Color(0xACBFA4);
        Color white=new Color(0xE2E8CE);
        Color black=new Color(0x262626);


        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(black);
        n9 = new CalcBtn(orange, () -> action.write(jTextField1, "9"));
        n7 = new CalcBtn(orange, () -> action.write(jTextField1, "7"));
        n6 = new CalcBtn(orange, () -> action.write(jTextField1, "6"));
        minusBtn = new CalcBtn(orange, () -> action.write(jTextField1, "-"));
        plusBtn = new CalcBtn(orange, () -> action.write(jTextField1, "+"));
        dividedBtn = new CalcBtn(orange, () -> action.write(jTextField1, "/"));
        timesBtn = new CalcBtn(orange, () -> action.write(jTextField1, "*"));
        equalsBtn = new CalcBtn(orange, () -> action.calculate(jTextField1));
        n8 = new CalcBtn(orange, () -> action.write(jTextField1, "8"));
        n5 = new CalcBtn(orange, () -> action.write(jTextField1, "5"));
        n4 = new CalcBtn(orange, () -> action.write(jTextField1, "4"));
        n3 = new CalcBtn(orange, () -> action.write(jTextField1, "3"));
        n2 = new CalcBtn(orange, () -> action.write(jTextField1, "2"));
        n1 = new CalcBtn(orange, () -> action.write(jTextField1, "1"));
        n0 = new CalcBtn(orange, () -> action.write(jTextField1, "0"));
        jTextField1 = new javax.swing.JTextField();
        jTextField1.setBackground(gray);
        jTextField1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        dotBtn = new CalcBtn(orange, () -> action.write(jTextField1, "."));
        refreshBtn = new CalcBtn(orange, () -> action.refresh(jTextField1));
        parenthesisOpen = new CalcBtn(orange, () -> action.write(jTextField1, "("));
        parenthesisClose = new CalcBtn(orange, () -> action.write(jTextField1, ")"));
        n9.setText("9");


        n7.setText("7");
        n0.setText("0");


        n6.setText("6");

        minusBtn.setText("-");

        plusBtn.setText("+");


        dividedBtn.setText("/");

        timesBtn.setText("*");


        equalsBtn.setText("=");


        n8.setText("8");


        n5.setText("5");


        n4.setText("4");


        n3.setText("3");


        n2.setText("2");


        n1.setText("1");





        dotBtn.setText(".");


        refreshBtn.setText("C");


        parenthesisOpen.setText("(");


        parenthesisClose.setText(")");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);



        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(parenthesisOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(parenthesisClose, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(n0, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField1)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(n7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(n1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(n4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(n5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(n8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(n2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(n6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(n9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(n3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(plusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(minusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(equalsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(timesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(dividedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(dotBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                .addGap(234, 234, 234))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(n9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(plusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(n8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(n7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(n6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(n5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(n4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(n3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(n2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(n1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(timesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dividedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(equalsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dotBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(parenthesisOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(parenthesisClose, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(n0, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );



        pack();

    }// </editor-fold>

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void n1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void n2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void n3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void n4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void n5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void n8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void timesBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void plusBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void n7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void n9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void equalsBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void dotBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void parenthesisOpenActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void parenthesisCloseActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    public JButton getTimesBtn() {
        return timesBtn;
    }



    public JButton getPlusBtn() {
        return plusBtn;
    }



    public JButton getN9() {
        return n9;
    }


    public JButton getN8() {
        return n8;
    }



    public JButton getN7() {
        return n7;
    }



    public JButton getN6() {
        return n6;
    }



    public JButton getN5() {
        return n5;
    }



    public JButton getN4() {
        return n4;
    }



    public JButton getN3() {
        return n3;
    }



    public JButton getN2() {
        return n2;
    }



    public JButton getN1() {
        return n1;
    }



    public JButton getMinusBtn() {
        return minusBtn;
    }



    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JButton getEqualsBtn() {
        return equalsBtn;
    }



    public JButton getDividedBtn() {
        return dividedBtn;
    }



    public JButton getParenthesisOpen() {
        return parenthesisOpen;
    }



    public JButton getParenthesisClose() {
        return parenthesisClose;
    }



    public JButton getDotBtn() {
        return dotBtn;
    }



    public JButton getRefreshBtn() {
        return refreshBtn;
    }


}
