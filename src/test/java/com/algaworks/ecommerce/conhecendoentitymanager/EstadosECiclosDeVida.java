package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Categoria;
import org.junit.Test;

public class EstadosECiclosDeVida extends EntityManagerTest {

    @Test
    public void analisarEstados(){
        Categoria categoriaNovo = new Categoria();
        categoriaNovo.setNome("Eletrônicos");

        Categoria categoriaGerenciadaMerge =  entityManager.merge(categoriaNovo);

        Categoria categoriaGerenciada = entityManager.find(Categoria.class, 1);

        entityManager.remove(categoriaGerenciada);
        entityManager.persist(categoriaGerenciada);

        entityManager.detach(categoriaGerenciada);

    }
}
