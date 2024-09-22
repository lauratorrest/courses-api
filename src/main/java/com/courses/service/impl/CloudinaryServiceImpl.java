package com.courses.service.impl;

import com.cloudinary.Cloudinary;
import com.courses.service.CloudinaryService;
import com.courses.shared.exceptions.exception.files.FileTypeNotAllowedException;
import com.courses.shared.exceptions.exception.files.TooBigFileException;
import com.courses.shared.exceptions.ExceptionCode;
import com.courses.shared.utils.Constants;
import jakarta.annotation.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {

    @Resource
    private Cloudinary cloudinary;
    private final MessageSource messageSource;

    @Override
    public String uploadFile(MultipartFile file, String folderName, Pattern allowedType,
                             long maxSize) {
        try {
            validateFileTypeAndSize(file, allowedType, maxSize);
            HashMap<Object, Object> options = new HashMap<>();
            options.put("folder", folderName);
            options.put("public_id", UUID.randomUUID() + "-" + file.getOriginalFilename());
            if (allowedType.equals(Constants.FILE_TYPE_FOR_VIDEOS_ALLOWED)) {
                options.put("resource_type", "video");
            }
            Map uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            String publicId = (String) uploadedFile.get("public_id");
            return cloudinary.url().secure(true).generate(publicId);
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private void validateFileTypeAndSize(MultipartFile file, Pattern allowedType, long maxSize) {
        if (!allowedType.matcher(
                Objects.requireNonNull(file.getOriginalFilename())).matches()) {
            throw new FileTypeNotAllowedException(messageSource.getMessage(
                    ExceptionCode.FILE_TYPE_NOT_ALLOWED.getType(), null, LocaleContextHolder.getLocale()
            ));
        }

        if (file.getSize() > maxSize) {
            throw new TooBigFileException(
                    this.messageSource.getMessage(ExceptionCode.FILE_EXCEEDS_ALLOWED_SIZE.getType(),
                            new Object[]{maxSize / 1024}, LocaleContextHolder.getLocale()));
        }
    }
}
