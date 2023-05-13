package DAO;

import Visao.Dialogs.FrmDialogLogin;
import Visao.FrmPrincipalPDV;

/**
 *
 * @author Alexandre
 */
public class DAOMain {
    
    public static void main(String[] arqs){
     
        FrmPrincipalPDV frm = new FrmPrincipalPDV();
        frm.setVisible(true);
        
        FrmDialogLogin login = new FrmDialogLogin(frm, true);
        login.setVisible(true);
        
        if(login.isConfirma()){
            frm.setDetalhes(login.getFuncionario(), login.getId_funcionario());
        }
        
    }
    
}
