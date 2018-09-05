package my.triple.services;

import java.util.List;

import my.triple.dto.MenuDto;
import my.triple.dto.RequestData;
import my.triple.dto.ResponseData;

public interface MenuService {
	ResponseData listOfMenus(RequestData requestData);

	String getScreenMenu(List<String> listAuthoritiesString);

	MenuDto validateEditMenu(MenuDto menuDto);

	MenuDto validateSaveMenu(MenuDto menuDto);
	
	public boolean validateDeleteMenu(long idMenu);

}
