package es.gva.edu.iesjuandegaray.valenbiciapiv2;



import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.DriverManager;





public class ConexionBDD extends javax.swing.JFrame {

    private static Connection con; // Inicializar a null
    private static Statement stmt;  // Inicializar a null
    private static DatosJSon datosJSon;
    private static int numEstaciones = 3;

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "diego14marta";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/balenbicibd";


 
    public ConexionBDD() {
        initComponents();
        datosJSon = new DatosJSon (numEstaciones);
        jTextFieldNumEstaciones.setText ( "" + numEstaciones);
    }

    // ... (initComponents - No se necesitan cambios)


   
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNumEstaciones = new javax.swing.JLabel();
        jTextFieldNumEstaciones = new javax.swing.JTextField();
        jLabelDatos = new javax.swing.JLabel();
        jButtonObtenerDatosEstacion = new javax.swing.JButton();
        jLabelEstadoConexion = new javax.swing.JLabel();
        jButtonConectar = new javax.swing.JButton();
        jButtonAñadirBdd = new javax.swing.JButton();
        jLabelPrimeroObtenerDatos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonCerrarConexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNumEstaciones.setText("Introduce el número de estaciones a consultar:");

        jTextFieldNumEstaciones.setText("Num. estaciones");
        jTextFieldNumEstaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumEstacionesActionPerformed(evt);
            }
        });

        jLabelDatos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDatos.setForeground(new java.awt.Color(102, 0, 102));
        jLabelDatos.setText("Datos");

        jButtonObtenerDatosEstacion.setText("Obtener Datos de Estaciones");
        jButtonObtenerDatosEstacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonObtenerDatosEstacionMouseClicked(evt);
            }
        });
        jButtonObtenerDatosEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObtenerDatosEstacionActionPerformed(evt);
            }
        });

        jLabelEstadoConexion.setForeground(new java.awt.Color(0, 51, 153));
        jLabelEstadoConexion.setText("Estado Conexión");

        jButtonConectar.setForeground(new java.awt.Color(0, 102, 153));
        jButtonConectar.setText("Conectar");
        jButtonConectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConectarMouseClicked(evt);
            }
        });
        jButtonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectarActionPerformed(evt);
            }
        });

        jButtonAñadirBdd.setText("Añadir a BDD");
        jButtonAñadirBdd.setEnabled(false);
        jButtonAñadirBdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAñadirBddMouseClicked(evt);
            }
        });
        jButtonAñadirBdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirBddActionPerformed(evt);
            }
        });

        jLabelPrimeroObtenerDatos.setText("Primero Obtener Datos de Estaciones y Conectar con BDD");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonCerrarConexion.setForeground(javax.swing.UIManager.getDefaults().getColor("Component.error.focusedBorderColor"));
        jButtonCerrarConexion.setText("Cerrar conexión");
        jButtonCerrarConexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCerrarConexionMouseClicked(evt);
            }
        });
        jButtonCerrarConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarConexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabelNumEstaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumEstaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonConectar)
                            .addComponent(jButtonAñadirBdd)
                            .addComponent(jLabelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPrimeroObtenerDatos)
                            .addComponent(jLabelEstadoConexion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCerrarConexion)
                            .addComponent(jButtonObtenerDatosEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumEstaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumEstaciones))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDatos)
                    .addComponent(jButtonObtenerDatosEstacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstadoConexion)
                    .addComponent(jButtonConectar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAñadirBdd)
                    .addComponent(jLabelPrimeroObtenerDatos))
                .addGap(18, 18, 18)
                .addComponent(jButtonCerrarConexion)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButtonConectar.getAccessibleContext().setAccessibleName("jButtonConectar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNumEstacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumEstacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumEstacionesActionPerformed

    private void jButtonObtenerDatosEstacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonObtenerDatosEstacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonObtenerDatosEstacionMouseClicked

    private void jButtonObtenerDatosEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObtenerDatosEstacionActionPerformed
    try {
        int num = Integer.parseInt(jTextFieldNumEstaciones.getText().trim());
            numEstaciones = num;
            datosJSon = new DatosJSon(numEstaciones);
            datosJSon.mostrarDatos(numEstaciones); // Obtener datos
            jTextArea1.setText(datosJSon.getDatos()); // Mostrar datos
        } catch (NumberFormatException e) {
            jTextArea1.setText("Error: Introduce un número válido de estaciones.");
        } catch (Exception e) {
            jTextArea1.setText("Error al obtener datos de las estaciones.");
            e.printStackTrace(); // Mantener para el registro detallado
    }

    }//GEN-LAST:event_jButtonObtenerDatosEstacionActionPerformed

    private void jButtonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectarActionPerformed
    try {
         Class.forName(DB_DRIVER);
            con = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            jLabelEstadoConexion.setText("Conexión exitosa a la base de datos.");
            jButtonAñadirBdd.setEnabled(true);
        } catch (ClassNotFoundException e) {
            jLabelEstadoConexion.setText("Error: No se encontró el driver de la base de datos.");
            e.printStackTrace();
        } catch (SQLException e) {
            jLabelEstadoConexion.setText("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();


    }
    }//GEN-LAST:event_jButtonConectarActionPerformed

    private void jButtonConectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConectarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConectarMouseClicked

    private void jButtonAñadirBddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAñadirBddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAñadirBddMouseClicked

    private void jButtonAñadirBddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirBddActionPerformed
    try {
        if (datosJSon != null && con != null && !con.isClosed()) {
                stmt = con.createStatement(); // Inicializar statement
                String[] values = datosJSon.getValues();
                for (String value : values) {
                    if (value != null && !value.isEmpty()) {
                        String sql = "INSERT INTO historico (estacion_id, direccion, bicis_disponibles, anclajes_libres, estado_operativo, ubicacion) VALUES " + value;
                        stmt.executeUpdate(sql);
    }

    }//GEN-LAST:event_jButtonAñadirBddActionPerformed

                
                 jTextArea1.append("\nDatos de estaciones añadidos a la base de datos.");
            } else {
                jTextArea1.append("\nError: Primero obtén los datos y conéctate a la base de datos.");
            }
        } catch (SQLException e) {
            jTextArea1.append("\nError al añadir los datos a la base de datos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close(); // Cerrar statement en finally
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

                
    private void jButtonCerrarConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarConexionActionPerformed
    try {
         if (con != null && !con.isClosed()) {
                con.close();
                jLabelEstadoConexion.setText("Conexión a la base de datos cerrada.");
                jButtonAñadirBdd.setEnabled(false);
            } else {
                jLabelEstadoConexion.setText("La conexión ya está cerrada.");
            }
        } catch (SQLException e) {
            jLabelEstadoConexion.setText("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();

    }
    }//GEN-LAST:event_jButtonCerrarConexionActionPerformed

    private void jButtonCerrarConexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCerrarConexionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCerrarConexionMouseClicked

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ConexionBDD().setVisible(true));
    }

    // Variables declaration - do not modify


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadirBdd;
    private javax.swing.JButton jButtonCerrarConexion;
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JButton jButtonObtenerDatosEstacion;
    private javax.swing.JLabel jLabelDatos;
    private javax.swing.JLabel jLabelEstadoConexion;
    private javax.swing.JLabel jLabelNumEstaciones;
    private javax.swing.JLabel jLabelPrimeroObtenerDatos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldNumEstaciones;
    // End of variables declaration//GEN-END:variables
}








