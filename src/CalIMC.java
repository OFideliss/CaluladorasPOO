import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalIMC extends JPanel {
    private JLabel pesoLabel;
    private JLabel alturaLabel;
    private JTextField pesoTextField;
    private JTextField alturaTextField;
    private JButton botao;
    private JLabel resultadoLabel;

    public CalIMC() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.setBackground(Color.decode("#a7e5eb"));


        pesoLabel = new JLabel("Peso (kg):");
        alturaLabel = new JLabel("Altura (m):");

        pesoTextField = new JTextField(10);
        alturaTextField = new JTextField(10);
        
        pesoTextField.setBackground(Color.decode("#cee8eb"));
        alturaTextField.setBackground(Color.decode("#cee8eb"));

        inputPanel.add(pesoLabel);
        inputPanel.add(pesoTextField);
        inputPanel.add(alturaLabel);
        inputPanel.add(alturaTextField);

        botao = new JButton("Calcular IMC");
        botao.setBackground(Color.decode("#127382"));// Define a cor do botao para azul
        botao.setForeground(Color.WHITE);               // Define a cor do texto do botão para branco
        this.setBackground(Color.decode("#cee8eb"));
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        resultadoLabel = new JLabel("");

        add(inputPanel, BorderLayout.NORTH);
        add(botao, BorderLayout.CENTER);
        add(resultadoLabel, BorderLayout.SOUTH);
    }

    public void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoTextField.getText());
            double altura = Double.parseDouble(alturaTextField.getText());
            double imc = peso / (altura * altura);

            resultadoLabel.setText("Seu IMC é: " + String.format("%.2f", imc));
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Inserir números.");
        }
    }
}
