package com.tr.springboot.kit.jpa;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;

/**
 * Jpa 查询工具类
 *
 * @Author: TR
 * @Date: 2023/06/26
 */
@Component
public class PgsqlJpaQueryKit {

    @PersistenceContext(unitName = "pgsql") // 指定使用 pgsql 数据源
    private EntityManager entityManager;

    /**
     * NativeQuery 写普通 sql，如：select * from user_info where user_id = 1
     * 注：实测发现 classType 只能传被 @Entity 注释的实体类，否则会报：
     *  org.hibernate.MappingException: Unknown entity: com.tr.controller.vo.XxxVo
     */
    public <T> T findOne(Class<T> classType, String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql, classType);
        return (T) nativeQuery.getSingleResult();
    }

    /**
     * NativeQuery 写普通 sql，如：select * from user_info
     */
    public <T> List<T> findList(Class<T> classType, String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql, classType);
        return nativeQuery.getResultList();
    }

    /**
     * Query 写 hibernate 语法 sql，如：from UserInfo where userId = '1' 或 select t from UserInfo t where t.userId = '1'
     */
    public <T> T findOneHibernate(Class<T> classType, String sql) {
        Query query = entityManager.createQuery(sql, classType);
        return (T) query.getSingleResult();
    }

    /**
     * Query 写 hibernate 语法 sql，如：from UserInfo 或 select t from UserInfo t
     */
    public <T> List<T> findListHibernate(Class<T> classType, String sql) {
        Query query = entityManager.createQuery(sql, classType);
        return query.getResultList();
    }

    /**
     * 注：最终 map 里的 key 全小写，即使别名使用大写字母如 userId，最终 key 也是小写 userid
     *  如果写 select * 报错，尝试写列名查询，如 select name, age from user_info where id = '1'
     *  实际测试结果：支持 select * 查询，正常返回 map 结果，如果报错，可能是因为某些字段无法自动转换，如 json
     */
    public HashMap getMap(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return (HashMap) nativeQuery.getSingleResult();
    }

    /**
     * 注：最终 map 里的 key 全小写，即使别名使用大写字母如 userId，最终 key 也是小写 userid
     *  如果写 select * 报错，尝试写列名查询，如 select name, age from user_info
     *  实际测试结果：支持 select * 查询，正常返回 map 结果，如果报错，可能是因为某些字段无法自动转换，如 json
     */
    public List<HashMap> getMapList(String sql) {
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return nativeQuery.getResultList();
    }

}
