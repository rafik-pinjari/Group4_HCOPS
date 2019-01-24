package com.capco.HROPS.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.capco.HROPS.model.User;
import com.capco.HROPS.repository.LoginRepository;
import com.capco.HROPS.repository.RegistrationRepository;





@CrossOrigin
@RestController
@RequestMapping("/profile")
public class MultipartController {
	
	
		@Autowired
		private RegistrationRepository registrationRepository;
			
		@Autowired
		private LoginRepository loginrepo;
	
	
	@CrossOrigin
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/upload1")
    public    ResponseEntity<User>  uploadService(@RequestParam("file") MultipartFile file ) throws Exception 
    {
		User user;

		 
		 user=loginrepo.findByuserid("answ");
		 if(user==null)
		 {
				return new ResponseEntity("User Not Found ", HttpStatus.INTERNAL_SERVER_ERROR);
			 
		 }
		 if(file.isEmpty())
		 {
				return new ResponseEntity("Image not selected", HttpStatus.NOT_FOUND);
			 
		 }
		 
		 

		 System.out.println("filename     "+file.getOriginalFilename());
		user.setProfilePic(file.getOriginalFilename());
		registrationRepository.save(user);
		return new ResponseEntity("Profile Pic Uploaded Sucessfully ",HttpStatus.OK);
		
	}
	@CrossOrigin
	@GetMapping("/upload2/{userid}")
    public    User  uploadpic(@PathVariable String userid ) throws Exception 
    {
		User user;

		 
		 user=loginrepo.findByuserid(userid);
		 if(user==null)
		 {
				return null;
			 
		 }
		 
		 

	
		return user;
		
	}

}
