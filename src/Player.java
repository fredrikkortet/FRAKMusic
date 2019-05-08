import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import jaco.mp3.player.MP3Player;

/**
 * <h1>Player.java</h1>
 * <p>
 * This class will make the layout and run all the method we will add.
 * </p>
 * 
 * @author Andre Frisk, Fredrik Kortetjarvi, Kristoffer Guachalla, Rohullah
 *         Khorami
 * @version 1.0
 */
public class Player {   
    private JFrame frame;
    private JPanel panelButtons, panelSearch, panelList, background;
    private JTextArea searchBox, musicList;
    private JButton play, pause, next, queue, search, add;
    final Dimension screenSize = new Dimension(600, 400);
    final static File folder = new File("/home/fredrik/FRAKMusic/Music");

    public Player() {
        gui(); //start gui
    }

    public void gui() {
        //fix the frame how big name
        frame = new JFrame("FRAKMusic");
        frame.setResizable(true);
        frame.setMinimumSize(screenSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create the panels with color and gridlayout
        panelButtons = new JPanel(new GridBagLayout());
        panelButtons.setBackground(Color.DARK_GRAY);
        panelSearch = new JPanel(new GridBagLayout());
        panelSearch.setBackground(Color.DARK_GRAY);
        background = new JPanel(new GridBagLayout());
        background.setBackground(Color.DARK_GRAY);
        panelList = new JPanel(new GridBagLayout());
        panelList.setBackground(Color.DARK_GRAY);

        //creat the buttons labels textfields
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
        searchBox.setColumns(20);
        search = new JButton("Search");
        search.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                // TODO here is your method
            }
        });

        musicList = new JTextArea();
        musicList.setColumns(30);
        musicList.setRows(6);
        add = new JButton("add");
        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent args) {
                adding(folder);
            }
        });
        // add it to the panel like buttons labels textfields  
        GridBagConstraints arrange = new GridBagConstraints(); // create the grids 

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

        arrange.gridx = 1;
        panelSearch.add(searchBox, arrange);

        arrange.gridx = 2;
        panelSearch.add(search, arrange);

        panelList.add(add);
        panelList.add(musicList);

        //here it adds panel to the frame 
        frame.add(background);
        frame.add(panelSearch, BorderLayout.NORTH);
        frame.add(panelButtons, BorderLayout.SOUTH);
        frame.add(panelList, BorderLayout.WEST);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Player(); // start player

    }

    /**
     * add the music into the program
     * @params source is the map all the music is in.
     */
    public void adding(final File source) {
        final File[] listOfFiles = source.listFiles();

        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                adding(file);
            } else {
                musicList.append(file.getName()+"\n");
                file.getName();

            }
        }
    }
    /**
     * Next song to be played
     */
    public void nextToPlay() {
    	addedList.remove();
    	addedList.play();
    }
    /**
     * Queue a song 
     * @param song; the song to be queued
     */
    public void queueSong(File song) {
    	addedList.add(song);
    }
}
