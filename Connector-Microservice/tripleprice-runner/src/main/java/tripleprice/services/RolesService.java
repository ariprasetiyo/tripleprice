package tripleprice.services;

import java.util.List;

import tripleprice.model.RolesModel;

public interface RolesService {
	
	public List<RolesModel> viewSysRoleAll();

	public List<RolesModel> getListIdByName(List<String> listAuthorities);
}
