/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.dao;

import com.artivisi.training.domain.Role;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author endy
 */
@Repository @Transactional
public class RoleDao {
    @PersistenceContext
    private EntityManager entityManager;
        
    public void simpan(Role u) throws Exception {
        entityManager.persist(u);
    }
    
    public Role cariById(Integer id){
        return entityManager.find(Role.class, id);
    }

    public List<Role> semuaRole() {
        return entityManager
                .createQuery("select r from Role r order by r.nama")
                .getResultList();
    }
}
