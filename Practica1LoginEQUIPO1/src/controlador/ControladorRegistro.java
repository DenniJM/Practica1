package controlador;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import negocio.GestionarArchivo;

/**
 * Servlet implementation class ControladorRegistro
 */
@WebServlet("/registro")
public class ControladorRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String ruta =request.getServletContext().getRealPath("/");
		GestionarArchivo archivoRegistro = new GestionarArchivo(ruta+"/archivos");
				
		//instancia usuario para agregar los datos obtenidos
				Usuario usuario = new Usuario();
				
				
				//System.out.println("ruta: "+ruta);
				//Obtiene datos del formulario
				String nombre=request.getParameter("nombres");
				String apellidoPaterno=request.getParameter("apellidoPaterno");
				String apellidoMaterno=request.getParameter("apellidoMaterno");
				String correo = request.getParameter("correoElectronico");
				String contrasena = request.getParameter("contrasena");
				
				System.out.println(nombre+"\n"+apellidoMaterno+"\n"+apellidoPaterno+"\n"+correo+"\n"+contrasena);
				
				//Agrega los datos obtenidos a la instancia
				usuario.setNombres(nombre);
				usuario.setApellidoPaterno(apellidoPaterno);
				usuario.setApellidoMaterno(apellidoMaterno);
				usuario.setCorreo(correo);
				usuario.setContrasena(contrasena);
				
				//enviar datos al archivo 
				archivoRegistro.crearUsuario(usuario);
				response.sendRedirect("Registro.html");
				System.gc();
				
				
	}

}
