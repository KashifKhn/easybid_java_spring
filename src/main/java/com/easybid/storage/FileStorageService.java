package com.easybid.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

  String uploadFile(MultipartFile file);

  void deleteFile(String filePath);

}
