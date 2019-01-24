package com.capco.HROPS.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.User;
import com.capco.HROPS.service.MultipartService;
import com.capco.HROPS.service.ProfileService;



@RestController
@RequestMapping("/profile")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private MultipartService multipartService;
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() throws HcopsServiceException {
		try {
			List<User> user=profileService.getAllUsers();
			if(user.isEmpty()) {
				
				logger.error("ProfileController : getUser: errorNoDataGetAllUSersObject");
				return new ResponseEntity("No User data ", HttpStatus.NO_CONTENT);
			}
			else {
				logger.info("ProfileController : getUser: User_Data_Available " + user);
				return ResponseEntity.ok().body(user);
			}
		}
		catch(Exception e) {
 			
			logger.error("ProfileController : getUser: Exception_caught " + e);
 			throw new HcopsServiceException(e);
 		}
		
	}
	
	@GetMapping("/getByUsername/{username}")
	public ResponseEntity<User> getByUsername(@PathVariable("username") String username) throws HcopsServiceException {
		
		try {
			if(username==null) {
				
				logger.error("ProfileController : getByUsername: errorUsernameNull");
				return new ResponseEntity("No Data ", HttpStatus.NOT_FOUND);
			}
			else {
				User user=profileService.getByUsername(username);
				if (user == null) {
					
					logger.error("ProfileController : getByUsername: errorGetByUsernameNull");
					return new ResponseEntity("No Data ", HttpStatus.NO_CONTENT);

				}
				else {
					logger.info("ProfileController : getUsername: User_Data_Available " + user);
					return ResponseEntity.ok().body(user);
				}
			}
		}
		catch(Exception e) {
 			
			logger.error("ProfileController : getUser: exceptionCaught " + e);
 			throw new HcopsServiceException(e);
 		}
		
	}
	
	@GetMapping("/getByEmail/{email}")
	public ResponseEntity<User> getByEmail(@PathVariable("email") String email) throws HcopsServiceException {

		try {
			if(email==null) {
				logger.error("ProfileController : getByEmail: errorEmailNull " );
				return new ResponseEntity("No Data ", HttpStatus.NO_CONTENT);
			}
			else {
				User user=profileService.getByEmail(email);
				
				if (user == null) {
					logger.error("ProfileController : getByEmail: errorUserNull " );
					return new ResponseEntity("No Data ", HttpStatus.NOT_FOUND);

				}
				else {
					logger.info("ProfileController : getByEmail : User_Data_Available");
					return ResponseEntity.ok().body(user);
				}
			}
		}
		catch(Exception e) {
			logger.error("ProfileController : getbyEmail: exceptionCaught " + e);
 			throw new HcopsServiceException(e);
 		}
		
	}
	
	@PutMapping("/updateUser/{username}")
	public ResponseEntity<User> updateByUserId(@PathVariable("username") String username, @RequestBody User user) throws HcopsServiceException {
		try {
			if(username==null || user==null) {
				logger.error("ProfileController : updateUser: errorUpdateNull " );
				return new ResponseEntity("No Data ", HttpStatus.NO_CONTENT);
			}
			else {
				User user1=profileService.updateByUserId(username,user);
				if(user1==null) {
					logger.error("ProfileController : updateUser: errorUpdateNull " );
					return new ResponseEntity("No Data ", HttpStatus.NOT_FOUND);

				}
				else {
					logger.info("ProfileController : updateUser : User_Updated");
					return ResponseEntity.ok().body(user);
				}
			}
		}
		catch(Exception e) {
 			
			logger.error("ProfileController : updateUser: exceptionCaught " + e);
 			throw new HcopsServiceException(e);
 		}
		

	}
	
	@DeleteMapping("/deleteUser/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable("username") String username) throws HcopsServiceException {
		try {
			if(username==null) {
				logger.error("ProfileController : deleteUser: errorUpdateNull " );
				return new ResponseEntity("No Data ", HttpStatus.NO_CONTENT);
			}
			else {
				Boolean flag=profileService.deleteUser(username);
				if(flag==false) {
					logger.error("ProfileController : deleteUser: errorEmptyData " );
					return new ResponseEntity("Empty Data ", HttpStatus.NOT_FOUND);
				}
				else {
					logger.info("ProfileController : deleteUser : User_Updated");
					return ResponseEntity.ok().build();
				}
			}
		}
		catch(Exception e) {
			logger.error("ProfileController : deleteUser: exceptionCaught " + e);
 			throw new HcopsServiceException(e);
 		}
		

	}
	
	/*@PostMapping("/upload")
    public ResponseEntity<User> uploadProfile(@RequestParam("file") MultipartFile file ) throws HcopsServiceException {
		
		try {
			if(file==null) {
				logger.error("ProfileController : uplaodProfilePic: errorNoData " );
				return new ResponseEntity("No Data ", HttpStatus.NO_CONTENT);
			}
			else {
				User user=multipartService.profileUpload(file);
				if(user==null) {
					logger.error("ProfileController : uploadProfilePic : errorEmptyData " );
					return new ResponseEntity("Empty Data ", HttpStatus.NOT_FOUND);
				}
				else {
					logger.info("ProfileController : uploadProfilePic : ProfilePic_Updated");
					return ResponseEntity.ok().body(user);
				}
				
			}
		}
		catch(Exception e) {
			logger.error("ProfileController : uploadProfilePic: exceptionCaught " + e);
 			throw new HcopsServiceException(e);
 		}
		
	}*/
	
	@CrossOrigin
	@PostMapping("/upload")
	public ResponseEntity<User> uploadService(@RequestParam("file") MultipartFile file) throws HcopsServiceException, IOException {
		User user;

		File file1=multipartService.convert(file);
		String mimetype= new MimetypesFileTypeMap().getContentType(file1);
        String type = mimetype.split("/")[0];
        
        if(type.equals("image")) {
            System.out.println("It's an image");
            user=multipartService.profileUpload(file);
            if(user==null) {
    			return new ResponseEntity("User Not Found ", HttpStatus.NOT_FOUND);
    		}
    		else {
    			return new ResponseEntity("Profile Pic Uploaded Sucessfully ", HttpStatus.OK);
    		}
        }
        else {
            System.out.println("It's NOT an image");
            return new ResponseEntity("It's NOT an image ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
	}
}
