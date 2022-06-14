package org.noneorone.boot.thymeleaf.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info")
    public static String index() {
        return "user/upload";
    }

    @RequestMapping("/upload")
    public static String upload(HttpServletRequest request, @RequestParam("description") String description, @RequestParam("file") MultipartFile file) {
        System.out.println("description: " + description);
        System.out.println("file: " + file);
        boolean success = false;
        if (!file.isEmpty()) {
            String path = request.getServletContext().getRealPath("/upload/");
            System.out.println("path: " + path);
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            File uploadFile = new File(path, fileName);
            if (!uploadFile.getParentFile().exists()) {
                //noinspection ResultOfMethodCallIgnored
                uploadFile.getParentFile().mkdirs();
            }
            System.out.println("dest-file-path: " + uploadFile.getPath());
            try {
                file.transferTo(uploadFile);
                request.setAttribute("fileName", fileName);
                success = true;
            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("error", e.getLocalizedMessage());
            }
        } else {
            request.setAttribute("error", "file is empty");
        }
        request.setAttribute("success", success);
        return "user/info";
    }

    @RequestMapping("/download")
    public static ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("fileName") String fileName, @RequestHeader("User-Agent") String userAgent, Model model) throws IOException {
        String path = request.getServletContext().getRealPath("/upload/");
        File file = new File(path + File.separator + fileName);
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        builder.contentLength(file.length());
        builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        fileName = URLEncoder.encode(fileName, "UTF-8");
        if (userAgent.indexOf("MSIE") > 0) {
            builder.header("Content-Disposition", "attachment; filename=" + fileName);
        } else {
            builder.header("Content-Disposition", "attachment; filename*=UTF-8''" + fileName);
        }
        return builder.body(FileUtils.readFileToByteArray(file));
    }

}
