package my.triple.beans;


import java.util.List;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import my.triple.dto.UserDto;
import my.triple.model.UserModel;

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
		"my.triple.dto.UserDto.createdtime",
		"my.triple.dto.UserDto.modifiedtime",
		"my.triple.dto.UserDto.url", 
		"my.triple.dto.RolesDto.createdtime",
		"my.triple.dto.RolesDto.modifiedtime",
		"my.triple.dto.UserDto.message",
		"my.triple.dto.UserDto.oldpassword",
		"my.triple.dto.UserDto.statusType",
		"my.triple.dto.RolesDto.message",
		"my.triple.dto.RolesDto.statusType",
		"my.triple.model.UserRolesModel.id"
		},
		withCustomFields = {
				@Field({"userRolesModel","roles"}),
				@Field({"my.triple.model.UserRolesModel.sysroles.rolename","my.triple.dto.RolesDto.rolename"}),
				@Field({"my.triple.model.UserRolesModel.sysroles.id","my.triple.dto.RolesDto.id"})
    }
)

public interface UserMapper {

	/**
	 * 
	 * @param source
	 * @return UserDto
	 */
	@Maps(withIgnoreFields = { 
			"my.triple.dto.UserDto.message",
			"my.triple.dto.UserDto.statusType",
			"my.triple.dto.UserDto.password"})
	UserDto asUserDTO(UserModel source);
	
	/**
	 * 
	 * @param source
	 * @return List<UserDto>
	 */
	@Maps(withIgnoreFields = { 
			"my.triple.dto.UserDto.message",
			"my.triple.dto.UserDto.statusType"})
	List<UserDto> asUserDTO(List<UserModel> source);

	/**
	 * 
	 * @param source
	 * @return UserModel
	 */
	UserModel asUserModel(UserDto source);
}
