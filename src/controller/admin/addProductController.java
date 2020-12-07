package controller.admin;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.*;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;




 /* 
 * @MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB maxFileSize =
 * 1024 * 1024 * 50, // 50MB maxRequestSize = 1024 * 1024 * 50) // 50MB
 * 
 * public class addProductController extends HttpServlet {
 * 
 * private static final long serialVersionUID = 1L; private static final String
 * UPLOAD_DIRECTORY = "images";
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { for
 * (Part part : request.getParts()) { String fileName = extractFileName(part);
 * // refines the fileName in case it is an absolute path fileName = new
 * File(fileName).getName(); part.write(this.getFolderUpload().getAbsolutePath()
 * + File.separator + fileName); } request.setAttribute("message",
 * "Upload File Success!");
 * getServletContext().getRequestDispatcher("/result.jsp").forward(request,
 * response); }
 * 
 * private String extractFileName(Part part) { String contentDisp =
 * part.getHeader("content-disposition"); String[] items =
 * contentDisp.split(";"); for (String s : items) { if
 * (s.trim().startsWith("filename")) { return s.substring(s.indexOf("=") + 2,
 * s.length() - 1); } } return ""; } String uploadPath =
 * getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
 * 
 * public File getFolderUpload() { File folderUpload = new File(uploadPath); if
 * (!folderUpload.exists()) { folderUpload.mkdirs(); } return folderUpload; }
 * 
 * }
 */

@WebServlet("/admin/addProduct")

public class addProductController extends HttpServlet {

    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "images";

    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk 
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {

            ArrayList<FileItem> formItems = upload.parseRequest((HttpServletRequest)request);

            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);

                        // saves the file on disk
                        item.write(storeFile);
                        request.setAttribute("msg", UPLOAD_DIRECTORY + "/" + fileName);
                        request.setAttribute("message",
                                "Upload has been done successfully >>" + UPLOAD_DIRECTORY + "/" + fileName);
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
        // redirects client to message page
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);
    }

}

