/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import baseDatos.tablaClientes;
import baseDatos.tablaVehiculos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Aravena A
 */
public class DatosVehiculo extends javax.swing.JFrame {

    /**
     * Creates new form DatosVehiculo
     */
    char c;
    Vehiculo veh;
    private int opcion; 
    String patente_veh, tipo_veh, marca_veh, modelo_veh, ano_veh, disponibilidad_veh,
            precio_veh;
    String sql;
    String mensaje, menError;
    public DatosVehiculo(int opcion) {
        this.opcion = opcion;
        initComponents();
        titulos();
    }
    public void titulos()
    {
        switch(opcion)
        {
            case 1://Titulo Agregar
                setTitle("Agregar Vehículos");
                break;
            case 2://Titulo Modificar
                setTitle("Modificar Vehículos");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfPatente = new javax.swing.JTextField();
        jbtBuscar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jbtVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfVehiculo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfModelo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfAno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfDisponibilidad = new javax.swing.JTextField();
        jbtAnadirLista = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Vehiculo:"));

        jbtBuscar.setText("Buscar");
        jbtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscarActionPerformed(evt);
            }
        });

        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtVolver.setText("Volver");
        jbtVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVolverActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingresar Patente");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Vehiculo:"));

        jLabel2.setText("Tipo Vehiculo:");

        jtfVehiculo.setEnabled(false);

        jLabel3.setText("Marca:");

        jtfModelo.setEnabled(false);
        jtfModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfModeloKeyTyped(evt);
            }
        });

        jLabel4.setText("Modelo:");

        jtfMarca.setEnabled(false);
        jtfMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMarcaKeyTyped(evt);
            }
        });

        jLabel5.setText("Año:");

        jtfAno.setEnabled(false);
        jtfAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAnoKeyTyped(evt);
            }
        });

        jLabel6.setText("Disponibilidad:");

        jtfDisponibilidad.setEnabled(false);
        jtfDisponibilidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDisponibilidadKeyTyped(evt);
            }
        });

        jbtAnadirLista.setText("Añadir Lista de Vehiculo");
        jbtAnadirLista.setEnabled(false);
        jbtAnadirLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAnadirListaActionPerformed(evt);
            }
        });

        jLabel7.setText("Precio:");

        jtfPrecio.setEnabled(false);
        jtfPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPrecioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtAnadirLista, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(53, 53, 53)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jtfDisponibilidad)
                            .addComponent(jtfAno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfPrecio, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfVehiculo)
                            .addComponent(jtfModelo))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(26, 26, 26)
                .addComponent(jbtAnadirLista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfPatente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBuscar)
                    .addComponent(jbtCancelar)
                    .addComponent(jbtVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(423, 477));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void cerrarVentana()
    {
        this.setVisible(false);
        veh = new Vehiculo();
        veh.setVisible(true);
    }
    private void jbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscarActionPerformed
        // TODO add your handling code here:
        if(this.jtfPatente.getText().trim().isEmpty())
        {
             JOptionPane.showMessageDialog(this,
              "Error Ingresar Patente",
              "ERROR",
              JOptionPane.ERROR_MESSAGE);
             this.jtfPatente.requestFocus();
             return;
        }
        patente_veh = jtfPatente.getText();
        tablaVehiculos mysql = new tablaVehiculos();
        java.sql.Connection cn = mysql.Conectar();
        sql = "select * from Vehiculos where patente_veh='"+patente_veh+"';";
        try
        {
            java.sql.Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
                switch(opcion)
                {
                    case 1://Agregar
                        JOptionPane.showMessageDialog(null,
                                "Patente Existente");
                        cerrarVentana();
                        break;
                    case 2://Modificar
                        jtfVehiculo.setText(rs.getString(3));
                        jtfMarca.setText(rs.getString(4));
                        jtfModelo.setText(rs.getString(5));
                        jtfAno.setText(rs.getString(6));
                        jtfDisponibilidad.setText(rs.getString(7));
                        jtfPrecio.setText(rs.getString(8));
                        break;
                }
            }
            else
            {
                switch(opcion)
                {
                    case 1://Agregar
                        jtfVehiculo.requestFocus();
                        break;
                    case 2://Modificar
                        JOptionPane.showMessageDialog(null,
                                "Patente No Existe");
                        cerrarVentana();
                        break;
                }
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Error de Lectura de Datos");
        }
    }//GEN-LAST:event_jbtBuscarActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        // TODO add your handling code here:
        opcion = 0;
        opcion = JOptionPane.showConfirmDialog(this,
                "¿Cancelar Operación?",
                "CANCELAR",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(opcion == JOptionPane.YES_OPTION)
        {
            cancelar();
        }
    }//GEN-LAST:event_jbtCancelarActionPerformed
    public void cancelar()
    {
        jtfVehiculo.setEnabled(false);
        jtfModelo.setEnabled(false);
        jtfMarca.setEnabled(false);
        jtfAno.setEnabled(false);
        jtfDisponibilidad.setEnabled(false);
        jtfPrecio.setEnabled(false);
        limpiar();
    }
    public void limpiar()
    {
        jtfVehiculo.setText("");
        jtfModelo.setText("");
        jtfMarca.setText("");
        jtfAno.setText("");
        jtfDisponibilidad.setText("");
        jtfPrecio.setText("");
        jtfPatente.setText("");
        jtfPatente.requestFocus();
        
    }
    public void Habilitar()
    {
        jtfVehiculo.setEnabled(true);
        jtfModelo.setEnabled(true);
        jtfMarca.setEnabled(true);
        jtfAno.setEnabled(true);
        jtfDisponibilidad.setEnabled(true);
        jtfPrecio.setEnabled(true);
        
    }
    public void validarCampos()
    {
        
    }
    private void jbtAnadirListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAnadirListaActionPerformed
        // TODO add your handling code here:
        switch(opcion)
        {
            case 1://Ingreso
                        //Validar Campos:
                        validarCampos();
                        //Crear Mensajes
                        mensaje = "Vehículo Registrado Exitosamente";
                        menError = "Vehiculo Existente en la Base de Datos";
                        //Lectura de datos desde el formulario
                        patente_veh = jtfPatente.getText();
                        tipo_veh = jtfVehiculo.getText();
                        marca_veh = jtfMarca.getText();
                        modelo_veh = jtfModelo.getText();
                        ano_veh = jtfAno.getText();
                        disponibilidad_veh = jtfDisponibilidad.getText();
                        precio_veh = jtfPrecio.getText();
                        //Abrir Conexión Base de Datos:
                        tablaVehiculos mysqling = new tablaVehiculos();
                        java.sql.Connection cning = mysqling.Conectar();
                        //Escribir Consulta MySQL
                        sql = "insert into Vehiculos (patente_veh, tipo_veh, marca_veh,"
                                + " modelo_veh, ano_veh,"
                                + " disponibilidad_veh, precio_veh) values (?,?,?,?,?,?,?)";
                        //Ejecutar la consulta llenando los parametros con los valores capturados:
                        try
                        {
                            PreparedStatement pst= cning.prepareStatement(sql);
                            pst.setString(1, patente_veh);
                            pst.setString(2, tipo_veh);
                            pst.setString(3, marca_veh);
                            pst.setString(4, modelo_veh);
                            pst.setString(5, ano_veh);
                            pst.setString(6, disponibilidad_veh);
                            pst.setString(7, precio_veh);
                            int n = pst.executeUpdate();
                            opcion = 0;
                            opcion = JOptionPane.showConfirmDialog(this,
                                    "¿Guardar Datos?",
                                    "GUARDAR",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE);
                            if(opcion == JOptionPane.YES_OPTION)
                            {
                                JOptionPane.showMessageDialog(null, mensaje);
                            }
                            else
                            {
                                limpiar();
                            }
                            cerrarVentana();
                            break;
                        }
                        catch(SQLException ex)
                        {
                            JOptionPane.showMessageDialog(this,
                            "Cliente ya Existe",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                        }
                break;
                
            case 2://Modificar 
                        //Crear Mensajes
                        //mensaje = "Cliente Actualizado Correctamente";
                        //menError = "Cliente Existente en la Base de Datos";
                        //Lectura de datos desde el formulario
                        tipo_veh = jtfVehiculo.getText();
                        marca_veh = jtfMarca.getText();
                        modelo_veh = jtfModelo.getText();
                        ano_veh = jtfAno.getText();
                        disponibilidad_veh = jtfDisponibilidad.getText();
                        precio_veh = jtfPrecio.getText();
                        //Abrir Conexión Base de Datos:
                        tablaClientes update = new tablaClientes();
                        java.sql.Connection cnup = update.Conectar();
                        //Escribir Consulta MySQL
                        sql = "select * from Vehiculos where patente_veh = '"+patente_veh+"';";
                        //Ejecutar la consulta llenando los parametros con los valores capturados:
                        try
                        {
                            java.sql.Statement st =cnup.createStatement();
                            ResultSet rs = st.executeQuery(sql);
                            if(rs.next())
                            {
                                int id_veh = rs.getInt(1);
                                System.out.println("ID = "+id_veh);
                                sql = "update Vehiculos set patente_veh = '"+patente_veh+"'"
                                        + "where id_cliente = '"+id_veh+"';";
                                opcion = 0;
                                opcion = JOptionPane.showConfirmDialog(this,
                                        "¿Actualizar Datos?",
                                        "ACTUALIZAR",
                                        JOptionPane.YES_NO_OPTION,
                                        JOptionPane.QUESTION_MESSAGE);
                                if(opcion == JOptionPane.YES_OPTION)
                                {
                                    cerrarVentana();
                                }
                                else
                                {
                                    limpiar();
                                }
                            }
                            return;
                        }
                        catch(SQLException ex)
                        {
                            JOptionPane.showMessageDialog(this,
                            "Cliente No Existe",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                        }
                break;
        }
        
    }//GEN-LAST:event_jbtAnadirListaActionPerformed

    private void jtfPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPrecioKeyTyped
        // TODO add your handling code here:
        c = evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_jtfPrecioKeyTyped

    private void jtfDisponibilidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDisponibilidadKeyTyped
        // TODO add your handling code here:
        c = evt.getKeyChar();
        if(Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_jtfDisponibilidadKeyTyped

    private void jtfAnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAnoKeyTyped
        // TODO add your handling code here:
        c = evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_jtfAnoKeyTyped

    private void jtfMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMarcaKeyTyped
        // TODO add your handling code here:
        c = evt.getKeyChar();
        if(Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_jtfMarcaKeyTyped

    private void jtfModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfModeloKeyTyped
        // TODO add your handling code here:
        c = evt.getKeyChar();
        if(Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_jtfModeloKeyTyped

    private void jbtVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVolverActionPerformed
        // TODO add your handling code here:
        opcion=0;
        opcion=JOptionPane.showConfirmDialog(this, 
                "¿Desea Volver?",
                "VOLVER",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(opcion == JOptionPane.YES_OPTION)
        {
            Volver();
        }
    }//GEN-LAST:event_jbtVolverActionPerformed
    public void Volver()
    {
          jtfPatente.setText("");
          jtfVehiculo.setText("");
          jtfMarca.setText("");
          jtfModelo.setText("");
          jtfAno.setText("");
          jtfDisponibilidad.setText("");
          jtfPrecio.setText("");
          this.setVisible(false);
          veh=new Vehiculo();
          veh.setVisible(true);
                  
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatosVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vehiculo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtAnadirLista;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtVolver;
    private javax.swing.JTextField jtfAno;
    private javax.swing.JTextField jtfDisponibilidad;
    private javax.swing.JTextField jtfMarca;
    private javax.swing.JTextField jtfModelo;
    private javax.swing.JTextField jtfPatente;
    private javax.swing.JTextField jtfPrecio;
    private javax.swing.JTextField jtfVehiculo;
    // End of variables declaration//GEN-END:variables
}
