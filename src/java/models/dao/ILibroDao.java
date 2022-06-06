/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.util.List;
import models.entity.Libro;

public interface ILibroDao {
        public List<Libro> Listar();
        public Libro getLibro (int id);
        public void Guardar(Libro libro);
        public void Insertar(Libro libro);
        public void Eliminar (int id);
}