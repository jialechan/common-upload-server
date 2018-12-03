wget "https://github.com/jialechan/common-upload-server/releases/download/1.0.0/common-upload-server.jar"

```shell
# 设置最大上传100M
java -jar common-upload-server.jar --host=http://x.x.x.x:10000 --basePath=/userdata1/www --extList=
"gif,jpg,png" --spring.servlet.multipart.maxFileSize=100000000 --spring.servlet.multipart.maxRequestSize=1000000000
```

curl -F "file=@/Users/xxx/Downloads/7CA85811-6908-4378-954E-92286031C84D.png" http://x.x.x.x:10000/uploadFile
