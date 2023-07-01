import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperaturasFrame extends JFrame implements ActionListener {
    JComboBox<String> fromCountry, toCountry;
    JButton convertButton, resetButton, backButton;
    TextField fromText;
    TextField toText;
    double libraEsterlina = 1;
    double dolar = 1.27;
    double pesoColombiano = 5296.07;
    double euro = 1.16;
    double yenJapones = 182.47;
    double wonSurCoreano = 1672.56;

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

        fromCountry = new JComboBox<>(new String[] {
                "Selecciona moneda",
                "Peso Colombiano",
                "Dolar",
                "Euro",
                "Libra Esterlina",
                "Yen Japonés",
                "Won Sur-Coreano"
        });
        fromCountry.setBounds(100, 80, 160, 25);
        fromCountry.setFont(new Font("Lato", Font.PLAIN, 15));
        this.add(fromCountry);

        fromText = new TextField();
        fromText.setBounds(300, 80, 200, 25);
        fromText.setFont(new Font("Lato",Font.PLAIN, 15));
        fromText.setForeground(Color.BLACK);
        this.add(fromText);

        JLabel toCurrency = new JLabel("A: ");
        toCurrency.setBounds(70, 120, 30, 25);
        toCurrency.setFont(new Font("Lato", Font.PLAIN, 15));
        toCurrency.setForeground(Color.white);
        this.add(toCurrency);

        toCountry = new JComboBox<>(new String[] {
                "Selecciona moneda",
                "Peso Colombiano",
                "Dolar",
                "Euro",
                "Libra Esterlina",
                "Yen Japonés",
                "Won Sur-Coreano"
        });
        toCountry.setBounds(100, 120, 160, 25);
        toCountry.setFont(new Font("Lato", Font.PLAIN, 15));
        this.add(toCountry);

        toText = new TextField("");
        toText.setBounds(300, 120, 200, 25);
        toText.setFont(new Font("Lato",Font.PLAIN, 15));
        toText.setForeground(Color.BLACK);
        toText.setEditable(false);
        this.add(toText);

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
        fromCountry.setSelectedIndex(0);
        toCountry.setSelectedIndex(0);
        fromText.setText("");
        toText.setText("");
    }

    private void backButtonActionPerformed() {
        new InitialFrame();
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convertButton) {
            if (fromCountry.getSelectedIndex() == 0 || toCountry.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Seleccione las monedas a convertir", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (fromText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad a convertir", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                double amountToChange = Double.parseDouble(fromText.getText());
                double amountInPounds;
                switch (fromCountry.getSelectedItem().toString()) {
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
                switch (toCountry.getSelectedItem().toString()) {
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
                toText.setText(amount);
            }
        }
    }
}