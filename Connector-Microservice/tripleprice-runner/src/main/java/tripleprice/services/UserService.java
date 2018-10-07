package tripleprice.services;

import tripleprice.dto.RequestData;
import tripleprice.dto.ResponseData;
import tripleprice.dto.UserDto;

public interface UserService {
	boolean deleteUser(long idUser);

	UserDto saveUserAndRole(UserDto user);

	UserDto updateUserAndRole(UserDto user);

	ResponseData listUser(RequestData requestData);

	UserDto getUser();

}
