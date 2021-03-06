/*
 * FrmRegEval.java
 *   Encargado de manejar registros individuales de rubros de evaluacion
 * Parte de proyecto: SADAA
 * Author: Pedro Cardoso Rodriguez
 * Mail: ingpedro@live.com
 * Place: Zacatecas Mexico
 * 
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

package grupos;

import database.Actualiza;
import alumnos.*;
import definiciones.TipoMensaje;
import iconos.Iconos;
import operaciones.Datos;

/**  Es una ventana interna (JInternalFrame) para manejar un registro individual de un 
 *  rubros de evaluacion programadas para un grupo. Es utilizado como ventana hija de 
 *  FrameEvaluaciones para altas y modificaciones de rubros de evaluacion de grupos y por 
 *  FrameDesGru para altas de calificaciones de desempeño de alumnos (en este caso no 
 *  puede modificar los datos del rubro solo el desempenio del alumno)
 * 
 * @author Pedro Cardoso Rodríguez
 */
public class FrmRegEval extends sistema.ModeloFrameInterno{
    
    /**Referencia a la ventana (rubros de evaluacion de un grupo) a la cual pertenece esta ventana null si pertenece a desempenio de alumno*/
    private FrameEvaluaciones refCalifs;
    /**Referencia a la ventana (desempenio en grupo de alumno) a la cual pertenece esta ventana null si pertenece a frame evaluaciones*/
    private FrameDesGru refDesGru;
    /**La clave del grupo al cual pertenece el rubro*/
    private String clvGrupo;
    /**Si es para desempeño de alumno la matricula del alumno*/
    private String matricula;
    /**Si es para desempeño de alumno su clave de pertenencia al grupo*/
    private int clvper;
    /**Clave del rubro en la base de datos (tabla pertenece)*/
    private int clave;
    /**Crea un listener para escuchar si hay cambios en los controles de texto*/
    private ListenChanges listenCh;
    
    /** Crea una nueva ventana FrmRegEval
     * @param ventana Referencia a la ventana principal contenedora (clase sistema.FramePrincipal)
     * @param refCalifs Referencia la ventana rubros de evaluacion de un grupo si pertenece a una o null en caso contrario
     * @param refDesGru Referencia la ventana desempenio en grupo de alumno si pertenece a una o null en caso contrario
     * @param mat Matricula de alumno si pertenece a un aventana de desempenio en grupo de alumno si pertenece a una o null en caso contrario
     * @param clvGrupo La clave del grupo al cual pertenece el rubro
     * @param clave Clave del rubro en la base de datos (tabla pertenece)
     * @param dts Los datos del rubro en orden: clave, tipo, descripcion, fecha solicita, fecha califica o null si es registro nuevo
     * @param clvper Si es para desempeño de alumno su clave de pertenencia al grupo
     */
    public FrmRegEval(sistema.FramePrincipal ventana,FrameEvaluaciones refCalifs, FrameDesGru refDesGru,String mat, String clvGrupo, int clave, String[] dts, int clvper) {
        super(ventana,"frmregdesgru.png");
        initComponents();
        this.refCalifs=refCalifs;
        this.refDesGru=refDesGru;
        this.clave=clave; this.clvGrupo=clvGrupo;
        this.matricula=mat; this.clvper=clvper;
        setTitle("Registro de rubro "+(clave>0?clave+" ":"")+"para "+(mat!=null?"alumno "+mat+" en ":"")+"grupo "+clvGrupo);
        btnGuarda.setIcon(Iconos.getIcono("guardar.png"));
        lblMens.setText("Datos del "+(clave==-1?"nuevo":"")+" rubro: "+(clave==-1?"":clave));
        if(clave!=-1){ // si ya existe el rubro cargarlo desde dts
            txtClave.setText(""+clave); jcbTipo.setSelectedItem(dts[1]);
            txtDesc.setText(dts[2]); txtFchaS.setText(dts[3]);
            txtFchaC.setText(dts[4]);
        }
        if(mat!=null){
            txtCalif.setText(dts[5]); txtValp.setText(dts[6]); txtObs.setText(dts[7]!=null?dts[7]:"");
            jcbTipo.setEnabled(false); txtDesc.setEditable(false); txtFchaS.setEditable(false);
            txtFchaC.setEditable(false);
        }
        else{
            lblCalif.setVisible(false); lblValp.setVisible(false); jspObs.setVisible(false);
            txtCalif.setVisible(false); lblValp2.setVisible(false);
            lblObs.setVisible(false); txtValp.setVisible(false);
        }
        pack(); setCambios(false);
        escuchaCambios();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFchaS = new javax.swing.JTextField();
        btnGuarda = new javax.swing.JButton();
        jcbTipo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        lblMens = new javax.swing.JLabel();
        lblCalif = new javax.swing.JLabel();
        txtCalif = new javax.swing.JTextField();
        lblValp = new javax.swing.JLabel();
        txtValp = new javax.swing.JTextField();
        lblObs = new javax.swing.JLabel();
        jspObs = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        lblValp2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFchaC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setTitle("Registro de rubro para grupo");

        jLabel1.setText("Tipo de rubro: ");

        jLabel6.setText("<html>Fecha en que<br> se solicita:</html>");

        btnGuarda.setMnemonic('G');
        btnGuarda.setText("Guardar");
        btnGuarda.setToolTipText("Guardar cambios realizados");
        btnGuarda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardaActionPerformed(evt);
            }
        });

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tarea", "Investigacion", "Exposicion", "Proyecto", "Practica", "Examen parcial", "Examen final", "Examen ordinario", "Examen extraordinario", "Calificacion final", "Otro" }));
        jcbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoItemStateChanged(evt);
            }
        });

        jLabel8.setText("Clave:");

        txtClave.setEditable(false);

        lblMens.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMens.setText("Etiqueta mensaje");

        lblCalif.setText("Calificación:");

        lblValp.setText("Valor porcentual:");

        lblObs.setText("Observaciones:");

        txtObs.setColumns(20);
        txtObs.setRows(5);
        jspObs.setViewportView(txtObs);

        lblValp2.setFont(new java.awt.Font("Tahoma", 2, 11));
        lblValp2.setText("(Sobre la calificación final)");

        jLabel2.setText("<html>Fecha en que<br>se califica:</html>");

        jLabel3.setText("Descripción:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMens, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuarda))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFchaS, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFchaC, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblObs))
                            .addComponent(jspObs, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCalif)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCalif, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblValp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValp, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValp2)))
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuarda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtFchaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFchaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCalif)
                    .addComponent(txtCalif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValp)
                    .addComponent(lblValp2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Llama al metodo guardaCambios
     * @param evt El ActionEvent que genero el evento
     */
    private void btnGuardaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardaActionPerformed
        guardaCambios();
    }//GEN-LAST:event_btnGuardaActionPerformed

    /** Valida y guarda los datos actuales en la base de datos si es registro nuevo crea el registro 
     *   si ya existia el registro actualiza los valores.
     * @return true si la operacion se realizo correctamente, false si hay datos invalidos o fallo al guardar en la bd
     */
    @Override
    public boolean guardaCambios(){
        String[] datos = obtenDtsVal(matricula!=null);
        String sentencia;
        if(matricula!=null && datos!=null){ 
            return guardaDatosRealiza(datos);
        }
        if(datos!=null){ // si clave no existe hacer un insert si no hacer update 
            if(clave==-1){
                if(database.Actualiza.newRgRubCalif(datos,true)){
                    clave=database.Actualiza.obtenClave();
                    muestraMensaje("Acción realizada","Se ha agregado el nuevo registro ",TipoMensaje.INFORMACION); 
                    txtClave.setText(""+clave);
                    setTitle("Registro de rubro "+clave+" para grupo "+clvGrupo);
                    lblMens.setText("Datos del rubro: "+clave);
                    if(refCalifs!=null) refCalifs.actualiza();
                    if(refDesGru!=null) refDesGru.actualiza();
                    setCambios(false);
                }
                else{
                    muestraMensaje("Acción fallida",database.Actualiza.obtenError(),TipoMensaje.ERROR);
                    return false;
                }
                return true;                
            }
            sentencia="update RubrosCalif set tipo="+(jcbTipo.getSelectedIndex()+1)+", descripcion='";
            sentencia+=datos[1]+"', fchasol="+(datos[3]==null?null:"'"+datos[3]+"'")+", fchacal='";
            sentencia+=datos[4]+"' where clvru="+clave+";";
            if(!database.Actualiza.actualiza(sentencia,true,true)){
                muestraMensaje("Acción fallida",database.Actualiza.obtenError(),TipoMensaje.ERROR);
                return false;
            }
            else{
                muestraMensaje("Acción Realizada","Se han actualizado los datos",TipoMensaje.INFORMACION);
                if(refCalifs!=null) refCalifs.actualiza();
                if(refDesGru!=null) refDesGru.actualiza();
                setCambios(false);
                return true;
            }
        }
        return false;
    }
 
    /** Guarda los datos de desempenio de alumno (en caso de tratarse de desempenio de alumno)
     *   en la base de datos (tabla realiza)
     * @param datos Los datos de desempenio en orden: 
     * @return true si la operacion se realizo correctamente, false si fallo al guardar en la bd
     */
    private boolean guardaDatosRealiza(String[] datos){
        String sentencia="update realiza set calif="+datos[5]+", valorp="+datos[6];
        sentencia+=", observaciones="+(datos[7].equals("")?null:"'"+datos[7]+"'");
        sentencia+=" where clvru="+clave+" and clvper="+clvper+";";
        if(!Actualiza.actualiza(sentencia,true,true)){
            muestraMensaje("Acción fallida",Actualiza.obtenError(),TipoMensaje.ERROR);
            return false;
        }
        else{
            muestraMensaje("Acción Realizada","Se han actualizado los datos",TipoMensaje.INFORMACION);
            if(refCalifs!=null) refCalifs.actualiza();
            if(refDesGru!=null) refDesGru.actualiza();
            setCambios(false);
            return true;
        }
    }
    
    /** Valida y obtiene los datos del rubro de evaluacion 
     * @param todos Banedra que indica si debe procesar todos los datos (incluyendo
     *  datos de desempenio de alumno) o solo los datos generales del rubro
     * @return Los datos actuales en el orden: tipode rubro; descripcion del rubro; 
     *  clave del grupo al que pertenece; fecha solicita; fecha califica; calificacion de alumno;
     *  valor porcentual y observaciones. Regresa null si hay al menos un dato invalido
     */
    private String[] obtenDtsVal(boolean todos){
        String[] datos=new String[(todos?8:5)];
        float auxf, auxf2;
        datos[0]=""+(jcbTipo.getSelectedIndex()+1);
        datos[1]=txtDesc.getText().trim();
        datos[2]=clvGrupo;
        datos[3]=txtFchaS.getText().trim();
        datos[4]=txtFchaC.getText().trim();
        if(todos){
            datos[5]=txtCalif.getText().trim();
            datos[6]=txtValp.getText().trim();
            datos[7]=txtObs.getText().trim();
        }
        // validar que no este vacia ni se pase de 65 caracteres
        if(datos[1].equals("")||datos[1].length()>65){
            muestraMensaje("Error en los datos", "Descripción invalida",TipoMensaje.ERROR);
            return null;
        }
        // validar el formato de las fechas
        if(datos[3].length()>0){
            if(!Datos.valFecha(datos[3])){
                muestraMensaje("Error en los datos", "Fecha de solicitud invalida",TipoMensaje.ERROR);
                return null;
            }
            datos[3]=Datos.transformatFcha(datos[3]);
        }
        else datos[3]=null;
        if(!Datos.valFecha(datos[4])){
            muestraMensaje("Error en los datos", "Fecha en que califica invalida",TipoMensaje.ERROR);
            return null;
        }
        datos[4]=Datos.transformatFcha(datos[4]);
        if(todos){
            try{
                auxf=Float.parseFloat(datos[5]);
                auxf2=Float.parseFloat(datos[6]);
            }
            catch(NumberFormatException nbfExc){ auxf=-1; auxf2=-1; }
            if(auxf<0f||auxf>10f||auxf2<0f||auxf2>100f){
                muestraMensaje("Error en los datos", "Calificación o valor porcentual invalido",TipoMensaje.ERROR);
                return null;
            }
            if(datos[7].length()>255){
                muestraMensaje("Error en los datos", "Observaciones invalidas (Excede el numero máximo de caracteres)",TipoMensaje.ERROR);
                return null;
            }
        }
        return datos;
    }
    
    /** Indica que hay cambios sin guardar al cambiar el elemento seleccionado del control jcbTipo
     * @param evt El ItemEvent que genero el evento
     */
    private void jcbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoItemStateChanged
        setCambios(true);
    }//GEN-LAST:event_jcbTipoItemStateChanged
    
    /** Crea y asigna un listener en los controles de texto para escuchar si hay cambios en su contenido*/
    private void escuchaCambios(){
        listenCh= new ListenChanges();
        txtDesc.getDocument().addDocumentListener(listenCh);
        txtFchaS.getDocument().addDocumentListener(listenCh);
        txtFchaC.getDocument().addDocumentListener(listenCh);
        txtCalif.getDocument().addDocumentListener(listenCh);
        txtValp.getDocument().addDocumentListener(listenCh);
        txtObs.getDocument().addDocumentListener(listenCh);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuarda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox jcbTipo;
    private javax.swing.JScrollPane jspObs;
    private javax.swing.JLabel lblCalif;
    private javax.swing.JLabel lblMens;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblValp;
    private javax.swing.JLabel lblValp2;
    private javax.swing.JTextField txtCalif;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtFchaC;
    private javax.swing.JTextField txtFchaS;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtValp;
    // End of variables declaration//GEN-END:variables

    /** Clase que implementa la interfaz DocumentListener 
     * para detectar si hay edicion en los controles de texto y saber si hay 
     * cambios sin guardar en el registro
     */
    private class ListenChanges implements javax.swing.event.DocumentListener{
        /** Crea un nuevo objeto ListenChanges */
        public ListenChanges(){}
        /** Metodo de la interfaz DocumentListener
         * detecta si se inserto contenido al documento (contenido del control de texto)
         * y avisa al FrmRegEval que hay cambios sin guardar
         * @param e El DocumentEvent que genero el evento
         */
        public void insertUpdate(javax.swing.event.DocumentEvent e){ 
            setCambios(true);
        }
        /** Metodo de la interfaz DocumentListener
         * detecta si se quito contenido al documento (contenido del control de texto)
         * y avisa al FrmRegEval que hay cambios sin guardar
         * @param e El DocumentEvent que genero el evento
         */
        public void removeUpdate(javax.swing.event.DocumentEvent e){ 
            setCambios(true);
        }
        /** Metodo de la interfaz DocumentListener
         * detecta si cambio el contenido del documento (contenido del control de texto)
         * @param e El DocumentEvent que genero el evento
         */
        public void changedUpdate(javax.swing.event.DocumentEvent e){}
    }
}
