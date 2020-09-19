package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;
import java.lang.Integer;

@WebServlet(
            urlPatterns = "/CVDSLabCinco"
	)
public class MyServlet extends HttpServlet{
    static final long serialVersionUID = 35L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
       int id;
       Todo todo;
       String name;
       Writer responseWriter = resp.getWriter();
       
       try{
    	   ArrayList<Todo> todoList = new ArrayList<Todo>();
    	   Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
    	   
    	   if(optName.isPresent()){
    		   resp.setStatus(HttpServletResponse.SC_OK);
    		   name = optName.get();
    	   }
    	   else{
    		   resp.setStatus(HttpServletResponse.SC_NOT_FOUND);	
    		   name = "";	
    	   }

    	   id = Integer.parseInt(name);
    	   todo = Service.getTodo(id);
    	   todoList.add(todo);
    	   responseWriter.write(Service.todosToHTMLTable(todoList)); 
       }
       catch(NumberFormatException num){
    	   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    	   responseWriter.write("requerimiento inv�lido");
       }
       catch(MalformedURLException mal){
    	   resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    	   responseWriter.write("error interno en el servidor");
       }
       catch(Exception e){
    	   resp.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
    	   responseWriter.write("requerimiento inv�lido");
       }  
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}