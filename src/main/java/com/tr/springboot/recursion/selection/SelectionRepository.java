package com.tr.springboot.recursion.selection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SelectionRepository extends JpaRepository<Selection, Long>, JpaSpecificationExecutor<Selection> {

    List<Selection> findAllByParentId(Integer parentId);

    List<Selection> findAllByTypeAndParentIdIsNull(String type);

}
