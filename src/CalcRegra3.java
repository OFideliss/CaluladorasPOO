import java.awt.*;
import javax.swing.*;

public class CalcRegra3 extends JPanel {

    public CalcRegra3() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // Define o painel principal como BoxLayout orientado no eixo X

        // ==================================Primeiro Painel===========================
        JPanel painel1 = new JPanel();// Cria um painel de nome painel1
        painel1.setBackground(Color.decode("#03dbfc")); // Muda a cor do fundo do painel1

        JTextField campoTextoA = new JTextField("", 25); // Cria um campo (caixa de texto) para inserir o primeiro valor
        campoTextoA.setHorizontalAlignment(SwingConstants.CENTER); //centraliza horizontalmente o valor digitado no campo
        campoTextoA.setBackground(Color.decode("#127382"));// Muda a cor de fundo da caixa de texto
        painel1.add(campoTextoA); // adiciona a caixa de texto ao painel1

        JLabel texto1 = new JLabel("Está para"); // cria um texto para ficar entre os campos
        painel1.add(texto1); // adiciona ao painel1

        JTextField campoTextoB = new JTextField("", 25); // Cria um campo (caixa de texto) para inserir o segundo valor
        campoTextoB.setHorizontalAlignment(SwingConstants.CENTER);  //centraliza horizontalmente o valor digitado no campo
        campoTextoB.setBackground(Color.decode("#127382"));// Muda a cor de fundo da caixa de texto
        painel1.add(campoTextoB);// adiciona a caixa de texto ao painel1

        // Adicione um espaço vertical entre os painéis
        add(Box.createVerticalStrut(1));

        // ==================================Segundo Painel===========================

        JPanel painel2 = new JPanel();// Cria um painel de nome painel2
        painel2.setBackground(Color.decode("#03dbfc")); // Muda a cor do fundo do painel2
        JLabel texto2 = new JLabel("Assim Como"); // cria um texto para ficar entre os paineis
        painel2.add(texto2);// adiciona o texto ao painel2

        // Adicione outro espaço vertical entre os painéis
        add(Box.createVerticalStrut(10));

        // ==================================Terceiro Painel===========================

        JPanel painel3 = new JPanel();// Cria um painel de nome painel3
        painel3.setBackground(Color.decode("#03dbfc")); // Muda a cor do fundo do painel3

        JTextField campoTextoC = new JTextField("", 25);// Cria um campo (caixa de texto) para inserir o terceiro valor
        campoTextoC.setHorizontalAlignment(SwingConstants.CENTER);  //centraliza horizontalmente o valor digitado no campo
        campoTextoC.setBackground(Color.decode("#127382")); // Muda a cor de fundo da caixa de texto
        painel3.add(campoTextoC); // adiciona o texto ao painel3

        JLabel texto3 = new JLabel("Está para"); // cria um texto para ficar entre o ultimo valor e o resultado
        painel3.add(texto3); // adiciona o texto ao painel3

        JTextField resultado = new JTextField("Resultado");// Cria um campo (caixa de texto) para inserir o mostrar o
                                                           // resultado do operacao
        resultado.setBackground(Color.decode("#a7e5eb")); // Muda a cor de fundo da caixa de texto
        resultado.setEditable(false); // Não permite inserir ou alterar valor da caixa de texto criada
        resultado
                .setPreferredSize(new Dimension(painel3.getPreferredSize().width, resultado.getPreferredSize().height));
        resultado.setHorizontalAlignment(SwingConstants.CENTER);  //centraliza horizontalmente o valor digitado no campo
        painel3.add(resultado); // adiciona o resultado ao painel3

        JButton calcular = new JButton("Calcular"); // cria um botão para calcular
        calcular.setBackground(Color.decode("#127382"));// Define a cor do botao para azul
        calcular.setForeground(Color.WHITE);               // Define a cor do texto do botão para branco
        painel3.add(calcular); // adiciona o botão ap painel3

        calcular.addActionListener(e -> { // cria a acao do botão calcular
            double valorA = Double.parseDouble(campoTextoA.getText()); // criar variavel para armazenar o valorA digitado
            double valorB = Double.parseDouble(campoTextoB.getText()); // criar variavel para armazenar o valorB digitado
            double valorC = Double.parseDouble(campoTextoC.getText()); // criar variavel para armazenar o valorC digitado
            double solucao = (valorC * valorB) / valorA; // calcula do resultado
            resultado.setText(Double.toString(solucao));// Converrte o resultado numa String e a coloca no campo resultado
        });
        // Adicionando os três painéis ao CalcRegra3
        add(painel1);
        add(painel2);
        add(painel3);
    }
}
