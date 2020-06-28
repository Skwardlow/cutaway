package ru.skwardlow.cutaway.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@Slf4j
@Controller
public class WebController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        log.info("Someone entered index page");
        return "index";
    }

    @RequestMapping(value = "/getcv", method = RequestMethod.GET)
    public void getCV(HttpSession session, HttpServletResponse response) throws IOException {
        try {
            String filePath = "src/main/resources/static/content/cv.pdf";
            File file = new File(filePath);
            InputStream inputStream = new FileInputStream(file);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=cv.pdf");
            IOUtils.copy(inputStream,response.getOutputStream());
            response.flushBuffer();
            inputStream.close();
        } catch (FileNotFoundException e) {
            log.error("No such file");
            e.printStackTrace();
        }
    }

}
