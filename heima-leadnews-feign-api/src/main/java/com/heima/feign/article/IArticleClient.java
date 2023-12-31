package com.heima.feign.article;

import com.heima.model.article.dto.ArticeDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("leadnews-article")
public interface IArticleClient {
    @PostMapping("api/v1/article/save")
    public ResponseResult saveArticleById(@RequestBody ArticeDto dto);
}
