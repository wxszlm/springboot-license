# 一、生成秘钥对

~~~~

1、首先要用KeyTool工具来生成私匙库：（-alias别名 –validity 3650表示10年有效）
keytool -genkey -alias privateKey -keystore privateKeys.store -validity 3650 -keysize 1024
 
2、然后把私匙库内的公匙导出到一个文件当中：
keytool -export -alias privateKey -file certfile.cer -keystore privateKeys.store
 
3、然后再把这个证书文件导入到公匙库：
keytool -import -alias publicCert -file certfile.cer -keystore publicCerts.store
 
最后生成文件privateKeys.store、publicCerts.store拷贝出来备用。
~~~~

# 二、 获取服务器硬件信息

### 访问地址：localhost:9999/license/getServerInfos

# 三、生成证书

### 生成接口：localhost:9999/license/generateLicense

# 四、启动项目

### 安装证书

# 五、认证接口

### localhost:8066/helloLicense