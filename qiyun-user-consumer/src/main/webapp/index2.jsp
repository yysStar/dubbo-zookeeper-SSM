<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="/user/updateMemberPicture" method="post" enctype="multipart/form-data" >
    <table>
        <tr>
            <td>
                图片:
                <input type="file" name="QRCode"/>
            </td>
        </tr>
        <tr>
            <td>
                token:
                <input  type="text" name="token"/>
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
