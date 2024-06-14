import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
public class ServerWindow extends JFrame
        {
    public JTextArea getMessageArea() {
        return messageArea;
    }

    public void setMessageArea(JTextArea messageArea) {
        this.messageArea = messageArea;
        
    }

    private JTextArea messageArea;
    TextAreaToFile textAreaToFile = new TextAreaToFile();
    private List<String> arrayLines = new ArrayList<>();
    boolean connect;
    String serverText;
    Message message = new Message("", "Server");
    public List<String> getLines() {
        return arrayLines;
    }
    public void setLines(String line) {
        System.out.println(line);
        textAreaToFile.addLine(line);
    }
    public ServerWindow() {
        setTitle("Сервер");
        setSize(400, 300);
        setLayout(new BorderLayout());
        messageArea = new JTextArea();
        messageArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        add(scrollPane, BorderLayout.CENTER);
        JPanel panelButtom = new JPanel(new GridLayout(1, 2));
        JButton startButton = new JButton("Start");
        startButton.addActionListener((ActionEvent e) -> {
            if (e.getSource() == startButton) {
                connect = true;
                serverText = "Сервер подключен";
                message.setText(serverText);
                displayMessage(message);
            }
        });
        add(startButton, BorderLayout.SOUTH);
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener((ActionEvent e) -> {
            if (e.getSource() == stopButton) {
                connect = false;
                serverText = "Сервер отключен";
                message.setText(serverText);
                displayMessage(message);
            }
        });
        panelButtom.add(startButton);
        panelButtom.add(stopButton);
        add(panelButtom, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void displayMessage(Message message) {
        messageArea.append(message.getSender() + ": " + message.getText() + " (" + message.getTimestamp() + ")\n");
    }
    public ArrayList<String> getMessage() {
        ArrayList<String> allMessage = new ArrayList<>();
        allMessage.add(messageArea.getText());
        System.out.println(messageArea.getText());
        return allMessage;
    }
}


