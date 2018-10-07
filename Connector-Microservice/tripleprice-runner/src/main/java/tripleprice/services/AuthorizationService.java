package tripleprice.services;

import java.util.List;

import tripleprice.dto.AuthorizationDto;
import tripleprice.dto.RequestData;
import tripleprice.model.AuthorizationModel;
import tripleprice.model.MenusModel;

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
