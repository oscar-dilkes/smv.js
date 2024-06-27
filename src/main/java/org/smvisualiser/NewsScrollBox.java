package org.smvisualiser;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;

public class NewsScrollBox extends JScrollPane {
  public NewsScrollBox(List<NewsItem> newsItems) {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    for (NewsItem item : newsItems) {
      panel.add(createNewsPanel(item));
    }
    panel.setPreferredSize(new Dimension(300, newsItems.size() * 100));
    this.setViewportView(panel);
  }

  private JPanel createNewsPanel(NewsItem item) {
    JPanel newsPanel = new JPanel(new BorderLayout());
    JLabel titleLabel = new JLabel("<html><b>" + item.getTitle() + "</b></html>");
    titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
    JLabel publisherLabel = new JLabel("Publisher: " + item.getPublisher());
    JLabel authorLabel = new JLabel("Author: " + item.getAuthor());
    JLabel dateLabel = new JLabel("Date: " + item.getDate());
    JLabel descriptionLabel = new JLabel("<html>" + item.getDescription() + "</html>");
    JLabel urlLabel = new JLabel("<html><a href=\"" + item.getUrl() + "\">Read more</a></html>");

    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
    infoPanel.add(titleLabel);
    infoPanel.add(publisherLabel);
    infoPanel.add(authorLabel);
    infoPanel.add(dateLabel);
    infoPanel.add(descriptionLabel);
    infoPanel.add(urlLabel);

    newsPanel.add(infoPanel, BorderLayout.CENTER);

    newsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    newsPanel.setPreferredSize(new Dimension(550, 150)); // Ensure each news panel has a fixed preferred size
    return newsPanel;
  }
}
