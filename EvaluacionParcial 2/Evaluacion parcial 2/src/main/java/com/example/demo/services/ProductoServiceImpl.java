/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.services;

/**
 *
 * @author ernes
 */

import com.example.demo.dao.ProductoRepository;
import com.example.demo.dto.Producto;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;







@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    public ProductoRepository productoRepository;
    
    org.slf4j.Logger logger= LoggerFactory.getLogger(ProductoServiceImpl.class);
    
    @Override
    public List<Producto> GetAllProductos(){
        List<Producto> Producto=productoRepository.findAll();
        return Producto;
    }
    
    @Override
    public Optional<Producto> getProductoById(Long id){
        Optional<Producto> searchProducto=productoRepository.findById(id);
        if(searchProducto.isPresent()){
            logger.error("Producto encontrado!!");
            return searchProducto;
        }else{
            logger.error("No se han encontrado productos con el id" + id );
            throw new NoSuchElementException("No");
        }
    }
    
    @Override
    public Optional<Producto> CreateProducto(Producto producto){
        Optional<Producto> optProducto=Optional.of(producto);
        if(optProducto.isPresent()){
            Producto newProducto= new Producto();
            newProducto.setNombre(producto.getNombre());
            newProducto.setPrecio(producto.getPrecio());
            newProducto.setDescripcion(producto.getDescripcion());
            newProducto.setExistencia(producto.getExistencia());
            newProducto.setNombreProv(producto.getNombreProv());
            productoRepository.save(newProducto);
            logger.info("Se ha creado el producto correctamente");
            Optional<Producto>rturnOptPro=Optional .of(newProducto);
            return rturnOptPro;
        }else{
            logger.error("No se ha recibido un producto para crear");
            throw new NoSuchElementException("No se ha recibido un Producto para crear");
        }
    }
    
        @Override
        public Producto updateProducto(Long id,Producto producto){
        Optional<Producto> optProducto=productoRepository.findById(id);
        if(optProducto.isPresent()){
            Producto productoUpdate = optProducto.get();
            productoUpdate.setNombre(producto.getNombre());
            productoUpdate.setPrecio(producto.getPrecio());
            productoUpdate.setDescripcion(producto.getDescripcion());
            productoUpdate.setExistencia(producto.getExistencia());
            productoUpdate.setNombreProv(producto.getNombreProv());
            productoRepository.save(productoUpdate);
            logger.error("Actualizacion correcta");
           
            return productoUpdate;
        }else{
            logger.error("No se ha recibido un producto para Actualizar");
            throw new NoSuchElementException("No se ha recibido un Producto para Actualiar");
        }
    }
        @Override
        public void deleteProductoById(Long id){
            Optional<Producto>optPro=productoRepository.findById(id);
            if(optPro.isPresent()){
                Producto productoTrust=optPro.get();
                productoRepository.deleteById(productoTrust.getId());
                logger.error("Hola profe como esta, Producto con id: "+ id+"Eliminado de forma correcta");
            }else{
                logger.error("El usuario ha eliminar no existe :v");
            }
        }
   
}
    

