package com.revol.sistematransporte;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.revol.vehiculo.Taxi;
import com.revol.vehiculo.Taxi_CRUD;

public class Principal {
    public static void main(String args[]) throws SQLException {
        int opc,anio;
        String modelo,marca,placa;
        Taxi_CRUD tx_crud = new Taxi_CRUD();
        Taxi tx = new Taxi("", "", "", 0);
        do{
            do{
                JOptionPane.showMessageDialog(null, "Bienvenido al sistema de transporte Neiva");
                opc = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE UNA DE LAS SIGUIENTES OPCIONES:\n1. REGISTAR VEHÍCULO\n2. ACTUALIZAR VEHÍCULO\n3. BORRAR VEHÍCULO\n4. OBTENER VEHÍCULO\n5. SALIR \n"));
            }while(!(opc>0 & opc<=5));
             switch(opc){
                case 1:
                    JOptionPane.showMessageDialog(null, "Digite los siguientes datos para el registro de vehículos");
                    modelo = JOptionPane.showInputDialog(null, "Modelo del vehículo");
                    marca = JOptionPane.showInputDialog(null, "Marca del vehículo");
                    placa = JOptionPane.showInputDialog(null, "Placa del vehículo");
                    anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Año del vehículo"));
                    tx = new Taxi(modelo, marca, placa, anio);
                    tx_crud.agregar(tx);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Digite el modelo por el caul quiere actualizar");
                    modelo = JOptionPane.showInputDialog(null, "Modelo del vehículo");
                    tx_crud.editar_modelo(tx, modelo);
                    JOptionPane.showMessageDialog(null, "Vehículo actualizado");
                    break;
                case 3:
                    placa = JOptionPane.showInputDialog(null, "Placa del vehículo a eliminar");
                    tx = new Taxi("", "", placa, 0);
                    tx_crud.eliminar(tx);
                    JOptionPane.showMessageDialog(null, "Vehículo eliminado");
                    break;
                case 4:
                    placa = JOptionPane.showInputDialog(null, "Placa del vehículo a buscar");
                    tx = new Taxi("", "", placa, 0);
                    tx_crud.obtener(tx);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "FIN DEL PROGRAMA");
                    break;
             }
        }while(!(opc==5));
    }
}