package com.capco.HROPS.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.User;
import com.capco.HROPS.repository.MultipartRepository;
import com.capco.HROPS.repository.RegistrationRepository;
import com.capco.HROPS.service.MultipartService;


@Service
public class MultipartServiceImpl implements MultipartService{

	private static String uploadFolder = "assets\\";
	
	@Autowired
	private  MultipartRepository multipartRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Override
	public User profileUpload(MultipartFile file) throws HcopsServiceException{
		
		User user=registrationRepository.findByuserid("ASNW");
		if(user==null) {
			return null;
		}
		else {
			byte[] bytes=null;
			if (file.isEmpty()) {
				
				return null;
			}
			else
			{
			try {
				// read and write the file to the selected location-
				bytes = file.getBytes();
				Path path = Paths.get(uploadFolder + file.getOriginalFilename());
			    Files.write(path, bytes);
			    user.setProfilePic(file.getOriginalFilename());
				registrationRepository.save(user);
				return user;
			    
			} 
			catch(IOException e) {
				throw new HcopsServiceException(e);
				}
			
			}

			
		}
		
	}
	
	public  File convert(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}

}
