
package com.example.demo.repositorios;

import com.expample.demo.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia,String> {
    //@Query ("SELECT 1 FROM noticia 1 WHERE 1.titulo =:titulo")
    //public Noticia buscarPorNoticia(String titulo);
}
