/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author windows
 */
public class SociosDAO 
{
    Connection conexion;
    
    
         public SociosDAO() throws ClassNotFoundException
	{
		Conexion con=new Conexion();
		conexion=con.getConnection();
	}
    
    public List<Socios> listarSocios()
    {
       PreparedStatement ps;
       ResultSet rs;   
       List<Socios> lista=new ArrayList<>(); 
           
       
       try
       {
                  
           ps=conexion.prepareStatement("select * from socios");
	   rs=ps.executeQuery();
           
           while(rs.next())
           {
               int id=rs.getInt("idSocio");
               String nombre=rs.getString("nombre");
               String apellido=rs.getString("apellido");
               String dni=rs.getString("dni");
               String cuil=rs.getString("cuil");
               String direccion=rs.getString("direccion");
               String localidad=rs.getString("localidad");             
               String codigoPostal=rs.getString("coigoPostal");             
               float peso=rs.getFloat("peso");             
               LocalDate fecha = rs.getDate("fnac").toLocalDate();
               String email=rs.getString("email");
               String telefono=rs.getString("telefono");
               boolean activo=rs.getBoolean("activo");                 
               Socios s1=new Socios(id,nombre,apellido, dni,cuil,direccion,localidad,codigoPostal,peso,fecha,email,telefono,activo);
               lista.add(s1);                

           }
           
           
       }
       catch(SQLException e)
       {
           System.out.println(e);
           //return null;
       }     
      
       
        return lista;
        
        
    }
    
    
    public Socios mostrarSocio(int _id)
    {
        PreparedStatement ps;
        ResultSet rs;
        Socios s1=null;
        try
        {
            ps=conexion.prepareStatement("select * from socios where idSocio=?");
            ps.setInt(1, _id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("idSocio");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String dni=rs.getString("dni");
                String cuil=rs.getString("cuil");
                String direccion=rs.getString("direccion");
                String localidad=rs.getString("localidad");             
                String codigoPostal=rs.getString("coigoPostal");             
                float peso=rs.getFloat("peso");             
                LocalDate fecha = rs.getDate("fnac").toLocalDate();
                String email=rs.getString("email");
                String telefono=rs.getString("telefono");
                boolean activo=rs.getBoolean("activo");                       
                s1=new Socios(id,nombre,apellido, dni,cuil,direccion,localidad,codigoPostal,peso,fecha,email,telefono,activo);
            }
            
            
            return s1;
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return null;
        }
        
    }
    
    
    public boolean InsertSocios(Socios s1)
    {
        PreparedStatement ps;
        
        try
        {
            ps=conexion.prepareStatement("insert into socios (nombre,apellido,dni,cuil,direccion,localidad,codigoPostal,peso,fnac,email,telefono,activo) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, s1.getNombre());
            ps.setString(2, s1.getApellido());
            ps.setString(3, s1.getDni());
            ps.setString(4, s1.getCuil());
            ps.setString(5, s1.getDireccion());
            ps.setString(6, s1.getLocalidad());
            ps.setString(7, s1.getCodigoPostal());
            ps.setFloat(8, s1.getPeso());
            ps.setObject(9, s1.getFnac()); 
            ps.setString(10, s1.getMail());
            ps.setString(11, s1.getTelefono());
            ps.setBoolean(12, true);
            ps.execute();
            return true;        
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    
    public boolean EliminarSocio(int _id)
    {
        PreparedStatement ps;
        
        try
        {
            ps=conexion.prepareStatement("delete from socios where idSocio=?");
            ps.setInt(1,_id);            
            ps.execute();
            return true;          
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean ActualizarSocios(Socios s1)
    {
        PreparedStatement ps;        
        try
        {
            ps=conexion.prepareStatement("update socios set nombre=?,dni=?,cuil=?,apellido=?,direccion=?,localidad=?,codigoPostal=?,peso=?,fnac=?,email=?,telefono=?,activo=? where idSocio=?");
            ps.setString(1, s1.getNombre());
            ps.setString(2, s1.getApellido());
            ps.setString(3, s1.getDni());
            ps.setString(4, s1.getCuil());
            ps.setString(5, s1.getDireccion());
            ps.setString(6, s1.getLocalidad());
            ps.setString(7, s1.getCodigoPostal());
            ps.setFloat(8, s1.getPeso());
            ps.setObject(9, s1.getFnac()); 
            ps.setString(10, s1.getMail());
            ps.setString(11, s1.getTelefono());
            ps.setBoolean(12, s1.isActivo());
            ps.setInt(13, s1.getIdSocio());
            ps.execute();
            return true;          
            
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    
    
    
    
    
    
    
 
    
 
 
}

