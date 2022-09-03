package com.example.dropzonetest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DropzoneController {


    @ResponseBody
    @PostMapping(value = "/recieveDropzone")
    //public String dropzone(@RequestParam HashMap<String,Object> formData){
    public String dropzone(@RequestParam MultipartFile file,
                           @RequestParam(required = false) String title){
        System.out.println("file = " + file + ", title = " + title);
        return "returnMessage";
    }
}
