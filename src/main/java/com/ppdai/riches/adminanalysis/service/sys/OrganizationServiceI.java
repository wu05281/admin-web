package com.ppdai.riches.adminanalysis.service.sys;

import java.util.List;

import com.ppdai.riches.adminanalysis.pageModel.base.Tree;
import com.ppdai.riches.adminanalysis.pageModel.sys.Organization;

public interface OrganizationServiceI {

	public List<Organization> treeGrid();

	public void add(Organization organization);

	public void delete(Long id);

	public void edit(Organization organization);

	public Organization get(Long id);

	public List<Tree> tree();

}
