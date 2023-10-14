package com.SmartContactManager_2.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SmartContactManager_2.service.Fileservice;

@Service
public class FileServiceImpl implements Fileservice{

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		String originalFilename = file.getOriginalFilename();
		String filePath =path+File.separator+originalFilename;
		
		File filefolder = new File(path);
		if(!filefolder.exists()) {
			System.out.println("true");
			filefolder.mkdir();
		}
		Files.copy(file.getInputStream(),Paths.get(filePath));
		return originalFilename;
	}

}
