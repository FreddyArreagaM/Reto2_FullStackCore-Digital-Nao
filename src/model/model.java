package model;

public class model {
    private String titulo;
    private String autor;
    private int year;

    //Constructor con parámetros
    public model(String titulo, String autor, int year){
        this.titulo = titulo;
        this.autor = autor;
        this.year = year;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
