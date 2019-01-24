package com.capco.HROPS.serviceImpl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.UserGroup;
import com.capco.HROPS.repository.UserGroupRepository;
import com.capco.HROPS.service.UserGroupService;

@Service
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	private UserGroupRepository userGroupRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public UserGroup createUserGroup(UserGroup userGroup) throws HcopsServiceException {

		try {
			logger.info("UserGroupServiceImpl : createUserGroup: started,{}", 1);
			UserGroup ugroup;
			String uGroupName = userGroup.getUserGroupName();
			ugroup = userGroupRepository.findByuserGroupName(uGroupName);

			if (ugroup == null) {
				logger.info("UserGroupServiceImpl : createUserGroup: ended,{}", 1);
				return userGroupRepository.save(userGroup);
			} else {
				logger.error("UserGroupServiceImpl : createUserGroup: Emptyugroup,{}", "");
				return null;
			}
		} catch (Exception e) {
			logger.error("UserGroupServiceImpl : createUserGroup: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}

	@Override
	public boolean deleteUserGroup(int userGroupId) throws HcopsServiceException {

		try {
			logger.info("UserGroupServiceImpl : deleteUserGroup: started,{}", 1);
			UserGroup userGroup = userGroupRepository.findAllByuserGroupId(userGroupId);
			if (userGroup == null) {
				logger.error("UserGroupServiceImpl : deleteUserGroup: EmptyuserGroup,{}", "");
				return false;
			} else {

				userGroupRepository.deleteById(userGroupId);
				logger.info("UserGroupServiceImpl : deleteUserGroup: ended,{}", 1);
				return true;
			}
		} catch (Exception e) {
			logger.error("UserGroupServiceImpl : deleteUserGroup: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}

	@Override
	public List<UserGroup> getAllUserGroup() throws HcopsServiceException {
		logger.info("UserGroupServiceImpl : getAllUserGroup: started,{}", 1);
		try {
			logger.info("UserGroupServiceImpl : getAllUserGroup: ended,{}", 1);
			return userGroupRepository.findAll();

		} catch (Exception e) {
			logger.error("UserGroupServiceImpl : getAllUserGroup: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}

	@Override
	public UserGroup findbyUserGroupName(String userGroupName) throws HcopsServiceException {
		logger.info("UserGroupServiceImpl : findbyUserGroupName: started,{}", 1);
		try {
			logger.info("UserGroupServiceImpl : findbyUserGroupName: ended,{}", 1);
			return userGroupRepository.findByuserGroupName(userGroupName);
		} catch (Exception e) {
			logger.error("UserGroupServiceImpl : findbyUserGroupName: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}

	@Override
	public UserGroup updateusergroup(int userGroupId, UserGroup usergroup) throws HcopsServiceException {

		try {
			logger.info("UserGroupServiceImpl : updateusergroup: started,{}", 1);
			UserGroup ugroup = userGroupRepository.findAllByuserGroupId(userGroupId);
			if (ugroup == null) {
				logger.error("UserGroupServiceImpl : updateusergroup: Emptyugroup,{}", "");
				return null;
			} else {
				ugroup.setUserGroupCode(usergroup.getUserGroupCode());
				ugroup.setUserGroupName(usergroup.getUserGroupName());
				logger.info("UserGroupServiceImpl : updateusergroup: ended,{}", 1);
				return userGroupRepository.save(ugroup);
			}

		} catch (Exception e) {
			logger.error("UserGroupServiceImpl : updateusergroup: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}

	@Override
	public UserGroup getbyuserGroupId(int userGroupId) throws HcopsServiceException {
		
		logger.info("UserGroupServiceImpl : getbyuserGroupId: started,{}", 1);
		try {
			logger.info("UserGroupServiceImpl : getbyuserGroupId: ended,{}", 1);
			return userGroupRepository.findAllByuserGroupId(userGroupId);
			
		}
		 catch (Exception e) {
				logger.error("UserGroupServiceImpl : updateusergroup: Exception,{}", e);
				throw new HcopsServiceException(e);
			}
		
	}

}
