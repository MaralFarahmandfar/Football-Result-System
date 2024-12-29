import javax.swing.SwingUtilities;

public class AppLuncher {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				FootBallResultSystemGUI footballResultGUI = new FootBallResultSystemGUI();
				footballResultGUI.setVisible(true);
			}
			
		});

	}

}
