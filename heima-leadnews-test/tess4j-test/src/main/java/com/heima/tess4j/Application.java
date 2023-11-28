package com.heima.tess4j;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * @ClassName Application
 * @Description TODO
 * @Author 胡
 * @Date 2023/11/27 17:19
 * @Version 1.0
 */
public class Application {
    public static void main(String[]args) throws TesseractException {
//创建实例
        ITesseract tesseract = new Tesseract();
//设置字体库路径
        tesseract.setDatapath("E:\\Java\\heima-leadnews\\heima-leadnews-test\\tess4j-test\\src\\main\\resources");
//设置语言-->简体中文
        tesseract.setLanguage("chi_sim");
//识别图片

        File file = new File("D:\\BaiduNetdiskDownload\\讲义\\自媒体文章-自动审核.assets\\image-20210524161243572.png");
        String s = tesseract.doOCR(file);
        System.out.println(s);


    }
}
