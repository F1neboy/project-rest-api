package com.project.rest.controller;

import com.project.rest.model.File;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileController {
    ResponseEntity<File> saveFile(@RequestParam("file") MultipartFile file, @PathVariable Long id);

    ResponseEntity<byte[]> getFile(@PathVariable Long id);

    List<File> getFilesByProject(@PathVariable Long id);

    void deleteFile(@PathVariable Long id);
}
