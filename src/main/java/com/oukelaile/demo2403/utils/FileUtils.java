package com.oukelaile.demo2403.utils;

import cn.hutool.core.lang.UUID;
import com.oukelaile.demo2403.enums.FileTypeEnums;
import com.oukelaile.demo2403.vo.common.FileVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class FileUtils {

    @Value("${file.storage}")
    public String fileStorage;

    @Value("${file.files}")
    public String fileFiles;

    public FileVo uploadFile(MultipartFile file, String typePath) throws IOException {

        // 构建日期目录路径，例如/year/month/day
        LocalDate now = LocalDate.now();
        String datePath = now.format(DateTimeFormatter.ofPattern("/yyyy/MM/dd"));

        //String fileTypeDir = fileTypeEnums.getTypeDir(); // 假设FileTypeEnums类中定义了返回类型目录的方法getTypeDir()
        String StorageFilePath = Paths.get(fileStorage+fileFiles, typePath, datePath).toString();

        System.out.println("StorageFilePath:" + StorageFilePath);
        // 创建目录
        Path directoryPath = Paths.get(StorageFilePath);
        if (!Files.exists(directoryPath)) {
            try {
                Files.createDirectories(directoryPath);
            } catch (IOException e) {
                throw new RuntimeException("创建目录失败", e);
            }
        }
        // 构建文件名，可以考虑加上UUID防止重名
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID() + "_" + originalFilename;
        Path targetLocation = directoryPath.resolve(fileName);

        // 保存文件
        Files.copy(file.getInputStream(), targetLocation);


        // 返回FileVo对象，根据实际情况填充
        FileVo fileVo = new FileVo();
        fileVo.setFilePath(targetLocation.toString().replaceAll("\\\\", "/").replace(fileStorage, ""));
        fileVo.setFileName(originalFilename);
        return fileVo;

    }

}
