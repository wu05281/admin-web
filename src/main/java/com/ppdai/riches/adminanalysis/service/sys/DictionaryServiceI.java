package com.ppdai.riches.adminanalysis.service.sys;

import java.util.List;

import com.ppdai.riches.adminanalysis.pageModel.base.PageFilter;
import com.ppdai.riches.adminanalysis.pageModel.sys.Dictionary;

public interface DictionaryServiceI {

	public List<Dictionary> dataGrid(Dictionary dictionary, PageFilter ph);

	public Long count(Dictionary dictionary, PageFilter ph);

	public void add(Dictionary dictionary);

	public void delete(Long id);

	public void edit(Dictionary dictionary);

	public Dictionary get(Long id);

	public List<Dictionary> combox(String code);

	public Dictionary checkUnique(Dictionary dictionary);

}
