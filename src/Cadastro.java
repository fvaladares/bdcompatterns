import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class Cadastro {
    private JFrame jfTela;
    private JLabel jlNome, jlTipoLogradouro, jlLogradouro, jlNumero, jlTelR, jlTelCom, jlTelCel, jlCPF, jlRG;
    private JTextField jtfNome, jtfLogradouro, jtfNumero, jtfTelR, jtfTelCom, jtfTelCel, jtfCPF, jtfRG;
    private JButton jbNovo, jbAlterar, jbExcluir, jbEsquerda, jbDireita, jbSalvar, jbCancelar;
    private final String[] ruas = {"Rua", "Avenida", "Estradas"};

    private JComboBox jcbTipoLogradouro;

    public Cadastro() {
        jfTela = new JFrame("Cadastro");
        jfTela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfTela.setSize(640,480);
        jfTela.setLayout(null);

        jlNome = new JLabel("Nome ");
        jlTipoLogradouro = new JLabel("Tipo logradouro ");
        jlLogradouro = new JLabel("Logradouro ");
        jlNumero = new JLabel("Número");
        jlTelR = new JLabel("Telefone Residêncial");
        jlTelCom = new JLabel("Telefone Comercial ");
        jlTelCel = new JLabel("Telefone Celular");
        jlCPF = new JLabel("CPF");
        jlRG = new JLabel("RG");

        jbNovo = new JButton("Novo");
        jbAlterar = new JButton("Alterar");
        jbExcluir = new JButton("Excluir");
        jbEsquerda = new JButton("<<");
        jbDireita = new JButton(">>");
        jbSalvar = new JButton("Salvar");
        jbCancelar = new JButton("Cancelar");



        jtfNome = new JTextField();
        jtfLogradouro = new JTextField();
        jtfNumero = new JTextField();

        jcbTipoLogradouro = new JComboBox(ruas);
        jtfRG = new JTextField();

        try {
            jtfTelR = new JFormattedTextField(new MaskFormatter("(##)####-####"));
            jtfTelCom = new JFormattedTextField(new MaskFormatter("(##)####-####"));
            jtfTelCel = new JFormattedTextField(new MaskFormatter("(##)# ####-####"));
            jtfCPF = new JFormattedTextField(new MaskFormatter("###.###.###.-##"));
//            jtfNumero = new JFormattedTextField(new MaskFormatter("########"));
//            jtfRG = new JFormattedTextField(new MaskFormatter("(##)####-####"));
        } catch (ParseException e){
            e.printStackTrace();
        }


        jlNome.setBounds(16, 16, 120, 30);
        jfTela.add(jlNome);

        jtfNome.setBounds(130, 16, 300, 30);
        jfTela.add(jtfNome);

        jlTipoLogradouro.setBounds(16, 62, 120, 30);
        jfTela.add(jlTipoLogradouro);

        jcbTipoLogradouro.setBounds(130, 62, 300, 30);
        jfTela.add(jcbTipoLogradouro);

        jlLogradouro.setBounds(16, 108, 120, 30);
        jfTela.add(jlLogradouro);

        jtfLogradouro.setBounds(130, 108, 300, 30);
        jfTela.add(jtfLogradouro);

        jlNumero.setBounds(16, 154, 120, 30);
        jfTela.add(jlNumero);

        jtfNumero.setBounds(130, 154, 300, 30);
        jfTela.add(jtfNumero);

        jlTelCel.setBounds(16, 200, 120, 30);
        jfTela.add(jlTelCel);

        jtfTelCel.setBounds(130, 200, 300, 30);
        jfTela.add(jtfTelCel);

        jbNovo.setBounds(16, 246, 100, 30);
        jfTela.add(jbNovo);

        jbAlterar.setBounds(116, 246, 100, 30);
        jfTela.add(jbAlterar);

        jbExcluir.setBounds(216, 246, 100, 30);
        jfTela.add(jbExcluir);

        jbSalvar.setBounds(316, 246, 100, 30);
        jfTela.add(jbSalvar);


        jbEsquerda.setBounds(16, 292, 100, 30);
        jfTela.add(jbEsquerda);

        jbCancelar.setBounds(116, 292, 200, 30);
        jfTela.add(jbCancelar);

        jbDireita.setBounds(316, 292, 100, 30);
        jfTela.add(jbDireita);










        jfTela.add(jtfNome);

        jfTela.setVisible(true);
    }
}
