package my.triple.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.triple.dao.RolesDao;
import my.triple.model.RolesModel;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	RolesDao rolesDao;

	@Override
	public List<RolesModel> viewSysRoleAll() {
		return (List<RolesModel>) rolesDao.findAll();
	}

	@Override
	public List<RolesModel> getListIdByName(List<String> listAuthorities) {
		return rolesDao.getListIdByName(listAuthorities);
	}
}
