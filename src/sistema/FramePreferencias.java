/*
 * FramePreferencias.java
 *  Ventana para configuracion de preferencias del usuario sobre el sistema
 * Parte de proyecto: SADAA
 * Author: Pedro Cardoso Rodriguez
 * Mail: ingpedro@live.com
 * Place: Zacatecas Mexico
 * 
    Copyright © 2010 Pedro Cardoso Rodriguez

    SADAA is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or any 
    later version.

    SADAA is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with SADAA.  If not, see <http://www.gnu.org/licenses/>
 */

package sistema;

import database.Actualiza;
import database.Consultas;
import definiciones.TipoMensaje;
import javax.swing.ImageIcon;

/** Ventana interna (JInternalFrame) para dar opcion de configuara preferencias del sistema
 *  como estilo, recordatorios automaticos
 * 
 * @author Pedro Cardoso Rodríguez
 */
public class FramePreferencias extends sistema.ModeloFrameInterno{
    
    /** Crea una nueva FramePreferencias
     * @param ventana Referencia a la ventana principal contenedora (clase sistema.FramePrincipal)
     */
    public FramePreferencias(sistema.FramePrincipal ventana){
        super(ventana,"aplicacion.png");
        initComponents();
        String[] prefs=cargaParams();
        if(prefs!=null){            
            rbtnEstMetal.setSelected(getPrincipalVnt().isUndecorated()); // estilo metal
            rbtnEstSO.setSelected(!getPrincipalVnt().isUndecorated()); // estilo SO
            chkMuestraVA.setSelected(prefs[0].equals("true")); // mostrar avisos al iniciar
            chkMuestraSA.setSelected(prefs[1].equals("true")); // mostrar asesorias al iniciar
            jcbDiasSesA.setEnabled(chkMuestraSA.isSelected()&&chkMuestraSA.isEnabled());
            jcbDiasSesA.setSelectedItem(prefs[2]); // dias siguientes asesorias
            chkMuestraCL.setSelected(prefs[3].equals("true")); // mostrar clases al iniciar
            jcbDiasSesC.setEnabled(chkMuestraCL.isSelected()&&chkMuestraCL.isEnabled());
            jcbDiasSesC.setSelectedItem(prefs[4]); // dias siguientes clases
        }
        prefs=getPrincipalVnt().cargaPrefEst();
        if(prefs!=null&&!prefs[5].equals("")){
            if((new java.io.File(prefs[5])).isFile()){
                txtDirLogo.setText(prefs[5]);
                ImageIcon imagen = new javax.swing.ImageIcon((new java.io.File(prefs[5])).getPath());
                imagen.setImage(imagen.getImage().getScaledInstance(61,61,java.awt.Image.SCALE_DEFAULT));
                lblLogo.setIcon(imagen);
            }
        }
        setCambios(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtnGrpEstVents = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        rbtnEstMetal = new javax.swing.JRadioButton();
        rbtnEstSO = new javax.swing.JRadioButton();
        btnAceptar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        chkMuestraVA = new javax.swing.JCheckBox();
        chkMuestraSA = new javax.swing.JCheckBox();
        chkMuestraCL = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jcbDiasSesA = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbDiasSesC = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtDirLogo = new javax.swing.JTextField();
        lblLogo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setTitle("Preferencias");

        jLabel1.setText("Estilo de las ventanas");

        rbtnGrpEstVents.add(rbtnEstMetal);
        rbtnEstMetal.setText("Metal");
        rbtnEstMetal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnEstMetalItemStateChanged(evt);
            }
        });

        rbtnGrpEstVents.add(rbtnEstSO);
        rbtnEstSO.setText("Sistema operativo");
        rbtnEstSO.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnEstSOItemStateChanged(evt);
            }
        });

        btnAceptar.setMnemonic('G');
        btnAceptar.setText("Guardar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel2.setText("Ventana de avisos");

        chkMuestraVA.setText("Mostrar ventana de avisos al iniciar el sistema");
        chkMuestraVA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMuestraVAItemStateChanged(evt);
            }
        });

        chkMuestraSA.setText("Alertar sobre sesiones de asesoría programadas para hoy");
        chkMuestraSA.setEnabled(false);
        chkMuestraSA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMuestraSAItemStateChanged(evt);
            }
        });

        chkMuestraCL.setText("Alertar sobre clases programadas para hoy ");
        chkMuestraCL.setEnabled(false);
        chkMuestraCL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkMuestraCLItemStateChanged(evt);
            }
        });

        jLabel3.setText("y para los siguientes:");

        jcbDiasSesA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        jcbDiasSesA.setEnabled(false);
        jcbDiasSesA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbDiasSesAItemStateChanged(evt);
            }
        });

        jLabel4.setText("días");

        jLabel5.setText("y para los siguientes: ");

        jcbDiasSesC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
        jcbDiasSesC.setEnabled(false);
        jcbDiasSesC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbDiasSesCItemStateChanged(evt);
            }
        });

        jLabel6.setText("días");

        jLabel7.setText("Logo para imprimir en los reportes");

        txtDirLogo.setEditable(false);

        lblLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoMouseClicked(evt);
            }
        });

        jLabel8.setText("<html>Si lo desea puede indicar un archivo de imagen (jpg o png)<br>para usar como logo (institucional o escolar) al imprimir<br>reportes del sistema (El archivo debe existir en cada<br>ocasión que imprima un reporte)</html>");

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 11));
        jLabel9.setText("Click en el cuadro de la izquierda para buscar imagen ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(chkMuestraVA)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkMuestraSA)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbDiasSesA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(chkMuestraCL)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbDiasSesC, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnEstMetal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnEstSO))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                        .addComponent(btnAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(txtDirLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnEstMetal)
                    .addComponent(rbtnEstSO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkMuestraVA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkMuestraSA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbDiasSesA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkMuestraCL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbDiasSesC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDirLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Llama al evento que guarda los cambios en los datos
     * @param evt El ActionEvent que genero el evento
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(guardaCambios()){ 
            muestraMensaje("Cambio guardados", "Cambio de preferencias de avisos se ha guardado", TipoMensaje.INFORMACION);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    /** Guarda los datos de las preferencias seleccionadas
     * @return true si los cambios se guardaron correctamente false en caso contrario
     */
    @Override
    public boolean guardaCambios(){
        String aux=""+rbtnEstMetal.isSelected(); // estilo metal
        // guardar preferencia de estilo en archivo local
        if(getPrincipalVnt().guardaPrefEst(aux,txtDirLogo.getText())){
            muestraMensaje("Cambio de estilo", "El cambio de estilo tendrá efecto al reiniciar el sistema",TipoMensaje.INFORMACION);
        }
        else{
            muestraMensaje("Ocurrio un error", "No se pudo guardar el cambio de estilo",TipoMensaje.ERROR);
            return false;
        }
        // guardar preferencias de avisos en servidor de bd
        aux="update dtspref set mostrar="+chkMuestraVA.isSelected()+", asesorias="+chkMuestraSA.isSelected();
        aux+=", diasase="+jcbDiasSesA.getSelectedItem()+", clases="+chkMuestraCL.isSelected(); 
        aux+=", diasclase="+jcbDiasSesC.getSelectedItem()+";"; 
        if(Actualiza.actualiza(aux,true,true)){ 
            setCambios(false);
            return true;
        }
        else{
            muestraMensaje("Ocurrio un error", "Preferencias de avisos no se pudo guardar "+Actualiza.obtenError(), TipoMensaje.INFORMACION);
            return false;
        }
    }
    
    /** Carga los datos de preferencias en cuanto a recordatorio de avisos
     * @return Las preferencias en cuanto a recordatorio de avisos
     */
    public String[] cargaParams(){
        String[] params=Consultas.consultaUnCampo("select * from dtspref;",false);
        return params;
    }
  
    /** Indica que hay cambios sin guardar
     * @param evt El ItemEvent que genero el evento
     */
    private void chkMuestraVAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkMuestraVAItemStateChanged
        chkMuestraSA.setEnabled(chkMuestraVA.isSelected());
        jcbDiasSesA.setEnabled(chkMuestraSA.isSelected()&&chkMuestraSA.isEnabled());
        chkMuestraCL.setEnabled(chkMuestraVA.isSelected());
        jcbDiasSesC.setEnabled(chkMuestraCL.isSelected()&&chkMuestraCL.isEnabled());
        setCambios(true);
    }//GEN-LAST:event_chkMuestraVAItemStateChanged

    /** Indica que hay cambios sin guardar
     * @param evt El ItemEvent que genero el evento
     */
    private void chkMuestraSAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkMuestraSAItemStateChanged
        jcbDiasSesA.setEnabled(chkMuestraSA.isSelected());
        setCambios(true);         
    }//GEN-LAST:event_chkMuestraSAItemStateChanged

    /** Indica que hay cambios sin guardar
     * @param evt El ItemEvent que genero el evento
     */
    private void chkMuestraCLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkMuestraCLItemStateChanged
        jcbDiasSesC.setEnabled(chkMuestraCL.isSelected());
        setCambios(true); 
    }//GEN-LAST:event_chkMuestraCLItemStateChanged

    /** Indica que hay cambios sin guardar
     * @param evt El ItemEvent que genero el evento
     */
    private void rbtnEstMetalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnEstMetalItemStateChanged
        setCambios(true); 
    }//GEN-LAST:event_rbtnEstMetalItemStateChanged

    /** Indica que hay cambios sin guardar
     * @param evt El ItemEvent que genero el evento
     */
    private void rbtnEstSOItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnEstSOItemStateChanged
        setCambios(true); 
    }//GEN-LAST:event_rbtnEstSOItemStateChanged

    /** Indica que hay cambios sin guardar
     * @param evt El ItemEvent que genero el evento
     */
    private void jcbDiasSesAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbDiasSesAItemStateChanged
        setCambios(true); 
    }//GEN-LAST:event_jcbDiasSesAItemStateChanged

    /** Indica que hay cambios sin guardar
     * @param evt El ItemEvent que genero el evento
     */
    private void jcbDiasSesCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbDiasSesCItemStateChanged
        setCambios(true); 
    }//GEN-LAST:event_jcbDiasSesCItemStateChanged

    /** Carga el archivo deseado para usar como logo (usa un JFileChooser)
     * @param evt El MouseEvent que genero el evento
     */
    private void lblLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoMouseClicked
        javax.swing.JFileChooser cajaArchivo;
        javax.swing.filechooser.FileNameExtensionFilter exts = new javax.swing.filechooser.FileNameExtensionFilter("Imagenes","jpg","png");
        ImageIcon imagen;
        java.io.File archLogo;
        String aux;
        int opcion;
        cajaArchivo = new javax.swing.JFileChooser();
        cajaArchivo.setFileFilter(exts);
        opcion = cajaArchivo.showOpenDialog(this);
        if(opcion==javax.swing.JFileChooser.APPROVE_OPTION){
            archLogo=cajaArchivo.getSelectedFile();
            aux=(archLogo.getPath().substring(archLogo.getPath().length()-4)).toLowerCase();
            if(!aux.equals(".jpg")&&!aux.equals(".png")){
                muestraMensaje("Acción fallida","Archivo invalido",TipoMensaje.ERROR);
                lblLogo.setIcon(null); archLogo=null;
                txtDirLogo.setText(""); return;
            }
            txtDirLogo.setText(archLogo.getPath());
            imagen = new javax.swing.ImageIcon(archLogo.getPath());
            imagen.setImage(imagen.getImage().getScaledInstance(lblLogo.getSize().width,lblLogo.getSize().height,java.awt.Image.SCALE_DEFAULT));
            lblLogo.setIcon(imagen); 
            setCambios(true); 
        }
    }//GEN-LAST:event_lblLogoMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JCheckBox chkMuestraCL;
    private javax.swing.JCheckBox chkMuestraSA;
    private javax.swing.JCheckBox chkMuestraVA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox jcbDiasSesA;
    private javax.swing.JComboBox jcbDiasSesC;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JRadioButton rbtnEstMetal;
    private javax.swing.JRadioButton rbtnEstSO;
    private javax.swing.ButtonGroup rbtnGrpEstVents;
    private javax.swing.JTextField txtDirLogo;
    // End of variables declaration//GEN-END:variables
    
}
