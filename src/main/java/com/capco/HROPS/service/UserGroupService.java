package com.capco.HROPS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.UserGroup;

@Service
public interface UserGroupService {

	public UserGroup createUserGroup(UserGroup userGroup) throws HcopsServiceException;

	public boolean deleteUserGroup(int group_id) throws HcopsServiceException;

	public List<UserGroup> getAllUserGroup() throws HcopsServiceException;

	public UserGroup findbyUserGroupName(String usergroup) throws HcopsServiceException;

	public UserGroup updateusergroup(int userGroupId, UserGroup usergroup) throws HcopsServiceException;

	public UserGroup getbyuserGroupId(int userGroupId)throws HcopsServiceException;

}
