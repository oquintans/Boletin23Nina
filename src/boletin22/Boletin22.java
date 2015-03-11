/*
 * Supoñer que queredes facer o mantemento dun ficheiro dunha librería .  Dos libros imos considerar 4 atributos :
 •	Nome do libro
 •	Autor
 •	Precio
 •	unidades

 Para facer o mantemento  utiliza un menú cos seguintes puntos :

 a)	engadir  engade un novo libro ao noso ficheiro
 b)	consultar dado o título dun libro visualizar o seu precio . se o libro non o temos na librería visualizamos unha mensaxe
 c)	visualizar visualiza todos os datos do ficheiro
 d)	borrar  borra os libros que teñan 0 unidades
 e)	modificar  modifica o precio dun libro determinado
 *       ordear por titulo do libro
 *       buscar libros dun autor

 */
package boletin22;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Boletin22 {

    public static void main(String[] args) {
        int opcion;
        ArrayList<Libro> biblio;
        File ficheiro = new File("Libros.txt");
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("1.Engadir un libro \n2.Consultar o prezo dun libro \n3.Ver todolos libros\n4.Borrar os libros con stock 0\n5.Modificar un prezo\n0.Sair"));
            switch (opcion) {
                case 1:
                    Metodos.engadir(ficheiro);
                    break;

                case 2:
                    Metodos.consultaLibro(Metodos.ler(ficheiro));
                    break;

                case 3:
                    Metodos.visualiza(Metodos.ler(ficheiro));
                    break;
                  
                case 4:
                    Metodos.engadirTodo(ficheiro,Metodos.borraLibro(Metodos.ler(ficheiro)));
                    Metodos.visualiza(Metodos.ler(ficheiro));
                    break;
                    
                case 5:
                    Metodos.engadirTodo(ficheiro,Metodos.ModificaPrezo(Metodos.ler(ficheiro)));
                    Metodos.visualiza(Metodos.ler(ficheiro));
                    
                    
                  
                default:break;      

            }



        } while (opcion != 0);





    }
}
