package week5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPFinderAWT extends Frame implements ActionListener {
	TextField textField;
    Label label;
    Button findButton, exitButton;
    Label resultLabel;
 // Constructor to set up the GUI
    public IPFinderAWT() {
        // Create frame
        setLayout(new FlowLayout());

        // Create and add label and text field
        label = new Label("Enter Website:");
        add(label);

        textField = new TextField(20);
        add(textField);

        // Create and add Find IP button
        findButton = new Button("Find IP");
        findButton.addActionListener(this);
        add(findButton);

        // Create and add Exit button
        exitButton = new Button("Exit");
        exitButton.setBounds(150,150,120,60); 
        exitButton.addActionListener(this);
        add(exitButton);

        // Create and add label to show the result
        resultLabel = new Label("");
        add(resultLabel);

        // Set window properties
        setTitle("IP Finder");
        setSize(300, 200);
        setVisible(true);

        // Close the window when the close button is clicked
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
    }//constructor
   
 // Handle button events
        
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == findButton) {
            String website = textField.getText();
            try {
                // Get the IP address of the website
            	InetAddress ip = InetAddress.getByName(website);
                resultLabel.setText("IP Address: " + ip.getHostAddress());
            } catch (UnknownHostException e) {
                resultLabel.setText("Invalid website!");
            }
        } else if (ae.getSource() == exitButton) {
            dispose(); // Close the window
        }
    }  //actionP
	public static void main(String[] args) {
        new IPFinderAWT(); // Create the GUI and display it
    }
}
