import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class YaMeHiceBolas extends JFrame {
	
	private Point a;
	private int largo, nivel;
	
	public YaMeHiceBolas() {
		super("Ya me hice bolas");
		this.setSize(720, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// creamos un punto base, con los valores que dio el profesor para testing
		this.a = new Point(50, 350);
		//le preguntamos al usuario que nos de el largo y el nivel
		this.largo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el largo"));
		this.nivel=Integer.parseInt(JOptionPane.showInputDialog("Introduce el nivel"));
		this.setVisible(true);
	}
	public void pintaCirculos(Graphics g, int nivel, int x, int y, int largo) {
		//primero cree ya el dibujo base, el cual solo es un circulo
		int x2=x+getInsets().left;
		int y2=(y-(largo/2))+getInsets().top;
		g.drawOval(x2,y2,largo,largo);
		// mi condicion base es que si es 0 solo se dibuje el circulo mas grande
		if(nivel != 0) {
			//por cada nivel se puede ver que se agrega adentro del criculo grande 2 ciculos pequeños
			// cada circulo es la mitad del tamaño grande
			// por lo cual hacemos 2 recursiones uno para el circulo menor a la derecha y a la izquierda
			pintaCirculos(g,nivel-1,x, y, largo/2);
			pintaCirculos(g, nivel-1,x+(largo/2), y, largo/2);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.pintaCirculos(g, this.nivel, this.a.x, this.a.y, this.largo);

    }
    public static void main(String[] args) {
        YaMeHiceBolas frame = new YaMeHiceBolas();
    }
}