package models.dao;

import java.util.List;
import models.entity.Cliente;

public interface IClienteDao {
     public List<Cliente> Listar();
     public Cliente getCliente (int id);
     public void Guardar(Cliente cliente);
     public void Insertar(Cliente cliente);
     public void Eliminar (int id);
}

