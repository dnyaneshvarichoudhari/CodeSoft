import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class WordCountTask extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCountTask() {
        setTitle("Word Count GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);

        countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textArea.getText();
                if (!inputText.trim().isEmpty()) {
                    String[] words = splitIntoWords(inputText);
                    int wordCount = words.length;
                    Map<String, Integer> wordFrequencies = countWordsAndFrequencies(words);
                    int uniqueWordCount = wordFrequencies.size();

                    resultLabel.setText("Word count: " + wordCount + " | Unique words: " + uniqueWordCount);
                    displayWordFrequencies(wordFrequencies);
                } else {
                    resultLabel.setText("Input is empty.");
                }
            }
        });

        resultLabel = new JLabel("");

        JPanel panel = new JPanel();
        panel.add(countButton);
        panel.add(resultLabel);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    protected void displayWordFrequencies(Map<String, Integer> wordFrequencies) {
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    protected String[] splitIntoWords(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            return new String[0];
        }

        String[] words = inputText.split("[\\s\\p{Punct}]+");
        return words;
    }

    private Map<String, Integer> countWordsAndFrequencies(String[] words) {
        Map<String, Integer> wordFrequencies = new HashMap<>();
        for (String word : words) {
            wordFrequencies.put(word.toLowerCase(), wordFrequencies.getOrDefault(word.toLowerCase(), 0) + 1);
        }
        return wordFrequencies;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCountTask().setVisible(true);
            }
        });
    }
}
