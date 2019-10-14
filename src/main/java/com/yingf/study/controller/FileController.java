package com.yingf.study.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Logger;

import com.yingf.study.util.PathUtil;

@Controller
public class FileController {


    @GetMapping("/upload")
    public String uploadByGet() {
        return "upload";
    }
    /*
        @GetMapping("/uploads")
        public String uploadsByGet() {
            return "uploads";
        }

    */
    @PostMapping("/upload")
    @ResponseBody
    public String uploadByPost(Model model,
                               @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String filePath = PathUtil.uploadPath + file.getOriginalFilename();
                System.out.println("filePath:" + filePath);
//                System.out.println("文件上传至服务器开始！");
//                file.transferTo(new File(filePath));
//                System.out.println("文件上传至服务器结束！");
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(filePath)));
                out.write(file.getBytes());
//                file.transferTo(new  File(filePath));
                out.flush();
                out.close();
                model.addAttribute("msg", "上传文件成功");
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("msg", "上传文件失败：" + e.getMessage());
            }
        } else {
            model.addAttribute("msg", "上传文件失败：文件为空");
        }
        return "SUCCESS";
    }

    @PostMapping("/uploads")
    public String uploadsByPost(Model model, HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    String filePath = PathUtil.uploadPath + file.getOriginalFilename();
                    BufferedOutputStream out = new BufferedOutputStream(
                            new FileOutputStream(new File(filePath)));
                    out.write(file.getBytes());
                    out.flush();
                    out.close();
                    model.addAttribute("msg", "上传文件成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("msg", "上传文件失败：" + e.getMessage());
                }
            } else {
                model.addAttribute("msg", "上传文件失败：文件为空");
            }
        }

        return "uploads";
    }
}
