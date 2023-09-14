<html>
<head>
    <title>login</title>
</head>
<body>
<!-- <h2>hii ${userName}</h2> -->
<div class="container">
    <h2 style="color: red;" >${errorMsg}</h2>
    <form class="container" method="post">
    <h2>Login</h2>
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="name" required>
    <br>
    <br>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
    <br>
    <br>
    <button type="submit">Login</button>
    </form>
</div>

</body>
</html>