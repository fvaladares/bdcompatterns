import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ListrFrameSample {
    private static final String[] colorNames = {"Black", "Blue", "Green"};
    private static final Color[] colors = {Color.BLACK, Color.BLUE, Color.GREEN };
    private final JList<String> colorJList;



    public ListrFrameSample() {
        JFrame tela = new JFrame("Exemplo de Litener para JList");
        JScrollPane scrollPane;
        Font f = new Font("serif", Font.PLAIN, 20);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        tela.setSize(200,150);
        tela.setLayout(null);

        colorJList = new JList<String>(colorNames);
        colorJList.setVisibleRowCount(5);
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane = new JScrollPane(colorJList);

        colorJList.setFont(f);
        scrollPane.setFont(f);



        scrollPane.setBounds(20, 20, (
                (int)tela.getWidth() - 30), 30);

        colorJList.addListSelectionListener( actionEvent -> {
            tela.getContentPane().setBackground(
                    colors[colorJList.getSelectedIndex()]
            );
        });

        tela.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                scrollPane.setBounds(20, 20, (
                        (int)tela.getWidth() - 30), 30);
            }
        });

        tela.add(scrollPane);
        tela.setVisible(true);

    }
}
