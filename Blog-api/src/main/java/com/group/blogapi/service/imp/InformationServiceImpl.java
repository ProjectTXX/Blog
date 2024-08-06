package com.group.blogapi.service.imp;

import com.group.blogapi.domain.vo.InformationVo;
import com.group.blogapi.mapper.ArticleMapper;
import com.group.blogapi.mapper.BlogMapper;
import com.group.blogapi.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private BlogMapper blogMapper;

    public InformationVo getInformations() {
        InformationVo informationVo = new InformationVo();
        int numsOfArticle = articleMapper.getNumsOfArticle();
        int numsOfViewers = blogMapper.getNumsOfViewers();
        informationVo.setTotalNumsOfArticle(numsOfArticle);
        informationVo.setTotalNumsOfViewers(numsOfViewers);
        return informationVo;
    }
}
