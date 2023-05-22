
package PruebaInterfaz;

import Dominio.*;
import Interfaz.*;


public class Prueba {
    
    public static void main(String[] args) {
        
        Sistema modelo = new Sistema();
        
        VentanaMenu ventMenu = new VentanaMenu(modelo);
        ventMenu.setVisible(true);
        // ahora si jeje
    }
}
