package Clases;
import java.util.ArrayList;

import MetodosSql.Credenciales;
import MetodosSql.MetodosSql;

public class BuscadorErrores {
	public static ArrayList<String>errores=new ArrayList<String>();	
	
	MetodosSql baseOjoHalconOperativo=new MetodosSql(
			Credenciales.ip_OjoHalconOperativo,
			Credenciales.base_OjoHalconOperativo,
			Credenciales.usuario_OjoHalconOperativo,
			Credenciales.password_OjoHalconOperativo
			);
	MetodosSql baseSurveillance=new MetodosSql(
			Credenciales.ip_Surveillance,
			Credenciales.base_Surveillance,
			Credenciales.usuario_Surveillance,
			Credenciales.password_Surveillance
			);
	
	static MetodosSql baseSGT=new MetodosSql(
			Credenciales.ip_SGT,
			Credenciales.base_SGT,
			Credenciales.usuario_SGT,
			Credenciales.password_SGT
			);

	public static ArrayList<String>erroresTotem(TotemSgt totem){
			
		
		if(!esIpValida(totem.getIP()))errores.add("IP Inv�lida -> "+totem.getIP());
		if(totem.getName().isEmpty())errores.add("Name Inv�lido Vac�o -> "+totem.getName());
		if(totem.getAddress().isEmpty())errores.add("Address Inv�lido Vac�o -> "+totem.getAddress());
		if(servicePlanInvalido(totem))errores.add("ServicePlanId Inv�lido -> "+totem.getServicePlanId());
		if(totem.getIpRangeId()==0)errores.add("IpRangeId Inv�lido -> "+totem.getIpRangeId());
		if(totem.getRecordingServer().length()<20)errores.add("RecordingServer Inv�lido -> "+totem.getRecordingServer());
		if(totem.getVpn().isEmpty())errores.add("Vpn Inv�lida -> "+totem.getVpn());	
		if(totemExisteEnSgtServices(totem))errores.add("Service ya cargado con contrato -> "+totem.getContractNumber());	
		
		
		return errores;
		
	}
	private String tieneCamposVacios() {
		return null;		
	}
	
	private static boolean esIpValida(String ip) {
		if(ip.contains("172.")) {//fucking genius =)
			return true;
		}else {
			return false;
		}
		
	}
	private static boolean servicePlanInvalido(TotemSgt totem) {
		if(totem.getServicePlanId()==-1) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean totemExisteenBaseSgt(String ip) {
		int flag=0;
		String SentenciaSql=
				 "select count(1) from IpRanges"
				+ " where ipAddress='"+ip+"'";
		flag=Integer.parseInt(baseSGT.consultarUnaCelda(SentenciaSql));
		if(flag>0) {
		return true;
		}else {
		return false;
		}
	}
	private static boolean totemExisteEnSgtServices(TotemSgt totem) {
		String query="SELECT count(1) from services\r\n" + 
				"  where contractnumber='"+totem.getContractNumber()+"';";
		String resultado=baseSGT.consultarUnaCelda(query);
		if(resultado.equals("0")) {
			return false;
		}else {
			return true;
		}
		
		
	}
}
