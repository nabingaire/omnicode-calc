import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorView extends JFrame {
    private final JTextField display = new JTextField();

    private final JButton[] buttons = {
        new JButton("7"), new JButton("8"), new JButton("9"), new JButton("/"),
        new JButton("4"), new JButton("5"), new JButton("6"), new JButton("*"),
        new JButton("1"), new JButton("2"), new JButton("3"), new JButton("-"),
        new JButton("0"), new JButton("."), new JButton("+"), new JButton("="),
        new JButton("sin"), new JButton("cos"), new JButton("tan"), new JButton("^"),
        new JButton("Store"), new JButton("Recall"), new JButton("Clear"), new JButton("Exit")
    };

    public CalculatorView() {
        // Set up frame
        this.setTitle("MVC Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLayout(new BorderLayout());

        // Display field
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        this.add(display, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));
        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            buttonPanel.add(button);
        }
        this.add(buttonPanel, BorderLayout.CENTER);
    }

    public String getInput() {
        return display.getText();
    }

    public void setOutput(String text) {
        display.setText(text);
    }

    public void clearDisplay() {
        display.setText("");
    }

    public void addButtonListener(ActionListener listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }
}
