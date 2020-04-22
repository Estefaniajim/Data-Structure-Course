import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;

public class Fractales extends JFrame {
	// fractal Sierpinski gasket
	private Point a,
				  b,
				  c;
	private int n;
    public Fractales(int n) {
    	super("Fractal de Sierpinski gasket");
    	this.n=n;
    	this.setSize(800,600);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.a=new Point(400,100);
    	this.b=new Point(50,500);
    	this.c=new Point(750,500);
    	this.setVisible(true);
    }
    private void pintaLineas(Graphics g, Point a, Point b) {
    	g.drawLine(a.x,a.y, b.x, b.y);
    	
    }
    private Point puntoMedio(Point a, Point b) {
    	return 
    	new Point((a.x+b.x)/2,(a.y+b.y)/2);
    	
    }
    private void pintaTriangulos(Graphics g, int n,Point a,Point b,Point c) {
    	if (n==0) {
    		this.pintaLineas(g, a, b);
    		this.pintaLineas(g, b, c);
    		this.pintaLineas(g, c, a);
    	}else {
    		Point pmab=this.puntoMedio(a, b),
    				pmbc=this.puntoMedio(b, c),
    				pmca=this.puntoMedio(c,a);
    		this.pintaTriangulos(g, n-1, a, pmab, pmca);
    		this.pintaTriangulos(g, n-1, pmab, b, pmbc);
    		this.pintaTriangulos(g, n-1, pmca,pmbc, c);
    	}
    	
    }
   public void paint(Graphics g) {
	   super.paint(g);
	   this.pintaTriangulos(g, n, a, b, c);
    	
    }
   public static void main(String[] args) {
	   Fractales fractal= new Fractales(9);
   }

}
