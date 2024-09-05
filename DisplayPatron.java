package bcu.cmp5332.librarysystem.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import bcu.cmp5332.librarysystem.model.Loan;
import bcu.cmp5332.librarysystem.model.Patron;

public class DisplayPatron extends JFrame {

    private MainWindow mw;
    private Loan loan;

    public DisplayPatron(MainWindow mw, Loan loan) {
        this.mw = mw;
        this.loan = loan;
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

        setTitle("Patron details");
        
        setSize(400, 300);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(6, 2));
		
        Patron patron = loan.getPatron();
        
        topPanel.add(new JLabel("ID: "));
        topPanel.add(new JLabel(String.valueOf(patron.getId())));
        topPanel.add(new JLabel("Name: "));
        topPanel.add(new JLabel(patron.getName()));
        topPanel.add(new JLabel("Phone : "));
        topPanel.add(new JLabel(patron.getPhone()));
        topPanel.add(new JLabel("Email : "));
        topPanel.add(new JLabel(patron.getEmail()));
        topPanel.add(new JLabel("Loan Due Date : "));
        topPanel.add(new JLabel(loan.getDueDate().toString()));

        this.getContentPane().add(topPanel, BorderLayout.CENTER);
        setLocationRelativeTo(mw);

        setVisible(true);
    }
}
