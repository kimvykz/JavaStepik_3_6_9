import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {

    static double calculate(double a, double b, String oper) {
        double res = 0;
        if (oper.equals("+")) {
            res = a + b;
        }
        else if(oper.equals("-")) {
            res = a - b;
        }
        else if(oper.equals("*")) {
            res = a * b;
        }
        else  if(oper.equals("/")) {
            res = a / b;
        }
        else {
            res = 0;
        }
        return res;
    }

    static boolean second = false;

    public static void main(String[] args) {

        double[] nums = new double[2];
        double[] result = new double[1];
        String[] exp = new String[1];



        JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        JTextField textField = new JTextField("0");
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setFont(new Font(textField.getFont().getName(), Font.PLAIN, 30));
        textField.setEditable(false);

        panel.setSize(350,500);
        panel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        CalcButton button0 = new CalcButton(textField, "0", "0");
        CalcButton button1 = new CalcButton(textField, "1", "1");
        CalcButton button2 = new CalcButton(textField, "2", "2");
        CalcButton button3 = new CalcButton(textField, "3", "3");
        CalcButton button4 = new CalcButton(textField, "4", "4");
        CalcButton button5 = new CalcButton(textField, "5", "5");
        CalcButton button6 = new CalcButton(textField, "6", "6");
        CalcButton button7 = new CalcButton(textField, "7", "7");
        CalcButton button8 = new CalcButton(textField, "8", "8");
        CalcButton button9 = new CalcButton(textField, "9", "9");
        JButton buttonC = new JButton("C");
        JButton buttonCalc = new JButton("=");
        JButton buttonMinus = new JButton("-");
        JButton buttonDiv = new JButton("/");
        JButton buttonMult = new JButton("*");
        JButton buttonPlus = new JButton( "+");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(350,500));

        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nums[0] = 0;
                nums[1] = 0;
                exp[0] = "";
                result[0] = 0;
                textField.setText("0");
                second = false;
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nums[0] = Double.valueOf(textField.getText());
                exp[0] = "+";
                textField.setText("");
                second = true;
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nums[0] = Double.valueOf(textField.getText());
                exp[0] = "-";
                textField.setText("");
                second = true;
            }
        });

        buttonMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nums[0] = Double.valueOf(textField.getText());
                exp[0] = "*";
                textField.setText("");
                second = true;
            }
        });

        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nums[0] = Double.valueOf(textField.getText());
                exp[0] = "/";
                textField.setText("");
                second = true;
            }
        });

        buttonCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (second) {
                    nums[1] = Double.valueOf(textField.getText());

                    if (nums[1] == 0.0 && exp[0].equals("/")) {
                        textField.setText("division by Zero");
                    }
                    else {
                        result[0] = calculate(nums[0], nums[1], exp[0]);

                        textField.setText(String.valueOf(result[0]));
                    }
                    second = false;
                }
            }
        });

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.ipady = 50;
        gbc.weightx = 0.0;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(textField, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(button1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(button2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(button3, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        panel.add(buttonPlus, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(button4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(button5, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(button6, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        panel.add(buttonMinus, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(button7, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(button8, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(button9, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        panel.add(buttonMult, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(buttonC, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(button0, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(buttonCalc, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        panel.add(buttonDiv, gbc);

        frame.add(panel);



        frame.setVisible(true);
    }

}

class CalcButton extends JButton{

    CalcButton(JTextField component, String textOnButton, String typeInTextField) {
        super(textOnButton);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (component.getText().equals("0")) {
                    component.setText(typeInTextField);
                }
                else {
                    component.setText(component.getText() + typeInTextField);
                }
            }
        });
    }
}
