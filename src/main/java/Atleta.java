import java.time.LocalDate;

/**
 * Created by dam on 19/1/17.
 */
public class Atleta {

    private long id;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private LocalDate nacimiento;

    public Atleta() {
    }

    public Atleta(long id, String nombre, String apellido, String nacionalidad, LocalDate nacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellido;
        this.nacionalidad = nacionalidad;
        this.nacimiento = nacimiento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellidos;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", nacimiento=" + nacimiento +
                '}';
    }


}
