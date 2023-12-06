package com.tr.springboot.recursion.selection;

import java.util.List;

public interface SelectionService {

    Selection findById(Long id);

    List<Selection> findVoListByType(String type);

    String formatAllNameById(Long id);

    String formatAllName(Selection selection);

}
