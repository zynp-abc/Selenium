package day09_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_Files {


    @Test
    void filesExistsTest() {

        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("user.home"));

        String ortakYol = "/Desktop/not.txt";

        String dynamicPath = System.getProperty("user.home") + ortakYol;

        Assertions.assertTrue(Files.exists(Paths.get(dynamicPath)));


    }


}

