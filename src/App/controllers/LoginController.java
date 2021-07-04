package App.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import App.models.Usuario;
import App.models.UsuarioModel;
import App.views.LoginView;

public class LoginController implements ActionListener {
    
    private final LoginView frm;
    private final UsuarioModel usrModel;
    
    public LoginController(LoginView frm) {
        usrModel = new UsuarioModel();
        this.frm = frm;
        this.frm.btnIng.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frm.btnIng)
            ingresar();
    }
    
    public void ingresar() {
        String strUsr = frm.txtUsr.getText();
        String strPss = String.valueOf( frm.txtPss.getPassword() );
        
        if( strUsr.isEmpty() || strPss.isEmpty() ) {
            
            frm.lblMsj.setForeground( Color.red );
            frm.lblMsj.setText( "Ingrese las credenciales" );
            
            if( strUsr.isEmpty() )
               frm.txtUsr.requestFocusInWindow();
            if( strPss.isEmpty() && !strUsr.isEmpty() )
               frm.txtPss.requestFocusInWindow();
            
            return;
        }
        
        Usuario usr = usrModel.autenticar( strUsr, strPss );
        
        if( null == usr ) {
            frm.lblMsj.setForeground( Color.red );
            frm.lblMsj.setText( "Credenciales incorrectas" );
        }
        else {
            frm.lblMsj.setForeground(Color.BLACK);
            frm.lblMsj.setText( "" );
            frm.txtUsr.setText( "" );
            frm.txtPss.setText( "" );
            JOptionPane.showMessageDialog(frm, "¡Bienvenido!", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
