import com.heima.file.service.FileStorageService;
import com.heima.minio.MinIOApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;

@SpringBootTest(classes = MinIOApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class minIOTest1 {



    @Autowired
    public FileStorageService client;

    @Test
    public  void main() {

        FileInputStream fileInputStream = null;
        try {


            fileInputStream =  new FileInputStream("E:\\Java\\heima-leadnews\\heima-leadnews-test\\minio-demo\\src\\main\\resources\\list.html");
            if (client!=null) {
                String s = client.uploadHtmlFile("", "list.html", fileInputStream);

                System.out.println(s);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}