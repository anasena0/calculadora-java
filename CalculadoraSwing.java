import javax.swing.*; 
import java.awt.*;


public class CalculadoraSwing extends JFrame {
    // campos de instância 
    private JTextField campo1, campo2, resultado;
    private JButton somar, subtrair, multiplicar, dividir;

     
    // Construtor: aqui criamos e organizamos a interface
    public CalculadoraSwing(){
        // Titulo Janela
        setTitle("Calculadora Swing");
    


        // Tamanho janela
        setSize(300,250);

        // Quando o usuario clicar no X, encerra
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Define layout: grade com 5 e 2 colunas, espaçamento
        setLayout(new GridLayout(5 ,2, 5, 5));

        // Cria os campos de texto
        campo1 = new JTextField();
        campo2 = new JTextField();
        resultado = new JTextField();
        resultado.setEditable(false); // resultado não deve editar

        // Cria os botões com o texto que aparece neles
        somar = new JButton("+");
        subtrair = new JButton("-");
        multiplicar = new JButton("*");
        dividir = new JButton("/");

        // adiciona os pares rótulo + campo ao layout
        add(new JLabel("Numero 1: "));
        add(campo1);
        add(new JLabel("Numero 2: "));
        add(campo2);
        add(new JLabel("Resultado: "));
        add(resultado);

        // Adiciona os botões ao layout
        add(somar);
        add(subtrair);
        add(multiplicar);
        add(dividir);

        // Liga ações dos botões
        somar.addActionListener(e -> calcular('+'));
        subtrair.addActionListener(e -> calcular('-'));
        multiplicar.addActionListener(e -> calcular('*'));
        dividir.addActionListener(e -> calcular('/'));


    }

    // Método que faz o calculo
    private void calcular(char operacao) {
        try {

            double n1 = Double.parseDouble(campo1.getText());
            double n2 = Double.parseDouble(campo2.getText());
            double res = 0;

            // Escolhe a operação
            switch (operacao){
                case '+': res = n1 + n2; break;
                case '-': res = n1 - n2; break;
                case '*': res = n1 * n2; break;
                case '/':

                    if (n2 == 0) {
                        JOptionPane.showMessageDialog(this, "Divisão por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    res = n1 / n2; 
                    break;
                }
            
                     resultado.setText(String.valueOf(res));

          } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite apenas numeros validos!", "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }

            // metodo main: ponto de entrada do programa
            public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                    } catch (Exception ignored) {}

                        // cria a janela
                        CalculadoraSwing calc = new CalculadoraSwing();
                        calc.setVisible(true);
                    });
                 }

            public JTextField getCampo1() {
                return campo1;
            }

            public void setCampo1(JTextField campo1) {
                this.campo1 = campo1;
            }

            public JTextField getCampo2() {
                return campo2;
            }

            public void setCampo2(JTextField campo2) {
                this.campo2 = campo2;
            }

            public JTextField getResultado() {
                return resultado;
            }

            public void setResultado(JTextField resultado) {
                this.resultado = resultado;
            }

            public JButton getSomar() {
                return somar;
            }

            public void setSomar(JButton somar) {
                this.somar = somar;
            }

            public JButton getSubtrair() {
                return subtrair;
            }

            public void setSubtrair(JButton subtrair) {
                this.subtrair = subtrair;
            }

            public JButton getMultiplicar() {
                return multiplicar;
            }

            public void setMultiplicar(JButton multiplicar) {
                this.multiplicar = multiplicar;
            }

            public JButton getDividir() {
                return dividir;
            }

            public void setDividir(JButton dividir) {
                this.dividir = dividir;
            }
                }

            
      
        
    
