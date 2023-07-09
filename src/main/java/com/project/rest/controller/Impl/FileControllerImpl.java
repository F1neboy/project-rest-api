package com.project.rest.controller.Impl;

import com.project.rest.controller.FileController;
import com.project.rest.model.File;
import com.project.rest.service.FileService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class FileControllerImpl implements FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/file/save/{id}")
    @Override
    public ResponseEntity<File> saveFile(@RequestParam("file") MultipartFile file, @PathVariable Long id){
        try{
            File savedFile = fileService.saveFile(file, id);
            return new ResponseEntity<>(savedFile, HttpStatus.CREATED);
        }catch (IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/file/{id}")
    @Override
    public ResponseEntity<byte[]> getFile(@PathVariable Long id){
        Optional<File> fileOptional = fileService.getFile(id);
        if(fileOptional.isPresent()){
            HttpHeaders headers = new HttpHeaders();
            try {
                headers.setContentType(MediaType.parseMediaType(fileOptional.get().getContentType()));
            }catch (EntityNotFoundException e){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(fileOptional.get().getData(), headers, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/files/{id}")
    @Override
    public List<File> getFilesByProject(@PathVariable Long id){
        return fileService.getFiles(id);
    }

    @DeleteMapping("/file/{id}")
    @Override
    public void deleteFile(@PathVariable Long id){
        fileService.deleteFile(id);
    }
}
