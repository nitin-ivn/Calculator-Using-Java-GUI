import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Calculator{
    
    ArrayList<Float> numbers = new ArrayList<>();
    float number1 = 0,number2 = 0, result = 0;
    String prevOperator = "";
    String buttonType="";
    int operatorCounter = 0;

    JFrame frame = new JFrame("Calculator");
    JLabel label = new JLabel();
    JTextField tf = new JTextField();
    JPanel panel = new JPanel();
    JButton[] numButtons = new JButton[10];
    JButton Add,Sub,Mul,Divide,dot,Delete,Clear,equals,numZero;
    JRadioButton onButton = new JRadioButton("on");
    JRadioButton offButton = new JRadioButton("off");
 

    public static void main(String args[]){
        Calculator cal = new Calculator();
        cal.SimpleGui();
    }

    void SimpleGui(){
        frame.setSize(300,470);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        label.setBounds(7,0,250,50);
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
        frame.getContentPane().add(label);

        tf.setBounds(10,40,265,40);
        tf.setEditable(false);
        tf.setFont(new Font("Arial", Font.BOLD, 18));
        tf.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(tf);

        onButton.setBounds(7,95,60,40);
        onButton.setSelected(true);
        onButton.setFont(new Font("Arial", Font.BOLD, 14));
        onButton.setBackground(Color.BLACK);
        onButton.setForeground(Color.WHITE);
        onButton.addActionListener(new RadioButtons());
        frame.add(onButton);

        offButton.setBounds(7,120,60,40);
        offButton.setSelected(false);
        offButton.setFont(new Font("Arial", Font.BOLD, 14));
        offButton.setBackground(Color.BLACK);
        offButton.setForeground(Color.WHITE);
        offButton.addActionListener(new RadioButtons());
        frame.add(offButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onButton);
        buttonGroup.add(offButton);

        dot = new JButton(".");
        Delete = new JButton("Del");
        Clear = new JButton("C");
        equals = new JButton("=");
        Add = new JButton("+");
        Sub = new JButton("-");
        Mul = new JButton("x");
        Divide = new JButton("/");
        numZero = new JButton("0");


        for(int i=1; i<=9; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(new Font("Arial", Font.BOLD, 14));
            numButtons[i].setForeground(Color.BLACK);
            numButtons[i].setBackground(Color.WHITE);
            numButtons[i].setFocusable(false);
            numButtons[i].addActionListener(new NumbtnClicked());
        }
            numButtons[0] = new JButton("lol");

        Delete.setBounds(150,110,60,40);
        Delete.setForeground(Color.WHITE);
        Delete.setBackground(Color.red);
        Delete.setFocusable(false);
        Delete.setFont(new Font("Arial", Font.BOLD, 14));
        Delete.addActionListener(new RadioButtons());
        frame.add(Delete);

        Clear.setBounds(80,110,60,40);
        Clear.setForeground(Color.WHITE);
        Clear.setBackground(Color.red);
        Clear.setFont(new Font("Arial", Font.BOLD, 14));
        Clear.setFocusable(false);
        Clear.addActionListener(new RadioButtons());
        frame.add(Clear);

        Add.setBounds(220,110,60,40);
        Add.setForeground(Color.BLACK);
        Add.setBackground(Color.YELLOW);
        Add.setFont(new Font("Arial", Font.BOLD, 14));
        Add.setFocusable(false);
        Add.addActionListener(new OperatorbtnClicked());
        frame.add(Add);

        Sub.setBounds(220,160,60,40);
        Sub.setForeground(Color.BLACK);
        Sub.setBackground(Color.YELLOW);
        Sub.setFont(new Font("Arial", Font.BOLD, 14));
        Sub.setFocusable(false);
        Sub.addActionListener(new OperatorbtnClicked());
        frame.add(Sub);

        Mul.setBounds(220,210,60,40);
        Mul.setForeground(Color.BLACK);
        Mul.setBackground(Color.YELLOW);
        Mul.setFont(new Font("Arial", Font.BOLD, 14));
        Mul.setFocusable(false);
        Mul.addActionListener(new OperatorbtnClicked());
        frame.add(Mul);

        Divide.setBounds(220,260,60,40);
        Divide.setForeground(Color.BLACK);
        Divide.setBackground(Color.YELLOW);
        Divide.setFont(new Font("Arial", Font.BOLD, 14));
        Divide.setFocusable(false);
        Divide.addActionListener(new OperatorbtnClicked());
        frame.add(Divide);

        equals.setBounds(220,310,60,100);
        equals.setForeground(Color.BLACK);
        equals.setBackground(Color.YELLOW);
        equals.setFont(new Font("Arial", Font.BOLD, 14));
        equals.setFocusable(false);
        equals.addActionListener(new OperatorbtnClicked());
        frame.add(equals);

        dot.setBounds(150,370,60,40);
        dot.setForeground(Color.BLACK);
        dot.setBackground(Color.WHITE);
        dot.setFont(new Font("Arial", Font.BOLD, 18));
        dot.setFocusable(false);
        dot.addActionListener(new NumbtnClicked());
        frame.add(dot);

        numZero.setBounds(7,370,135,40);
        numZero.setForeground(Color.BLACK);
        numZero.setBackground(Color.WHITE);
        numZero.setFont(new Font("Arial", Font.BOLD, 18));
        numZero.setFocusable(false);
        numZero.addActionListener(new NumbtnClicked());
        frame.add(numZero);

        panel.setBounds(7,162,205,200);
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridLayout(3,3,5,5));
        panel.add(numButtons[9]);
        panel.add(numButtons[8]);
        panel.add(numButtons[7]);
        panel.add(numButtons[6]);
        panel.add(numButtons[5]);
        panel.add(numButtons[4]);
        panel.add(numButtons[3]);
        panel.add(numButtons[2]);
        panel.add(numButtons[1]);
        panel.setFocusable(false);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        
    }

    class RadioButtons implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Object input = event.getSource();
        if(input == onButton){
            onButton.setEnabled(true);
            offButton.setEnabled(true);
            label.setEnabled(true);
            Delete.setEnabled(true);
            Clear.setEnabled(true);
            equals.setEnabled(true);
            numZero.setEnabled(true);
            Add.setEnabled(true);
            Mul.setEnabled(true);
            Sub.setEnabled(true);
            Divide.setEnabled(true);
            for(int i=1;i<=9;i++){
                numButtons[i].setEnabled(true);
            }
    }
        else if(input == offButton){
            onButton.setEnabled(true);
            offButton.setEnabled(true);
            label.setEnabled(false);
            label.setText("");
            tf.setText("");
            Delete.setEnabled(false);
            Clear.setEnabled(false);
            equals.setEnabled(false);
            numZero.setEnabled(false);
            Add.setEnabled(false);
            Mul.setEnabled(false);
            Sub.setEnabled(false);
            Divide.setEnabled(false);
            for(int i=1;i<=9;i++){
                numButtons[i].setEnabled(false);
            }
            
        }
        else if(input == Clear){
            label.setText("");
            tf.setText("");
            numbers.clear();
            number1 = 0;
            number2 = 0;
        }
        else if(input == Delete){
            String string = tf.getText();
            tf.setText("");
            for(int i=0;i<string.length()-1;i++){
                tf.setText(tf.getText() + string.charAt(i));
            }
        }
        }
    }
    class NumbtnClicked implements ActionListener{
    public void actionPerformed(ActionEvent event){
        if(buttonType.equals("operator")){
            tf.setText("");
        }
        String num = ((JButton)event.getSource()).getText();
        String oldnum = tf.getText();

        tf.setText(oldnum + num);
        buttonType = "num";
        operatorCounter = 0;
    }
}

    class OperatorbtnClicked implements ActionListener{
        public void actionPerformed(ActionEvent event){
            buttonType = "operator";
            operatorCounter++;
            String operator = ((JButton)event.getSource()).getText();
            if(operatorCounter == 1){
            String str = label.getText() + tf.getText() + operator;
            label.setText(str);
            numbers.add(Float.valueOf(tf.getText()));
            if(numbers.size() == 2){
                number1 = numbers.get(0);
                number2 = numbers.get(1);

                numbers.clear();
            if(prevOperator.equals("+")){
                result = number1 + number2;
            }
            else if(prevOperator.equals("-")){
                result = number1 - number2;
            }
            else if(prevOperator.equals("x")){
                result = number1 * number2;
            }
            else if(prevOperator.equals("/")){
                try{
                result = number1 / number2;
                }
                catch(ArithmeticException e){
                    label.setText("");
                    tf.setText("Cannot Divide by Zero"+ e);
                }
            }
            numbers.add(result);
            tf.setText(String.valueOf(result));
            label.setText(String.valueOf(result + "  "));
        }
        prevOperator = operator;
        }
        else{
            String str1 = label.getText();
            String newString = str1.substring(0,str1.length()-1);
            label.setText(newString + operator);
            prevOperator = operator;
        }
    }
    }

}