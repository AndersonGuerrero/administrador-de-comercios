package funciones;


public class Dco_pw {

	private int numero=0;
	private String decifrada="",n="";
	private char cadena[]=null,x;
	
	
	Mensaje msj=new Mensaje();
	
	public String Decodificacionm(String clave)
	
	{
		
		cadena=clave.toCharArray();
		
		n =String.valueOf(cadena[cadena.length-1]);	
		
		x=n.charAt(0);
		x-=45;
		n=String.valueOf(x);
		
		numero=Integer.parseInt(n);
		
		for(int i=0;i<cadena.length-1;i++)
		{
			
			
			cadena[i]-=numero;
			
			decifrada+=cadena[i];
			
		}
	
		return decifrada;
		
		
	}
	
}
