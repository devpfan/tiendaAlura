package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;
import com.latam.tienda.dao.CategoriaDao;
import com.latam.tienda.dao.ProductoDao;

public class RegistroDeProducto {

	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Samsung","Telefono usado",new BigDecimal("1000"),celulares);
		
		
		EntityManager em = JPAUtils.getEntityManager();
		
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.guardar(celulares);
		productoDao.guardar(celular);
		
		em.getTransaction().commit();
		em.close();

	}

}
