
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

     JTextField textField;
     JButton[] buttons;
     String[] buttonLabels = {
            "1", "2", "3", "/",
            "4", "5", "6", "*",
            "7", "8", "9", "-",
            "0", ".", "=", "+"
    };

     double num1, num2, result;
     char operator;

    public Calculator() {
    	setResizable(false);
        setTitle(" Java Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200,50));
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            buttons[i].addActionListener(this);
        }

        setLayout(new GridLayout(5, 4, 10, 10));
        add(textField);
        for (JButton button : buttons) {
            add(button);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9.]")) {
            textField.setText(textField.getText() + command);
        } else if (command.matches("[/*\\-+]")) {
            num1 = Double.parseDouble(textField.getText());
            operator = command.charAt(0);
            textField.setText("");
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        }
    }
}

