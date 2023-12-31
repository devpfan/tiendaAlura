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
		
		
		
		EntityManager em = JPAUtils.getEntityManager();
		
		
		
		em.getTransaction().begin();
		
		
		em.persist(celulares);
		
		celulares.setNombre("LIBROS");
		
		em.flush();
		em.clear();
		
		celulares=em.merge(celulares);
		celulares.setNombre("SOFTWARES");
		
		em.flush();
		em.clear();
		
		celulares=em.merge(celulares);
		em.remove(celulares);
		em.flush();

	}

}
