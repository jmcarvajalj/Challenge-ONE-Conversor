import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TemperaturasFrame extends JFrame implements ActionListener {
    JComboBox<String> fromTemperature, toTemperature;
    JButton convertButton, resetButton, backButton;
    TextField fromTemperatureText;
    TextField toTemperatureText;

    public TemperaturasFrame()
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
        conversionOption.setText("Conversor de Temperaturas");
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

        fromTemperature = new JComboBox<>(new String[] {
                "Selecciona escala",
                "Celsius",
                "Kelvin",
                "Fahrenheit"
        });
        fromTemperature.setBounds(100, 80, 160, 25);
        fromTemperature.setFont(new Font("Lato", Font.PLAIN, 15));
        this.add(fromTemperature);

        fromTemperatureText = new TextField();
        fromTemperatureText.setBounds(300, 80, 200, 25);
        fromTemperatureText.setFont(new Font("Lato",Font.PLAIN, 15));
        fromTemperatureText.setForeground(Color.BLACK);
        this.add(fromTemperatureText);

        JLabel toCurrency = new JLabel("A: ");
        toCurrency.setBounds(78, 120, 30, 25);
        toCurrency.setFont(new Font("Lato", Font.PLAIN, 15));
        toCurrency.setForeground(Color.white);
        this.add(toCurrency);

        this.toTemperature = new JComboBox<>(new String[] {
                "Selecciona escala",
                "Celsius",
                "Kelvin",
                "Fahrenheit"
        });
        this.toTemperature.setBounds(100, 120, 160, 25);
        this.toTemperature.setFont(new Font("Lato", Font.PLAIN, 15));
        this.add(this.toTemperature);

        toTemperatureText = new TextField("");
        toTemperatureText.setBounds(300, 120, 200, 25);
        toTemperatureText.setFont(new Font("Lato",Font.PLAIN, 15));
        toTemperatureText.setForeground(Color.BLACK);
        toTemperatureText.setEditable(false);
        this.add(toTemperatureText);

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
        fromTemperature.setSelectedIndex(0);
        toTemperature.setSelectedIndex(0);
        fromTemperatureText.setText("");
        toTemperatureText.setText("");
    }

    private void backButtonActionPerformed() {
        new InitialFrame();
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convertButton) {
            if (fromTemperature.getSelectedIndex() == 0 || toTemperature.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione las monedas a convertir", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (fromTemperatureText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad a convertir", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                double amountToChange = Double.parseDouble(fromTemperatureText.getText());
                double resultAmount = 0;

                if (Objects.equals(fromTemperature.getSelectedItem().toString(), "Fahrenheit")
                    && Objects.equals(toTemperature.getSelectedItem().toString(), "Celsius")){
                    resultAmount = (amountToChange - 32) * ((double) 5 /9);
                } else if (Objects.equals(fromTemperature.getSelectedItem().toString(), "Fahrenheit")
                        && Objects.equals(toTemperature.getSelectedItem().toString(), "Kelvin")) {
                    resultAmount = (amountToChange - 32) * ((double) 5 /9) + 273.15;
                } else if (Objects.equals(fromTemperature.getSelectedItem().toString(), "Celsius")
                        && Objects.equals(toTemperature.getSelectedItem().toString(), "Kelvin")) {
                    resultAmount = amountToChange + 273.15;
                } else if (Objects.equals(fromTemperature.getSelectedItem().toString(), "Celsius")
                        && Objects.equals(toTemperature.getSelectedItem().toString(), "Fahrenheit")) {
                    resultAmount = (amountToChange * 9/5) + 32;
                } else if (Objects.equals(fromTemperature.getSelectedItem().toString(), "Kelvin")
                        && Objects.equals(toTemperature.getSelectedItem().toString(), "Celsius")) {
                    resultAmount = amountToChange - 273.15;
                } else if (Objects.equals(fromTemperature.getSelectedItem().toString(), "Kelvin")
                        && Objects.equals(toTemperature.getSelectedItem().toString(), "Fahrenheit")) {
                    resultAmount = (amountToChange - 273.15) * 9/5 + 32;
                } else if (Objects.equals(fromTemperature.getSelectedItem().toString(), toTemperature.getSelectedItem().toString())){
                    resultAmount = amountToChange;
                }

                String finalAmount = String.format("%.5f", resultAmount);
                toTemperatureText.setText(finalAmount);
            }
        }
    }
}