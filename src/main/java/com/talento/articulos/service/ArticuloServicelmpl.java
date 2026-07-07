package com.talento.articulos.service;

import com.talento.articulos.model.Articulo;
import com.talento.articulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ArticuloServicelmpl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloServicelmpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }
    @Override
    public List<Articulo> listarArticulos() {
        return articuloRepository.findAll();
    }
    @Override
    public Optional<Articulo> obtenerArticuloPorId(Long id) {
        return articuloRepository.findById(id);
    }
    @Override
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }
    @Override
    public Articulo actualizarArticulo(Long id, Articulo articulo) {
        articulo.setId(id);
        return articuloRepository.save(articulo);
    }
    @Override
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }

}
