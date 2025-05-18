import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


public class Tela extends JFrame{
    private JPanel painel;
    private JTextArea jtxTexto;
    private JScrollPane scroll;
    private JLabel jlFonte,  jlTamanho, jlCor;
    private JButton jbAlterar, jbLimpar, jbApagar;
    private JRadioButton jrbNegrito, jrbNormal, jrbItalico, jrbNegritoItalico;
    private JComboBox jcbFonte, jcbTamanho, jcbCor;
    private Font fonteOriginal;
    private Color corOriginal;


    public Tela() {
        painel = new JPanel();
        jtxTexto = new JTextArea();
        scroll = new JScrollPane();
        //Textos
        jlFonte = new JLabel("Fonte: ");
        jlTamanho = new JLabel("Tamanho: ");
        jlCor = new JLabel("Cor: ");
        //Botões
        jbAlterar = new JButton("Alterar Formatção");
        jbLimpar = new JButton("Limpar Formatação");
        jbApagar = new JButton("Apagar Texto");
        //Botões de Seleção
        jrbItalico = new JRadioButton("Itálico");
        jrbNegrito = new JRadioButton("Negrito");
        jrbNormal = new JRadioButton("Normal");
        jrbNegritoItalico = new JRadioButton("Negrito - Itálico");
        //Caixa de Seleção
        jcbFonte = new JComboBox<>(new String[]{"Times New Roman", "Calibri", "Arial", "Cambria",
                "Garamond", "Georgia", "Verdana", "Tahoma", "Helvetica", "Calibri Light"});
        jcbCor = new JComboBox<>(new String[]{"Preto", "Azul", "Vermelho", "Azul Claro",
                "Cinza", "Verde", "Branco", "Amarelo", "Magenta"});
        jcbTamanho = new JComboBox<>(new String []{"8", "10", "11", "12", "14", "16", "18", "20", "24", "28"});
    }

    public void configurarJanela(){
        setVisible(true);
        setTitle("Editor de Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocation(600,500);
        add(painel);
        configurarPainel();
    }
    public void configurarPainel(){
        //painel.setBackground(Color.cyan);
        painel.setLayout(null);
        jtxTexto.setBounds(10, 130, 565,420);
        painel.add(jtxTexto);
        jtxTexto.setLineWrap(true);
        jtxTexto.setWrapStyleWord(true);
        jtxTexto.setBorder(BorderFactory.createLineBorder(Color.black));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        painel.add(scroll);
        fonteOriginal = jtxTexto.getFont();
        corOriginal = jtxTexto.getForeground();

        //Botões
        jbAlterar.setBounds(250, 45, 150, 25);
        painel.add(jbAlterar);
        jbLimpar.setBounds(410, 45, 150, 25);
        painel.add(jbLimpar);
        jbApagar.setBounds(430, 85, 130, 25);
        painel.add(jbApagar);

        //Ação dos Botões
        jbLimpar.addActionListener(evento->{
            jtxTexto.setFont(fonteOriginal);
            jtxTexto.setForeground(corOriginal);
        });
        jbAlterar.addActionListener(evento -> {
            String fonte = (String) jcbFonte.getSelectedItem();
            int tamanho = Integer.parseInt((String) jcbTamanho.getSelectedItem());
            Color cor = getCor((String) jcbCor.getSelectedItem());

            int estilo = Font.PLAIN;
            if (jrbNegrito.isSelected())
                estilo = Font.BOLD;
            else if (jrbItalico.isSelected()) {
                estilo = Font.ITALIC;
            } else if (jrbNegritoItalico.isSelected()) {
                estilo = Font.BOLD | Font.ITALIC;
            }

            Font novaFonte = new Font(fonte, estilo, tamanho);
            jtxTexto.setFont(novaFonte);
            jtxTexto.setForeground(cor);
        });
        jbApagar.addActionListener(evento -> {
            jtxTexto.setText("");
        });

        //Botões de Seleção
        jrbNegrito.setBounds(10, 85, 80, 20);
        painel.add(jrbNegrito);
        jrbItalico.setBounds(95, 85, 80, 20);
        painel.add(jrbItalico);
        jrbNormal.setBounds(190, 85, 80, 20);
        painel.add(jrbNormal);
        jrbNegritoItalico.setBounds(285, 85, 130, 20);
        painel.add(jrbNegritoItalico);

        //Textos
        jlFonte.setBounds(10, 10, 50, 30);
        painel.add(jlFonte);
        jlTamanho.setBounds(270, 10, 60, 30);
        painel.add(jlTamanho);
        jlCor.setBounds(10, 45, 50, 30);
        painel.add(jlCor);

        //Caixa de Seleção
        jcbFonte.setBounds(65, 10, 150, 25);
        painel.add(jcbFonte);
        jcbTamanho.setBounds(340, 10, 150, 25);
        painel.add(jcbTamanho);
        jcbCor.setBounds(65, 45, 150, 25);
        painel.add(jcbCor);

        }

    //Metodo
    private Color getCor(String cor){
        return switch (cor){
            case "Preto" -> Color.black;
            case "Azul" -> Color.blue;
            case "Vermelho" -> Color.red;
            case "Azul Claro" -> Color.cyan;
            case "Cinza" -> Color.gray;
            case "Verde" -> Color.green;
            case "Branco" -> Color.white;
            case "Amarelo" -> Color.yellow;
            case "Magenta" -> Color.magenta;
            default -> Color.black;
        };
    }
}
