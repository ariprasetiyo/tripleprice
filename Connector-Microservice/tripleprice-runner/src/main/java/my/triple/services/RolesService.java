package my.triple.services;

import java.util.List;

import my.triple.model.RolesModel;

public interface RolesService {
	
	public List<RolesModel> viewSysRoleAll();

	public List<RolesModel> getListIdByName(List<String> listAuthorities);
}
