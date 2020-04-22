//Autor: Estefania Jimenez Garcia A01635062
//Clase: Laberinto.java
//Fecha: 13 de Enero del 2020
//Comentarios: Los agrege adentro del codigo
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Laberinto {
	private Point inicio,
					fin;
	private boolean[][] laberinto;
	private boolean[][][] pasado;
	public Laberinto(String ruta) {
  	// Ruta = "C:/Documents/labirynth.txt"
		// Leer archivo
    Scanner input;
    try {
      input = new Scanner(new File(ruta));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return;
    }
    int counter = 0;
    String ini = input.nextLine();
    String[] iniSplit = ini.split(" ", 2);
    int x = Integer.parseInt(iniSplit[0]);
    int y = Integer.parseInt(iniSplit[1]);
    this.inicio = new Point(x, y);
    //System.out.println(this.inicio);
    
    String fini = input.nextLine();
    String[] finiSplit = fini.split(" ", 2);
    x = Integer.parseInt(finiSplit[0]);
    y = Integer.parseInt(finiSplit[1]);
    this.fin = new Point(x, y);
    //System.out.println(this.fin);
    
    String nxm=input.nextLine();
    String[] nxmSplit = nxm.split(" ", 2);
    int fila = Integer.parseInt(nxmSplit[0]);
    int columna= Integer.parseInt(nxmSplit[1]);
    this.laberinto = new boolean[fila][columna];
    this.pasado = new boolean[fila][columna][2];
    
    // Inicializar matrices
    for (int i = 0; i < fila; i++){
      String[] numSplit = input.nextLine().split("",columna);
      for (int j = 0; j < columna; j++){
        this.pasado[i][j][0] = false;
        this.pasado[i][j][1] = false;
        int numero = Integer.parseInt(numSplit[j]);
        if (numero == 0){
          this.laberinto[i][j] = false;
        }else{
          this.laberinto[i][j] = true;
        }
      }
    }
    
    // Mandamos a llamar la funcion buscar desde el inicio
    Buscar(this.inicio.x, this.inicio.y);
    
    // Escribir archivo
    try {
        FileWriter salida = new FileWriter("C:\\Users\\Estefania Jimenez\\Documents/salida.txt");
        int n = this.laberinto.length;
      	//System.out.println(n);
        int m = this.laberinto[0].length;
      	//System.out.println(m);
        for(int i=0; i<n; i++) {
          //System.out.println(i);
        	for (int j=0;j<m;j++) {
            if(i == this.inicio.x && j == this.inicio.y){
              salida.write("I");
            }else if(i == this.fin.x && j == this.fin.y){
              salida.write("F");
            } else if(this.pasado[i][j][1]==true) {
        			salida.write("Y");
        		}else if(this.pasado[i][j][0]==true) {
        			salida.write("X");
            }else if(this.laberinto[i][j]==true){
              salida.write("P");
        		}else {
        			salida.write(" ");
        		}
            if (j < m-1){
            	salida.write(",");  
            }
        	}
          salida.write("\n");
        }
        
        salida.close();
        //System.out.println("Se escribio en archivo");
      } catch (IOException e) {
        System.out.println("Ocurrio un error al momento de escribir en el archivo");
        e.printStackTrace();
      }
   }

	
	private boolean Buscar(int x, int y ) {
		// Checar los cuadros alrededor de la coordenada
    //  - - - j
    // |- x -
    // |x 0 x
    // |- x -
    // i
    this.pasado[x][y][0] = true; //Marcar visitado
    if(this.fin.x==x && this.fin.y==y){ //Revisar que sea la celda final
      this.pasado[x][y][1] = true;
      this.pasado[this.inicio.x][this.inicio.y][1] = true;
      return true;
    }
    if (validar(x,y+1) == true){ //derecha
      this.pasado[x][y+1][1] = true;
      return true;
    }
    if( validar(x+1,y)== true){//abajo
      this.pasado[x+1][y][1] = true;
      return true;
    }
    if(validar(x,y-1)==true){//izquierda
      this.pasado[x][y-1][1] = true;
      return true;
    }
    if(validar(x-1,y)==true){//arriba
      this.pasado[x-1][y][1] = true;
      return true;
    }
    return false;
    
	}
	private boolean validar(int x, int y) {
    int n = this.laberinto.length;
    int m = this.laberinto[0].length;
    if( x>=0 && x<n ){ //Checar que no se pasa en las filas
      if(y>=0 && y<m){ // Checar que no se pase en columnas
        if(this.laberinto[x][y]==false){ // Revisar si es camino libre
          if(this.pasado[x][y][0]==false){ // Revisar si no esta en el pasado
            return Buscar(x,y);
          }
        }
    	}
    }
    return false;
	}
	public static void main(String[] args) {
  	Laberinto lab = new Laberinto("C:\\Users\\Estefania Jimenez\\Documents/EjemploEntrada2.txt");
	}
}