package cl.duoc.fullstack_back_users.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String correo;

    @Column(unique=false)
    private String contrasena;

    @Column(unique=false)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return correo;
    }

    public void setEmail( String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return contrasena;
    }

    public void setPassword(String contrasena) {
        this.contrasena = contrasena;
    }

}
