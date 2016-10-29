<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Start page</title>
</head>
<body>

<a href= ${s:mvcUrl('LA#index')}>Login</a>
<br>
<a href= ${s:mvcUrl('R#index')}>Registration</a>

</body>
</html>