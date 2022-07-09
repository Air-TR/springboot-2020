### 参数赋值的两种方式：
@Query(value = "select * from user where user_id = ?1", nativeQuery = true)
@Query(value = "select * from user where user_id = :userId", nativeQuery = true)
User findByUserId(String userId); // 以上 ?1 / :userId 都可以进行参数赋值


### 要支持原生 SQL 查询，添加 nativeQuery = true（用表名和字段名）：
@Query(value = "select * from user where user_id = :userId", nativeQuery = true)
@Query(value = "select name, birth_day from user where user_id = :userId", nativeQuery = true)


### HQL 查询写法（用实体名和实体属性名）：
@Query("from User where userId = :userId") // HQL 查询全部字段，去掉 "select * "，加上反而错误
@Query("select name, birthDay from User where userId = :userId") // HQL 查询部分字段，要写 select


### 以下两种 HQL 写法错误：
1. @Query("select * from User where userId = :userId") // 错误，去掉 "select * " 就正确
2. @Query("select User from User where userId = :userId") // 错误，给 User 起别名解决
### 以上两条 HQL 正确写法：
1. @Query("from User where userId = :userId") // 正确
2. @Query("select u from User u where u.userId = :userId") // 正确
