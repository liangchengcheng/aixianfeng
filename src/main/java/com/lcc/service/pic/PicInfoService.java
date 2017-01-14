package com.lcc.service.pic;

import com.lcc.domain.PicInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PicInfoService {

    void upload(MultipartFile file) throws IOException;

    List<PicInfo> list();

    int deleteById(Long picId);
}
