import javax.swing.JOptionPane;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class passwordGenerator { // Global Variables
	static String letter1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String letter2 = "abcdefghijklmnopqrstuvwxyz";
	static String nums = "0123456789";
	static String syms = "!#$%^&*=+-/€?<>()";
	static String all = letter1 + letter2 + nums + syms;
	static String lenz = JOptionPane.showInputDialog("Passwd Length?", 16);
	static int len = Integer.parseInt(lenz);
	static char password[] = new char[len];
	static String gen = "";
	static int rc = 0;

	public static void Generator() { // this method randomly choose words...
		for (int i = 0; i < len; i++) {
			password[i] = all.charAt((int) ((Math.random()) * 79));
		}
	}

	public static void copyClipBoard() { // it contains copy function
		Generator();
		gen = new String(password);
		StringSelection selection = new StringSelection(gen);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
	}

	public static void GUI() { // contains the GUI part, i used JOptionPane in swing.

		copyClipBoard();
		String[] buttons = { "copy", "Regenarate again" };
		rc = JOptionPane.showOptionDialog(null, "Your passwd is " + gen, "Generated Passwd",
				JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
	}

	public static void conditionForRegenarating() { // this condition contains an infinite loop that if you want to
													// regenarate the code it will do regenrate until you press copy.
		GUI();
		for (;;) {
			if (!(rc == 0)) {
				GUI();
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) { // main method
		conditionForRegenarating();
	}

}