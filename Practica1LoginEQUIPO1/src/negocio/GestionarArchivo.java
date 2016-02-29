package negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import modelo.Usuario;

public class GestionarArchivo {
	private File rutaDelArchivo;
	private Usuario unUsuario;
	
	public GestionarArchivo(){
		rutaDelArchivo = null;
		unUsuario = new Usuario();
	}
	
	public GestionarArchivo(String ruta) {
		unUsuario = new Usuario();
		try {
			//Creacion o apertura del archivo
			rutaDelArchivo = new File(ruta,"prueba.txt");
			System.out.println(rutaDelArchivo.getPath());

		} catch (NullPointerException e) {
			System.out.println("Error al crear el archivo" + e);
		}
	}

	public boolean crearUsuario(Usuario usuario) {
		try {
			FileWriter agregarUsuario = new FileWriter(rutaDelArchivo, true);
			agregarUsuario.write(usuario.getNombres() + "|" + usuario.getApellidoPaterno() + "|"
					+ usuario.getApellidoMaterno() + "|" + usuario.getCorreo() + "|" + usuario.getContrasena() + "\n");
			/*System.out.println(usuario.getNombres() + "|" + usuario.getApellidoPaterno() + "|"
					+ usuario.getApellidoMaterno() + "|" + usuario.getCorreo() + "|" + usuario.getContrasena() + "&");*/
			agregarUsuario.close();
			return true;
			
		} catch (IOException e) {
			System.out.println("Error al agregar un usuario" + e);
			return false;
		}
	
	}

	public void actualizarUsuario(Usuario usuario) {

	}

	// login
	public Usuario buscarUsuario(String usuario) {
		String linea=" | | | | ";
		String []lineaDividida=null;
		int i = 0;
		try {
			BufferedReader bufferLinea = new BufferedReader(new FileReader(rutaDelArchivo));
			// StringBuffer auxUsuario, auxContrasena = new StringBuffer();
			// StringTokenizer separador = null;

			while (linea!= null) {
				//System.out.println("linea del archivo " + linea.length());
				lineaDividida = linea.split("\\|");

				
				if(lineaDividida.length==0){
					unUsuario=null;
				}else if(lineaDividida[3].equals(usuario)){
					System.out.println("Usuario: "+usuario+" encontrado"+" Longitud de lineaDividida: "+lineaDividida.length);
					unUsuario.setNombres(lineaDividida[0]);
					unUsuario.setApellidoPaterno(lineaDividida[1]);
					unUsuario.setApellidoMaterno(lineaDividida[2]);
					unUsuario.setCorreo(lineaDividida[3]);
					unUsuario.setContrasena(lineaDividida[4]);
					return unUsuario;
				}
				linea=bufferLinea.readLine();
			}
			bufferLinea.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo" + e);

		}

		return unUsuario;
	}
	
	public void cerarArchivo(){
		
	}
}
