wget "https://github.com/jialechan/common-upload-server/releases/download/0.0.1/common-upload-server.jar"   

java -jar common-upload-server.jar --host=http://x.x.x.x:10000 --basePath=/userdata1/www --extList=
"gif,jpg,png" --server.port=10001
