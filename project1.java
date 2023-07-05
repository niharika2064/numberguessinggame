import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*<applet code="Number.class" height=400 width=400></applet>*/
public class project1 extends JFrame
{
private JLabel labelGMN, labelHigh, labelLow, labelWin;
private JButton btnGuess, btnPlay;
private JTextField txtEnterNum;
private int intGuess, intTarget;
private Container c = getContentPane();
public static void main(String[] args)
{
project1 frm = new project1();
frm.setSize(1000,1000);
frm.setVisible(true);
frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public project1()
{
c.setLayout(new FlowLayout());
setTitle("Random Number Generator");
labelGMN = new JLabel("I have a number between 1 and 1000. Can you guess my number? \n Please enter your guess.");
add(labelGMN);
txtEnterNum = new JTextField(10);
add(txtEnterNum);
btnGuess = new JButton("Guess Number");
add(btnGuess);
btnGuess.setToolTipText("Click here to guess your entered number");
btnPlay = new JButton("Play Again");
btnPlay.setToolTipText("Click here to play again");
labelHigh = new JLabel("Too High!");
labelLow = new JLabel("Too Low!");
labelWin = new JLabel("You Win!");
Handler bhandler = new Handler();
btnGuess.addActionListener(bhandler);
btnPlay.addActionListener(bhandler);
Random randNum = new Random();
intTarget = randNum.nextInt(1000) + 1;
System.out.print(intTarget);
}
public class Handler implements ActionListener
{
public void actionPerformed(ActionEvent ev)
{
String strGuess = txtEnterNum.getText();
intGuess = Integer.parseInt(strGuess);
if(intGuess == intTarget)
{
getContentPane().setBackground(Color.green);
add(labelWin);
labelLow.setVisible(false);
labelHigh.setVisible(false);
add(btnPlay);
}
if(intGuess < intTarget)
{
getContentPane().setBackground(Color.red);
add(labelLow);
labelWin.setVisible(false);
labelHigh.setVisible(false);
}
if (intGuess > intTarget)
{
getContentPane().setBackground(Color.blue);
add(labelHigh);
labelWin.setVisible(false);
labelLow.setVisible(false);
}
}//end action performed
}//end handler
}//end app