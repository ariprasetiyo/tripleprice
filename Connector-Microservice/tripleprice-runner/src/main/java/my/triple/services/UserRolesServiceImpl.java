package my.triple.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.triple.dao.UserRolesDao;
import my.triple.dao.UserRolesDaoImpl;
import my.triple.model.UserRolesModel;
import my.triple.ref.ActionType;
import my.triple.util.LogUtil;

@Service
public class UserRolesServiceImpl implements UserRolesService {

	private static Logger logger = LoggerFactory.getLogger(UserRolesServiceImpl.class);

	@Autowired
	private UserRolesDao userRolesDao;

	@Autowired
	private UserRolesDaoImpl userRolesDaoEM;

	@Override
	public UserRolesModel save(UserRolesModel sysUserRoles) {
		return userRolesDao.save(sysUserRoles);
	}

	@Override
	public int deleteByUserId(long userId) {
		int countDelete = userRolesDaoEM.deleteByUserId(userId);
		LogUtil.logDebugType(logger, true, ActionType.DELETE, "delete  UserRolesModel : {} for update", countDelete);
		return countDelete;
	}
}
