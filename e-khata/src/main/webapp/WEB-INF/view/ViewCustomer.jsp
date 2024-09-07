<%@ page import="java.util.ArrayList" %>
<%@ page import="utils.StringUtils" %>
<%@ page import="model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"/>
    <title>Customer List</title>
    <%
        @SuppressWarnings("unchecked")
        List<Customer> customers = (List<Customer>) request.getAttribute(StringUtils.CUSTOMER_OBJECT);
    %>

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

        /* Styling Body Content */
        .body-content {
            margin-left: 260px;
            margin-top: 70px;
            padding: 20px;
            background-color: #e7f2fd;
            width: calc(100% - 260px);
        }

        .search-container {
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 10px;
        }

        .search-wrapper {
            position: relative;
            width: 100%;
            max-width: 600px;
            display: flex;
            align-items: center;
        }

        .search-bar {
            font-size: 16px;
            width: 400px;
            padding: 10px 40px 10px 10px;
            border-radius: 25px;
            box-sizing: border-box;
            border: none;
            outline: none;
        }

        .search-bar::placeholder {
            color: #888;
            font-size: 16px;
        }

        .search-button {
            position: absolute;
            top: 50%;
            right: 2%;
            transform: translateY(-50%);
            background: transparent;
            border: none;
            cursor: pointer;
            padding: 10px;
        }

        .search-button i {
            color: #333;
            font-size: 16px;
        }

        .search-bar:focus {
            outline: none;
            border-color: #8AAAE5;
        }

        .reset-button {
            padding: 10px 20px;
            background-color: var(--blue-color);
            color: var(--white-color);
            border: none;
            border-radius: 25px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }

        .reset-button:hover {
            background-color: #335dc2;
        }

        .body-content .container{
            background: white;
            width: 800px;
            padding: 25px;
            margin: 20px auto 50px;
            border-top: 5px solid blue;
            box-shadow: 0 0 5px 2px rgba(0, 0, 0, 0.5);
            overflow-y: auto;
            overflow-x: hidden;
            max-height: 500px;
            position: relative;
        }

        .customer-table {
            width: 100%;
            border-collapse: collapse;
            table-layout: fixed;
            height: 500px;
        }

        .customer-table th, .customer-table td {
            text-align: left;
            padding: 10px;
            border-bottom: 1px solid #ddd;
            word-wrap: break-word;
            line-height: 1.99;
            vertical-align: top;
        }

        .customer-table th {
            background-color: #f2f2f2;
            color: #333;
        }

        .customer-table tbody {
            max-height: 500px;
            overflow-y: auto;
            display: block;
        }

        .customer-table tbody tr {
            display: table;
            width: 100%;
            table-layout: fixed;
        }

        .customer-table thead, .customer-table tbody tr {
            display: table;
            width: 100%;
            table-layout: fixed;
        }

        .customer-table th:nth-child(1),
        .customer-table td:nth-child(1) {
            width: 10%;
        }

        .customer-table th:nth-child(2),
        .customer-table td:nth-child(2) {
            width: 40%;
        }

        .customer-table th:nth-child(3),
        .customer-table td:nth-child(3),
        .customer-table th:nth-child(4),
        .customer-table td:nth-child(4) {
            width: 30%;
        }

        .customer-table tr:hover {
            background-color: #f5f5f5;
        }

        .customer-table td {
            color: #333;
        }

        .customer-table .edit-btn, .customer-table .delete-btn {
            padding: 5px 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-size: 14px;
            width: 70px;
            margin-right: 5px;
        }

        .customer-table .edit-btn {
            background-color: #4CAF50;
            color: white;
            transition: opacity 0.3s;
        }

        .customer-table .delete-btn {
            background-color: #f44336;
            color: white;
            transition: opacity 0.3s;
        }

        .customer-table .edit-btn:hover{
            opacity: 0.8;
        }

        .customer-table .delete-btn:hover{
            opacity: 0.8;
        }

        .container::-webkit-scrollbar {
            width: 5px;
        }

        .container::-webkit-scrollbar-track {
            background: #f1f1f1;
        }

        .container::-webkit-scrollbar-thumb {
            background: #888;
            border-radius: 5px;
        }

        .container::-webkit-scrollbar-thumb:hover {
            background: #555;
        }
    </style>
</head>
<body>
<%@include file="Sidebar.jsp"%>

<!-- Body Content -->
<div class="body-content">
    <div class="search-container">
        <form action="${pageContext.request.contextPath}/customer-list" method="get">
            <div class="search-wrapper">
                <input type="text" placeholder="Search" class="search-bar" name="search">
                <button class="search-button" type="submit">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </div>
            <button type="reset" class="reset-button" onclick="window.location.href='${pageContext.request.contextPath}/customer-list'">Reset Filter</button>
        </form>
    </div>
    <div class="container">
        <table class="customer-table">
            <thead>
            <tr>
                <th>S.N.</th>
                <th>Customer Name</th>
                <th>Phone Number</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                if(customers != null && !customers.isEmpty()) {
                    int symbolNumber = 1;
            %>
            <% for(Customer customer: customers) { %>
            <tr>
                <td><%= symbolNumber %></td>
                <td><%= customer.getFirstName() + " " + customer.getLastName() %></td>
                <td><%= customer.getPhone() %></td>
                <td>
                    <button class="edit-btn">Edit</button>
                    <button class="delete-btn">Delete</button>
                </td>
            </tr>
            <%
                    symbolNumber++;
                } %>
            <% } else { %>
            <tr>
                <td colspan="4" style="text-align: center">No Customers</td>
            </tr>
            <% } %>
            </tbody>


        </table>
    </div>
</div>
</body>
</html>
