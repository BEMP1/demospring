
package com.example.demo.servicios;

import com.example.demo.excepciones.MiExcepcion;
import com.example.demo.repositorios.NoticiaRepositorio;
import com.expample.demo.entidades.Noticia;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NoticiaServicio {
    @Autowired
    private NoticiaRepositorio noticiaRepositorio;
    
    @Transactional
    public void crearNoticia(String titulo,String cuerpo)throws MiExcepcion{
        validar(titulo,cuerpo);
        Noticia noticia = new Noticia();
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        
        noticiaRepositorio.save(noticia);
    }
    
    public List<Noticia> listarNoticias(){
        List<Noticia> noticias = new ArrayList();
        noticias = noticiaRepositorio.findAll();
        return noticias;
    }
    
    public void modificarNoticia(String titulo,String cuerpo)throws MiExcepcion{
        validar(titulo,cuerpo);
        Optional<Noticia> respuesta = noticiaRepositorio.findById(titulo);
        if (respuesta.isPresent()) {
            Noticia noticia = respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
        }
    }
    
    private void validar(String titulo, String cuerpo) throws MiExcepcion{
        if (titulo==null) {
            throw new MiExcepcion("El titulo no puede ser nulo");
        }
        if (cuerpo==null) {
            throw new MiExcepcion("El cuerpo no puede ser nulo");
        }
    }
}
