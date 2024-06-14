import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ClientGUI extends JFrame {
    String userName;
    private JTextArea chatHistoryArea;
    private JTextField messageField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private boolean loggedIn = false;
    Message message = new Message("", "Info");

    public ClientGUI(ServerWindow serverWindow) {
        setTitle("Клиент");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        chatHistoryArea = new JTextArea();
        chatHistoryArea.setLineWrap(true);
        chatHistoryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatHistoryArea);
        add(scrollPane, BorderLayout.CENTER);
        JPanel panel = new JPanel(new GridLayout(1, 3));
        loginField = new JTextField("Логин");
        panel.add(loginField);
        passwordField = new JPasswordField("Пароль");
        panel.add(passwordField);
        JButton sendAutorization = new JButton("Send");
        panel.add(sendAutorization);
        add(panel, BorderLayout.SOUTH);
        sendAutorization.addActionListener((ActionEvent l) -> {
            if (l.getSource() == sendAutorization) {
                if (!loginField.getText().equals("Логин")) {
                    userName = loginField.getText();
                    loggedIn = true;
                    System.out.println(userName);
                    panel.remove(loginField);
                    panel.remove(passwordField);
                    panel.remove(sendAutorization);
                    repaint();
                    JLabel login = new JLabel(userName);
                    messageField = new JTextField();
                    JButton sendButton = new JButton("Send");
                    panel.add(login);
                    panel.add(messageField);
                    panel.add(sendButton);
                    repaint();
                    sendButton.addActionListener((ActionEvent e) -> {
                        if (e.getSource() == sendButton) {
                            String messageText = messageField.getText();
                            Message message = new Message(messageText, userName);
                            serverWindow.displayMessage(message);
                            serverWindow.setLines(message.getSender() + ": " + message.getText() + " (" + message.getTimestamp() + ")");
                            chatHistoryArea.setText(serverWindow.getMessageArea().getText());
                            System.out.println(serverWindow.getMessageArea().getText());

                        }
                    });
                } else {
                    message.setText("Ваш логин должен отличаться от слова Логин. Попробуйте снова");
                    chatHistoryArea.append(message.getSender() + ": " + message.getText() + " (" + message.getTimestamp() + ")\n");
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void sendMessageToServer(ServerWindow serverWindow) {
        String messageText = messageField.getText();
        Message message = new Message(messageText, "User");
        serverWindow.displayMessage(message);
        chatHistoryArea.append("You: " + messageText + " (" + message.getTimestamp() + ")\n");
        messageField.setText("");
    }

}