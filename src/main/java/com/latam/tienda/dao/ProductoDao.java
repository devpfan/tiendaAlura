package com.latam.tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Producto;



public class ProductoDao {
	
	private EntityManager em;

	public ProductoDao(EntityManager em) {
		
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	
	public Producto consultaPorId(Long id) {
		return em.find(Producto.class, id);
	}
	
	public List<Producto> consultarTodos(){
		String jpql = "SELECT P FROM Producto AS P";
		return em.createQuery(jpql,Producto.class).getResultList();
	}
	
	public List<Producto> consultaPorNombre(String nombre){
		String jpql ="SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
		return em.createQuery(jpql).setParameter("nombre",nombre).getResultList();
	}

}
