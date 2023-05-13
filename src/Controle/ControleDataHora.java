package Controle;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Alexandre
 */
public class ControleDataHora {
    
    SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hr = new SimpleDateFormat("HH:mm");
    
    public String retornaData(){
        
        Calendar cal = Calendar.getInstance();
        String hoje = dt.format(cal.getTime());
        return hoje;
                
    }
        
    public String retornaHora(){
                
        Calendar cal = Calendar.getInstance();
        String hora = hr.format(cal.getTime());       
        return hora;
        
    }   
    
}
