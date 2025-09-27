import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


// Accessibility, Disability , Awareness (ADA)

public class Ada {
    public static Font customFont1 = new Font("Comic Sans", Font.PLAIN, 20);
    public static void main(String[] args) {
        // Create Frame
        JFrame frame = new JFrame("ADA Personal Mental Health ChatBot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Create Panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(237, 216, 180));
        frame.add(panel);

        // Create and resize image
        ImageIcon AdaLogo = new ImageIcon("AdaLogo.png");
        Image scaledImage = AdaLogo.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        panel.add(imageLabel);

        // Intro text
        JLabel introLabel = new JLabel("Hi there! I am Ada, Your personal Mental Health Chat Bot");
        introLabel.setForeground(Color.BLACK);
        introLabel.setFont(customFont1);
        panel.add(introLabel);

        // Text Area
        JTextArea userResponse = new JTextArea(5, 40);
        userResponse.setLineWrap(true);
        userResponse.setBackground(Color.WHITE);
        userResponse.setForeground(Color.BLACK);
        userResponse.setFont(customFont1);
        Border lineBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
        userResponse.setBorder(lineBorder);
        userResponse.setText("In one word how are you feeling: ");
        panel.add(userResponse);
        JScrollPane scrollPane = new JScrollPane(userResponse);
        panel.add(scrollPane);

        // Button
        JButton sendButton = new JButton("Get a Response");
        sendButton.setForeground(Color.BLACK);
        sendButton.setOpaque(true);
        sendButton.setFont(customFont1);
        sendButton.setBorder(lineBorder);
        panel.add(sendButton);

        sendButton.addActionListener(e -> {
            String text = userResponse.getText();

            // Create Frame
            JFrame responseFrame = new JFrame("ADA Personal Mental Health ChatBot");
            responseFrame.setSize(800, 500);
            responseFrame.setResizable(false);
            responseFrame.setLocationRelativeTo(frame);


            // Create Panel
            JPanel responsePanel = new JPanel();
            responsePanel.setBackground(new Color(237, 216, 180));
            responseFrame.add(responsePanel);
            responsePanel.add(imageLabel);

            // Intro Text
            JLabel responseLabel = new JLabel("Hmmmmm... I understand");
            responseLabel.setForeground(Color.BLACK);
            responseLabel.setFont(customFont1);
            responsePanel.add(responseLabel);

            // Text Area
            JTextArea adaResponse = new JTextArea(5, 40);
            adaResponse.setLineWrap(true);
            adaResponse.setBackground(Color.WHITE);
            adaResponse.setForeground(Color.BLACK);
            adaResponse.setFont(customFont1);
            adaResponse.setBorder(lineBorder);
            adaResponse.setEditable(false);
            adaResponse.setText(text);
            responsePanel.add(adaResponse);
            JScrollPane scrollPane2 = new JScrollPane(adaResponse);
            responsePanel.add(scrollPane2);

            // Make frame visible
            responseFrame.setVisible(true);

        });


        // Make frame visible
        frame.setVisible(true);
    }
}