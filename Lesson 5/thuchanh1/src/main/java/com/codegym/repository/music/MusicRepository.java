package com.codegym.repository.music;

import com.codegym.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class MusicRepository implements IMusicRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Music> findAll() {
        String queryStr = "select m from Music m";
        TypedQuery<Music> query = em.createQuery(queryStr, Music.class);
        return query.getResultList();
    }

    @Override
    public Music find(Long id) {
        String queryStr = "select m from Music m where m.id =:id ";
        TypedQuery<Music> query = em.createQuery(queryStr,Music.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Music music) {
        if(music.getId() != null) {
            em.merge(music);
        }else {
            em.persist(music);
        }
    }

    @Override
    public void remove(Long id) {
        Music music = find(id);
        if(music !=null) {
            em.remove(music);
        }
    }
}
