
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
		
		JPanel card1 = new JPanel();
        //card1.add(new JLabel(comboBoxItems[0]));
        card1.add(new JButton("Start Timer"));
        card1.add(new JButton("Stop Timer"));

		JPanel card2 = new JPanel();
        //card2.add(new JLabel(comboBoxItems[1]));
        card2.add(new JButton("Start Timer"));
        card2.add(new JButton("Stop Timer"));
        
		JPanel card3 = new JPanel();
		//card3.add(new JLabel(comboBoxItems[2]));
        card3.add(new JButton("Start Timer"));
        card3.add(new JButton("Stop Timer"));
        
        cards = new JPanel(new CardLayout());
        cards.add(card1, comboBoxItems[0]);
        cards.add(card2, comboBoxItems[1]);
        cards.add(card3, comboBoxItems[2]);
		
        pane.add(comboBoxPanel, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
        
	}
	
	public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem, menuItem2;

        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the first menu.
        menu = new JMenu("Settings");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "Access Settings");
        menuBar.add(menu);
 
        //a group of JMenuItems
        menuItem = new JMenuItem("General",
                                 KeyEvent.VK_T);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Access General Settings");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        
      //a group of JMenuItems
        menuItem2 = new JMenuItem("Appearance",
                                 KeyEvent.VK_T);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem2.getAccessibleContext().setAccessibleDescription(
                "Access Appearance Settings");
        menuItem2.addActionListener(this);
        menu.add(menuItem2);
        
 
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
		CardLayout change = (CardLayout)(cards.getLayout());
		change.show(cards, (String)arg0.getItem());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0);
		if("General".equals(arg0.getActionCommand())) {
			System.out.println("General Settings");
		} else if("Appearance".equals(arg0.getActionCommand())) {
			System.out.println("Appearance Settings");
		}
		
	}
}
