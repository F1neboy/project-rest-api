package com.project.rest;

import com.project.rest.model.File;
import com.project.rest.model.Projekt;
import com.project.rest.repository.FileRepo;
import com.project.rest.repository.ProjektRepo;
import com.project.rest.service.Impl.FileServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FileServiceImplTest {

    @InjectMocks
    private FileServiceImpl fileService;

    @Mock
    private FileRepo fileRepo;

    @Mock
    private ProjektRepo projektRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSaveFile() throws IOException {
        MockMultipartFile multipartFile = new MockMultipartFile(
                "testFile",
                "testFile.txt",
                "text/plain",
                "Hello, World!".getBytes()
        );
        Projekt projekt = new Projekt();
        File fileModel = new File();
        fileModel.setFileName("testFile.txt");

        when(projektRepo.findProjektById(anyLong())).thenReturn(projekt);
        when(fileRepo.save(any())).thenReturn(fileModel);

        File result = fileService.saveFile(multipartFile, 1L);
        assertNotNull(result);
        assertEquals("testFile.txt", result.getFileName());
    }

    @Test
    void testGetFile() {
        File fileModel = new File();
        when(fileRepo.getById(anyLong())).thenReturn(fileModel);

        Optional<File> result = fileService.getFile(1L);
        assertTrue(result.isPresent());
        assertEquals(fileModel, result.get());
    }

    @Test
    void testGetFiles() {
        Projekt projekt = new Projekt();
        List<File> files = List.of(new File(), new File());

        when(projektRepo.getById(anyLong())).thenReturn(projekt);
        when(fileRepo.getByProjekt(any())).thenReturn(files);

        List<File> result = fileService.getFiles(1L);
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testDeleteFile() {
        doNothing().when(fileRepo).deleteById(anyLong());

        fileService.deleteFile(1L);

        verify(fileRepo, times(1)).deleteById(1L);
    }



    @Test
    void testGetFileNotFound() {
        File file= new File();
        file.setFileName("test");
        file.setId(1L);

        when(fileRepo.getById(anyLong())).thenReturn(file);

        Optional<File> result = fileService.getFile(1L);
        assertNotNull(result.isPresent());
    }
}
