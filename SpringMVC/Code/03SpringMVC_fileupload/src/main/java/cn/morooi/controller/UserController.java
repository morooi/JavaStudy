package cn.morooi.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");

        // 使用 fileUpload 组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        // 判断该路劲是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 创建文件夹
            file.mkdirs();
        }

        // 解析 request 对象, 获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            // 判断当前 item 对象是否是上传文件项
            if (item.isFormField()) {
                // 说明是普通表单项
            } else {
                // 说明是上传文件项
                // 获取到上传文件的名称
                String filename = item.getName();
                // 把文件的名称设置为唯一值, uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                item.write(new File(path, filename));
                // 删除临时文件
                item.delete();
            }
        }

        return "success";
    }

    /**
     * @param request
     * @param upload  该形参名必须和表单里的name属性一样
     * @return
     * @throws Exception
     */
    @RequestMapping("fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC 的文件上传...");

        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        // 判断该路劲是否存在
        File file = new File(path);
        if (!file.exists()) {
            // 创建文件夹
            file.mkdirs();
        }

        // 获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置为唯一值, uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        upload.transferTo(new File(path, filename));

        return "success";
    }


}
