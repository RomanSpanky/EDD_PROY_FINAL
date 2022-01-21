
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Registro {

    DecimalFormat df = new DecimalFormat("#.00");
    int registros = 0;
    int tamaño = 0;
    double[] arrayUtilidades1;
    double[] arrayUtilidades2;
    Empleado[] arrayObjetos;
    Empleado[] arrayOrden;

    public Registro(int tamaño) {
        arrayObjetos = new Empleado[tamaño];
        arrayUtilidades1 = new double[tamaño];
        arrayUtilidades2 = new double[tamaño];
        this.tamaño = tamaño;

    }

    public String buscaID(int BuscarID) {
        String ResultadoRegresar = "El empleado no ha sido encontrado";

        for (int i = 0; i < registros; i++) {
            if (arrayObjetos[i].getID() == BuscarID) {
                ResultadoRegresar = "ID\tNombre\tDias laborados\tSalario\tUtilidad 1\tUtilidad 2\n"
                        + arrayObjetos[i].getID() + "\t" + arrayObjetos[i].getNombre() + "\t" + arrayObjetos[i].getLaborados() + "\t"
                        + arrayObjetos[i].getSalario() + "\t" + df.format(arrayUtilidades1[i]) + "\t" + df.format(arrayUtilidades2[i]);

            }
        }
        return ResultadoRegresar;
    }

    public int getDiasLaborados() {
        int DiasTotales = 0;
        for (int i = 0; i < registros; i++) {
            DiasTotales += arrayObjetos[i].getLaborados();
        }
        return DiasTotales;
    }

    public double getSueldos() {
        double SueldosTotales = 0;
        for (int i = 0; i < registros; i++) {
            SueldosTotales += arrayObjetos[i].getSalario() * arrayObjetos[i].getLaborados();
        }
        return SueldosTotales;
    }

    public DefaultTableModel getTabla() {
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("ID");
        tabla.addColumn("Nombre");
        tabla.addColumn("Dias laborados");
        tabla.addColumn("Salario");
        tabla.addColumn("Utilidades 1");
        tabla.addColumn("Utilidades 2");
        Object[] renglon = new Object[6];
        double UtilidadesTotales = 0;
        for (int i = 0; i < registros; i++) {
            arrayUtilidades1[i] = 20000 / getDiasLaborados() * arrayObjetos[i].getLaborados();
            UtilidadesTotales += arrayUtilidades1[i];
        }
        for (int i = 0; i < registros; i++) {
            arrayUtilidades2[i] = UtilidadesTotales / getSueldos() * (arrayObjetos[i].getLaborados() * arrayObjetos[i].getSalario());
            UtilidadesTotales += arrayUtilidades1[i];
        }

        for (int i = 0; i < registros; i++) {
            renglon[0] = arrayObjetos[i].getID();
            renglon[1] = arrayObjetos[i].getNombre();
            renglon[2] = arrayObjetos[i].getLaborados();
            renglon[3] = arrayObjetos[i].getSalario();
            renglon[4] = df.format(arrayUtilidades1[i]);
            renglon[5] = df.format(arrayUtilidades2[i]);
            tabla.addRow(renglon);
        }
        return tabla;
    }

    public void AgrEmp() {

        //Se lee si está lleno, si no está lleno, agregamos
        if (registros < arrayObjetos.length) {
            //Indicar parámetros
            //Nombre y apellido
            String nombre = JOptionPane.showInputDialog("Escribe un nombre y apellido");
            //Antigüedad
            String texto = JOptionPane.showInputDialog("Escribe los dias laborados");
            int laborados = Integer.parseInt(texto);
            //Salario diario
            texto = JOptionPane.showInputDialog("Escribe el salario diario");
            double salario = Double.parseDouble(texto);
            arrayObjetos[registros] = new Empleado(nombre, laborados, salario);
            registros++;
            arrayObjetos[registros - 1].setID(registros);
        }

    }

    //Ordenar
    public void quickSort(int primero, int ultimo, boolean ascendente) {
        int i = primero, j = ultimo;
        int pivote = arrayObjetos[(primero + ultimo) / 2].getLaborados();
        Empleado auxiliar;
        do {
            if (ascendente) {
                while (arrayObjetos[i].getLaborados() < pivote) {
                    i++;
                }
                while (arrayObjetos[j].getLaborados() > pivote) {
                    j--;
                }
            } else {
                while (arrayObjetos[i].getLaborados() > pivote) {
                    i++;
                }
                while (arrayObjetos[j].getLaborados() < pivote) {
                    j--;
                }
            }
            if (i <= j) {
                auxiliar = arrayObjetos[i];
                arrayObjetos[i] = arrayObjetos[j];
                arrayObjetos[j] = auxiliar;
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            quickSort(primero, j, ascendente);
        }
        if (i < ultimo) {
            quickSort(i, ultimo, ascendente);
        }

    }
    public int getRegistros(){
        return registros;
    
    }
    
}
