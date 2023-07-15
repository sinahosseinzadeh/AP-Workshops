package ceit.gui;

import ceit.model.Note;
import ceit.utils.FileUtils;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class CMainPanel extends JPanel {

    private JTabbedPane tabbedPane;
    private JList<File> directoryList;

    /**
     * constructs main panel and making a tabbed pane and JList in that
     */
    public CMainPanel() {

        setLayout(new BorderLayout());

        initDirectoryList(); // add JList to main Panel

        initTabbedPane(); // add TabbedPane to main panel
        //i disabled the first opened tab in order to control over the name of files and reopening notes
//        addNewTab(""); // open new empty tab when user open the application
    }

    private void initTabbedPane() {
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }

    private void initDirectoryList() {
        File[] files = FileUtils.getFilesInDirectory();
        directoryList = new JList<>(files);

        directoryList.setBackground(new Color(211, 211, 211));
        directoryList.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        directoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        directoryList.setVisibleRowCount(-1);
        directoryList.setMinimumSize(new Dimension(130, 100));
        directoryList.setMaximumSize(new Dimension(130, 100));
        directoryList.setFixedCellWidth(130);
        directoryList.setCellRenderer(new MyCellRenderer());
        directoryList.addMouseListener(new MyMouseAdapter());

        add(new JScrollPane(directoryList), BorderLayout.WEST);
    }

    /**
     * adds new tab to the tabbed pane
     * @param tabTitle the title of the tab (note)
     */
    public void addNewTab(String tabTitle) {
        JTextArea textPanel = createTextPanel();
        textPanel.setText("Write Something here...");
        String title=null;
        if(tabTitle.isEmpty())
            title="Tab " + (tabbedPane.getTabCount() + 1);
        else
            title=tabTitle;
        tabbedPane.addTab(title, textPanel);
    }

    /**
     * opens a note with given title and content in a tab
     * @param title the title of the note
     * @param content the content of the note
     */
    public void openExistingNote(String title,String content) {
        JTextArea existPanel = createTextPanel();
        existPanel.setText(content);
        String tabTitle=null;
        int tabIndex = tabbedPane.getTabCount() + 1;

        if(title.isEmpty())
            tabTitle="Tab " + tabIndex;
        else
            tabTitle=title;
        tabbedPane.addTab(tabTitle, existPanel);
        tabbedPane.setSelectedIndex(tabIndex - 1);
    }

    /**
     * saves the tab details in a note
     */
    public void saveNote() {
        JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
        String content = textPanel.getText();
        if (!content.isEmpty()) {
            SimpleDateFormat dateFormatter=new SimpleDateFormat("yyyy.MM.dd'_'HH");
            String date=dateFormatter.format(new Date());
            String noteName=tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
            Note newNote=new Note(noteName,content,date);
            FileUtils.serializeNote(newNote);
//            FileUtils.outputStreamFileWriter(note);
        }
        updateListGUI();
    }

    private JTextArea createTextPanel() {
        JTextArea textPanel = new JTextArea();
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return textPanel;
    }

    private void updateListGUI() {
        File[] newFiles = FileUtils.getFilesInDirectory();
        directoryList.setListData(newFiles);
    }
    private class MyMouseAdapter extends MouseAdapter {
        // contains a list of opened notes in order to prevent opening pre-opened note
        private ArrayList<Note> openedNotes=new ArrayList<>();
        @Override
        public void mouseClicked(MouseEvent eve) {
            // Double-click detected
            if (eve.getClickCount() == 2) {
                int index = directoryList.locationToIndex(eve.getPoint());
                System.out.println("Item " + index + " is clicked...");
                //TODO: Phase1: Click on file is handled... Just load content into JTextArea
                File curr[] = FileUtils.getFilesInDirectory();
                Note noteToRead = FileUtils.deserializeNote(curr[index]);
                boolean found=false;
                for(Note note:openedNotes)
                    if(isEqual(note,noteToRead))
                        found=true;
                if(!found){
                    openExistingNote(noteToRead.getTitle(),noteToRead.getContent());
                    openedNotes.add(noteToRead);
                }
            }
        }
    }

    /**
     * determines if two given notes are the same or note
     * @param note1 first note to be compared
     * @param note2 second note to be compared
     * @return if they are similar or not
     */
    private boolean isEqual(Note note1,Note note2){
        return note1.getTitle().equals(note2.getTitle())&&note1.getContent().equals(note2.getContent())&&
                note1.getDate().equals(note2.getDate());
    }
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    private class MyCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean cellHasFocus) {
            if (object instanceof File) {
                File file = (File) object;
                setText(file.getName());
                setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
                setEnabled(list.isEnabled());
            }
            return this;
        }
    }
}
