import javax.swing.*;

//Ler sobre os gerenciadores de layout do Swing!
public class Tela {
    public Tela(){
        // Cria o objeto que representa a tela
        JFrame screen = new JFrame("Minha primeira tela");
        // Configura o tamanho da tela
        screen.setLayout(null);
        screen.setSize(275, 200);
        // Determina o modo de encerramento da aplicação
        screen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Caixa de texto sem edição pelo usuário
        JLabel msgBoasVindas = new JLabel("Olá, seja " +
                "bem vindo ao Swing.");
        JLabel msgBoasVindas2 = new JLabel("JLabel 2");
       // Determinar a configuração dos componentes
        msgBoasVindas.setBounds(10,10,200, 25);
        msgBoasVindas2.setBounds(10,40,200, 25);
        // Vincular componente ao container
        screen.add(msgBoasVindas);
        screen.add(msgBoasVindas2);
        screen.setVisible(true);
    }
}
