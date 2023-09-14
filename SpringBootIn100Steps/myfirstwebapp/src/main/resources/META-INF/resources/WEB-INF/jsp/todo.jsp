<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <link rel="stylesheet" href="webjars/bootstrap/5.3.1/css/bootstrap.min.css">
        <title>
            Add Todos Page
        </title>
    </head>
    <body>
    <div class="container">   
        <h1> Enter todo details</h1>
        <form:form method="post" modelAttribute="todo">
       <!-- "todo" i.e variable name, should be same as in controller-showAllTodo method -->       
        <label for="description"><b>Description</b></label>
        <form:input type="text" path="description" required="required"/>
        <form:errors path="description" class="text-danger"/>
        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="done"/>
        <input type="submit" class="btn btn-success"></a>
        </form:form>
        </div>
        <script src="webjars/bootstrap/5.3.1/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.7.0/jquery.min.js"></script>
    </body>
</html>