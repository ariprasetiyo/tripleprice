package tripleprice.services;

import tripleprice.model.UserRolesModel;

public interface UserRolesService {
	public UserRolesModel save(UserRolesModel sysUserRoles);
	public int deleteByUserId(long userId);
}
