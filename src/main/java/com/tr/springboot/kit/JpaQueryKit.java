package com.tr.springboot.kit;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;

/**
 * Jpa 直接根据 SQL 查询返回结果
 *
 * @Author: TR
 * @Date: 2023/5/11
 */
@Component
public class JpaQueryKit {

    @PersistenceContext
    private EntityManager entityManager;

    public HashMap<Object, Object> getMap(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return (HashMap<Object, Object>) nativeQuery.getSingleResult();
    }

    public List<HashMap<Object, Object>> getListMap(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return nativeQuery.getResultList();
    }

}
