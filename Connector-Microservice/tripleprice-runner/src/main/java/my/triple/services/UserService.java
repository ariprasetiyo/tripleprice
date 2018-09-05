package my.triple.services;

import my.triple.dto.RequestData;
import my.triple.dto.ResponseData;
import my.triple.dto.UserDto;

public interface UserService {
	boolean deleteUser(long idUser);

	UserDto saveUserAndRole(UserDto user);

	UserDto updateUserAndRole(UserDto user);

	ResponseData listUser(RequestData requestData);

	UserDto getUser();

}
