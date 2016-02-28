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
 * Servlet implementation class ControladorLogin
 */
@WebServlet("/login")
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Usuario usuarioEncontrado;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogin() {
        super();
        usuarioEncontrado = new Usuario();
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
		String ruta = request.getServletContext().getRealPath("/");
		GestionarArchivo archivoregistro = new GestionarArchivo(ruta+"/archivos");
		String usuario = request.getParameter("usuario");
		String pass = request.getParameter("contrasena");
		System.out.println("nombre: "+usuario+" contrasena "+pass);
		usuarioEncontrado = archivoregistro.buscarUsuario(usuario);
		if(usuarioEncontrado.getNombres().equals(usuario) && usuarioEncontrado.getContrasena().equals(pass)){
			System.out.println("usuario encontrado");
			response.sendRedirect("loginExitoso.html");
		}else{
			response.sendRedirect("loginError.html");
		}
		
	}

}
