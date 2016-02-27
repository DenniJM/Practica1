package negocio;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.catalina.connector.Request;

import modelo.Usuario;

public class GestionarArchivo {
	private File rutaDelArchivo;

	public GestionarArchivo() {
		// TODO Auto-generated constructor stub
		try{
			//Creacion o apertura de archivo
			File archivoRegistro = new File("/home/denni/Documentos/Tecnologias para la web /Programas/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Practica1LoginEQUIPO1/archivos/prueba.txt");
			//rutaDelArchivo= archivoRegistro.getPath();
			//File archivoRegistro = new File();
			rutaDelArchivo= archivoRegistro;
			
			
		}catch(NullPointerException e){
			System.out.println("Error al crear el archivo" + e);
		}
	}
	
	public void crearUsuario(Usuario usuario){
		try{
			FileWriter agregarUsuario = new FileWriter(rutaDelArchivo, true);
			agregarUsuario.write(usuario.getNombres()+"|"+usuario.getApellidoPaterno()+"#"+usuario.getApellidoMaterno()+"$"+usuario.getCorreo()+"%"+usuario.getContrasena()+"&\n");
			System.out.println(usuario.getNombres()+"|"+usuario.getApellidoPaterno()+"#"+usuario.getApellidoMaterno()+"$"+usuario.getCorreo()+"%"+usuario.getContrasena()+"&");
			agregarUsuario.close();
		}catch(IOException e){
			System.out.println("Error al agregar un usuario"+ e);
		}		
	}
	
	public void actualizarUsuario(Usuario usuario){
		
	}
	//login
	public boolean buscarUsuario(String usuario, String contrasena){
		String linea, auxUsuario="", auxContrasena="";
//		List<Usuario> usuarios = new ArrayList<>();
		int i=0, j=0;
		
		try{
			FileReader encontrarUsuario = new FileReader(rutaDelArchivo);
			BufferedReader bufferLinea = new BufferedReader(encontrarUsuario);
			//StringBuffer auxUsuario, auxContrasena = new StringBuffer();
//			StringTokenizer separador = null;
			
			
			while((linea=bufferLinea.readLine())!=null){
				System.out.println("linea del archivo "+i + linea);
				while(linea.charAt(i)!='|'){
					auxUsuario +=linea.charAt(i);
					i++;
				}
				System.out.println("auxUsuario: "+auxUsuario+ " usuario: "+ usuario);
				
				
				for(j=i;j<linea.length();j++){
					if(linea.charAt(j)=='%'){
						while(linea.charAt(j+1)!='&'){
							auxContrasena+=linea.charAt(j);
							j++;
						}	
					}
				}
				System.out.println("auxContrasena: "+auxContrasena+ " contrasena: "+ contrasena);
//				
//				Pattern user = Pattern.compile("[a-zA-z]|");
//				Matcher busquedaUser = user.matcher(linea);
//				busquedaUser.find();
//				auxUsuario = busquedaUser.group();
//				System.out.println("auxUsuario: "+auxUsuario+ " usuario: "+ usuario);
//				
//				Pattern password = Pattern.compile("%(a-zA-Z0-9)&");
//				Matcher busquedaPassword = password.matcher(linea);
//				if(busquedaPassword.find()){
//					auxContrasena = busquedaPassword.group(1);
//					
				
				
			}	
				
				if(usuario==auxUsuario && contrasena==auxContrasena){
					System.out.println("usuario: "+usuario);
					System.out.println("contrasena: "+contrasena);
				    System.out.println("usuario encontrado");
				}else{
					System.out.println("Usuario invalido");
				}
			encontrarUsuario.close();
		}catch(IOException e){
			System.out.println("Error al leer el archivo"+e);
			
		}
		
		return false;
		}
	}
