import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        // Attach listeners to buttons
        this.view.addButtonListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements ActionListener {
        private String operator = "";
        private Double firstOperand = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = ((javax.swing.JButton) e.getSource()).getText();
            try {
                switch (command) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "^":
                        operator = command;
                        firstOperand = Double.parseDouble(view.getInput());
                        view.clearDisplay();
                        break;

                    case "=":
                        double secondOperand = Double.parseDouble(view.getInput());
                        double result = performOperation(firstOperand, secondOperand, operator);
                        view.setOutput(String.valueOf(result));
                        break;

                    case "sin":
                    case "cos":
                    case "tan":
                        double angle = Double.parseDouble(view.getInput());
                        double trigResult = performTrigonometry(command, angle);
                        view.setOutput(String.valueOf(trigResult));
                        break;

                    case "Store":
                        double numberToStore = Double.parseDouble(view.getInput());
                        model.storeNumber(numberToStore);
                        view.setOutput("Stored: " + numberToStore);
                        break;

                    case "Recall":
                        double recalledNumber = model.recallNumber();
                        view.setOutput(String.valueOf(recalledNumber));
                        break;

                    case "Clear":
                        view.clearDisplay();
                        break;

                    case "Exit":
                        System.exit(0);
                        break;

                    default: // For numbers and decimals
                        view.setOutput(view.getInput() + command);
                }
            } catch (Exception ex) {
                view.setOutput("Error: " + ex.getMessage());
            }
        }

        private double performOperation(double a, double b, String operator) {
            return switch (operator) {
                case "+" -> model.add(a, b);
                case "-" -> model.subtract(a, b);
                case "*" -> model.multiply(a, b);
                case "/" -> model.divide(a, b);
                case "^" -> model.exponentiate(a, b);
                default -> throw new IllegalStateException("Invalid operator");
            };
        }

        private double performTrigonometry(String function, double angle) {
            return switch (function) {
                case "sin" -> model.sine(angle);
                case "cos" -> model.cosine(angle);
                case "tan" -> model.tangent(angle);
                default -> throw new IllegalStateException("Invalid function");
            };
        }
    }
}
