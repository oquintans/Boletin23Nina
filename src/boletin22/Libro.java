
package boletin22;

public class Libro {
private String nome;
private String autor;
private float precio;
private int unidades;

public Libro(){
    }

public Libro(String nome,String autor,float precio,int unidades){
    this.nome=nome;
    this.autor=autor;
    this.precio=precio;
    this.unidades=unidades;
    
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String toString(){
        return nome +","+autor+","+precio+","+unidades;
    }
    public int compareTo(Object o) {//sobreescribo o metodo compare to para que sepa como ten que comparar o obxecto
        Libro l = (Libro) o;//fago cast por que recibo un obxecto tipo obxect-->teño que pasalo a miña clase (libro)
        //Non poño para recibir directamente como parametro o obxecto libro no método para non cambiar 
        // a sinatura da inteface
        if (this.nome.compareToIgnoreCase(l.nome) == 0) {
            return 0;
        } else if (this.nome.compareToIgnoreCase(l.nome) > 0) {
            return 1;
        } else {
            return -1;
        }

}
    
}
