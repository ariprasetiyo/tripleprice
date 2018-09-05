package my.triple.services;

import my.triple.dto.RequestData;
import my.triple.dto.ResponseData;
import my.triple.dto.RolesDto;

public interface UserGroupService {

	ResponseData listUserGroup(RequestData requestData);

	ResponseData saveUserGroup(RolesDto rolesDto);

	ResponseData editUserGroup(RolesDto rolesDto);

}
