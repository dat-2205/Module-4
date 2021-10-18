package com.codegym.repository.image;

import com.codegym.model.Customer;
import com.codegym.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ImageRepository implements IImageRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Image> findAll() {
        String queryStr = "select i from Image as i";
        TypedQuery<Image> query = em.createQuery(queryStr, Image.class);
        return query.getResultList();
    }

    @Override
    public Image find(Long id) {
        String queryStr = "select i from Image as i where i.id = ?1";
        TypedQuery<Image> query = em.createQuery(queryStr,Image.class);
        query.setParameter(1,id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Image image) {
        if(image.getId()!=null) {
            em.merge(image);
        }else {
            em.persist(image);
        }
    }

    @Override
    public void remove(Long id) {
        Image image = find(id);
        if (image != null) {
            em.remove(image);
        }
    }

    @Override
    public List<Image> findAllByCustomerId(Long id) {
        String queryStr = "select i from Image as i where i.id = ?1";
        TypedQuery<Image> query = em.createQuery(queryStr,Image.class);
        query.setParameter(1,id);
        return query.getResultList();
    }
}
