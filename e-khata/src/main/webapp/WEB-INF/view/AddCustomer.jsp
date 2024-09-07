<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Khata System</title>
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"/>
    <style>
        /* Import Google font - Poppins */
        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap");
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", sans-serif;
        }

        :root {
            --white-color: #fff;
            --blue-color: #4070f4;
            --grey-color: #707070;
            --grey-color-light: #aaa;
        }

        body {
            background-color: #e7f2fd;
            transition: all 0.5s ease;
        }

        body.dark {
            background-color: #333;
        }

        body.dark {
            --white-color: #333;
            --blue-color: #fff;
            --grey-color: #f2f2f2;
            --grey-color-light: #aaa;
        }

        /* Styling Body Content */
        .body-content {
            margin-left: 260px;
            margin-top: 70px;
            padding: 20px;
            background-color: #e7f2fd;
            width: calc(100% - 260px);
        }

        .body-content .container{
            background: white;
            width: 600px;
            padding: 25px;
            margin: 50px auto 50px;
            border-top: 5px solid blue;
            box-shadow: 0 0 5px 2px rgba(0, 0, 0, 0.5);
        }

        .body-content .container h2{
            font-size: 24px;
            line-height: 24px;
            padding: 20px;
            text-align: center;
        }

        .input-name {
            width: 90%;
            position: relative;
            margin: 20px auto;
        }

        .lock{
            padding: 12px 11px;
        }

        .fname, .lname{
            width: 46%;
            padding: 8px 0 8px 50px;
        }

        .input-name span{
            margin-left: 35px;
        }

        .email, .number, .address{
            width: 100%;
            padding: 8px 0 8px 50px;
        }

        .input-name i{
            position: absolute;
            font-size: 20px;
            color: blue;
            border-right: 1px solid #cccccc;
        }

        .envelope, .phoneNumber{
            padding: 12px 11px;
        }

        .input-name input{
            font-size: 17px;
            border: 1px solid #cccccc;
            outline: none;
            -webkit-transition: all 0.30s ease-in-out;
            -moz-transition: all 0.30s ease-in-out;
            -ms-transition: all 0.30s ease-in-out;
            transition: all 0.30s ease-in-out;
        }

        input:hover{
            background-color: #fafafa;
        }

        input:focus{
            border: 1px solid #0866ff;
        }

        .btn{
            width: auto;
            padding: 5px 20px;
            cursor: pointer;
            background: #007bff;
            color: white;
            font-weight: 500;
        }

        .btn:hover{
            background-color: #0056b3;
        }

        .login-link {
            text-align: center;
            margin-top: 20px;
        }

        .login-link p {
            font-size: 0.9rem;
        }

        .login-link a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        .login-link a:hover {
            text-decoration: underline;
        }

        .error-message {
            color: red;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<%@include file="Sidebar.jsp"%>

<!-- Body Content -->
<div class="body-content">
    <div class="container">
        <h2>Add New Customer</h2>
        <div class="form-container">
            <form>
                <div class="input-name">
                    <i class="fa-solid fa-user lock"></i>
                    <input type="text" placeholder="First Name" class="fname" name="firstName">
                    <span>
                        <i class="fa-solid fa-user lock"></i>
                        <input type="text" placeholder="Last Name" class="lname" name="lastName">
                    </span>
                </div>

                <div class="input-name">
                    <i class="fa-solid fa-envelope envelope"></i>
                    <input type="text" placeholder="Email" class="email" name="emailAddress">

                </div>

                <div class="input-name">
                    <i class="fa-solid fa-phone phoneNumber"></i>
                    <input type="text" placeholder="Phone Number" class="number" name="phoneNumber">
                </div>

                <div class="input-name">
                    <i class="fa-solid fa-location-dot phoneNumber"></i>
                    <input type="text" placeholder="Address" class="number" name="address">
                </div>

                <div class="input-name">
                    <input type="submit" class="btn" value="Save Customer">
                </div>
            </form>
        </div>

    </div>
</div>

</body>
</html>
