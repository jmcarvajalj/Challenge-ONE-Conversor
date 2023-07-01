import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MonedaFrame extends JFrame implements ActionListener {
    JComboBox<String> fromCountry, toCountry;
    JButton convertButton, resetButton, backButton;
    JLabel fromUnit, toUnit;
    TextField fromText;
    TextField toText;
    String[] currencyUnits={
            "units",
            "Peso Colombiano",
            "Dolar",
            "Euro",
            "Libra Esterlina",
            "Yen Japonés",
            "Won Sur-Coreano"
    };

    double pesoColombiano = 1;
    double dolar = 0.00024;
    double euro = 0.00022;
    double libraEsterlina = 0.00019;
    double yenJapones = 0.035;
    double wonSurCoreano = 0.32;
    public MonedaFrame()
    {
        ImageIcon icon = new ImageIcon("src/assets/icon.png");
        this.setIconImage(icon.getImage());
        this.setSize(600, 300);
        this.setTitle("Challenge-ONE-Conversor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setResizable(false);//set to false to make frame not resizable
        this.setLocationRelativeTo(null);

        JLabel conversionOption = new JLabel();
        conversionOption.setText("Conversor de Monedas");
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

//        //TODO: remove at the end IMPORTANT
//        Border border = BorderFactory.createLineBorder(Color.green,1);
//        ITEM.setBorder(border);

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
        fromCountry.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                fromCountryItemStateChanged(evt);
            }
        });
        add(fromCountry);

        fromText = new TextField();
        fromText.setBounds(300, 80, 200, 25);
        fromText.setFont(new Font("Lato",Font.PLAIN, 15));
        fromText.setForeground(Color.BLACK);
        add(fromText);

        JLabel toCurrency = new JLabel("A: ");
        toCurrency.setBounds(70, 120, 30, 25);
        toCurrency.setFont(new Font("Lato", Font.PLAIN, 15));
        toCurrency.setForeground(Color.white);
        add(toCurrency);

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
        toCountry.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                toCountryItemStateChanged(evt);
            }
        });
        add(toCountry);

        toText = new TextField("");
        toText.setBounds(300, 120, 200, 25);
        toText.setFont(new Font("Lato",Font.PLAIN, 15));
        toText.setForeground(Color.BLACK);
        toText.setEditable(false);
        add(toText);

        convertButton = new JButton("Convertir");
        convertButton.setBounds(100, 170, 96, 25);
        convertButton.setFont(new Font("Lato",Font.PLAIN, 15));
        convertButton.addActionListener(this);
        add(convertButton);

        resetButton = new JButton("Reiniciar");
        resetButton.setBounds(260, 170, 90, 25);
        resetButton.setFont(new Font("Lato",Font.PLAIN, 15));
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        add(resetButton);

        backButton = new JButton("Volver");
        backButton.setBounds(420, 170, 80, 25);
        backButton.setFont(new Font("Lato",Font.PLAIN, 15));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton);

        this.setLayout(null);
        this.setVisible(true);
    }

    private void resetButtonActionPerformed(ActionEvent evt) {
        this.fromCountry.setSelectedIndex(0);
        this.toCountry.setSelectedIndex(0);
        this.fromText.setText(null);
        this.toText.setText(null);
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        new InitialFrame();
        this.dispose();
    }

    private void fromCountryItemStateChanged(ItemEvent evt) {
        int position = this.fromCountry.getSelectedIndex();
        this.fromUnit.setText(currencyUnits[position]);
    }

    private void toCountryItemStateChanged(ItemEvent evt) {
        int position = this.toCountry.getSelectedIndex();
        this.toUnit.setText(currencyUnits[position]);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.convertButton) {
            if (this.fromCountry.getSelectedIndex() == 0 || this.toCountry.getSelectedIndex() == 0 || this.fromText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Getting Error", JOptionPane.ERROR_MESSAGE);
            } else {
                double amountToChange = Double.parseDouble(this.fromText.getText());
                double amountInPounds = 0.0;
                switch (this.fromCountry.getSelectedItem().toString()) {
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

                double newAmount = 0.0;
                switch (this.toCountry.getSelectedItem().toString()) {
                    case "Peso Colombiano":
                        newAmount = amountInPounds * pesoColombiano;
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
                        newAmount = amountInPounds = 0.0;
                }
                String amount = String.format("%.10f", newAmount);
                this.toText.setText(amount);
            }
        }
    }
}

//TODO CHECK FOR ERRORS AND REMOVE THE THIS AS NEEDED AND FIX FORMATTING AND CONVERSION VALUES
// (MIGHT NEED TO REWRITE THE FUNCTIONS AND/OR CREATE NEW ONES)