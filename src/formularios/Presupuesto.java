/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import baseDatos.tablaClientes;
import baseDatos.tablaVehiculos;
import baseDatos.tablaPresupuesto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**                     
 *
 * @author Carlos Aravena A
 */
public class Presupuesto extends javax.swing.JFrame {

    /**
     * Creates new form Presupuesto
     */
    MantenedorPer mp;
    private DefaultTableModel modelo;
    private int precio, cant, dias, resultado;
    private int opcion;
    String sql;
    String mensaje, menError;
    String rut_cliente, nom_cliente, pres_cliente;
    public Presupuesto(int opcion) {
        this.opcion=opcion;
        initComponents();
        titulos();
        tablaVehiculos();
        tablaPresupuesto();
    }
    public void tablaVehiculos() 
    {
        modelo = new DefaultTableModel();
        modelo.addColumn("Patente");
        modelo.addColumn("Tipo Vehículo");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Año");
        modelo.addColumn("Disponibilidad");
        modelo.addColumn("Precio $");
        try
        {
            tablaVehiculos mysql = new tablaVehiculos();
            java.sql.Connection cn = mysql.Conectar();
            sql = "select * from Vehiculos";
            java.sql.Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                Object[] registro = new Object[8];
                registro[0] = rs.getString("patente_veh");
                registro[1] = rs.getString("tipo_veh");
                registro[2] = rs.getString("marca_veh");
                registro[3] = rs.getString("modelo_veh");
                registro[4] = rs.getString("ano_veh");
                registro[5] = rs.getString("disponibilidad_veh");
                registro[6] = rs.getString("precio_veh");
                modelo.addRow(registro);
            }
            jTable1.setModel(modelo);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Error de Lectura de Datos");
        }
    }
    public void tablaPresupuesto()
    {
        modelo = new DefaultTableModel();
        modelo.addColumn("N° Presupuesto");
        modelo.addColumn("R.U.T");
        modelo.addColumn("Nombre Cliente");
        modelo.addColumn("Presupuesto");
        try
        {
            tablaPresupuesto mysql = new tablaPresupuesto();
            java.sql.Connection cn = mysql.Conectar();
            sql = "select * from Presupuesto";
            java.sql.Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                Object[] registro = new Object[4];
                registro[0] = rs.getString("id_presupuesto");
                registro[1] = rs.getString("rut_cliente");
                registro[2] = rs.getString("nom_cliente");
                registro[3] = rs.getString("pres_cliente");
                modelo.addRow(registro);
            }
            jTable2.setModel(modelo);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "Error de Lectura de Datos");
        }
    }
    public void titulos()
    {
        switch(opcion)
        {
            case 1: setTitle("Calcular Presupuesto");
        }
    }
    public void validaciones()
    {
        if(this.jtfPrecioVehiculo.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                    "Debes Ingresar Precio",
                    "ERROR DE INGRESO",
                    JOptionPane.ERROR_MESSAGE);
            this.jtfPrecioVehiculo.requestFocus();
            return;
        }
        if(this.jtfCantVehiculos.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this,
                    "Debes Ingresar Cantidad Vehiculos",
                    "ERROR DE INGRESO",
                    JOptionPane.ERROR_MESSAGE);
            this.jtfCantVehiculos.requestFocus();
            return;
        }
        if(this.jtfDiasArriendo.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(this, 
                    "Debes Ingresar Dias de Arriendo",
                    "ERROR DE INGRESO",
                    JOptionPane.ERROR_MESSAGE);
            this.jtfDiasArriendo.requestFocus();
            return;
        }
    }
    public void limpiarCampos()
    {
        jtfPrecioVehiculo.setText("");
        jtfCantVehiculos.setText("");
        jtfDiasArriendo.setText("");
        jtfTotal.setText("");
        jtfNomCliente.setText("");
        jtfRut.requestFocus();
    }
    public void calcular()
    {
        precio = Integer.parseInt(jtfPrecioVehiculo.getText());
        cant = Integer.parseInt(jtfCantVehiculos.getText());
        dias = Integer.parseInt(jtfDiasArriendo.getText());
        resultado = precio*cant*dias;
        jtfTotal.setText(""+resultado);
    }
    public void habilitarPanel()
    {
        jtfPrecioVehiculo.setEnabled(true);
        jtfCantVehiculos.setEnabled(true);
        jtfDiasArriendo.setEnabled(true);
    }
    public void deshabilitarPanel()
    {
        jtfRut.setText("");
        jtfRut.requestFocus();
        jtfPrecioVehiculo.setEnabled(false);
        jtfCantVehiculos.setEnabled(false);
        jtfDiasArriendo.setEnabled(false);
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
        jtfRut = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbtBuscar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfCantVehiculos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfDiasArriendo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfPrecioVehiculo = new javax.swing.JTextField();
        jbtCalcularPresupuesto = new javax.swing.JButton();
        jbtAnadirTabla = new javax.swing.JButton();
        jbtLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jtfNomCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Presupuesto:"));

        jLabel1.setText("Ingresar R.U.T.");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Calcular Presupuesto"));

        jLabel2.setText("Cantidad:");

        jtfCantVehiculos.setEnabled(false);

        jLabel3.setText("Dias de Arriendo:");

        jtfDiasArriendo.setEnabled(false);

        jLabel4.setText(" Precio $:");

        jtfPrecioVehiculo.setEnabled(false);

        jbtCalcularPresupuesto.setText("Calcular Presupuesto");
        jbtCalcularPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCalcularPresupuestoActionPerformed(evt);
            }
        });

        jbtAnadirTabla.setText("Añadir en Tabla Presupuesto");
        jbtAnadirTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAnadirTablaActionPerformed(evt);
            }
        });

        jbtLimpiar.setText("Limpiar");
        jbtLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLimpiarActionPerformed(evt);
            }
        });

        jLabel5.setText("Total:");

        jtfTotal.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbtAnadirTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtCalcularPresupuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jtfPrecioVehiculo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfCantVehiculos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfDiasArriendo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfPrecioVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfCantVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfDiasArriendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCalcularPresupuesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtAnadirTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtLimpiar)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabla Precios:"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Patente", "Tipo Vehículo", "Marca", "Modelo", "Año", "Disponibilidad", "Precio $"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Presupuestos:"));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N° Prespuesto", "RUT", "Nombre Cliente", "Presupuesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel6.setText("Nombre:");

        jtfNomCliente.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfRut, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtCancelar))
                            .addComponent(jLabel1))
                        .addComponent(jtfNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtBuscar)
                            .addComponent(jbtCancelar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfNomCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(909, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCalcularPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCalcularPresupuestoActionPerformed
        // TODO add your handling code here:
        calcular();
    }//GEN-LAST:event_jbtCalcularPresupuestoActionPerformed

    private void jbtLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_jbtLimpiarActionPerformed

    private void jbtAnadirTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAnadirTablaActionPerformed
        // TODO add your handling code here:
        opcion = 0;
        opcion = JOptionPane.showConfirmDialog(this,
                "¿Añadir Presupuesto a la Lista?",
                "GUARDAR DATOS",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(opcion == JOptionPane.YES_OPTION)
        {
            validaciones();
            
            mensaje = "Datos Añadidos Correctamente";
            menError = "Error al Añadir Datos";
            
            rut_cliente = jtfRut.getText();
            nom_cliente = jtfNomCliente.getText();
            pres_cliente = jtfTotal.getText();
        
            tablaPresupuesto mysql = new tablaPresupuesto();
            java.sql.Connection cn = mysql.Conectar();
            sql = "insert into Presupuesto (rut_cliente, nom_cliente, pres_cliente) values(?,?,?)";
        
            try
            {
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, rut_cliente);
                pst.setString(2, nom_cliente);
                pst.setString(3, pres_cliente);
                int n = pst.executeUpdate();
                JOptionPane.showMessageDialog(null,
                    mensaje);
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(this,
                    "Presupuesto Existente",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            }
            cerrarVentana();
        }
        else
        {
            cerrarVentana();
            limpiarCampos();
        }
    }//GEN-LAST:event_jbtAnadirTablaActionPerformed

    private void jbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscarActionPerformed
        // TODO add your handling code here:
        if((this.jtfRut.getText().trim().isEmpty()))
        {
            JOptionPane.showMessageDialog(this,
                    "Debes Ingresar RUT",
                    "ERROR DE INGRESO",
                    JOptionPane.ERROR_MESSAGE);
            this.jtfRut.requestFocus();
            return;
        }
        rut_cliente = jtfRut.getText();
        confirmaRut();
        tablaPresupuesto mysql = new tablaPresupuesto();
        java.sql.Connection cn = mysql.Conectar();
        sql = "select * from Clientes where rut_cliente='"+rut_cliente+"';";
        try
        {
            java.sql.Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
                switch (opcion)
                {
                    case 1: JOptionPane.showMessageDialog(null,
                            "El RUT ingresado ya existe");
                        cerrarVentana();
                        break;
                        
                    case 2: jtfNomCliente.setText(rs.getString(3));
                        break;
                }
            }
            else
            {
                switch(opcion)
                {
                    case 1: jtfNomCliente.requestFocus();
                        break;
                    case 2: JOptionPane.showMessageDialog(null, "El RUT Ingresado No Existe");
                        cerrarVentana();
                }
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,
                    "ERROR de Lectura de Datos");
        }
    }//GEN-LAST:event_jbtBuscarActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        // TODO add your handling code here:
        deshabilitarPanel();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    public void cerrarVentana()
    {
        this.setVisible(false);
        mp = new MantenedorPer();
        mp.setVisible(true);
    }
    private boolean validarRut()
    {
        boolean valido = true;        
        int suma = 0;
        int pond = 2;
        int resto = 0;
        int valor = 0;
        String digito = "";
        int largo = 0;
        
        largo = this.jtfRut.getText().trim().length() - 2;
        
        for(int i=largo-1; i>-1; i--)
        {
            suma = suma + 
            (Integer.parseInt(""+this.jtfRut.getText().trim().charAt(i)) * pond);
            pond++;
            if(pond > 7)
            {
                pond = 2;
            }
        }
        resto = suma % 11;
        valor = 11 - resto;
        if(valor == 10)
        {
            digito = "K";
        }
        else if(valor == 11)
        {
            digito = "0";
        }
        else
        {
            digito = "" + valor;
        }
        
        if(digito.charAt(0) != 
                this.jtfRut.getText().trim().charAt(largo+1))
        {
            valido = false;
        }
        
        return valido;
    }
    private void confirmaRut()
    {
        if(this.validarRut() == false)
        {
            JOptionPane.showMessageDialog(this,
                    "RUT Invalido",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            jtfRut.setText("");
            jtfRut.requestFocus();
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    "RUT Valido");
            habilitarPanel();
        }
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
            java.util.logging.Logger.getLogger(Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Presupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenedorPer().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbtAnadirTabla;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtCalcularPresupuesto;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtLimpiar;
    private javax.swing.JTextField jtfCantVehiculos;
    private javax.swing.JTextField jtfDiasArriendo;
    private javax.swing.JTextField jtfNomCliente;
    private javax.swing.JTextField jtfPrecioVehiculo;
    private javax.swing.JTextField jtfRut;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables
}
