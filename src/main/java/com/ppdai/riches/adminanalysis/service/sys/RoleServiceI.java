package com.ppdai.riches.adminanalysis.service.sys;

import java.util.List;

import com.ppdai.riches.adminanalysis.pageModel.base.PageFilter;
import com.ppdai.riches.adminanalysis.pageModel.base.Tree;
import com.ppdai.riches.adminanalysis.pageModel.sys.Role;

public interface RoleServiceI {

	public List<Role> dataGrid(Role role, PageFilter ph);

	public Long count(Role role, PageFilter ph);

	public void add(Role role);

	public void delete(Long id);

	public void edit(Role role);

	public Role get(Long id);

	public void grant(Role role);

	public List<Tree> tree();

}
