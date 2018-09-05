package my.triple.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.xebia.extras.selma.Selma;
import my.triple.beans.UserMapper;
import my.triple.dto.UserDto;
import my.triple.model.RolesModel;
import my.triple.model.UserModel;
import my.triple.model.UserRolesModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
	
	private static final UserMapper userMapper = Selma.mapper(UserMapper.class);
	private static Logger logger = LoggerFactory.getLogger(MapperTest.class);
	
	@Test
	public void mapperUserTest(){
		UserDto userDto = new UserDto();
		userDto = userMapper.asUserDTO(userModel());
		logger.debug("result : {}", userDto);	
	}
	
	private static UserModel userModel(){
		UserModel userModel = new UserModel();
		userModel.setId(333L);
		userModel.setName("Ari Prasetiyo");
		
		RolesModel rolesModel = new RolesModel();
		rolesModel.setId(123L);
		rolesModel.setRoleName("admin");
		
		RolesModel rolesModel1 = new RolesModel();
		rolesModel1.setId(124L);
		rolesModel1.setRoleName("public");
		
		List<UserRolesModel> userRolesList = new ArrayList<UserRolesModel>();
		UserRolesModel userRolesModel = new UserRolesModel();
		userRolesModel.setId(1L);
		userRolesModel.setSysRoles(rolesModel);
		userRolesList.add(userRolesModel);
		
		userRolesModel = new UserRolesModel();
		userRolesModel.setId(2L);
		userRolesModel.setSysRoles(rolesModel1);
		userRolesList.add(userRolesModel);
		
		userModel.setUserRolesModel(userRolesList);
		
		return userModel;
	}
}
