import java.applet.Applet;
import java.awt.Graphics;

public class AppletTest extends Applet {
	String msg = "";

	public void init() {
		msg = "Hello Geeks";
	}

	public void start() {
		msg = msg + ",Welcome to GeeksForGeeks";
	}

	public void paint(Graphics g) {
		g.drawString(msg, 20, 20);
	}
}