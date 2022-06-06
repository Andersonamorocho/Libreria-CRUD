package models.entity;

public class Prestamo {
    public int id;
    public int idcliente;
    public String nombrecliente;
    public int idlibro;
    public String nombrelibro;

    public Prestamo() {
    }

    public Prestamo(int idcliente, String nombrecliente, int idlibro, String nombrelibro) {
        this.idcliente = idcliente;
        this.nombrecliente = nombrecliente;
        this.idlibro = idlibro;
        this.nombrelibro = nombrelibro;
    }

    public Prestamo(int id, int idcliente, String nombrecliente, int idlibro, String nombrelibro) {
        this.id = id;
        this.idcliente = idcliente;
        this.nombrecliente = nombrecliente;
        this.idlibro = idlibro;
        this.nombrelibro = nombrelibro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombrelibro() {
        return nombrelibro;
    }

    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }
    
    
}
