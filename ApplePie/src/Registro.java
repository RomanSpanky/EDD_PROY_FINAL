
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Registro {
    DecimalFormat df = new DecimalFormat("#.00");
    int registros = 0;
    int tamaño = 0;
    double[] arrayUtilidades1;
    Empleado[] arrayObjetos;

    public Registro(int tamaño) {
        arrayObjetos = new Empleado[tamaño];
        arrayUtilidades1 = new double[tamaño];
        this.tamaño = tamaño;

    }
    public int getDiasLaborados(){
        int DiasTotales = 0;
        for (int i = 0; i < registros; i++) {
            DiasTotales += arrayObjetos[i].getLaborados();
        }
        return DiasTotales;
    }
    
     public double getSueldos(){
        double SueldosTotales = 0;
        for (int i = 0; i < registros; i++) {
            SueldosTotales += arrayObjetos[i].getSalario()*arrayObjetos[i].getLaborados();
        }
        return SueldosTotales;
     }
     
    public DefaultTableModel getTabla(){
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Nombre");
        tabla.addColumn("Dias laborados");
        tabla.addColumn("Salario");
        tabla.addColumn("Utilidades 1");
        tabla.addColumn("Utilidades 2");
        Object[] renglon = new Object[5];
        double UtilidadesTotales = 0;
        for (int i = 0; i < registros; i++) {
            arrayUtilidades1[i] = 20000/getDiasLaborados() * arrayObjetos[i].getLaborados();
            UtilidadesTotales += arrayUtilidades1[i];
        }
        

        for (int i = 0; i < registros; i++) {
            renglon [0] = arrayObjetos[i].getNombre();
            renglon [1] = arrayObjetos[i].getLaborados();
            renglon [2] = arrayObjetos[i].getSalario();
            renglon [3] = df.format(arrayUtilidades1[i]);
            renglon [4] = df.format(UtilidadesTotales/getSueldos() * (arrayObjetos[i].getLaborados() * arrayObjetos[i].getSalario()));
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
        }

    }


}
