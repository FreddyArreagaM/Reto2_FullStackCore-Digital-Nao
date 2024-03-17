package view;

import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import controller.controller;

public class view {
    public static void main(String[] args) {

        //Creación del Frame que contendrá la vista 
        JFrame frame = new JFrame("API Google Scholar");
        //Creación del panel para insertar los componentes visuales
        JPanel panel = new JPanel();
        //Creación de bordes para mejorar la vista
        Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20); // Arriba, Izquierda, Abajo, Derecha margenes
        //Creación de instancia para conectar al controlador
        controller controllerInstance = new controller();   
        //Definición de la Tabla y sus headers
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Titulo", "Autor", "Resumen"}, 0);
        // Creación de Tabla 
        JTable table = new JTable(tableModel);
        //Creación de un Scroll para el panel
        JScrollPane scrollPanel = new JScrollPane(table);

        //Denificón de opciones del frame 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Definición de dimensiones
        frame.setSize(600, 800);

        //Definimos que la ventana no se pueda redimensionar
        frame.setResizable(false);

        //Aplicamos los bordes al panel para estructurar mejor los componentes visuales
        panel.setBorder(emptyBorder);

        //Definimos el valor del Label y su alineación
        JLabel labelCriterio = new JLabel("Escribe un criterio de búsqueda:");
        labelCriterio.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Creación del campo de texto JTextField
        JTextField criterioBusqueda = new JTextField(20);
       
        //Creación de un botón 
        JButton btnBuscar = new JButton("Buscar");

        //Agregamos al panel los componentes visuales
        panel.add(labelCriterio);
        panel.add(criterioBusqueda);
        panel.add(btnBuscar);
        panel.add(scrollPanel);

        //Agregamos le pnale con sus elementos al frame.
        frame.add(panel);
     
        //Accion Listener para detectar el cambio de estado del botón en este caso el click
        btnBuscar.addActionListener(e -> {
            //Denificón de clave para consumir en SearchAPI
            String apiKey = "3d6be67e2ca53c5d98397368a4a2b3587c4963d3e5c9f5126ad18f3efc83ef23";
            try {
                //Enviamos de parámetros necesarios al metodo para consumir información del API
                controllerInstance.fetchScholarData(apiKey, criterioBusqueda.getText(), tableModel);
            } catch (IOException | InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        //Indicamos que el frame pueda ser visible 
        frame.setVisible(true);
    }
}
