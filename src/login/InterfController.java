/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 * FXML Controller class
 *
 * @author diego
 */
public class InterfController implements Initializable {
    
    ObservableList<String> FabC = FXCollections.observableArrayList();
    Connection conn= Conectar.Cone();;
    OraclePreparedStatement pst = null;
    OracleResultSet rs= null;
    
    /*
    /////////////////////
    Pestaña Fabricante///
    /////////////////////
    */
    
    @FXML
    private TextField TxNomFabF;
    
    /*
    //////////////////
    Pestaña Cerveza///
    //////////////////
    */
    @FXML
    private TextField TxNomC;

    @FXML
    private TextField TxTipoC;

    @FXML
    private TextField TxAlcoC;

    @FXML
    private ChoiceBox ChoiceBoxFabC;

    @FXML
    private TextField TxCosteC;

    @FXML
    private TextField TxDescripC;

    @FXML
    private Button Btn_CrearC;
    
    /*
    //////////////////////////////////////
    /////////Pestaña Cliente//////////////
    //////////////////////////////////////
    */
    
    @FXML
    private TextField TxNomCl;

    @FXML
    private TextField TxApeCl;

    @FXML
    private TextField TxIdCl;

    @FXML
    private TextField TxPaisCl;

    @FXML
    private TextField TxDirCl;

    @FXML
    private TextField TxCorreoCl;

    @FXML
    private Button Btn_CrearCl;
    
    /*Pestaña Depositos*/
    
    @FXML
    private TextField TxCodD;

    @FXML
    private TextField TxDirD;

    @FXML
    private TextField TxCapD;

    @FXML
    private Button Btn_CrearD;

    @FXML
    private ChoiceBox ChoiceBoxFabD;
    
    
     /*
    /////////////////////
    Pestaña Tienda    ///
    /////////////////////
    */
    @FXML
    private TextField TxPaiT;
    @FXML
    private TextField TxNomT;
    @FXML
    private TextField TxIdT;
    @FXML
    private TextField TxCiuT;
    @FXML
    private TextField TxConT;
    @FXML
    private Button Btn_CrearT;
    @FXML
    void CrearT(ActionEvent event) { }
    
    /*///////////////////
    Pestaña Pedido//  ///
    /////////////////////
    */
    @FXML
    private TextField TxCodP;
    @FXML
    private ChoiceBox ChoiceBoxIdTienP;
    @FXML
    private ChoiceBox ChoiceBoxNomDP;
    @FXML
    private TextField TxFechaP;
    @FXML
    private Button Btn_CrearP;
    @FXML
    void CrearP(ActionEvent event) { }
    
    
    /*///////////////////
    Pestaña Orden   /////
    /////////////////////
    */
    @FXML
    private ChoiceBox ChoiceBoxNomFabO;
    @FXML
    private TextField TxCodO;
    @FXML
    private ChoiceBox ChoiceBoxProO;
    @FXML
    private Button Btn_CrearO;
    @FXML
    void CrearO(ActionEvent event) { }
    
    
    /*///////////////////
    Pestaña Proveedor  /////
    /////////////////////
    */
    @FXML
    private TextField TxProCodPro;
    @FXML
    private TextField TxDirPro;
    @FXML
    private Button Btn_CrearPro;
    @FXML
    void CrearPro(ActionEvent event) { }
    
    /*///////////////////
    Pestaña Materias Primas  /////
    /////////////////////
    */
    @FXML
    private TextField TxPreM;
    @FXML
    private TextField TxNomM;
    @FXML
    private TextField TxCodM;
    @FXML
    private Button Btn_CrearM;
    @FXML
    void CrearM(ActionEvent event) { }
    
    

    @FXML
    void CrearC(ActionEvent event) {
        
        String sql="INSERT INTO CERV_CERVEZA(CER_GRADO,CER_PRECIO,CER_DESCRIP,FAB_NOMBRE,CER_TIPO,CER_CODIGO,CER_NOMBRE)VALUES(?,?,?,?,?,?,?)";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion de Cerveza a la base de datos
        pst.setString(1, TxAlcoC.getText());
        pst.setString(2, TxCosteC.getText());
        pst.setString(3, TxDescripC.getText());
        pst.setString(4, ChoiceBoxFabC.getValue().toString());
        pst.setString(5, TxTipoC.getText());
        
        String temp=ChoiceBoxFabC.getValue().toString().substring(0,2)+TxTipoC.getText().substring(0,2)+TxNomC.getText().substring(0,2);
        pst.setString(6, temp);
        
        pst.setString(7, TxNomC.getText());
        
        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! Una nueva cerveza para disfrutar.");
        
        //Limpiar textboxes
        TxAlcoC.clear();
        TxCosteC.clear();
        TxDescripC.clear();
        TxTipoC.clear();
         
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }
    }
    
    
    
    @FXML
    void CrearCl(ActionEvent event) {
        String sql="INSERT INTO CERV_CLIENTE(CLI_NOMBRE,CLI_APELLIDO,CLI_ID,CLI_PAIS,CLI_DIR,CLI_EMAIL) VALUES(?,?,?,?,?,?)";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion a la base de datos
        pst.setString(1, TxNomCl.getText());
        pst.setString(2, TxApeCl.getText());
        pst.setString(3, TxIdCl.getText());
        pst.setString(4, TxPaisCl.getText());
        pst.setString(5, TxDirCl.getText());
        pst.setString(6, TxCorreoCl.getText());    
        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! El usuario ha sido creado exitosamente");
        
        //Limpiar textbox una vez creado un usuario
        TxNomCl.clear();
        TxApeCl.clear();
        TxIdCl.clear();
        TxPaisCl.clear();
        TxDirCl.clear();
        TxCorreoCl.clear();
        
        
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        
        }

    }
    
    @FXML
    void CrearF(ActionEvent event) {
        
        String sql="insert into cerv_fabricante(FAB_NOMBRE) values(?)";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        pst.setString(1, TxNomFabF.getText());
        rs = (OracleResultSet) pst.executeQuery();
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }
        TxNomFabF.clear();
        Poblarg();
        
    }
    
    @FXML
    void CrearD(ActionEvent event) {
        String sql="INSERT INTO CERV_CLIENTE(CLI_NOMBRE,CLI_APELLIDO,CLI_ID,CLI_PAIS,CLI_DIR,CLI_EMAIL) VALUES(?,?,?,?,?,?)";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        
        //Enviar la informacion a la base de datos
        pst.setString(1, TxNomCl.getText());
        pst.setString(2, TxApeCl.getText());
        pst.setString(3, TxIdCl.getText());
        pst.setString(4, TxPaisCl.getText());
        pst.setString(5, TxDirCl.getText());
        pst.setString(6, TxCorreoCl.getText());    
        rs = (OracleResultSet) pst.executeQuery();
        
        JOptionPane.showMessageDialog(null, "¡Enhorabuena! El usuario ha sido creado exitosamente");
        
        //Limpiar textbox una vez creado un usuario
        TxNomCl.clear();
        TxApeCl.clear();
        TxIdCl.clear();
        TxPaisCl.clear();
        TxDirCl.clear();
        TxCorreoCl.clear();
        
        
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Poblarg();
        
    }
    
    public void Poblarg()
    {
        ObservableList<String> FabCtemp = FXCollections.observableArrayList();
        String sql="select * from cerv_fabricante";
        try{
        pst = (OraclePreparedStatement) conn.prepareStatement(sql);
        rs = (OracleResultSet) pst.executeQuery();
        while (rs.next())
        {
        String Fabnombre=rs.getString("FAB_NOMBRE");
        FabCtemp.add(Fabnombre);
        }
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        }
        FabC=FabCtemp;
        ChoiceBoxFabC.setItems(FabC);
        ChoiceBoxFabD.setItems(FabC);
        
    }
    
}
