import javax.swing.JTabbedPane;

public class Jtabbedpane extends JTabbedPane {
    public Jtabbedpane() {
        super();
        this.add("Custo Viagem", new CalculadoraCustoViagem());
        this.add("IMC", new CalIMC()); 
        this.add("Regra de três", new CalcRegra3());
    }
}
