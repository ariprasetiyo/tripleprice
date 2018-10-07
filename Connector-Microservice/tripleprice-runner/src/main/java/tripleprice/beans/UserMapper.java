package tripleprice.beans;


import java.util.List;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import tripleprice.dto.UserDto;
import tripleprice.model.UserModel;

/**
 * {@code SelmaMapper mapper = Selma.mapper(SelmaMapper.class); 
 * OutBean res = mapper.asOutBean(in); 
 * Or OutBean dest = dao.getById(42); 
 * OutBean res = mapper.updateOutBean(in, dest); }
 * 
 * @author ARI-PRASETIYO
 * @see https://github.com/ariprasetiyo/selma
 * @see https://github.com/xebia-france/selma/issues/23
 * @See http://www.selma-java.org/#custom-mapper
 * @see http://www.selma-java.org/#abstract-mapper
 */
@Mapper(withIgnoreFields = { 
		"tripleprice.dto.UserDto.createdtime",
		"tripleprice.dto.UserDto.modifiedtime",
		"tripleprice.dto.UserDto.url", 
		"tripleprice.dto.RolesDto.createdtime",
		"tripleprice.dto.RolesDto.modifiedtime",
		"tripleprice.dto.UserDto.message",
		"tripleprice.dto.UserDto.oldpassword",
		"tripleprice.dto.UserDto.statusType",
		"tripleprice.dto.RolesDto.message",
		"tripleprice.dto.RolesDto.statusType",
		"tripleprice.model.UserRolesModel.id"
		},
		withCustomFields = {
				@Field({"userRolesModel","roles"}),
				@Field({"tripleprice.model.UserRolesModel.sysroles.rolename","tripleprice.dto.RolesDto.rolename"}),
				@Field({"tripleprice.model.UserRolesModel.sysroles.id","tripleprice.dto.RolesDto.id"})
    }
)

public interface UserMapper {

	/**
	 * 
	 * @param source
	 * @return UserDto
	 */
	@Maps(withIgnoreFields = { 
			"tripleprice.dto.UserDto.message",
			"tripleprice.dto.UserDto.statusType",
			"tripleprice.dto.UserDto.password"})
	UserDto asUserDTO(UserModel source);
	
	/**
	 * 
	 * @param source
	 * @return List<UserDto>
	 */
	@Maps(withIgnoreFields = { 
			"tripleprice.dto.UserDto.message",
			"tripleprice.dto.UserDto.statusType"})
	List<UserDto> asUserDTO(List<UserModel> source);

	/**
	 * 
	 * @param source
	 * @return UserModel
	 */
	UserModel asUserModel(UserDto source);
}
