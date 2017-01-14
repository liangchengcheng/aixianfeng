package com.lcc.service.book;

import java.util.List;

public interface BookInfoService {

    List<BookInfoVO> findList();

    BookInfoVO findBySlug(Long slug, String ipAddress);
}

