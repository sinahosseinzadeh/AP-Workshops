package ceit.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CFrame extends JFrame implements ActionListener {

    private CMainPanel mainPanel;

    private JMenuItem newItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;

    /**
     * constructs a frame with given title
     * @param title the title of the frame
     */
    public CFrame(String title) {
        super(title);

        initMenuBar(); //create menuBar

        initMainPanel(); //create main panel
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu jmenu = new JMenu("File");

        newItem = new JMenuItem("New");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        newItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        jmenu.add(newItem);
        jmenu.add(saveItem);
        jmenu.add(exitItem);

        menuBar.add(jmenu);
        setJMenuBar(menuBar);
    }

    private void initMainPanel() {
        mainPanel = new CMainPanel();
        add(mainPanel);
    }

    /**
     * based on the chosen item it can create and save notes or save all notes and exit program
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem) {
            String tabName=JOptionPane.showInputDialog(null,
                    "Enter file name:","create note",JOptionPane.QUESTION_MESSAGE);
            mainPanel.addNewTab(tabName);
        } else if (e.getSource() == saveItem) {
            mainPanel.saveNote();
        } else if (e.getSource() == exitItem) {
            //TODO: Phase1: check all tabs saved ...
            saveAllNotes(mainPanel.getTabbedPane());
            System.exit(0);
        } else {
            System.out.println("Nothing detected...");
        }
    }

    /**
     * goes through all tabs and saves them as notes
     * @param tabbedPane the tabbed pane containing notes
     */
    private void saveAllNotes(JTabbedPane tabbedPane){
        int tabNumber=tabbedPane.getTabCount();
        for(int i=0;i<tabNumber;i++){
            tabbedPane.setSelectedIndex(i);
            mainPanel.saveNote();
        }

    }
}
