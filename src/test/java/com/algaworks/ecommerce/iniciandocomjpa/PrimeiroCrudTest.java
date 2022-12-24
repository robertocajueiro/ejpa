package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest  {

    // Delete
    @Test
    public void excluirCliente(){
        Cliente cliente = entityManager.find(Cliente.class, 2);

        cliente.setId(2);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        Cliente verificaCliente = entityManager.find(Cliente.class, 2);
        Assert.assertNull(verificaCliente);
    }

    // Upadate
    @Test
    public void atualizarCliente(){
        Cliente cliente = new Cliente();

        cliente.setId(1);
        cliente.setNome("Lucas Batista Cajueiro");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }
    // Read
    @Test
    public void buscarPorId(){
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Assert.assertNotNull(cliente);
        Assert.assertEquals("Lucas Cajueiro", cliente.getNome());

        System.out.println("Cliente: " + cliente.getNome());
    }

    // Create
    @Test
    public void inserirCliente(){
        Cliente cliente = new Cliente();

        cliente.setId(3);
        cliente.setNome("Aires Maria");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    // Popular o banco
    @Test
    public void abrirEFecharATransacao(){

        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
    }
}
