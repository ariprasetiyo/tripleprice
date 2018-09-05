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
import my.triple.dto.MenuDto;
import my.triple.dto.RequestData;
import my.triple.dto.RequestDto;
import my.triple.dto.ResponseData;
import my.triple.dto.ResponseDto;
import my.triple.ref.StatusType;
import my.triple.services.MenuService;

/**
 *
 * @author ari-prasetiyo
 */
@RestController
@RequestMapping("/admin/v1/api/menu")
public class MenuRestController {

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public Future<ResponseEntity<ResponseDto>> listMenu(@RequestBody @Valid RequestDto<RequestData> menu) {

		return CompletableFuture.supplyAsync(() -> {
			try {
				ResponseDto responseDto = new ResponseDto();
				ResponseData responseData = menuService.listOfMenus(menu.getRequestData());
				responseDto.setResponseData(responseData);
				return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<ResponseDto>(new ResponseDto(), HttpStatus.NOT_ACCEPTABLE);
		});
	}

	@RequestMapping(value = "/saveMenu", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public Future<ResponseEntity<ResponseDto>> saveMenu(@RequestBody @Valid RequestDto<MenuDto> menu) {

		return CompletableFuture.supplyAsync(() -> {
			try {
				ResponseDto responseDto = new ResponseDto();
				MenuDto menuDto = menuService.validateSaveMenu(menu.getRequestData());
				responseDto.setResponseData(menuDto);
				responseDto.setStatusType(menuDto.getStatusType());
				responseDto.setMessage(menuDto.getMessage());
				return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<ResponseDto>(new ResponseDto(), HttpStatus.NOT_ACCEPTABLE);
		});
	}

	@RequestMapping(value = "/editMenu", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public Future<ResponseEntity<ResponseDto>> saveEditMenu(@RequestBody @Valid RequestDto<MenuDto> menu) {

		return CompletableFuture.supplyAsync(() -> {
			try {
				ResponseDto responseDto = new ResponseDto();
				MenuDto menuDto = menuService.validateEditMenu(menu.getRequestData());
				responseDto.setResponseData(menuDto);
				responseDto.setStatusType(menuDto.getStatusType());
				responseDto.setMessage(menuDto.getMessage());
				return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<ResponseDto>(new ResponseDto(), HttpStatus.NOT_ACCEPTABLE);
		});
	}

	@RequestMapping(value = "/deleteMenu", method = RequestMethod.DELETE, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	public Future<ResponseEntity<ResponseDto>> deleteMenu(@RequestBody @Valid RequestDto<Dto> dtoMenu) {

		return CompletableFuture.supplyAsync(() -> {
			try {
				Dto dto = new Dto();
				dto.setId(dtoMenu.getRequestData().getId());
				ResponseDto responseDto = new ResponseDto();
				boolean isSuccessDelete = menuService.validateDeleteMenu(dto.getId());
				if (isSuccessDelete) {
					responseDto = new ResponseDto(StatusType.DELETE_SUCCEED, StatusType.DELETE_SUCCEED.stringValue,
							dto);
				} else {
					responseDto = new ResponseDto(StatusType.DELETE_ERROR, StatusType.DELETE_ERROR.stringValue, dto);
				}
				return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<ResponseDto>(new ResponseDto(), HttpStatus.NOT_ACCEPTABLE);
		});
	}

	/*
	 * @RequestMapping(value = "/saveee", method = RequestMethod.POST, consumes
	 * = { "application/json", "application/xml" }, produces = {
	 * "application/json", "application/xml" }) public Map<String, Object>
	 * saveMenu1(
	 * 
	 * @RequestParam("textMenuName") String textNameMenu,
	 * 
	 * @RequestParam("textUrl") String textUrl,
	 * 
	 * @RequestParam("checkBoxIsActive") Boolean checkBoxIsActive,
	 * 
	 * @RequestParam(value = "idMenu", required = false) Long idMenu ) {
	 * logger.debug("textNameMenu : " + textNameMenu + ", textUrl : " + textUrl
	 * + ", checkBoxIsActive : " + checkBoxIsActive + ", idMenu : " + idMenu);
	 * MenusModel sysMenus = new MenusModel();
	 * sysMenus.setMenusName(textNameMenu); sysMenus.setUrl(textUrl);
	 * sysMenus.setDisabled(checkBoxIsActive); if (idMenu == null) {
	 * sysMenus.setId(idMenu); } sysMenus.setId(idMenu); sysMenus =
	 * menuService.saveMenu(sysMenus);
	 * 
	 * boolean isSuccessSave = false; if (sysMenus.getModifiedTime() != null) {
	 * isSuccessSave = true; }
	 * 
	 * Map<String, Object> mapJson = new HashMap<String, Object>();
	 * mapJson.put("isSuccessSave", isSuccessSave); return mapJson; }
	 */
}
