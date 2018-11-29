package com.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author: create by Administrator
 * @version: v1.0
 * @description: com.servlet
 * @date:2018/11/29
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("上传文件.......");
        //检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(req)) {
            //如果不是,则停止
            PrintWriter writer = resp.getWriter();
            writer.print("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        //配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置内存临界值,超过后将产生临时文件
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        //设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        //设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        //中文处理
        upload.setHeaderEncoding("UTF-8");

        //构造临时路径,来存储上传的文件
        String uploadPath = req.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        //如果目录不存在,则创建
        File file = new File(uploadPath);
        if (!file.exists()){
            file.mkdir();
        }

        try {
            List<FileItem> fileItems = upload.parseRequest(req);

            if (fileItems!=null && fileItems.size()>0){
                //迭代表单数据
                for (FileItem item:fileItems
                     ) {
                    //处理不在表单中的字段
                    if (!item.isFormField()){
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        req.setAttribute("message","文件上传成功!");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("message","错误信息: " + e.getMessage());
        }

        //跳转到message.jsp
        req.getServletContext().getRequestDispatcher("/page/message.jsp").forward(req, resp);
    }
}
