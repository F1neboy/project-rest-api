package com.project.rest.service.Impl;

import com.project.rest.model.File;
import com.project.rest.model.Projekt;
import com.project.rest.repository.FileRepo;
import com.project.rest.repository.ProjektRepo;
import com.project.rest.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FileServiceImpl implements FileService {


    private FileRepo fileRepo;

    private ProjektRepo projektRepo;


    @Override
    public File saveFile(MultipartFile file, Long id) throws IOException {
        File fileModel = new File();
        fileModel.setContentType(file.getContentType());
        fileModel.setFileName(file.getOriginalFilename());
        fileModel.setData(file.getBytes());
        fileModel.setProjekt(projektRepo.findProjektById(id));
        return fileRepo.save(fileModel);
    }

    @Override
    public Optional<File> getFile(Long id) {
        return Optional.of(fileRepo.getById(id));
    }

    @Override
    public List<File> getFiles(Long id) {
        Projekt prj = projektRepo.getById(id);
        //List<File> abc = ;
        return fileRepo.getByProjekt(prj).stream().toList();
    }

    @Override
    public void deleteFile(Long id) {
        fileRepo.deleteById(id);
    }
}
