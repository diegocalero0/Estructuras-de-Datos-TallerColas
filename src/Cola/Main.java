/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main {
    
	private static Colasimple<Integer> colaCien;
	
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	colaCien=colaCien();
    	Colasimple<Integer> aux = new Colasimple<Integer>();
    	System.out.println("Desea Conocer los negativos de la cola?\n1: Si\n2: No");
    	int o=sc.nextInt();
    	if(o==1){
    		System.out.println("Original: ");
    		for(int n:colaCien){
    			aux.encolar(n);
    			System.out.print(n+" ");
    		}
    		colaCien=aux;
    		Colasimple<Integer> negativos=colaNegativa(colaCien);
    		
    		System.out.println();
    		System.out.println("Negativos: ");
    		
    		for(int n:negativos){
    			System.out.print(n+" ");
    		}
    		
    		System.out.println();
    		System.out.println("Positivos: ");
    		for(int n:colaCien){
    			System.out.print(n+" ");
    		}
    		System.out.println();
    	}
    	
    }
    
    
    /**
     * Metodo que indica si un numero es capicúa
     * @param n el numero a observar
     * @return true si el numero es capicúa.
     */
    public static boolean isCapicua(int n){
    	 int numeroDigitos=((int)Math.log10(n)+1)/2;
    	 Colasimple<Integer> cola=new Colasimple<>();
    	 
    	for(int i=0;i<numeroDigitos;i++)
    	{
    		cola.encolar(n%10);
    		n=n/10;
    	}
    	int aux=1;
    	if(numeroDigitos%2==0){
    		aux=0;
    	}
    	for(int i=0;i<numeroDigitos;i++)
    	{
    		
    		if(cola.desencolar()!=(n/(int)Math.pow(10, numeroDigitos-i-aux))%10){
    			return false;
    		}
    	}
    	 return true;
    }
    
    /**
     * Metodo que genera 100 numeros aleatorios desde -25 a 25
     * @return una cola con 100 numeros
     */
    public static Colasimple<Integer> colaCien(){
    	Colasimple<Integer> cola = new Colasimple<Integer>();
    	int c=100;
    	int aleatorio;
    	while(c-->0){
    		aleatorio=(int)(Math.random()*25+1);
    		if((int)(Math.random()*100+1)%2!=0){
    			aleatorio*=-1;
    		}
    		cola.encolar(aleatorio);
    	}
    	return cola;
    }
    
    /**
     * Metodo que dada una cola retorna otra con solo los valores negativos que se encuentren en esta
     * @param Cola
     * @return una nueva cola con valores negativos
     */
    public static Colasimple<Integer> colaNegativa(Colasimple<Integer> cola){
    	Colasimple<Integer> positivos = new Colasimple<Integer>();
    	Colasimple<Integer> negativos = new Colasimple<Integer>();
    	
    	for(int n : cola){
    		if(n<0){
    			negativos.encolar(n);
    		}else{
    			positivos.encolar(n);
    		}
    	}
    	colaCien=positivos;
    	return negativos;
    }
    
    public boolean balanceado(String exp)
    {
        Colasimple <Character> cola=new Colasimple<Character>();
        for(int i=0;i<exp.length();i++)
        {
            if(exp.charAt(i)=='(')
            {
                cola.encolar('(');
            }
            else if(exp.charAt(i)==')')
            {
                if(cola.verPrimero()!=null)
                cola.desencolar();
                else return false;
                
            }
        }
        if(cola.verPrimero()!=null)
        {
            return false;
        }
        return true;
    }
    
    
    public String DE(String a)
    {
        String aux="";
        Colasimple<Character> cola= new Colasimple<Character>();
        
        for (int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i)>='A'&&a.charAt(i)<='Z')
            {
                cola.encolar(a.charAt(i));
            }
            else
            {
                if(a.charAt(i)=='*')
                {
                 if(cola.verPrimero()!=null)
                 {
                     aux+=cola.desencolar();
                 }
                }
            }
        }
        return aux;
    }
}
