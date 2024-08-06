package com.group.blogapi.service.imp;

import com.group.blogapi.domain.Notice;
import com.group.blogapi.mapper.NoticeMapper;
import com.group.blogapi.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    public Notice getTheNewestNotice() {
        return noticeMapper.getTheNewestNotice();
    }
}
