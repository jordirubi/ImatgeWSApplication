/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.imatge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author annagarcia-nieto
 */
@WebService(serviceName = "ImatgeWS")
public class ImatgeWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registreImatge")
    public int registreImatge(@WebParam(name = "imatge") Imatge imatge) {
        //TODO write your implementation code here:
        String titol = imatge.getTitol();
        String autor = imatge.getAutor();
        String data = imatge.getDataCreacio();
        String descripcio = imatge.getDescripcio();
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error class.forname");
        }
        try{
            //conn = DriverManager.getConnection("jdbc:sqlite:\\Users\\oriol\\OneDrive\\Escritorio\\loquesea.db");
           conn = DriverManager.getConnection("jdbc:sqlite:/Usuaris/annagarcia-nieto/Escriptori/basedades.db");
           PreparedStatement statement = conn.prepareStatement("insert into imagenes values (?, ?, ?, ?, ?, ? , ?)");
           statement.setInt(1, imatge.getId());
           statement.setString(2, "Jordi");
           statement.setString(3, imatge.getTitol());
           statement.setString(4, imatge.getDescripcio());
           statement.setString(5, imatge.getKeywords());
           statement.setString(6, imatge.getAutor());
           statement.setString(7, imatge.getDataCreacio());
           statement.executeUpdate();
            return 1;
        }
        catch(SQLException ex){
            return 0;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modifyImatge")
    public int modifyImatge(@WebParam(name = "id_imatge") int id_imatge) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listImatges")
    public List<Imatge> listImatges() {
        //TODO write your implementation code here:
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error class.forname");
        }
        try{
            //conn = DriverManager.getConnection("jdbc:sqlite:\\Users\\oriol\\OneDrive\\Escritorio\\loquesea.db");
            conn = DriverManager.getConnection("jdbc:sqlite:/Usuaris/annagarcia-nieto/Escriptori/basedades.db");
            PreparedStatement statement =  conn.prepareStatement("select * from imagenes"); 

            List<Imatge> list = null;
            Imatge imatge = new Imatge();
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                imatge.setTitol(rs.getString("titulo"));
                imatge.setId(rs.getInt("id_imagen"));
                imatge.setDescripcio(rs.getString("descripcion"));
                imatge.setKeywords(rs.getString("palabras_clave"));
                imatge.setDataCreacio(rs.getString("creacion"));
                imatge.setAutor(rs.getString("autor"));
                            
                list.add(imatge);

            }
            return list;
        } catch(SQLException e) {
            return null;
        }  
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchById")
    public List<Imatge> searchById(@WebParam(name = "Id") int Id) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchByTitle")
    public List<Imatge> searchByTitle(@WebParam(name = "title") String title) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchByDate")
    public List<Imatge> searchByDate(@WebParam(name = "date") String date) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchByAutor")
    public List<Imatge> searchByAutor(@WebParam(name = "autor") String autor) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchByKeywords")
    public List<Imatge> searchByKeywords(@WebParam(name = "keywords") String keywords) {
        //TODO write your implementation code here:
        return null;
    }
}
