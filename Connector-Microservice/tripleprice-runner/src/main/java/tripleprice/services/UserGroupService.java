package tripleprice.services;

import tripleprice.dto.RequestData;
import tripleprice.dto.ResponseData;
import tripleprice.dto.RolesDto;

public interface UserGroupService {

	ResponseData listUserGroup(RequestData requestData);

	ResponseData saveUserGroup(RolesDto rolesDto);

	ResponseData editUserGroup(RolesDto rolesDto);

}
