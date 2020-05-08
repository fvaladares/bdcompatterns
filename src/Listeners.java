import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listeners implements ActionListener {
    private JTextField jTextField;
    private JButton jButton;
    private JFrame jFrame;

    public Listeners() {
        jFrame = new JFrame("Janela de exemplo");
        jFrame.setSize(300,200);
        jFrame.setLayout(new FlowLayout());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width/2-jFrame.getSize().width/2, dim.height/2-jFrame.getSize().height/2);

        jTextField = new JTextField(25);
        jButton = new JButton("Click");
        jButton.setActionCommand("btnClick");

        //Adicionando uma classe anônima para criar a ação do botão
//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                acaoBtn();
//            }
//        });

        // Adicionando um lambda para criar a ação do botão
        jButton.addActionListener((actionEvent -> {
            acaoBtn();
        }));

//        jButton.addActionListener(this);

        jFrame.add(jTextField);
        jFrame.add(jButton);



        jFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("btnClick")){
            acaoBtn();
        }
    }

    public void acaoBtn(){
        JOptionPane.showMessageDialog(null,"Botão acionado.");
    }
}
