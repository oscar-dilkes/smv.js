package org.smvisualiser;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class NewsItemPanel extends JPanel {

  public NewsItemPanel(NewsItem newsItem) {
    setLayout(new BorderLayout(10, 10));
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel titleLabel = new JLabel("<html><h2>" + newsItem.getTitle() + "</h2></html>");
    JLabel publisherLabel = new JLabel(newsItem.getPublisher() + " - " + newsItem.getDate());
    JLabel authorLabel = new JLabel("By: " + newsItem.getAuthor());
    JTextArea descriptionArea = new JTextArea(newsItem.getDescription());
    descriptionArea.setLineWrap(true);
    descriptionArea.setWrapStyleWord(true);
    descriptionArea.setEditable(false);
    JLabel urlLabel = new JLabel("<html><a href=\"" + newsItem.getUrl() + "\">Read more</a></html>");
    urlLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

    urlLabel.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        try {
          Desktop.getDesktop().browse(new URL(newsItem.getUrl()).toURI());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    if (newsItem.getImageUrl() != null && !newsItem.getImageUrl().isEmpty()) {
      try {
        ImageIcon imageIcon = new ImageIcon(new URL(newsItem.getImageUrl()));
        JLabel imageLabel = new JLabel(imageIcon);
        add(imageLabel, BorderLayout.WEST);
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }

    JPanel textPanel = new JPanel(new BorderLayout());
    textPanel.add(titleLabel, BorderLayout.NORTH);
    textPanel.add(descriptionArea, BorderLayout.CENTER);
    textPanel.add(urlLabel, BorderLayout.SOUTH);

    add(textPanel, BorderLayout.CENTER);
    add(publisherLabel, BorderLayout.SOUTH);
    add(authorLabel, BorderLayout.NORTH);
  }
}
