/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.util.List;
import models.entity.Prestamo;

public interface IPrestamoDao {
    public List<Prestamo> Listar();
     public Prestamo getPrestamo (int id);
     public void Guardar(Prestamo prestamo);
     public void Insertar(Prestamo prestamo);
     public void Eliminar (int id);
}
