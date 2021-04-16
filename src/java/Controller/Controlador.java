/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Config.Conexion;
import Entidad.Persona;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {
    //INSTANCIAMOS UNA CONEXION
    Conexion con=new Conexion();
    JdbcTemplate jdbcTemplate=new JdbcTemplate(con.Conectar());
    //CREAMOS UN OBJETO DE SPRING PARA PROCESO DE MODELADO Y VISTA
    ModelAndView mav=new ModelAndView();
    //GENERAMOS UNA VARIABLE PARA EL CAMPO CLAVE
    int id;
    //gENERAMOS UN OBJETO DEL TIPO LIST PARA EL ARREGLO DE DATOS
    List datos;
    
    
    //ESTE METODO DESPLIEGA EN LA PAGINA PRINCIPAL EL LISTADO CON EL QUE TRABAJAREMOS
    @RequestMapping("index.htm")
    public ModelAndView Listar(){
        String sql="select * from persona";
        datos=this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("index");
        return mav;
    }
    
    //ESTE METODO ENVIA A LA VISTA CORRESPONDIENTE PARA UNA CAPTURA
    @RequestMapping(value="agregar.htm", method=RequestMethod.GET)
    public ModelAndView Agregar(){
    mav.addObject(new Persona());
    mav.setViewName("agregar");
    return mav;
    }
    //ESTE METODO NOS PERMITE ENVIAR LOS DATOS CAPTURADOS EN EL FORMULARIO Y EMPTARLOS
    @RequestMapping(value="agregar.htm", method=RequestMethod.POST)
    public ModelAndView Agregar(Persona p){
    String sql="insert into persona(Nombre, Correo, Nacionalidad)values(?,?,?)";
    this.jdbcTemplate.update(sql,p.getNom(),p.getCorreo(),p.getNacio());
    return new ModelAndView("redirect:/index.htm");
    
    }
    
    //ESTE METODO NOS ENVIA AL FORMULARIO CORRESPONDIENTE TOMANDO EL CAMPO CLAVE
     @RequestMapping(value="editar.htm", method=RequestMethod.GET)
     public ModelAndView Editar(HttpServletRequest request){
         id=Integer.parseInt(request.getParameter("id"));
         String sql="select * from persona where Id="+id;
         datos=this.jdbcTemplate.queryForList(sql);
         mav.addObject("lista",datos);
         mav.setViewName("editar");
         return mav;
     }
     
     //ESTE METODO GUARDA LOS CAMBIOS REALIZADOS EN EL FORMULARIO Y ACTUALIZA LOS REGISTROS
     @RequestMapping(value="editar.htm", method=RequestMethod.POST)
     public ModelAndView Editar(Persona p){
         String sql="update persona set Nombre=?,Correo=?,Nacionalidad=? where Id=?";
         this.jdbcTemplate.update(sql,p.getNom(),p.getCorreo(),p.getNacio(),id);
         return new ModelAndView("redirect:/index.htm");
     
     }
         
     //ESTE METODO BORRA DIRECTAMENTE UN REGISTRO DEL LISTADO PRINCIPAL
     @RequestMapping("borrar.htm")
      public ModelAndView Borrar(HttpServletRequest request){
         id=Integer.parseInt(request.getParameter("id"));
         String sql="delete from persona where Id="+id;
         this.jdbcTemplate.update(sql);
         return new ModelAndView("redirect:/index.htm");
}
}
