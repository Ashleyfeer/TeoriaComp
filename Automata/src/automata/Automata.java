/*
 *La expresión regular a tratar es 1(00*)* cabe añadir que para el desarrollo del automata en código era más
 * sencillo realizarlo por caracteres, de forma que tomara a(bb*)*, la lógica que se siguió fue 
 * por medio de condicionales que iban revisando la cadena ingresada por teclado por el usuario, si esta era válida o no
 * de acuerdo a la expresión con sus reglas de ir o no ir por el *.
 */
package automata;

/**
 *
 * @author Fernanda Idalia Hatem Vargas - 140923
 * Teoría Computacionalbbb
 */
import java.util.Scanner;

    
public class Automata {
   int contador;
   char [] w;      //Se ingresan las variables a utilizar, en un arreglo de tipo Char
   
    public static void main(String[] args) {
        
        String Cadena;
        System.out.println("AUTOMATA a(bb*)* \n");
       
        System.out.println("Introduce la cadena:\n");
        Scanner entrada = new Scanner(System.in);   //Pedimos datos por teclado usando el Scanner
        Automata Aut = new Automata();
        Cadena = entrada.next(); 
        Aut.w = Cadena.toCharArray();     //Guardamos los datos en la variable w que será la cadena a evaluar
        
        Aut.Inicio();
       
    }
    
    public void Inicio(){
    
        contador = 0;   //Iniciamos en el estado 0
        Estadoq0();
    }
    
    public void Estadoq0(){
        
        if(contador<w.length) //Validamos la cadena
        {
            if(w[contador]=='a')  //condición de entrada si es una 'a' 
            {
                contador++;
                Estadoq1(); //Lo manda al estado q1
            }
            else
            {
                System.out.print("La cadena es inválida"); //Imprime que si es una cadena válida 
            }
        }
        else //En dado caso que sea 'b' la cadena no es válida
        {
            System.out.print("La cadena es inválida");
        }
    
    }
    
    public void Estadoq1(){ //Entrando al estado q1
        
        if(contador<w.length)
        {
            if(w[contador]=='a') //Nuevamente si el siguiente valor es 'a'
            {
                System.out.print("La cadena es inválida"); //Termina el ciclo e imprime que es la cadena inválida
                
            }
            else
            {
                if(w[contador]=='b') //pero si el valor es 'b' entonces entra al estado q2
                {
                    contador++;
                    Estadoq2();
                
                }
            }
        }
         else
        {
           System.out.print("La cadena es válida"); //En dado caso que no sea ninguno, la cadena es válida
        }
    
    }
    
    
    public void Estadoq2(){ //finalmente si pasa al estado q2
        
        if(contador<w.length)
        {
            if(w[contador]=='a') //Si el último valor es 'a' nuevamente termina el ciclo por que no es válido
            {
                System.out.print("La cadena es inválida");
                
            }
            else
            {
                if(w[contador]=='b') //si el valor es 'b' regresa al estado q1 y termina el ciclo
                {
                    contador++;
                    Estadoq1();
                }
            }
        }
        else
        {
            System.out.print("La cadena es válida");
        }     
    
    }
    
}
