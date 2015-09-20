package funciones;

public class Cod_pw {

	
	String n,clave="",cifrada="",decifrada="";
	char cadena[]=null,x;
    double numero;
 public	String Codificacionm(String clave)
	{			
	numero=Math.floor(Math.random()*9+1);
	cadena =clave.toCharArray();
	n=String.valueOf(numero);
	for(int i=0;i<cadena.length;i++)
	{
		cadena[i]+=numero;
		cifrada+=cadena[i];
	}
	x=n.charAt(0);
    x+=45l;
	cifrada+=String.valueOf(x);
    return cifrada;
	}
}
