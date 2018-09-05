/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.triple.controller.rest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.triple.dto.Dto;
import my.triple.dto.RequestData;
import my.triple.dto.RequestDto;
import my.triple.dto.ResponseData;
import my.triple.dto.ResponseDto;
import my.triple.dto.UserDto;
import my.triple.ref.StatusType;
import my.triple.services.UserService;

@RestController
@RequestMapping(value = "/admin/v1/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = { "application/json",
			"application/xml" }, consumes = { "application/json", "application/xml" })
	public ResponseEntity<ResponseDto> deleteUser(@RequestBody @Valid RequestDto<Dto> user) {
		Dto dto = new Dto();
		dto.setId(user.getRequestData().getId());
		ResponseDto responseDto = new ResponseDto();
		boolean isSuccessDeleteUser = userService.deleteUser(user.getRequestData().getId());
		if (isSuccessDeleteUser) {
			responseDto = new ResponseDto(StatusType.DELETE_SUCCEED, StatusType.DELETE_SUCCEED.stringValue, dto);
		} else {
			responseDto = new ResponseDto(StatusType.DELETE_ERROR, StatusType.DELETE_ERROR.stringValue, dto);
		}
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public Future<ResponseEntity<ResponseDto>> getListUser(@RequestBody @Valid RequestDto<RequestData> user) {

		return CompletableFuture.supplyAsync(() -> {
			try {
				ResponseDto responseDto = new ResponseDto();
				ResponseData responseData = userService.listUser(user.getRequestData());
				responseDto.setResponseData(responseData);
				return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<ResponseDto>(new ResponseDto(), HttpStatus.NOT_ACCEPTABLE);
		});
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public Future<ResponseEntity<ResponseDto>> saveUser(@RequestBody @Valid RequestDto<UserDto> user) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				UserDto userDto = userService.saveUserAndRole(user.getRequestData());
				ResponseDto userDtoJson = new ResponseDto(userDto.getStatusType(), userDto.getMessage(), userDto);
				return new ResponseEntity<ResponseDto>(userDtoJson, HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<ResponseDto>(new ResponseDto(), HttpStatus.NOT_ACCEPTABLE);
		});
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" }, consumes = { "application/json", "application/xml" })
	public Future<ResponseEntity<ResponseDto>> editUser(@RequestBody @Valid RequestDto<UserDto> user) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				UserDto userDto = userService.updateUserAndRole(user.getRequestData());
				ResponseDto userDtoJson = new ResponseDto(userDto.getStatusType(), userDto.getMessage(), userDto);
				return new ResponseEntity<ResponseDto>(userDtoJson, HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<ResponseDto>(new ResponseDto(), HttpStatus.NOT_ACCEPTABLE);
		});
	}

}
