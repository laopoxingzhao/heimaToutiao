package com.heima.article.feign;


import com.heima.article.service.ApArticleService;
import com.heima.feign.article.IArticleClient;

import com.heima.model.article.dto.ArticeDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ArticleClient implements IArticleClient {

    @Autowired
    private ApArticleService apArticleService;





    @Override
    @PostMapping("/api/v1/article/save")
    public ResponseResult saveArticleById(ArticeDto dto) {
        return apArticleService.saveArticle(dto);
    }

}