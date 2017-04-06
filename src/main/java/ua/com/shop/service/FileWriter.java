package ua.com.shop.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {

	enum Folder {
		COMMODITY, STICKER, CHALK, GLOVE, PRODUCT_CARE, HOLDERS_CHALK, MOTHER_IN_LAW, TUBE, DESC
	}

	boolean write(Folder folder, MultipartFile file, Long id);
	
	//boolean multiFileUpload(Folder folder, MultipartFile[] files, Long id);
}
