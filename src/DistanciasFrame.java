import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DistanciasFrame extends JFrame implements ActionListener {
    JComboBox<String> fromDistance, toDistance;
    JButton convertButton, resetButton, backButton;
    TextField fromDistanceText;
    TextField toDistanceText;
    double centimeter = 160934;
    double meter = 1609.34;
    double kilometer = 1.60934;
    double foot = 5280;
    double yard = 1760;
    double mile = 1;

    public DistanciasFrame()
    {
        ImageIcon icon = new ImageIcon("src/assets/icon.png");
        this.setIconImage(icon.getImage());
        this.setSize(600, 300);
        this.setTitle("Challenge-ONE-Conversor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JLabel conversionOption = new JLabel();
        conversionOption.setText("Conversor de Distancias");
        conversionOption.setForeground(new Color(0xFFFFFF));
        conversionOption.setVerticalAlignment(SwingConstants.CENTER);
        conversionOption.setHorizontalAlignment(SwingConstants.CENTER);
        conversionOption.setFont(new Font("Lato", Font.PLAIN, 20));
        conversionOption.setBounds(130, 30, 350, 30);
        this.add(conversionOption);

        JLabel credits = new JLabel();
        credits.setText("Creado por José Miguel Carvajal Jiménez");
        credits.setForeground(new Color(0xFFFFFF));
        credits.setVerticalAlignment(SwingConstants.CENTER);
        credits.setHorizontalAlignment(SwingConstants.CENTER);
        credits.setBounds(170, 230, 250, 30);
        credits.setFont(new Font("Lato", Font.PLAIN, 11));
        this.add(credits);

        JLabel fromCurrency = new JLabel("De: ");
        fromCurrency.setBounds(70, 80, 30, 25);
        fromCurrency.setFont(new Font("Lato",Font.PLAIN, 15));
        fromCurrency.setForeground(Color.white);
        this.add(fromCurrency);

        this.fromDistance = new JComboBox<>(new String[] {
                "Selecciona unidad",
                "Centímetro",
                "Metro",
                "Kilómetro",
                "Pie",
                "Yarda",
                "Milla"
        });
        this.fromDistance.setBounds(100, 80, 160, 25);
        this.fromDistance.setFont(new Font("Lato", Font.PLAIN, 15));
        this.add(this.fromDistance);

        fromDistanceText = new TextField();
        fromDistanceText.setBounds(300, 80, 200, 25);
        fromDistanceText.setFont(new Font("Lato",Font.PLAIN, 15));
        fromDistanceText.setForeground(Color.BLACK);
        this.add(fromDistanceText);

        JLabel toCurrency = new JLabel("A: ");
        toCurrency.setBounds(78, 120, 30, 25);
        toCurrency.setFont(new Font("Lato", Font.PLAIN, 15));
        toCurrency.setForeground(Color.white);
        this.add(toCurrency);

        this.toDistance = new JComboBox<>(new String[] {
                "Selecciona unidad",
                "Centímetro",
                "Metro",
                "Kilómetro",
                "Pie",
                "Yarda",
                "Milla"
        });
        this.toDistance.setBounds(100, 120, 160, 25);
        this.toDistance.setFont(new Font("Lato", Font.PLAIN, 15));
        this.add(this.toDistance);

        toDistanceText = new TextField("");
        toDistanceText.setBounds(300, 120, 200, 25);
        toDistanceText.setFont(new Font("Lato",Font.PLAIN, 15));
        toDistanceText.setForeground(Color.BLACK);
        toDistanceText.setEditable(false);
        this.add(toDistanceText);

        convertButton = new JButton("Convertir");
        convertButton.setBounds(100, 170, 96, 25);
        convertButton.setFont(new Font("Lato",Font.PLAIN, 15));
        convertButton.addActionListener(this);
        this.add(convertButton);

        resetButton = new JButton("Reiniciar");
        resetButton.setBounds(260, 170, 90, 25);
        resetButton.setFont(new Font("Lato",Font.PLAIN, 15));
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetButtonActionPerformed();
            }
        });
        this.add(resetButton);

        backButton = new JButton("Volver");
        backButton.setBounds(420, 170, 80, 25);
        backButton.setFont(new Font("Lato",Font.PLAIN, 15));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed();
            }
        });
        this.add(backButton);

        this.setLayout(null);
        this.setVisible(true);
    }

    private void resetButtonActionPerformed() {
        fromDistance.setSelectedIndex(0);
        toDistance.setSelectedIndex(0);
        fromDistanceText.setText("");
        toDistanceText.setText("");
    }

    private void backButtonActionPerformed() {
        new InitialFrame();
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convertButton) {
            if (fromDistance.getSelectedIndex() == 0 || toDistance.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione las unidades a convertir", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (fromDistanceText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad a convertir", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                double amountToChange = Double.parseDouble(fromDistanceText.getText());
                double baseAmount;
                switch (fromDistance.getSelectedItem().toString()) {
                    case "Kilómetro":
                        baseAmount = amountToChange / kilometer;
                        break;
                    case "Metro":
                        baseAmount = amountToChange / meter;
                        break;
                    case "Pie":
                        baseAmount = amountToChange / foot;
                        break;
                    case "Centímetro":
                        baseAmount = amountToChange / centimeter;
                        break;
                    case "Yarda":
                        baseAmount = amountToChange / yard;
                        break;
                    case "Milla":
                        baseAmount = amountToChange / mile;
                        break;
                    default:
                        baseAmount = 0.0;
                }

                double newAmount;
                switch (toDistance.getSelectedItem().toString()) {
                    case "Kilómetro":
                        newAmount = baseAmount * kilometer;
                        break;
                    case "Metro":
                        newAmount = baseAmount * meter;
                        break;
                    case "Pie":
                        newAmount = baseAmount * foot;
                        break;
                    case "Centímetro":
                        newAmount = baseAmount * centimeter;
                        break;
                    case "Yarda":
                        newAmount = baseAmount * yard;
                        break;
                    case "Milla":
                        newAmount = baseAmount * mile;
                        break;
                    default:
                        newAmount = 0.0;
                }
                String finalAmount = String.format("%.10f", newAmount);
                toDistanceText.setText(finalAmount);
            }
        }
    }
}