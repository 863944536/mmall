<%@ page language="java"  contentType="text/html; charset=UTF-8" %>

<html>
<body>
<h2>Tomcat1!</h2>
<h2>Tomcat1!</h2>
<h2>Tomcat1!</h2>
<h2>Hello World!</h2>



springmvc上传文件
<h1>----- BEGIN LICENSE -----
    sgbteam
    Single User License
    EA7E-1153259
    8891CBB9 F1513E4F 1A3405C1 A865D53F
    115F202E 7B91AB2D 0D2A40ED 352B269B
    76E84F0B CD69BFC7 59F2DFEF E267328F
    215652A3 E88F9D8F 4C38E3BA 5B2DAAE4
    969624E7 DC9CD4D5 717FB40C 1B9738CF
    20B3C4F1 E917B5B3 87C38D9C ACCE7DD8
    5F7EF854 86B9743C FADC04AA FB0DA5C0
    F913BE58 42FEA319 F954EFDD AE881E0B
    ------ END LICENSE ------</h1>
<form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="springmvc上传文件" />
</form>


富文本图片上传文件
<form name="form2" action="/manage/product/richtext_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file" />
    <input type="submit" value="富文本图片上传文件" />
</form>

</body>
</html>
