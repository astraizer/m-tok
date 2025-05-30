package com.nostratech.m_tok.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadFile(MultipartFile file,String filename) throws Exception;
}
