<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ page import="java.io.File" %>  
<%@ page import="java.util.Arrays" %>  
<%@ page import="java.util.List" %>  
<!DOCTYPE html>  
<html>  
<head>  
    <title>Uploaded Images</title>  
    <style>  
        .image-container {  
            display: flex;  
            flex-wrap: wrap;  
        }  
        .image-container img {  
            margin: 10px;  
            max-width: 200px;  
            max-height: 200px;  
        }  
    </style>  
</head>  
<body>  
    <h2>Uploaded Images</h2>  
    <div class="image-container">  
        <%  
            // Get the path to the uploads directory  
            String uploadDir = application.getRealPath("") + File.separator + "uploads";  
            File dir = new File(uploadDir);  
              
            // Ensure the directory exists  
            if (dir.exists() && dir.isDirectory()) {  
                // Get the list of files in the uploads directory  
                List<File> files = Arrays.asList(dir.listFiles());  
                  
                // Iterate through the files and display each image  
                for (File file : files) {  
                    if (file.isFile()) {  
                        String fileName = file.getName();  
                        String filePath = request.getContextPath() + "/uploads/" + fileName;  
        %>  
                        <img src="<%= filePath %>" alt="<%= fileName %>">  
        <%  
                    }  
                }  
            } else {  
                out.println("No images uploaded yet.");  
            }  
        %>  
    </div>  
</body>  
</html>  