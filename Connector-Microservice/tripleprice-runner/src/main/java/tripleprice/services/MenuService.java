package tripleprice.services;

import java.util.List;

import tripleprice.dto.MenuDto;
import tripleprice.dto.RequestData;
import tripleprice.dto.ResponseData;

public interface MenuService {
	ResponseData listOfMenus(RequestData requestData);

	String getScreenMenu(List<String> listAuthoritiesString);

	MenuDto validateEditMenu(MenuDto menuDto);

	MenuDto validateSaveMenu(MenuDto menuDto);
	
	public boolean validateDeleteMenu(long idMenu);

}
