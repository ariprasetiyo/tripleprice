package my.triple.services;

import my.triple.model.UserRolesModel;

public interface UserRolesService {
	public UserRolesModel save(UserRolesModel sysUserRoles);
	public int deleteByUserId(long userId);
}
