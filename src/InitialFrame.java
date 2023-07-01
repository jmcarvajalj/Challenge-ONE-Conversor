import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialFrame extends JFrame implements ActionListener {
    JComboBox<String> conversorComboBox;
    public InitialFrame() {
        ImageIcon icon = new ImageIcon("src/assets/icon.png");
        this.setIconImage(icon.getImage());
        this.setSize(600, 300);
        this.setTitle("Challenge-ONE-Conversor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setResizable(false);//set to false to make frame not resizable
        this.setLocationRelativeTo(null);

        JLabel conversionOption = new JLabel();
        JLabel credits = new JLabel();
        conversionOption.setText("Challenge-ONE-Conversor");
        conversionOption.setForeground(new Color(0xFFFFFF));
        conversionOption.setVerticalAlignment(SwingConstants.CENTER);
        conversionOption.setHorizontalAlignment(SwingConstants.CENTER);
        conversionOption.setFont(new Font("Lato", Font.PLAIN, 20));
        conversionOption.setBounds(130, 30, 350, 30);
        this.add(conversionOption);
        credits.setText("Creado por José Miguel Carvajal Jiménez");
        credits.setForeground(new Color(0xFFFFFF));
        credits.setVerticalAlignment(SwingConstants.CENTER);
        credits.setHorizontalAlignment(SwingConstants.CENTER);
        credits.setBounds(170, 230, 250, 30);
        credits.setFont(new Font("Lato", Font.PLAIN, 11));
        this.add(credits);
        this.setLayout(null);
        String[] tipo = {
                "Seleccione el tipo de conversor que desea usar",
                "Conversor de Monedas",
                "Conversor de Temperatura",
                "Conversor de Distancia"};
        conversorComboBox = new JComboBox<>(tipo);
        conversorComboBox.addActionListener(this);
        conversorComboBox.setBounds(130, 130, 340, 30);
        conversorComboBox.setFont(new Font("Lato", Font.PLAIN, 15));
        this.add(conversorComboBox);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== conversorComboBox){
            if(conversorComboBox.getSelectedIndex()==1){
                new MonedaFrame();
                this.dispose();
            } else if (conversorComboBox.getSelectedIndex()==2) {
                new TemperaturaFrame();
                this.dispose();
            }
        }
    }
}
