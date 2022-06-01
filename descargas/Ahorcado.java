package ahorcado;

import javax.swing.JOptionPane;

public class Ahorcado {

    public static void main(String[] args) {
        int fallosPermitidos=7, fallos=0;
        int i, encontrados;
        String letra;
        String palabraAdivinar;
        String letrasEncontradas="";
        String mensaje="";
        boolean adivinado=false;
        
        palabraAdivinar=JOptionPane.showInputDialog("Introduce la palabra a adivinar");
        palabraAdivinar=palabraAdivinar.toLowerCase();
        letrasEncontradas=inicializarLetrasEncontradas(palabraAdivinar.length());
                
        do{
            letra=JOptionPane.showInputDialog("Introduce una letra");
            letra=letra.toLowerCase();
                   
            //comprobamos si ha fallado y actualizamos el número de fallos
            encontrados=actualizarFallos(palabraAdivinar, letra);
            if(encontrados==0){
                fallos++;
            }
            
            mensaje+="La palabra contiene "+encontrados+" "+letra.charAt(0)+" en la palabra";
            
            //ahora dibujamos el dibujo del ahorcado dependiendo del número de fallos
            mensaje+="\n"+dibujarAhorcado(fallos);
            
            //ahora actualizamos la información de las letras encontradas y la imprimimos
            letrasEncontradas=actualizarLetrasEncontradas(palabraAdivinar, letra, letrasEncontradas);
            
            mensaje+="\nLetras encontradas: "+letrasEncontradas;
            
            JOptionPane.showMessageDialog(null,mensaje);
            
            //ahora reiniciamos el mensaje para la siguiente letra
            mensaje="";
            
            //comprobamos si ha encontrado todas las letras
            if(palabraAdivinar.equals(letrasEncontradas)){
                adivinado=true;
            }
            
        }while(fallos<fallosPermitidos && adivinado==false);
        
        if(adivinado==false){
        
            JOptionPane.showMessageDialog(null,"Lo siento has agotado los intentos.\nHa finalizado el juego.");
        }else{
            JOptionPane.showMessageDialog(null,"¡Enhorabuena! has acertado la palabra");
        }
        
    }
/**
 * Escribe tantos guiones como numero de letras tiene la palabra
 * @param longitud
 * @return
 */
    private static String inicializarLetrasEncontradas(int longitud) {
        String letras="";
        int i;
        for(i=0; i<longitud;i++){
            letras=letras+"_";
        }
        return letras;
    }
    
    /**
     * Cuenta los fallos que se han tenido
     * @param palabraAdivinar
     * @param letra
     * @return numero de fallos
     */
    private static int actualizarFallos(String palabraAdivinar, String letra) {
        int i;
        int encontrado=0;
        
        for(i=0; i<palabraAdivinar.length();i++){
            if(palabraAdivinar.charAt(i)==letra.charAt(0)){
                encontrado++;                
            }
        }
 
        return encontrado;
    }
/**
 * Cambia los guiones por las letras introducidas que estan dentro de la palabra
 * @param palabraAdivinar
 * @param letra
 * @param letrasEncontradas
 * @return
 */
    private static String actualizarLetrasEncontradas(String palabraAdivinar, String letra, String letrasEncontradas) {
        int i;
        String actualizacionLetras="";
         
        for(i=0; i<palabraAdivinar.length();i++)  {
        
                if(letra.charAt(0)==palabraAdivinar.charAt(i)){
                    //hemos encontrado la letra
                    actualizacionLetras+=letra.charAt(0);
                }else{
                    actualizacionLetras+=letrasEncontradas.charAt(i);
                }
        }
        return actualizacionLetras;
    }
    /**
     * 
     * @param fallos
     * @return dibujo del muñeco en cada fallo
     */
    private static String dibujarAhorcado(int fallos){
        String dibujo="";
        
        switch(fallos){
            
            case 0:
                dibujo="_____";
                break;
            case 1:
                dibujo="|\n|\n|\n_____";
                break;
            case 2:
                dibujo="|\n|\n|\n|\n|\n_____";
                break;
            case 3:
                dibujo="____\n|\n|\n|\n|\n|\n_____";
                break;
            case 4:
                dibujo="____\n|      |\n|\n|\n|\n|\n_____";
                break;
            case 5:
                dibujo="____\n|      |\n|     O\n|\n|\n|\n_____";
                break;
            case 6:
                dibujo="____\n|      |\n|     O\n|      |\n|\n|\n_____";
                break;
            case 7:
                dibujo="____\n|      |\n|     O\n|      |\n|     /\\  \n|\n_____";
                break;  
        }
        return dibujo;
    }    
}
