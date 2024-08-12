package com.courses.service;

import java.util.regex.Pattern;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

  String uploadFile(MultipartFile file, String folderName, Pattern allowedType, long maxSize);
}
