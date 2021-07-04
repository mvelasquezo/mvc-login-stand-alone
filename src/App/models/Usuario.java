package App.models;

public class Usuario {
    
    private int idUsuario;
    private String codUsuario;
    private String nombre;
    private String apellidos;
    private String contrasenya;
    private boolean estado;

    public Usuario(int idUsuario, String codUsuario, String nombre, String apellidos, String contrasenya, boolean estado) {
        setIdUsuario(idUsuario);
        setCodUsuario(codUsuario);
        setNombre(nombre);
        setApellidos(apellidos);
        setContrasenya(contrasenya);
        setEstado(estado);
    }
    
    public Usuario() {
        this( 0, "", "", "", "", false );
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String toString() {
        return "{ " + idUsuario + ": " + codUsuario + ", " + nombre  + " " + apellidos + ", " + contrasenya + " }";
    }
}