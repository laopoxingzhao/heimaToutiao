package com.heima.model.article.dto;

import com.heima.model.article.pojo.ApArticle;
import lombok.Data;

/**
 * @ClassName ArticeDto
 * @Description TODO
 * @Author 胡
 * @Date 2023/11/19 10:13
 * @Version 1.0
 */
@Data
public class ArticeDto extends ApArticle {

    /**
     * 内容
     */
     private String content;

}
