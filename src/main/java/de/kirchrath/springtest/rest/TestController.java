package de.kirchrath.springtest.rest;

import de.kirchrath.springtest.config.TestConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class TestController {
    private final TestConfiguration configuration;

    public TestController(TestConfiguration configuration) {
        this.configuration = configuration;
    }


    @GetMapping("/foo")
    public String foo() {
        return configuration.getFoo();
    }

    @GetMapping("/dir")
    public List<String> dir() {
        File folder = new File(configuration.getDir());
        List<String> filenames = Stream.of(folder.listFiles())
                .map(file -> file.getName())
                .filter(name -> !name.startsWith("."))
                .collect(Collectors.toList());
        return filenames;
    }

    @GetMapping("/write")
    public List<String> write() {
        String filename = configuration.getDir() + "/bla";

        try {
            Files.write(Paths.get(filename), (getDateString() + "\n").getBytes(), StandardOpenOption.APPEND);
            return Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getDateString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}
