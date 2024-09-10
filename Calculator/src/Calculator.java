import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

// Declerations of all components

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10]; // Array of JButtons
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Dialog",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;

// Constructor

    Calculator() {

        // Instantiating and designing JFrame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#141414"));

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.black);
        textfield.setForeground(Color.white);
        textfield.setBorder(null);

        // Instantiating all buttons 
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        // Adding function buttons to Array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for(int i = 0; i < 8 ; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.white);
        }

        // Creating all of the number buttons using string value of i
        for(int i = 0; i < 10 ; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.black);
            numberButtons[i].setForeground(Color.white);
            numberButtons[i].setBorderPainted(false);
        }

        delButton.setBounds(205, 430, 145, 50);
        delButton.setBackground(Color.decode("#F28C28"));
        delButton.setForeground(Color.white);
        delButton.setBorderPainted(false);

        clrButton.setBounds(50, 430, 145, 50);
        clrButton.setBackground(Color.darkGray);
        clrButton.setForeground(Color.white);
        clrButton.setBorderPainted(false);

        decButton.setBackground(Color.black);
        decButton.setForeground(Color.white);
        decButton.setBorderPainted(false);

        // Instantiating JPanel
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.decode("#141414"));

        // Adding all buttons to JPanel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

    }
    public static void main(String[] args) {

        Calculator calc = new Calculator();

    }
    @Override
    // Implemented method that adds functionality to buttons
    public void actionPerformed(ActionEvent e) {

        for(int i=0; i < 10 ; i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton) { 
            textfield.setText(textfield.getText().concat(String.valueOf(".")));
        }
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == subButton) { 
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == mulButton) { 
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divButton) { 
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource()==equButton) {
            num2=Double.parseDouble(textfield.getText());

            // Operations as per operator value
            switch(operator){
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result)); // Update textField to result
            num1=result;
        }
    
        // Clear and delete buttons
        if(e.getSource() == clrButton) { 
            textfield.setText("");
        }
        if(e.getSource() == delButton) { 
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        
    }

}
