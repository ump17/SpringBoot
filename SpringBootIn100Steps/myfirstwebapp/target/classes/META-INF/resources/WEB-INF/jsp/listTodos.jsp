<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- <h2> welcome ${todos}</h2> -->
<html>
    <head>
        <link rel="stylesheet" href="webjars/bootstrap/5.3.1/css/bootstrap.min.css">
        <title>
            List Todos Page
        </title>
    </head>
    <body>
    <div class="container">   
        <table class="table">
            <thead>
                <th>id</th>
                <th>Description</th>
                <th>Target date</th>
                <th>Is Done?</th>
                <th>Delete?</th>
                <th>Update?</th>
            </thead>
            <tbody>
            <h2> your todos are: </h2>
                <c:forEach items="${todos}" var="todo" >
               <tr> 
                    <td>${todo.id}</td> 
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td> 
                    <td> <a href="delete-todo?id=${todo.id}" class="btn btn-danger">DELETE</a>  </td>
                    <td> <a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a>  </td>
               </tr> 
            </c:forEach> 
            </tbody>
          </table>
               <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
        <script src="webjars/bootstrap/5.3.1/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.7.0/jquery.min.js"></script>
    </body>
</html>