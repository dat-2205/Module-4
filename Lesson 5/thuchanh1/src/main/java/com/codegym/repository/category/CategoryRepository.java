package com.codegym.repository.category;

import com.codegym.model.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CategoryRepository implements ICategoryRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Category> findAll() {
        String queryStr = "select m from Category m";
        TypedQuery<Category> query = em.createQuery(queryStr, Category.class);
        return query.getResultList();
    }

    @Override
    public Category find(Long id) {
        String queryStr = "select m from Category m where m.id =:id ";
        TypedQuery<Category> query = em.createQuery(queryStr,Category.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Category category) {
        if(category.getId() != null) {
            em.merge(category);
        }else {
            em.persist(category);
        }
    }

    @Override
    public void remove(Long id) {
        Category category = find(id);
        if(category !=null) {
            em.remove(category);
        }
    }
}
