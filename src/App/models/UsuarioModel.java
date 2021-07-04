package App.models;

import Core.BCrypt;
import Core.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel extends Model {
    
    private static final String STR_TBL = "usuario";  
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String strEnc;
    
    public UsuarioModel(){
        strEnc = "idUsuario, codUsuario, nombre, apellidos, email, contrasenya, estado";
    }
    
    public Usuario autenticar( String codigo, String contrasenya ) {
        
        List<Usuario> listUsr = this.buscarPorCodigo(codigo);
        
        if( 1 == listUsr.size() ) {
            Usuario usr = listUsr.get(0);
            if( null != usr && usr.isEstado() ) {
                if( verificarContrasenya( contrasenya, usr.getContrasenya() ) )
                    return usr;
                else
                    return null;
            }
            else
                return null;
        }
        
        return null;
    }
    
    public List<Usuario> buscarPorCodigo(String codigo) {
        List<Usuario> datos = new ArrayList<>();
        String sql = "SELECT " + strEnc + " FROM " + STR_TBL + " WHERE codUsuario = ?";
        
        try {
            con = super.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            
            while( rs.next() ) {
                Usuario usr = new Usuario();
                usr.setIdUsuario(rs.getInt(1));
                usr.setCodUsuario(rs.getString(2));
                usr.setNombre(rs.getString(3));
                usr.setApellidos(rs.getString(4));
                usr.setContrasenya(rs.getString(6));
                usr.setEstado((rs.getInt(7)==1));
                datos.add(usr);
            }
            
        } catch( Exception ex1 ) {
            System.err.println(ex1);
        }
        return datos;
    }
    
    public Boolean verificarContrasenya( String candidata_txt_pln, String alm_hsh ) {
        
        // Hash a password for the first time
        //String hashed = BCrypt.hashpw( candidata_txt_pln, BCrypt.gensalt());

        // gensalt's log_rounds parameter determines the complexity
        // the work factor is 2**log_rounds, and the default is 10
        //String hashed2 = BCrypt.hashpw( candidata_txt_pln, BCrypt.gensalt(12));
        
        alm_hsh = alm_hsh.replaceAll( "\\$2y\\$", "\\$2a\\$" );
        return BCrypt.checkpw( candidata_txt_pln, alm_hsh );
    }
    
}
