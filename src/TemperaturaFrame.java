import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperaturaFrame extends JFrame implements ActionListener
{
    //initialises the frame and opens it
    public TemperaturaFrame()
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
        JLabel credits = new JLabel();
        conversionOption.setText("Conversion de Temperatura");
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
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        //code for the new frame
    }
}