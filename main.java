package Clases;

import java.sql.SQLException;
import java.util.Scanner;

public class main {

	public static void main(String[] args)  {
	
if(args[0].equalsIgnoreCase("rollback")) {
	System.out.println("Comenzar� rollback, est�s de acuerdo? S/N");
	
	String contrato;
    Scanner teclado = new Scanner(System.in);
    System.out.print("Introduzca el contrato: ");
    contrato = teclado.nextLine();
    Scanner estaSeguro = new Scanner(System.in);
    System.out.println("Est� seguro de hacer Rollback del contrato ->  " + contrato+" ?");
    System.out.print("Si est� seguro introduzca la palabra SI: ");
    
    
    if(estaSeguro.nextLine().equalsIgnoreCase("si")) {
    System.out.println("Cumpliendo sus �rdenes, haciendo Rollback del contrato ->  " + contrato);
    }else {
    	System.out.println("Ok, no har� cambios, hasta la pr�xima!.");
    }
    
}else {



		String contrato;

		contrato=args[0];
		System.out.println("Intentando guardar el contrato "+contrato);

if(AdministradorSgt.testearConexionBases()) {
	
	TotemSgt totem=new TotemSgt(contrato); 
	//TotemSgt totem=new TotemSgt("1193841"); 	
	AdministradorSgt.guardarTotem(totem, null);	
	AdministradorSgt.guardarServiceCameras(totem);
	AdministradorSgt.guardarServiceDevices(totem);	
	
	
};
}


		
 }
}


