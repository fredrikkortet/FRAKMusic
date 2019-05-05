import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <h1>Main.java</h1>
 * <p>
 * Frs
 * </p>
 * 
 * @author Andre Frisk, Fredrik Kortetjarvi, Kristoffer Guachalla, Rohullah
 *         Khorami
 * @version 1.0
 */
public class Player {
    private JFrame frame;
    private JPanel panelButtons, panelSearch, background;
    private JTextArea searchBox;
    private JButton play, pause, next, queue, search;
    // private JLabel label;

    final Dimension screenSize = new Dimension(600, 400);

    public Player() {
        gui();
    }

    public void gui() {
        frame = new JFrame("FRAKMusic");
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setSize(600, 400);
        frame.setMinimumSize(screenSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelButtons = new JPanel(new GridBagLayout());
        panelButtons.setBackground(Color.DARK_GRAY);
        panelSearch = new JPanel(new GridBagLayout());
        panelSearch.setBackground(Color.DARK_GRAY);
        background = new JPanel(new GridBagLayout());
        background.setBackground(Color.DARK_GRAY);

        play = new JButton("Play");
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO here is your method
            }
        });
        pause = new JButton("Pause");
        pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO here is your method
            }
        });
        next = new JButton("Next");
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO here is your method
            }
        });
        queue = new JButton("Queue");
        queue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO here is your method
            }
        });
        // label = new JLabel("FRAKMusic player");

        searchBox = new JTextArea();
        search = new JButton("Search");
        search.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                // TODO here is your method
            }
        });
        GridBagConstraints arrange = new GridBagConstraints();

        arrange.insets = new Insets(10, 10, 10, 10);

        arrange.gridy = 0;
        arrange.gridx = -2;
        panelButtons.add(pause, arrange);

        arrange.gridx = -1;
        panelButtons.add(play, arrange);

        arrange.gridx = 5;
        panelButtons.add(next, arrange);

        arrange.gridx = 10;
        panelButtons.add(queue, arrange);

        // panelSearch.add(label);
        arrange.gridx = 1;
        panelSearch.add(searchBox, arrange);
        arrange.gridx = 2;
        panelSearch.add(search, arrange);

        frame.add(background);
        frame.add(panelSearch, BorderLayout.NORTH);
        frame.add(panelButtons, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        new Player();
    }
}
