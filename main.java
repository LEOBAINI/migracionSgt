package Clases;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JTextArea;

import Pantallas.ppal;

public class main {

	public static void main(String[] args)  {
	
if(args[0].equalsIgnoreCase("rollback")) {
	System.out.println("Comenzar� rollback");
	
	String contrato;
    Scanner teclado = new Scanner(System.in);
    System.out.print("Introduzca el contrato: ");
    contrato = teclado.nextLine();
    Scanner estaSeguro = new Scanner(System.in);
    System.out.println("Est� seguro de hacer Rollback del contrato ->  " + contrato+" ?");
    System.out.print("Si est� seguro introduzca la palabra SI: ");
    
    
    if(estaSeguro.nextLine().equalsIgnoreCase("si")) {
    System.out.println("Cumpliendo sus �rdenes, haciendo Rollback del contrato ->  " + contrato);
    AdministradorSgt.hacerRollback(contrato, null);
    }else {
    	System.out.println("Ok, no har� cambios, hasta la pr�xima!.");
    }
    
}else {



		String contrato;

		contrato=args[0];
		System.out.println("Intentando guardar el contrato "+contrato);

if(AdministradorSgt.testearConexionBases(null)) {
	
	TotemSgt totem=new TotemSgt(contrato); 
	
	AdministradorSgt.guardarTotem(totem, null);	
	AdministradorSgt.guardarServiceCameras(totem,null);
	AdministradorSgt.guardarServiceDevices(totem,null);	
	
	
};
}


		
	
		
		
							
				/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ppal frame = new ppal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
	}
}


