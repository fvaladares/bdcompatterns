import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo implements ActionListener {
    JTextField jTextFieldNome;
    JLabel jLabelMensagem;
    public ButtonDemo() {
        JFrame jFrame = new JFrame("Button " +
                "Demo");
        jFrame.setSize(350, 250);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        JButton button = new JButton("Clique");
        JLabel jLabelNome = new JLabel("Nome: ");
        jTextFieldNome = new JTextField();
        jLabelMensagem = new JLabel("Mensagem");


        jLabelNome.setBounds(10,10,100, 25);
        jTextFieldNome.setBounds(100,10,200, 25);
        jLabelMensagem.setBounds(10, 40, 200, 25);
        button.setBounds(60, 100, 150, 25);


        // Cria um listener
        button.addActionListener(this);

        jFrame.add(jLabelNome);
        jFrame.add(jTextFieldNome);
        jFrame.add(jLabelMensagem);
        jFrame.add(button);


        // centralizar jframe na tela
//        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String texto = jTextFieldNome.getText().toString();
        if (actionEvent.getActionCommand().equals("Clique"))
            jLabelMensagem.setText("Seja bem vindo " + texto);
//            JOptionPane.showMessageDialog(null,
//                    "Você clicou no botão!");
    }
}
