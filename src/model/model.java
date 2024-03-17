package model;

public class model {

    //Creación de variables 
    private String titulo;
    private String autor;
    private String resumen;

    //Constructor con parámetros
    public model(String titulo, String autor, String resumen){
        this.titulo = titulo;
        this.autor = autor;
        this.resumen = resumen;
    }

    //Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }    
    
}
