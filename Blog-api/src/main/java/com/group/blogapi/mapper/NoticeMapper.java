package com.group.blogapi.mapper;

import com.group.blogapi.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {

    Notice getTheNewestNotice();
}
