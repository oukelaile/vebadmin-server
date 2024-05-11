package com.oukelaile.vebAdmin.controller.common;

import com.oukelaile.vebAdmin.enums.FileTypeEnums;
import com.oukelaile.vebAdmin.utils.FileUtils;
import com.oukelaile.vebAdmin.utils.vo.ResponseEnum;
import com.oukelaile.vebAdmin.vo.common.FileVo;
import com.oukelaile.vebAdmin.vo.system.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("file")
public class FileController {

    @Resource
    FileUtils fileUtils;

    @PostMapping("/upload")
        public Object handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam(value = "fileType") String fileType) {
        System.out.println("fileType:" + fileType);
        // 确保文件不为空
        if (file.isEmpty()) {
            return ResponseVo.error("文件为空");
        }

        // 查找fileType对应的枚举值
        Optional<FileTypeEnums> enumValue = Arrays.stream(FileTypeEnums.values())
                .filter(e -> e.name().equalsIgnoreCase(fileType))
                .findFirst();

        if (!enumValue.isPresent()) {
            // fileType不存在于FileTypeEnums中
            return ResponseVo.error("没有该业务");
        }

        try {
            // fileType存在于FileTypeEnums中，直接使用
            FileVo fileVo = fileUtils.uploadFile(file, fileType);
            return ResponseVo.response(ResponseEnum.SUCCESSFUL, fileVo);
        } catch (IOException e) {
            return ResponseVo.error("保存异常");
        }
    }

}
