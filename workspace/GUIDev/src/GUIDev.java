
/*
 * This file is for testing and developing methods related to the GUI only
 * 
 * 
 */

//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class GUIDev implements ItemListener, ActionListener {
	
	//Initialize global variables
	private JPanel cards;
	
	
	public void addComponentToPane(Container pane) {
		
		JPanel comboBoxPanel = new JPanel();
		String comboBoxItems[] = {"ELEC 287", "ELEC 221", "ENPH 242"};
		JComboBox<String> cb = new JComboBox<>(comboBoxItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPanel.add(cb);
		
		JButton start1 = new JButton("Start Timer");
		JButton stop1 = new JButton("Stop Timer");
		JButton start2 = new JButton("Start Timer");
		JButton stop2 = new JButton("Stop Timer");
		JButton start3 = new JButton("Start Timer");
		JButton stop3 = new JButton("Stop Timer");
		
		
		JPanel card1 = new JPanel();
        //card1.add(new JLabel(comboBoxItems[0]));
        card1.add(start1);
        card1.add(stop1);

		JPanel card2 = new JPanel();
        //card2.add(new JLabel(comboBoxItems[1]));
        card2.add(start2);
        card2.add(stop2);
        
		JPanel card3 = new JPanel();
		//card3.add(new JLabel(comboBoxItems[2]));
        card3.add(start3);
        card3.add(stop3);
        
        cards = new JPanel(new CardLayout());
        cards.add(card1, comboBoxItems[0]);
        cards.add(card2, comboBoxItems[1]);
        cards.add(card3, comboBoxItems[2]);
		
        pane.add(comboBoxPanel, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
        
	}
	
	public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu sett, stats;
        JMenuItem gen, app, viewStat;
        
        menuBar = new JMenuBar();

        //Start -- Settings Menu items
        sett = new JMenu("Settings");
        sett.setMnemonic(KeyEvent.VK_S);
        menuBar.add(sett);
 
        //General submenu
        gen = new JMenuItem("General", KeyEvent.VK_G);
        gen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        gen.addActionListener(this);
        sett.add(gen);
        
        //Appearance submenu
        app = new JMenuItem("Appearance", KeyEvent.VK_A);
        app.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        app.addActionListener(this);
        sett.add(app);       
        //End -- Settings Menu items
        
        
        
        //Start -- Stats Menu items
        stats = new JMenu("Stats");
        stats.setMnemonic(KeyEvent.VK_A);
        menuBar.add(stats);
        
        viewStat = new JMenuItem("View Stats", KeyEvent.VK_V);
        viewStat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
        viewStat.addActionListener(this);
        stats.add(viewStat);
        //End -- Stats Menu items
        
        
 
        return menuBar;
	}
	
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Study Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        GUIDev demo = new GUIDev();
        demo.addComponentToPane(frame.getContentPane());
        
        //Set menu
        frame.setJMenuBar(demo.createMenuBar());
        
        //Display the window.
        frame.setMinimumSize(new Dimension(300, 150));
        frame.pack();
        frame.setVisible(true);
    }
    
	
	public static void main(String[] args) {
		createAndShowGUI();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		System.out.println("Changed tab");
		CardLayout change = (CardLayout)(cards.getLayout());
		change.show(cards, (String)arg0.getItem());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());

		
	}
}
