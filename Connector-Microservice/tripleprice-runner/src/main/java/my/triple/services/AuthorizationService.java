package my.triple.services;

import java.util.List;

import my.triple.dto.AuthorizationDto;
import my.triple.dto.RequestData;
import my.triple.model.AuthorizationModel;
import my.triple.model.MenusModel;

public interface AuthorizationService {

	public void viewSysRoles(Long idRoles);

	public List<MenusModel> listMenu();

	public List<AuthorizationModel> listMenuAuthorization(Long idRole);

	public AuthorizationDto getAuthorizationList(int offset, int limit, String keySearch);

	public String getAuthorizationJson(Long idRole);
	
	public List<AuthorizationDto> getAuthorizationList(RequestData requestData);

/*	public void viewDataMenu(Model model, Long idRole);*/

	public AuthorizationDto saveMenu(AuthorizationDto authorizationDto);

	int updateAuthorization(Long id, AuthorizationDto authorizationDto);

	void deleteAuthorization(Long id);
	
	long countAuthorization(long roleId);
}
