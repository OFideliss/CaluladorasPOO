import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraCustoViagem extends JPanel {
    private JTextField caixa1;          // Campo de texto para o valor do combustível
    private JTextField caixa2;          // Campo de texto para o consumo do veículo
    private JTextField caixa3;          // Campo de texto para a distância do trajeto
    private JPanel resultadoPanel;      // Painel para exibir os resultados

    public CalculadoraCustoViagem() {
        super(new GridLayout(2, 1));      // Configura o layout do painel principal

        JPanel labelsPanel = new JPanel(new BorderLayout());       // Subpainel para rótulos
        JLabel texto1 = new JLabel("Valor do Combustível:");  // Rótulo para o valor do combustível
        JLabel texto2 = new JLabel("Consumo do Veículo:");    // Rótulo para o consumo do veículo
        JLabel Texto3 = new JLabel("Distância do Trajeto:");  // Rótulo para o distância do trajeto
        labelsPanel.add(texto1, BorderLayout.NORTH);               // Adiciona o rótulo do valor do combustível ao painel de rótulos
        labelsPanel.add(texto2, BorderLayout.CENTER);              // Adiciona o rótulo do consumo do veículo ao painel de rótulos
        labelsPanel.add(Texto3, BorderLayout.SOUTH);               // Adiciona o rótulo do distância do trajeto ao painel de rótulos
        labelsPanel.setBackground(Color.decode("#a7e5eb"));
        texto1.setBackground(Color.decode("#a7e5eb"));
        texto2.setBackground(Color.decode("#a7e5eb"));
        Texto3.setBackground(Color.decode("#a7e5eb"));

        JPanel fieldsPanel = new JPanel(new BorderLayout());  // Subpainel para caixas de texto
        caixa1 = new JTextField(25);                  // Caixa de texto para o valor do combustível
        caixa2 = new JTextField(25);                  // Caixa de texto para o consumo do veículo
        caixa3 = new JTextField(25);                  // Caixa de texto para a distância do trajeto
        fieldsPanel.add(caixa1, BorderLayout.NORTH);          // Adiciona a caixa de texto do valor do combustível ao painel de campos
        fieldsPanel.add(caixa2, BorderLayout.CENTER);         // Adiciona a caixa de texto do consumo do veículo ao painel de campos
        fieldsPanel.add(caixa3, BorderLayout.SOUTH);          // Adiciona a caixa de texto distância do trajeto ao painel de campos
        fieldsPanel.setBackground(Color.decode("#a7e5eb"));
        caixa1.setBackground(Color.decode("#cee8eb"));
        caixa2.setBackground(Color.decode("#cee8eb"));
        caixa3.setBackground(Color.decode("#cee8eb"));

        JPanel inputPanel = new JPanel(new BorderLayout()); // Cria um painel para organizar os campos de entrada (Valor do Combustível, Consumo do Veículo, Distância do Trajeto)
        inputPanel.add(labelsPanel, BorderLayout.WEST);     // Adiciona o painel de rótulos à esquerda do painel de entrada
        inputPanel.add(fieldsPanel, BorderLayout.CENTER);   // Adiciona o painel de campos no centro do painel de entrada
        this.add(inputPanel, BorderLayout.CENTER);          // Adicionar o painel de entrada ao centro do CalculadoraCustoViagem

        // Botão para calcular
        JButton botao1 = new JButton("Enviar");     // Cria um botão com o rótulo "Enviar"
        this.add(botao1, BorderLayout.CENTER);           // Adiciona o botão na parte inferior do painel principal
        botao1.setBackground(Color.decode("#127382"));// Define a cor do botao para azul
        botao1.setForeground(Color.WHITE);               // Define a cor do texto do botão para branco
        this.setBackground(Color.decode("#cee8eb"));

        // Painel para exibir os resultados
        resultadoPanel = new JPanel(new BorderLayout()); // Cria um painel para resultados com layout BorderLayout
        this.add(resultadoPanel);
        resultadoPanel.setBackground(Color.decode("#cee8eb"));

        // Ação do botão
        botao1.addActionListener(new ActionListener() {  // Adiciona um ouvinte de ação ao botão
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultado(); // Chama o método para calcular os resultados quando o botão é pressionado
            }
        });
    }

    private void calcularResultado() {
        try {
            int distancia = Integer.parseInt(caixa3.getText());              // Obtém a distância do trajeto
            double consumoVeiculo = Double.parseDouble(caixa2.getText());    // Obtém o consumo do veiculo
            double valorCombustivelRS = Double.parseDouble(caixa1.getText());// Obtém o valor do combustível
            double consumoCombustivel = distancia / consumoVeiculo;          // Calcula o consumo de combustível da viagemS
            double custoViagem = consumoCombustivel * valorCombustivelRS;    // Calcula o custo da viagem

            JLabel resultadoLabel1 = new JLabel("O combustível gasto é de " + consumoCombustivel + " Litros");
            JLabel resultadoLabel2 = new JLabel("O custo total da viagem é de R$ " + custoViagem);

            resultadoPanel.removeAll();                               // Remove todos os componentes anteriores do painel de resultados
            resultadoPanel.add(resultadoLabel1, BorderLayout.CENTER); // Adiciona o primeiro rótulo no topo
            resultadoPanel.add(resultadoLabel2, BorderLayout.SOUTH);  // Adiciona o segundo rótulo na parte inferior

            // Atualizar a interface gráfica
            resultadoPanel.revalidate(); // Revalida o layout do painel de resultados
            resultadoPanel.repaint();    // Repinta o painel de resultados
            this.add(resultadoPanel, BorderLayout.SOUTH); // Adiciona o painel de resultados na parte inferior do painel principal
        } catch (NumberFormatException ex) {
            System.out.println("Erro de entrada inválida. Certifique-se de que todos os campos sejam preenchidos corretamente.");
        }
    }
}
