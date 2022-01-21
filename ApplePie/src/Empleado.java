
public class Empleado {

    private String nombre;
    private int laborados;
    private int ID;
    private double salario;
    
    
    
    Empleado(String nombre, int laborados, double salario) {
        this.nombre = nombre;
        this.laborados = laborados;
        this.salario = salario;
    }

    public int getID() {
        return ID;
    }
    

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLaborados() {
        return laborados;
    }

    public void setLaborados(int laborados) {
        this.laborados = laborados;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
