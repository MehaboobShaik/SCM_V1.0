package com.SmartContactManager_2.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface Fileservice {

	public String uploadImage(String path,MultipartFile file) throws IOException;
}
