//package com.tr.springboot.config;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
//import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Map;
//
///**
// * MysqlConfig 配置全部添加 @Primary
// *  @Primary：自动装配时，当出现多个 Bean 候选者，被注解为 @Primary 的 Bean 将作为首选者，否则将抛出异常。
// *
// * @EnableJpaRepositories:
// *  entityManagerFactoryRef: 实体管理工厂引用名称，对应到 @Bean 注解对应的方法
// *  transactionManagerRef: 事务管理工厂引用名称，对应到 @Bean 注解对应的方法
// *  basePackage: 用于配置扫描 Repositories 所在的 package 及子 package
// *
// * @author taorun
// * @date 2023/2/6 11:08
// */
//@Configuration
//@EnableTransactionManagement // 使用注解 @EnableTransactionManagement 开启事务支持后，可以在访问数据库的 Service 方法上添加注解 @Transactional 使用事务
//@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager",
//        basePackages = {"com.huibo.webconfig.mysql.repository"})
//public class MysqlConfig {
//
//    @Primary
//    @Bean(name = "mysqlDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.mysql")
//    public DataSource mysqlDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name = "mysqlJpaProperties")
//    @ConfigurationProperties(prefix = "spring.jpa.mysql")
//    public JpaProperties jpaProperties() {
//        return new JpaProperties();
//    }
//
//    /**
//     * 获取主库实体管理工厂对象
//     *
//     * @param builder
//     * @param dataSource
//     * @param jpaProperties
//     * @return
//     */
//    @Primary
//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("mysqlDataSource") DataSource dataSource, @Qualifier("mysqlJpaProperties") JpaProperties jpaProperties) {
//        return builder
//                .dataSource(dataSource) // 设置数据源
//                .properties(getJpaProperties(jpaProperties)) // 设置 jpa 配置
//                .packages("com.huibo.webconfig.mysql.entity") // 设置实体包路径
//                .persistenceUnit("mysql") // 设置持久化单元名，用于 @PersistenceContext 注解获取 EntityManager 时指定数据源
//                .build();
//    }
//
//    /**
//     * 多数据源下必须这样配置，否则会出现 Jpa 实体类字段不能自动驼峰匹配下划线的问题
//     * @param jpaProperties
//     * @return
//     */
//    private Map<String, String> getJpaProperties(JpaProperties jpaProperties) {
//        Map<String, String> properties = jpaProperties.getProperties();
//        properties.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
//        properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
//        return properties;
//    }
//
//    /**
//     * 获取主库事务管理对象
//     *
//     * @param entityManagerFactory
//     * @return
//     */
//    @Primary
//    @Bean(name = "transactionManager")
//    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//
//}
