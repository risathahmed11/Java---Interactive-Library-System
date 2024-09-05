package bcu.cmp5332.librarysystem.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import bcu.cmp5332.librarysystem.model.Book;

public class DisplayBook extends JFrame {

    private MainWindow mw;
    private List<Book> books;

    public DisplayBook(MainWindow mw, List<Book> books) {
        this.mw = mw;
        this.books = books;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        } 

        setTitle("Patron List of Books");
        
        setSize(400, 300);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        
        for (Book book : books) {
            topPanel.add(new JLabel("Book " + book.getId() + " - " + book.getTitle()));
		}

        this.getContentPane().add(new JScrollPane(topPanel), BorderLayout.CENTER);
        setLocationRelativeTo(mw);

        setVisible(true);
    }
}