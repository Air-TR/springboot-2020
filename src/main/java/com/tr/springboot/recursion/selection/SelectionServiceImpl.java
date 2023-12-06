package com.tr.springboot.recursion.selection;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Author: TR
 */
@Service
public class SelectionServiceImpl implements SelectionService {

    @Resource
    private SelectionRepository selectionRepository;

    @Override
    public Selection findById(Long id) {
        return selectionRepository.findById(id).orElseThrow(() -> new RuntimeException("no record find by id = " + id));
    }

    @Override
    public String formatAllNameById(Long id) {
        return formatAllName(findById(id));
    }

    @Override
    public String formatAllName(Selection selection) {
        return formatAllName(selection, selection.getName());
    }

    /**
     * 递归拼接父级名称
     */
    private String formatAllName(Selection selection, String allName) {
        if (Objects.isNull(selection.getParentId())) {
            return allName;
        }
        selection = findById(selection.getParentId());
        allName = selection.getName() + "/" + allName;
        return formatAllName(selection, allName);
    }

    @Override
    public List<Selection> findVoListByType(String type) {
        List<Selection> selections = selectionRepository.findAllByTypeAndParentIdIsNull(type);
        selections.forEach(selection -> {
            formatChildren(selection);
        });
        return selections;
    }

    /**
     * 递归 set 子集
     */
    private Selection formatChildren(Selection selection) {
        List<Selection> children = selectionRepository.findAllByParentId(selection.getId());
        if (!CollectionUtils.isEmpty(children)) {
            selection.setChildren(children);
            children.forEach(child -> formatChildren(child));
        }
        return selection;
    }

}
