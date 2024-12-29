import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

import org.json.simple.JSONObject;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.json.simple.JSONArray;

public class FootBallResultSystemGUI extends JFrame implements ActionListener {
	
	private JPanel mainScoresPanel;
	private JScrollPane scrollPane;
	
	public FootBallResultSystemGUI() {
		super("FootBall Result System");
		setSize(750,700);
		ImageIcon backgroundimg=new ImageIcon("img/images.jpg");
		JLabel backgroundLabel=new JLabel(backgroundimg);
		backgroundLabel.setBounds(0,0, 750, 700);
		add(backgroundLabel);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addGUIComponents();
	
	}

	private void addGUIComponents() {
		
		JButton PortugalLeague = new JButton("Portugal");
		PortugalLeague.setName("Portugal");
		PortugalLeague.setBounds(90 , 20, 140 , 40);
		PortugalLeague.setFont(new Font("Dialog" , Font.PLAIN, 22));
		PortugalLeague.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PortugalLeague.addActionListener(this);
		add(PortugalLeague);
		
		JButton spainLeague = new JButton("Spain");
		spainLeague.setName("Spain");
		spainLeague.setBounds(305 , 20, 140 , 40);
		spainLeague.setFont(new Font("Dialog" , Font.PLAIN, 22));
		spainLeague.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spainLeague.addActionListener(this);
		add(spainLeague);
		
		JButton italyLeague = new JButton("Italy");
		italyLeague.setName("Italy");
		italyLeague.setBounds(520 , 20, 140 , 40);
		italyLeague.setFont(new Font("Dialog" , Font.PLAIN, 22));
		italyLeague.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		italyLeague.addActionListener(this);
		add(italyLeague);
		
		JButton germanyLeague = new JButton("Germany");
		germanyLeague.setName("Germany");
		germanyLeague.setBounds(90 , 80, 140 , 40);
		germanyLeague.setFont(new Font("Dialog" , Font.PLAIN, 22));
		germanyLeague.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		germanyLeague.addActionListener(this);
		add(germanyLeague);
		
		JButton franceLeague = new JButton("France");
		franceLeague.setName("France");
		franceLeague.setBounds(305 , 80, 140 , 40);
		franceLeague.setFont(new Font("Dialog" , Font.PLAIN, 22));
		franceLeague.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		franceLeague.addActionListener(this);
		add(franceLeague);
		
		JButton englandLeague = new JButton("England");
		englandLeague.setName("England");
		englandLeague.setBounds(520 , 80, 140 , 40);
		englandLeague.setFont(new Font("Dialog" , Font.PLAIN, 22));
		englandLeague.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		englandLeague.addActionListener(this);
		add(englandLeague);
	}
	
		
	public void setLabels(int index, JSONObject match, JPanel mainScores) {
	    JSONObject matchJson = (JSONObject) match;
	    JSONObject homeTeamJson = (JSONObject) matchJson.get("homeTeam");
	    String homeTeamName = (String) homeTeamJson.get("shortName");

	    JSONObject awayTeamJson = (JSONObject) matchJson.get("awayTeam");
	    String awayTeamName = (String) awayTeamJson.get("shortName");

	    String dateJson = (String) matchJson.get("utcDate");

	    JSONObject scoreJson = (JSONObject) matchJson.get("score");
	    JSONObject fullTimeScore = (JSONObject) scoreJson.get("fullTime");
	    Long homeScore = (Long) fullTimeScore.get("home");
	    Long awayScore = (Long) fullTimeScore.get("away");

	    String statusJson = (String) matchJson.get("status");

	    // پنل اصلی برای هر بازی
	    JPanel gamePanel = new JPanel();
	    gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
	    gamePanel.setPreferredSize(new Dimension(700, 120));
	    gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	    gamePanel.setBackground(Color.LIGHT_GRAY);

	    // نمایش تاریخ بازی
	    JLabel dateLabel = new JLabel("Date: " + dateJson);
	    dateLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
	    dateLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    gamePanel.add(dateLabel);

	    // نمایش نام تیم‌ها و نتیجه
	    JPanel scorePanel = new JPanel();
	    scorePanel.setLayout(new GridLayout(1, 3, 10, 10));
	    scorePanel.setBackground(Color.LIGHT_GRAY);

	    JLabel homeTeamLabel = new JLabel(homeTeamName, JLabel.CENTER);
	    homeTeamLabel.setFont(new Font("Dialog", Font.BOLD, 18));
	    scorePanel.add(homeTeamLabel);

	    JLabel scoreLabel = new JLabel(
	        (homeScore != null ? homeScore : "-") + " : " + (awayScore != null ? awayScore : "-"),
	        JLabel.CENTER
	    );
	    scoreLabel.setFont(new Font("Dialog", Font.BOLD, 24));
	    scorePanel.add(scoreLabel);

	    JLabel awayTeamLabel = new JLabel(awayTeamName, JLabel.CENTER);
	    awayTeamLabel.setFont(new Font("Dialog", Font.BOLD, 18));
	    scorePanel.add(awayTeamLabel);

	    gamePanel.add(scorePanel);

	    // نمایش وضعیت بازی
	    JLabel statusLabel = new JLabel("Status: " + statusJson);
	    statusLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
	    statusLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    gamePanel.add(statusLabel);

	    // افزودن پنل بازی به پنل اصلی
	    mainScores.add(gamePanel);
	}


		@Override
		public void actionPerformed(ActionEvent e) {
		    JButton o = (JButton) e.getSource();
		    String name = o.getName();

		    // اگر پنل نتایج از قبل وجود دارد، آن را پاک کنید
		    if (mainScoresPanel != null) {
		        mainScoresPanel.removeAll();
		        mainScoresPanel.revalidate();
		        mainScoresPanel.repaint();
		    } else {
		        // اگر اولین بار است، پنل را ایجاد کنید
		        mainScoresPanel = new JPanel();
		        mainScoresPanel.setBounds(5, 140, 730, 500);
		        mainScoresPanel.setLayout(new GridLayout(0, 1, 10, 10));
		        mainScoresPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

		        scrollPane = new JScrollPane(mainScoresPanel);
		        scrollPane.setBounds(5, 140, 730, 500);
		        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		        add(scrollPane);
		    }

		    // نمایش پیام بارگذاری
		    JLabel loadingLabel = new JLabel("Loading...", JLabel.CENTER);
		    loadingLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		    mainScoresPanel.add(loadingLabel);
		    mainScoresPanel.revalidate();
		    mainScoresPanel.repaint();

		    // استفاده از SwingWorker برای بارگذاری داده‌ها
		    SwingWorker<Void, Void> worker = new SwingWorker<>() {
		        JSONArray matches;

		        @Override
		        protected Void doInBackground() {
		            // فراخوانی API برای دریافت داده‌ها
		            switch (name) {
		                case "Portugal": // PPL
		                    matches = FootBallResultSystemAPI.getLeageData("PPL");
		                    break;
		                case "Spain": // PD
		                    matches = FootBallResultSystemAPI.getLeageData("PD");
		                    break;
		                case "Italy": // SA
		                    matches = FootBallResultSystemAPI.getLeageData("SA");
		                    break;
		                case "France": // FL1
		                    matches = FootBallResultSystemAPI.getLeageData("FL1");
		                    break;
		                case "Germany": // BL1
		                    matches = FootBallResultSystemAPI.getLeageData("BL1");
		                    break;
		                case "England": // PL
		                    matches = FootBallResultSystemAPI.getLeageData("PL");
		                    break;
		            }
		            return null;
		        }

		        @Override
		        protected void done() {
		            // پاک کردن پیام بارگذاری
		            mainScoresPanel.removeAll();

		            // بررسی اینکه آیا داده‌ها با موفقیت بارگذاری شده‌اند
		            if (matches != null && !matches.isEmpty()) {
		                for (int i = 0; i < matches.size(); i++) {
		                    JSONObject match = (JSONObject) matches.get(i);
		                    setLabels(i, match, mainScoresPanel);
		                }
		            } else {
		                JLabel errorLabel = new JLabel("No data available or an error occurred.", JLabel.CENTER);
		                errorLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		                mainScoresPanel.add(errorLabel);
		            }

		            // به‌روزرسانی رابط کاربری
		            mainScoresPanel.revalidate();
		            mainScoresPanel.repaint();
		        }
		    };

		    worker.execute();
		}

		
}
