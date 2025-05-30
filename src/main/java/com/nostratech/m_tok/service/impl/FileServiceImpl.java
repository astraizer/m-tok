package com.nostratech.m_tok.service.impl;

import com.nostratech.m_tok.config.MinioProperties;
import com.nostratech.m_tok.service.FileService;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    private final MinioClient minioClient;
    private final MinioProperties minioProperties;

    public FileServiceImpl(MinioClient minioClient, MinioProperties minioProperties) {
        this.minioClient = minioClient;
        this.minioProperties = minioProperties;
    }

    @Override
    public String uploadFile(MultipartFile file,String filename) throws Exception {
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(minioProperties.getBucketName())
                        .object(filename)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build()
        );
        return String.format("%s/%s/%s",
                minioProperties.getUrl(),                  // e.g. http://localhost:9000
                minioProperties.getBucketName(),                // e.g. my-bucket
                filename
        );
    }
}
