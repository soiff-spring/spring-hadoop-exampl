package xyz.cloorc.springhadoop;

import org.apache.hadoop.fs.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.hadoop.fs.FsShell;

import java.util.Collection;

/**
 * Created by Soiff on 2016/05/16.
 *
 * @author : Soiff
 */
@SpringBootApplication
public class SpringHadoopExampleApplication implements ApplicationRunner {

    @Autowired
    FsShell shell;

    public static void main(String[] args) {
        SpringApplication.run(SpringHadoopExampleApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Collection<FileStatus> statuses = shell.ls(true, "/");
        for (FileStatus status : statuses)
            System.out.println(status);
    }
}
