import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Desktop;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;


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

        // Play Ada Intro
        try {
            File adaIntro = new File("AdaIntro.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(adaIntro);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("unable to play track");
        }

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
        JLabel introLabel = new JLabel("<html>Hi there! I am Ada, Your personal Mental Health ChatBot!<br><br><center>(Accessibility, Disability, Awareness (ADA))</center></html>");
        introLabel.setForeground(Color.BLACK);
        introLabel.setFont(customFont1);
        panel.add(introLabel);

        // User Prompt
        JLabel userPromptLabel = new JLabel("In one word, describe how you are feeling");
        userPromptLabel.setForeground(Color.BLACK);
        userPromptLabel.setFont(customFont1);
        panel.add(userPromptLabel);

        // Text Area
        JTextField userResponse = new JTextField(40);
        userResponse.setHorizontalAlignment(SwingConstants.CENTER);
        userResponse.setBackground(Color.WHITE);
        userResponse.setForeground(Color.BLACK);
        userResponse.setFont(customFont1);
        Border lineBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
        userResponse.setBorder(lineBorder);
        panel.add(userResponse);

        // User Prompt 2
        JLabel userPromptLabel2 = new JLabel("How long have these feelings persisted?");
        userPromptLabel2.setForeground(Color.BLACK);
        userPromptLabel2.setFont(customFont1);
        panel.add(userPromptLabel2);

        // Text Area 2
        JTextField userResponse2 = new JTextField(40);
        userResponse2.setHorizontalAlignment(SwingConstants.CENTER);
        userResponse2.setBackground(Color.WHITE);
        userResponse2.setForeground(Color.BLACK);
        userResponse2.setFont(customFont1);
        userResponse2.setBorder(lineBorder);
        panel.add(userResponse2);

        // User Prompt 3
        JLabel userPromptLabel3 = new JLabel("Have these feelings made day to day life difficult?");
        userPromptLabel3.setForeground(Color.BLACK);
        userPromptLabel3.setFont(customFont1);
        panel.add(userPromptLabel3);

        // Text Area 3
        JTextField userResponse3 = new JTextField(40);
        userResponse3.setHorizontalAlignment(SwingConstants.CENTER);
        userResponse3.setBackground(Color.WHITE);
        userResponse3.setForeground(Color.BLACK);
        userResponse3.setFont(customFont1);
        userResponse3.setBorder(lineBorder);
        panel.add(userResponse3);

        // Send Button
        JButton sendButton = new JButton("Get a Response");
        sendButton.setForeground(Color.BLACK);
        sendButton.setOpaque(true);
        sendButton.setFont(customFont1);
        sendButton.setBorder(lineBorder);
        panel.add(sendButton);
        frame.setVisible(true);

        sendButton.addActionListener(e -> {
                    frame.setVisible(false);
                    String word = userResponse.getText();
                    String word2 = userResponse2.getText();
                    String word3 = userResponse3.getText();

                    // Create Frame
                    JFrame responseFrame = new JFrame("ADA Personal Mental Health ChatBot");
                    responseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    responseFrame.setSize(800, 500);
                    responseFrame.setResizable(false);
                    responseFrame.setLocationRelativeTo(frame);


                    // Create Panel
                    JPanel responsePanel = new JPanel();
                    responsePanel.setBackground(new Color(237, 216, 180));
                    responseFrame.add(responsePanel);
                    responsePanel.add(imageLabel);

                    // Intro Text
                    JLabel responseLabel = new JLabel("<html>I understand how you feel.<br> I am here to support you</html>");
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
                    adaResponse.setText("You are feeling " + word + ". \nYou have been having these feelings for " + word2
                            + ". \nYou responded \""  + word3
                            + "\" to if these feelings are causing you trouble daily.\nDo you need me to direct you to mental health resources?");
                    responsePanel.add(adaResponse);

                    // Yes Button
                    JButton yesButton = new JButton(" Yes ");
                    yesButton.setForeground(Color.BLACK);
                    yesButton.setOpaque(true);
                    yesButton.setFont(customFont1);
                    yesButton.setBorder(lineBorder);
                    responsePanel.add(yesButton);

                    // No Button
                    JButton noButton = new JButton(" No  ");
                    noButton.setForeground(Color.BLACK);
                    noButton.setOpaque(true);
                    noButton.setFont(customFont1);
                    noButton.setBorder(lineBorder);
                    responsePanel.add(noButton);

                    // Make frame visible
                    responseFrame.setVisible(true);

            yesButton.addActionListener(y -> {
                try {
                    Desktop.getDesktop().browse(new java.net.URI("https://www.cdc.gov/mental-health/caring/index.html"));
                    System.exit(0);
                } catch (Exception ex) {
                    System.out.println("Failed to open the link.");

                }
            });

            noButton.addActionListener(n -> System.exit(0));

            });
        }
    }
