package com.heima.file;

import com.heima.file.config.MinIOConfigProperties;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;

@SpringBootTest
public class MinIOTest1 {



    @Autowired

    public MinioClient client;

    @Test
    public  void main() {

        FileInputStream fileInputStream = null;
        try {

            fileInputStream =  new FileInputStream("E:\\Java\\heima-leadnews\\heima-leadnews-test\\minio-demo\\src\\main\\resources\\list.html");

            //1.创建minio链接客户端
//            MinioClient client = MinioClient.builder().credentials("admin", "password").endpoint(" http://127.0.0.1:9090").build();
            //2.上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object("list.html")//文件名
                    .contentType("text/html")//文件类型
                    .bucket("leadnews")//桶名词  与minio创建的名词一致
                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流
                    .build();
            if (client!=null)
//                client.putObject(putObjectArgs);
System.out.println(" http://127.0.0.1:9000/leadnews/ak47.jpg");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}