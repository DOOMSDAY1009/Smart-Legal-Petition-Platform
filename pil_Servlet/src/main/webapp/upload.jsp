<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html>  
<head>  
    <title>Upload Image</title>  
    <style>  
        body {  
            font-family: Arial, sans-serif;  
        }  
        .container {  
            width: 50%;  
            margin: auto;  
            padding: 20px;  
            border: 1px solid #ccc;  
            border-radius: 10px;  
            box-shadow: 0 0 10px rgba(0,0,0,0.1);  
        }  
        h2 {  
            text-align: center;  
        }  
        .form-group {  
            margin-bottom: 15px;  
        }  
        .form-group label {  
            display: block;  
            margin-bottom: 5px;  
        }  
        .form-group input[type="file"] {  
            width: 100%;  
        }  
        .form-group input[type="submit"] {  
            display: block;  
            width: 100%;  
            padding: 10px;  
            background-color: #4CAF50;  
            color: white;  
            border: none;  
            border-radius: 5px;  
            cursor: pointer;  
        }  
        .form-group input[type="submit"]:hover {  
            background-color: #45a049;  
        }  
    </style>  
</head>  
<body>  
    <div class="container">  
        <h2>Upload Image</h2>  
        <form action="<%= request.getContextPath() %>/uploadServlet" method="post" enctype="multipart/form-data">  
            <div class="form-group">  
                <label for="file">Select Image:</label>  
                <input type="file" name="file" id="file" accept="image/*" required>  
            </div>  
            <div class="form-group">  
                <input type="submit" value="Upload">  
            </div>  
        </form>  
    </div>  
</body>  
</html>  