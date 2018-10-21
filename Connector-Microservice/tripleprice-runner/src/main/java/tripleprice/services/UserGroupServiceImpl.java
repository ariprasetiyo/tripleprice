package tripleprice.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleprice.dao.UserGroupDao;
import tripleprice.dao.UserGroupDaoImpl;
import tripleprice.dto.RequestData;
import tripleprice.dto.ResponseData;
import tripleprice.dto.RolesDto;
import tripleprice.model.RolesModel;
import tripleprice.ref.StatusType;

@Service
public class UserGroupServiceImpl implements UserGroupService {

	private static final Logger logger = LoggerFactory.getLogger(UserGroupServiceImpl.class);

	@Autowired
	private UserGroupDaoImpl userGroupDaoImpl;

	@Autowired
	private UserGroupDao userGroupDao;

	@Override
	public ResponseData listUserGroup(RequestData requestData) {

		if (logger.isDebugEnabled()) {
			logger.debug("{}", requestData.toString());
		}

		List<RolesModel> rolesModel = userGroupDaoImpl.listUserGroup(requestData);
		long countRolesModel = userGroupDaoImpl.countUserGroup(requestData);

		ResponseData responseData = new ResponseData();
		responseData.setData(rolesModel);
		responseData.setTotalRecord(countRolesModel);

		if (logger.isDebugEnabled()) {
			logger.debug("{}", responseData.toString());
		}
		return responseData;
	}

	@Override
	public ResponseData saveUserGroup(RolesDto rolesDto) {
		logger.debug("Start save user group {}", rolesDto.toString());

		ResponseData responseData = new ResponseData();
		int countUserGroup = userGroupDao.countUserGroupByRoleName(rolesDto.getRoleName());
		if (countUserGroup > 0) {
			responseData.setStatusType(StatusType.DUPLICATE_DATA_ERROR);
			responseData.setMessage(StatusType.DUPLICATE_DATA_ERROR.stringValue);
			return responseData;
		}

		RolesModel rolesModel = new RolesModel();
		rolesModel.setRoleName(rolesDto.getRoleName());
		rolesModel.setDisabled(rolesDto.isDisabled());
		rolesModel = userGroupDao.save(rolesModel);
		responseData.setData(rolesModel);

		if (rolesModel.getId() == null) {
			responseData.setStatusType(StatusType.SAVE_ERROR);
			responseData.setMessage(StatusType.NULL_POINTER_ERROR.stringValue);
		} else {
			responseData.setStatusType(StatusType.SAVE_SUCCEED);
		}

		logger.debug("Final save user group {}", responseData.toString());
		return responseData;
	}

	public ResponseData editUserGroup(RolesDto rolesDto) {
		logger.debug("Edit user group {}", rolesDto.toString());

		ResponseData responseData = new ResponseData();
		if (rolesDto.getId() == null || rolesDto.getId() <= 0) {
			responseData.setStatusType(StatusType.UPDATE_ERROR);
			responseData.setMessage(StatusType.NULL_VALUE.stringValue);
			return responseData;
		}

		RolesModel rolesModel = new RolesModel();
		rolesModel.setId(rolesDto.getId());
		rolesModel.setRoleName(rolesDto.getRoleName());
		rolesModel.setDisabled(rolesDto.isDisabled());
		rolesModel = userGroupDao.save(rolesModel);
		responseData.setData(rolesModel);

		if (rolesModel.getId() == null) {
			responseData.setStatusType(StatusType.UPDATE_ERROR);
			responseData.setMessage(StatusType.NULL_POINTER_ERROR.stringValue);
		} else {
			responseData.setStatusType(StatusType.UPDATE_SUCCEED);
		}

		logger.debug("Final edit user group {}", responseData.toString());
		return responseData;
	}

}
