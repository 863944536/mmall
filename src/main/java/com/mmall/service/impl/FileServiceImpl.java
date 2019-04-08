package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Service("iFileService")
@Slf4j
public class FileServiceImpl implements IFileService {


    public String upload(MultipartFile file,String path){
        String fileName = file.getOriginalFilename();
        //扩展名
        //abc.jsp
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String upLoadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        log.info("开始上传文件，上传的文件名：{},上传路径：{},新文件名：{}",fileName,path,upLoadFileName);
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setReadable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,upLoadFileName);
        try {
            file.transferTo(targetFile);
            //文件已经上传成功了

            //todo 将文件上传到ftp服务器上
            FTPUtil.uploadFile(Lists.<File>newArrayList(targetFile));
            //todo 上传完后删除upload下的文件
            targetFile.delete();
        } catch (IOException e) {
            log.info("上传文件异常",e);
            return null;
        }
        return targetFile.getName();
    }


}
