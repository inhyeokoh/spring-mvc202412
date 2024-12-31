package com.spring.mvcproject.chap08.api;

import com.spring.mvcproject.chap08.config.FileUploadConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v8")
@Slf4j  // 로깅
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadConfig fileUploadConfig;

    // 첨부파일 업로드
    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadSingleFile(
            @RequestParam("profile") MultipartFile file
    ) {
        log.info("uploaded file name: {}", file.getOriginalFilename());
        log.info("uploaded file type: {}", file.getContentType());

        // 저장 파일 경로 생성
        String rootDir = fileUploadConfig.getLocation();
        String fileName = file.getOriginalFilename();

        //   Users/user/spring/upload/티니핑.jpg
        File uploadedLocation = new File(rootDir + fileName);

        // 해당 위치에 파일 저장
        try {
            file.transferTo(uploadedLocation);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("파일 저장 실패!");
        }

        return ResponseEntity.ok().body("OK!");
    }


    // 다중파일 업로드
    @PostMapping("/upload-multi")
    public ResponseEntity<?> uploadMultiFile(
            @RequestParam("profile") List<MultipartFile> fileList
    ) {

        for (MultipartFile file : fileList) {
            log.info("file-name: {}", file.getOriginalFilename());
            log.info("file-type: {}", file.getContentType());
            System.out.println("==============================");

            // 저장 파일 경로 생성
            String rootDir = fileUploadConfig.getLocation();
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            //   Users/user/spring/upload/티니핑.jpg
            File uploadedLocation = new File(rootDir + fileName);

            // 해당 위치에 파일 저장
            try {
                file.transferTo(uploadedLocation);
            } catch (IOException e) {
                return ResponseEntity.internalServerError().body("파일 저장 실패!");
            }

        }

        return ResponseEntity.ok().body("multiple upload success!");
    }


}
