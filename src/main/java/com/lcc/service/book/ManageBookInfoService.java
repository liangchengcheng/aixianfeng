package com.lcc.service.book;

import com.lcc.domain.BookInfo;
import com.lcc.web.controller.bookmanage.BookInfoFormBean;

import java.util.List;

public interface ManageBookInfoService {

    void insert(BookInfoFormBean bookInfoFormBean);

    void update(BookInfoFormBean bookInfoFormBean);

    List<BookInfo> findList();

    BookInfo findById(Integer id);
}

