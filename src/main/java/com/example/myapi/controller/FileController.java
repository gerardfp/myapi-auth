package com.example.myapi.controller;

import com.example.myapi.domain.MapStructMapper;
import com.example.myapi.domain.dto.FileDetails;
import com.example.myapi.domain.model.File;
import com.example.myapi.repository.FileRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileRepository fileRepository;
    private final MapStructMapper mapStructMapper;

    public FileController(FileRepository fileRepository, MapStructMapper mapStructMapper) {
        this.fileRepository = fileRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @PostMapping
    public FileDetails upload(@RequestParam("file") MultipartFile uploadedFile) {
        try {
            System.out.println(uploadedFile.getOriginalFilename() + ", " + uploadedFile.getContentType());
            File file = new File();
            file.contenttype = uploadedFile.getContentType();
            file.data = uploadedFile.getBytes();

            return mapStructMapper.toFileDetails(fileRepository.save(file));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping
    public List<FileDetails> list() {
        return mapStructMapper.toListFileDetails(fileRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable UUID id) {
        File file = fileRepository.findById(id).orElse(null);

        if (file == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(file.contenttype))
                .contentLength(file.data.length)
                .body(file.data);
    }
}