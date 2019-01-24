package com.capco.HROPS.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.UserGroup;
import com.capco.HROPS.service.UserGroupService;

@CrossOrigin
@RestController
@RequestMapping("/UserGroup")
public class UserGroupController {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	private UserGroupService userGroupService;

	@CrossOrigin
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public ResponseEntity<UserGroup> usergroup(@RequestBody UserGroup userGroup, HttpServletRequest request,
			HttpServletResponse response) throws HcopsServiceException {
		try {
			logger.info("UserGroupController : usergroup: started,{}", 1);
			if (userGroup == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				UserGroup uGroup;
				uGroup = userGroupService.createUserGroup(userGroup);
				if (uGroup == null) {
					logger.error("UserGroupController : usergroup: Emptyugroup,{}", "");
					return new ResponseEntity<>(uGroup, HttpStatus.ALREADY_REPORTED);
				} else {
					logger.info("UserGroupController : usergroup: ended,{}", 1);
					return new ResponseEntity<>(HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			logger.error("UserGroupController : usergroup: Exception,{}", e);
			throw new HcopsServiceException(e);
		}
	}

	@RequestMapping(value = "/delete/{userGroupId}", method = RequestMethod.DELETE)
	public ResponseEntity<UserGroup> deleteusergroup(@PathVariable int userGroupId) throws HcopsServiceException {
		try {
			logger.info("UserGroupController : deleteusergroup: started,{}", 1);
			Boolean flag = userGroupService.deleteUserGroup(userGroupId);
			if (flag == false) {
				logger.error("UserGroupController : deleteusergroup: Emptyugroup,{}", "");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				logger.info("UserGroupController : deleteusergroup: ended,{}", 1);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error("UserGroupController : deleteusergroup: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}

	@RequestMapping(value = "/getAllUserGroup", method = RequestMethod.GET)
	public ResponseEntity<List<UserGroup>> allusergroup() throws HcopsServiceException {
		try {
			logger.info("UserGroupController : allusergroup: started,{}", 1);
			List<UserGroup> usergroup;
			usergroup = userGroupService.getAllUserGroup();
			if (usergroup.isEmpty()) {
				logger.error("UserGroupController : allusergroup: Emptyugroup,{}", "");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				logger.info("UserGroupController : allusergroup: ended,{}", 1);
				return new ResponseEntity<>(usergroup, HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error("UserGroupController : allusergroup: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}

	@RequestMapping(value = "/getByUserGroupName/{usergroupname}", method = RequestMethod.GET)
	public ResponseEntity<UserGroup> getbyusergroup(@PathVariable String usergroupname) throws HcopsServiceException {
		try {
			logger.info("UserGroupController : getbyusergroup: started,{}", 1);
			UserGroup usergroup;
			usergroup = userGroupService.findbyUserGroupName(usergroupname);

			if (usergroup == null) {
				logger.error("UserGroupController : getbyusergroup: Emptyugroup,{}", "");
				return new ResponseEntity<>(usergroup, HttpStatus.NOT_FOUND);
			} else {
				logger.info("UserGroupController : getbyusergroup: ended,{}", 1);
				return new ResponseEntity<>(usergroup, HttpStatus.OK);
			}
		} catch (Exception e) {
			logger.error("UserGroupController : getbyusergroup: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}

	@RequestMapping(value = "/getByUserGroupId/{userGroupId}", method = RequestMethod.GET)
	public ResponseEntity<UserGroup> getbyuserGroupId(@PathVariable int userGroupId) throws HcopsServiceException {
		try {
			logger.info("UserGroupController : getbyuserGroupId: started,{}", 1);
			UserGroup usergroup = userGroupService.getbyuserGroupId(userGroupId);
			if(usergroup==null) {
				logger.error("UserGroupController : getbyuserGroupId: Emptyugroup,{}", "");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				logger.info("UserGroupController : getbyuserGroupId: ended,{}", 1);
				return new ResponseEntity<>(usergroup, HttpStatus.OK);
			}
			
		}
		catch (Exception e) {
			logger.error("UserGroupController : getbyuserGroupId: Exception,{}", e);
			throw new HcopsServiceException(e);
		}
	}
	@RequestMapping(value = "/updateByUserGroupId/{userGroupId}", method = RequestMethod.PUT)
	public ResponseEntity<UserGroup> updateusergroup(@PathVariable int userGroupId, @RequestBody UserGroup usergroup1)
			throws HcopsServiceException {

		try {
			logger.info("UserGroupController : updateusergroup: started,{}", 1);
			if (userGroupId == 0 || usergroup1 == null) {
				logger.error("UserGroupController : updateusergroup: Emptyugroup,{}", "");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				UserGroup usergroup;
				usergroup = userGroupService.updateusergroup(userGroupId, usergroup1);
				if (usergroup == null) {
					logger.error("UserGroupController : updateusergroup: Emptyugroup,{}", "");
					return new ResponseEntity<>(usergroup, HttpStatus.NOT_FOUND);

				} else {
					logger.info("UserGroupController : updateusergroup: ended,{}", 1);
					return new ResponseEntity<>(usergroup, HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			logger.error("UserGroupController : updateusergroup: Exception,{}", e);
			throw new HcopsServiceException(e);
		}

	}

}
