import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DistanciasFrame extends JFrame implements ActionListener {
    JComboBox<String> fromCurrency, toCurrency;
    JButton convertButton, resetButton, backButton;
    TextField fromCurrencyText;
    TextField toCurrencyText;
    double libraEsterlina = 1;
    double dolar = 1.27;
    double pesoColombiano = 5296.07;
    double euro = 1.16;
    double yenJapones = 182.47;
    double wonSurCoreano = 1672.56;

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

        this.fromCurrency = new JComboBox<>(new String[] {
                "Selecciona moneda",
                "Peso Colombiano",
                "Dolar",
                "Euro",
                "Libra Esterlina",
                "Yen Japonés",
                "Won Sur-Coreano"
        });
        this.fromCurrency.setBounds(100, 80, 160, 25);
        this.fromCurrency.setFont(new Font("Lato", Font.PLAIN, 15));
        this.add(this.fromCurrency);

        fromCurrencyText = new TextField();
        fromCurrencyText.setBounds(300, 80, 200, 25);
        fromCurrencyText.setFont(new Font("Lato",Font.PLAIN, 15));
        fromCurrencyText.setForeground(Color.BLACK);
        this.add(fromCurrencyText);

        JLabel toCurrency = new JLabel("A: ");
        toCurrency.setBounds(78, 120, 30, 25);
        toCurrency.setFont(new Font("Lato", Font.PLAIN, 15));
        toCurrency.setForeground(Color.white);
        this.add(toCurrency);

        this.toCurrency = new JComboBox<>(new String[] {
                "Selecciona moneda",
                "Peso Colombiano",
                "Dolar",
                "Euro",
                "Libra Esterlina",
                "Yen Japonés",
                "Won Sur-Coreano"
        });
        this.toCurrency.setBounds(100, 120, 160, 25);
        this.toCurrency.setFont(new Font("Lato", Font.PLAIN, 15));
        this.add(this.toCurrency);

        toCurrencyText = new TextField("");
        toCurrencyText.setBounds(300, 120, 200, 25);
        toCurrencyText.setFont(new Font("Lato",Font.PLAIN, 15));
        toCurrencyText.setForeground(Color.BLACK);
        toCurrencyText.setEditable(false);
        this.add(toCurrencyText);

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
        fromCurrency.setSelectedIndex(0);
        toCurrency.setSelectedIndex(0);
        fromCurrencyText.setText("");
        toCurrencyText.setText("");
    }

    private void backButtonActionPerformed() {
        new InitialFrame();
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convertButton) {
            if (fromCurrency.getSelectedIndex() == 0 || toCurrency.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione las monedas a convertir", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (fromCurrencyText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad a convertir", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                double amountToChange = Double.parseDouble(fromCurrencyText.getText());
                double amountInPounds;
                switch (fromCurrency.getSelectedItem().toString()) {
                    case "Peso Colombiano":
                        amountInPounds = amountToChange / pesoColombiano;
                        break;
                    case "Dolar":
                        amountInPounds = amountToChange / dolar;
                        break;
                    case "Euro":
                        amountInPounds = amountToChange / euro;
                        break;
                    case "Libra Esterlina":
                        amountInPounds = amountToChange / libraEsterlina;
                        break;
                    case "Yen Japonés":
                        amountInPounds = amountToChange / yenJapones;
                        break;
                    case "Won Sur-Coreano":
                        amountInPounds = amountToChange / wonSurCoreano;
                        break;
                    default:
                        amountInPounds = 0.0;
                }

                double newAmount;
                switch (toCurrency.getSelectedItem().toString()) {
                    case "Peso Colombiano":
                        newAmount = amountInPounds * pesoColombiano;
                        break;
                    case "Dolar":
                        newAmount = amountInPounds * dolar;
                        break;
                    case "Euro":
                        newAmount = amountInPounds * euro;
                        break;
                    case "Libra Esterlina":
                        newAmount = amountInPounds * libraEsterlina;
                        break;
                    case "Yen Japonés":
                        newAmount = amountInPounds * yenJapones;
                        break;
                    case "Won Sur-Coreano":
                        newAmount = amountInPounds * wonSurCoreano;
                        break;
                    default:
                        newAmount = 0.0;
                }
                String amount = String.format("%.5f", newAmount);
                toCurrencyText.setText(amount);
            }
        }
    }
}