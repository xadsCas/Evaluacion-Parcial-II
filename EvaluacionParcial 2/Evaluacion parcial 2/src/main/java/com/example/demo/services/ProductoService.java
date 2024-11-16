/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.services;

/**
 *
 * @author ernes
 */

import com.example.demo.dto.Producto;
import java.util.List;
import java.util.Optional;



public interface ProductoService {
    List<Producto> GetAllProductos();
    Optional<Producto> getProductoById(Long id);
    Optional<Producto> CreateProducto(Producto producto);
    Producto updateProducto(Long id,Producto producto);
    void deleteProductoById(Long id);
}
