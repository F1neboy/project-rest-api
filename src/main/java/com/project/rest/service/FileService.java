package com.project.rest.service;

import com.project.rest.model.File;
import org.springframework.http.ProblemDetail;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface FileService {
    File saveFile(MultipartFile file, Long id) throws IOException;

    Optional<File> getFile(Long id);

    List<File> getFiles(Long id);

    void deleteFile(Long id);
}
