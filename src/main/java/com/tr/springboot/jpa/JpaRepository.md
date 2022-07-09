### JpaRepository 官方定义：
@NoRepositoryBean
public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T>

@NoRepositoryBean
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> 

### 由上可见：
JpaRepository 继承了接口 PagingAndSortingRepository 和 QueryByExampleExecutor；
PagingAndSortingRepository 又继承 CrudRepository。


### CrudRepository<T, ID> 提供的方法：
/** 保存一个实体 */
<S extends T> S save(S entity);

/** 保存提供的所有实体 */
<S extends T> Iterable<S> saveAll(Iterable<S> entities);

/** 根据id查询对应的实体 */
Optional<T> findById(ID id);

/** 根据id查询对应的实体是否存在 */
boolean existsById(ID id);

/** 查询所有的实体 */
Iterable<T> findAll();

/** 根据给定的id集合查询所有对应的实体，返回实体集合 */
Iterable<T> findAllById(Iterable<ID> ids);

/** 统计现存实体的个数 */
long count();

/** 根据id删除对应的实体 */
void deleteById(ID id);

/** 删除给定的实体 */
void delete(T entity);

/** 删除给定的实体集合 */
void deleteAll(Iterable<? extends T> entities);

/** 删除所有的实体 */
void deleteAll();


### PagingAndSortingRepository<T, ID> 提供的方法：
/** 返回所有的实体，根据 Sort 参数提供的规则排序 */
Iterable<T> findAll(Sort sort);

/** 返回分页实体，根据 Pageable 参数提供的规则进行过滤 */
Page<T> findAll(Pageable pageable);


### JpaRepository<T, ID> 提供的方法：
/** 将所有未决的更改刷新到数据库 */
void flush();

/** 保存一个实体并立即将更改刷新到数据库 */
<S extends T> S saveAndFlush(S entity);

/** 在一个批次中删除给定的实体集合，这意味着将产生一条单独的Query */
void deleteInBatch(Iterable<T> entities);

/** 在一个批次中删除所有的实体 */
void deleteAllInBatch();

/** 根据给定的id标识符，返回对应实体的引用 */
T getOne(ID id);
