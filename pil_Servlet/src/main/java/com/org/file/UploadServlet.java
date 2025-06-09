package com.org.file; 

import java.io.File;  
import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.MultipartConfig;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.Part;  
  
@WebServlet("/uploadServlet")  
@MultipartConfig  
public class UploadServlet extends HttpServlet {  
    private static final long serialVersionUID = 1L;  
    private static final String UPLOAD_DIRECTORY = "uploads";  
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        // Create path components to save the file  
        final String path = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;  
        final Part filePart = request.getPart("file");  
        final String fileName = getFileName(filePart);  
  
        // Create the upload directory if it does not exist  
        File uploadDir = new File(path);  
        if (!uploadDir.exists()) {  
            uploadDir.mkdir();  
        }  
  
        // Save the file on the server  
        File file = new File(path + File.separator + fileName);  
        filePart.write(file.getAbsolutePath());  
  
        // Redirect to display.jsp  
        response.sendRedirect("display.jsp");  
    }  
  
    private String getFileName(final Part part) {  
        final String partHeader = part.getHeader("content-disposition");  
        for (String content : partHeader.split(";")) {  
            if (content.trim().startsWith("filename")) {  
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");  
            }  
        }  
        return null;  
    }  
}  