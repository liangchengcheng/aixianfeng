package com.lcc.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
/**
 * Created by lcc on 2017/1/13.
 */
@Component
public class ImageUploadUtils {
    private static Logger logger = LoggerFactory.getLogger(ImageUploadUtils.class);

    public static String uploadImage(MultipartFile file ,String staticPath) throws IOException{
        String fileName = makeFileName(file);
        File tempFile = new File(staticPath,fileName);

        boolean success = tempFile.createNewFile();
        if (success){
            file.transferTo(tempFile);
            ImageFormatUtils.waterMark(tempFile);
        }else {
            logger.info("image failed to upload!");
        }

        return fileName;
    }

    //获得文件扩展名
    private static String getSuffix(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        int n = fileName.indexOf(".");

        return fileName.substring(n);
    }

    private static String makeFileName(MultipartFile file){
        String suffix = getSuffix(file);
        String fileName = UUID.randomUUID().toString().replace("-","");
        return fileName + suffix;
    }

}
