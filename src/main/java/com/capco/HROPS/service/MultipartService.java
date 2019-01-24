package com.capco.HROPS.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.capco.HROPS.custom.exception.HcopsException.HcopsServiceException;
import com.capco.HROPS.model.User;


public interface MultipartService {

	  //public User PicUploadService(String username, MultipartFile file ) throws HcopsServiceException;

	User profileUpload(MultipartFile file) throws HcopsServiceException;
	
	public File convert(MultipartFile file) throws IOException;
}
