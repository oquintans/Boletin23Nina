
package boletin22;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Metodos {

    public static void engadir(File ficheiro) {
        PrintWriter fich = null;//abre ficheiro (fluxo de escritura)
        FileWriter f = null;//posiciona ao final do archivo

        try {
            f = new FileWriter(ficheiro, true);
            fich = new PrintWriter(f);
            fich.println(pedirDatos());
        } catch (IOException ex) {
            System.out.println("erro de escritura: " + ex.getMessage());
        }
        if (f != null) {
            fich.close();
        }

    }

    public static void engadirTodo(File ficheiro, ArrayList<Libro> biblio) {
        PrintWriter fich = null;//abre ficheiro (fluxo de escritura)


        try {
            fich = new PrintWriter(ficheiro);
            for (int i = 0; i < biblio.size(); i++) {
                fich.println(biblio.get(i));
            }
        } catch (IOException ex) {
            System.out.println("erro de escritura: " + ex.getMessage());
        }
        if (fich != null) {
            fich.close();
        }

    }

    public static ArrayList<Libro> ler(File ficheiro) {
        Scanner sc = null;
        ArrayList<Libro> biblio = new ArrayList<Libro>();
        try {
            sc = new Scanner(ficheiro);
            while (sc.hasNext()) {
                String cadea = sc.nextLine();
                String[] datos = cadea.split(",");
                biblio.add(new Libro(datos[0], datos[1], Float.parseFloat(datos[2]), Integer.parseInt(datos[3])));
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "erro 7" + ex.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return biblio;
    }

    public static int consultaLibro(ArrayList<Libro> nomearray) {
        int posicion = -1;
        String nom = JOptionPane.showInputDialog("Introduce nome do libro que queres saber se está");
        Libro obx = new Libro(nom, null, 0, 0);//creo un obxecto para que poida ser comparado

        for (Libro i : nomearray) {
            if (i.compareTo(obx) == 0) {//teño o metodo compareTo sobreescrito para poder comparar por nome
                posicion = nomearray.indexOf(i);
            }
        }

        if (posicion == -1) {
            JOptionPane.showMessageDialog(null, "o Libro" + nom + " non está na lista");
        } else {
            JOptionPane.showMessageDialog(null, "o Libro " + nomearray.get(posicion) + " está na lista");

        }
        return posicion;
    }

    public static void visualiza(ArrayList<Libro> nomearray) {
        String ver = "";
        for (int i = 0; i < nomearray.size(); i++) {
            ver = ver+nomearray.get(i).toString() + "\n";
        }
        String cabeceira = "nome \tautor\tprecio\tunidades\n";
        JOptionPane.showMessageDialog(null, cabeceira + ver);
    }

    public static Libro pedirDatos() {
        String nom = JOptionPane.showInputDialog("Introduce nome do libro");
        String aut = JOptionPane.showInputDialog("Introduce autor");
        float prezo = Float.parseFloat(JOptionPane.showInputDialog("Introduce prezo"));
        int unidades = Integer.parseInt(JOptionPane.showInputDialog("Introduce stock"));
        return new Libro(nom, aut, prezo, unidades);


    }

    public static ArrayList<Libro> borraLibro(ArrayList<Libro> biblio) {
        ArrayList<Libro> aux = null;
        for (int i = 0; i < biblio.size(); i++) {
            if (biblio.get(i).getPrecio() != 0.0f) {
                aux.add(biblio.get(i));
            }
        }

        return aux;
    }
    public static ArrayList<Libro> ModificaPrezo(ArrayList<Libro> biblio){
        int posicion=Metodos.consultaLibro(biblio);
        float prezo=Integer.parseInt(JOptionPane.showInputDialog("Introduce o novo prezo"));
        biblio.get(posicion).setPrecio(prezo);
        JOptionPane.showMessageDialog(null,biblio.get(posicion));
        return biblio;
    }
    
    
    
}
