import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CadastroAluno {

    public Crud controle;
    private final DefaultTableModel modelo;

    public CadastroAluno() {
        // configuração da tabela
        modelo = new DefaultTableModel();
        this.initComponents();
    }

    /**
     *
     */
    private void initComponents() {

        // Criação dos widgets
        JLabel codJLabel;
        JTextField codJTextField;
        JLabel nameJlJLabel;
        JTextField nameJtJTextField;
        JLabel ageJlJLabel;
        JTextField ageJTextField;
        JLabel raJLabel;
        JTextField raJTextField;
        JPanel buttonsJPanel;
        JButton[] jButtons;
        final String[] buttonNames;
        buttonNames = new String[]{"Inserir", "Atualizar", "Excluir"};
        JPanel infoJPanel; // organizar os widgets
        JFrame telaJFrame; // Tela da aplicação

        JTable tabela; // Exibir os dados do DB

        // utilizado para alteração da fonte da aplicação.
        Font f = new Font("serif", Font.PLAIN, 20);
        // Layout utilizado para organização dos widgets
        SpringLayout layout = new SpringLayout();

        // Instanciando o JFRAME
        telaJFrame = new JFrame("Cadastro de alunos");
        telaJFrame.setSize(400, 600);


        telaJFrame.setLayout(null);
        telaJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // Instanciando demais componentes
        infoJPanel = new JPanel();
        buttonsJPanel = new JPanel();
        jButtons = new JButton[buttonNames.length];


        codJLabel = new JLabel("Código");
        codJLabel.setFont(f); // definição do tamanho da fonte
        codJTextField = new JTextField();
        codJTextField.setFont(f);
        nameJlJLabel = new JLabel("Nome");
        nameJlJLabel.setFont(f);
        nameJtJTextField = new JTextField();
        nameJtJTextField.setFont(f);
        ageJlJLabel = new JLabel("Idade");
        ageJlJLabel.setFont(f);
        ageJTextField = new JTextField();
        ageJTextField.setFont(f);
        raJLabel = new JLabel("RA");
        raJLabel.setFont(f);
        raJTextField = new JTextField();
        raJTextField.setFont(f);


        infoJPanel.setBounds(16, 16, (telaJFrame.getWidth() - 32), (telaJFrame.getHeight() / 3));
        infoJPanel.setLayout(layout); // Configurando o layout do painel
//        infoJPanel.setSize((telaJFrame.getWidth()-32),(telaJFrame.getHeight()-200));

        // Associando os widgets à ao painel (JPanel)
        infoJPanel.add(codJLabel);
        infoJPanel.add(codJTextField);
        infoJPanel.add(nameJlJLabel);
        infoJPanel.add(nameJtJTextField);
        infoJPanel.add(ageJlJLabel);
        infoJPanel.add(ageJTextField);
        infoJPanel.add(raJLabel);
        infoJPanel.add(raJTextField);

        layout.putConstraint(SpringLayout.WEST, codJLabel, 6, SpringLayout.WEST, infoJPanel);
        layout.putConstraint(SpringLayout.NORTH, codJLabel, 6, SpringLayout.NORTH, infoJPanel);
        layout.putConstraint(SpringLayout.WEST, codJTextField, 6, SpringLayout.EAST, codJLabel);
        layout.putConstraint(SpringLayout.NORTH, codJTextField, 6, SpringLayout.NORTH, infoJPanel);
        layout.putConstraint(SpringLayout.EAST, codJTextField, 6, SpringLayout.EAST, infoJPanel);


        layout.putConstraint(SpringLayout.WEST, nameJlJLabel, 6, SpringLayout.WEST, infoJPanel);
        layout.putConstraint(SpringLayout.NORTH, nameJlJLabel, 12, SpringLayout.SOUTH, codJLabel);
        layout.putConstraint(SpringLayout.EAST, nameJlJLabel, 6, SpringLayout.EAST, codJLabel);

        layout.putConstraint(SpringLayout.NORTH, nameJtJTextField, 6, SpringLayout.SOUTH, codJTextField);
        layout.putConstraint(SpringLayout.WEST, nameJtJTextField, 0, SpringLayout.WEST, codJTextField);
        layout.putConstraint(SpringLayout.EAST, nameJtJTextField, 6, SpringLayout.EAST, infoJPanel);


        layout.putConstraint(SpringLayout.WEST, ageJlJLabel, 6, SpringLayout.WEST, infoJPanel);
        layout.putConstraint(SpringLayout.NORTH, ageJlJLabel, 12, SpringLayout.SOUTH, nameJlJLabel);
        layout.putConstraint(SpringLayout.EAST, ageJlJLabel, 6, SpringLayout.EAST, codJLabel);

        layout.putConstraint(SpringLayout.NORTH, ageJTextField, 6, SpringLayout.SOUTH, nameJtJTextField);
        layout.putConstraint(SpringLayout.WEST, ageJTextField, 0, SpringLayout.WEST, nameJtJTextField);
        layout.putConstraint(SpringLayout.EAST, ageJTextField, 6, SpringLayout.EAST, infoJPanel);


        layout.putConstraint(SpringLayout.WEST, raJLabel, 6, SpringLayout.WEST, infoJPanel);
        layout.putConstraint(SpringLayout.NORTH, raJLabel, 12, SpringLayout.SOUTH, ageJlJLabel);
        layout.putConstraint(SpringLayout.EAST, raJLabel, 6, SpringLayout.EAST, codJLabel);

        layout.putConstraint(SpringLayout.NORTH, raJTextField, 6, SpringLayout.SOUTH, ageJTextField);
        layout.putConstraint(SpringLayout.WEST, raJTextField, 0, SpringLayout.WEST, nameJtJTextField);
        layout.putConstraint(SpringLayout.EAST, raJTextField, 6, SpringLayout.EAST, infoJPanel);

        // inicialização dos botões.
        for (int i = 0; i < buttonNames.length; i++) {
            jButtons[i] = new JButton(buttonNames[i]);
            jButtons[i].setFont(f);
            buttonsJPanel.add(jButtons[i]);
        }

        // Configuração do layout do painel de botões
        buttonsJPanel.setLayout(new GridLayout(1, 3));
        buttonsJPanel.setBounds(16, (infoJPanel.getBounds().height + 16), (telaJFrame.getWidth() - 32), 30);

        // Configuração da tabela que exibe os dados do BD.
        tabela = new JTable(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Idade");
        modelo.addColumn("RA");
        JScrollPane painel = new JScrollPane(tabela);
        painel.setBounds(16, 250, (telaJFrame.getWidth() - 32), 200);


        tabela.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        ListSelectionModel selectionModel = tabela.getSelectionModel();

        selectionModel.addListSelectionListener(listSelectionEvent -> {
            if (!(tabela.getSelectedRow() < 0)) {
                codJTextField.setText(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0).toString());
                nameJtJTextField.setText(tabela.getModel().getValueAt(tabela.getSelectedRow(), 1).toString());
                ageJTextField.setText(tabela.getModel().getValueAt(tabela.getSelectedRow(), 2).toString());
                raJTextField.setText(tabela.getModel().getValueAt(tabela.getSelectedRow(), 3).toString());
                carregarDados();
            }
        });


//        modelo.addTableModelListener();


        // btn inserção
        controle = new Crud();
        jButtons[0].addActionListener(actionEvent -> {
            controle.cadastrarAluno(nameJtJTextField.getText(),
                    Integer.parseInt(ageJTextField.getText()),
                    raJTextField.getText());
            carregarDados();
        });

        // btn atualizar (action linstener)
        jButtons[1].addActionListener(actionEvent -> {
            controle.atualizarAluno(Integer.parseInt(codJTextField.getText()),
                    nameJtJTextField.getText(),
                    Integer.parseInt(ageJTextField.getText()),
                    raJTextField.getText());

            carregarDados();
        });

        // btn excluir
        jButtons[2].addActionListener(actionEvent -> {
            controle.excluirAluno(Integer.parseInt(codJTextField.getText()));
            carregarDados();
        });


        telaJFrame.add(infoJPanel);
        telaJFrame.add(buttonsJPanel);
        telaJFrame.add(painel);
        telaJFrame.setVisible(true);
        this.carregarDados();
    }

    private void carregarDados() {
        modelo.setNumRows(0);
        try {
            ResultSet dados = controle.carregarAlunos();
            while (dados.next()) {
                int id = dados.getInt("id_aluno");
                String nome = dados.getString("nome");
                int idade = dados.getInt("idade");
                String ra = dados.getString("ra");
                modelo.addRow(new Object[]{
                        id,
                        nome,
                        idade,
                        ra
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
