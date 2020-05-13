package com.yxf.license.controller;

import com.yxf.license.core.LicenseCheck;
import com.yxf.license.core.LicenseCreator;
import com.yxf.license.core.LicenseCreatorParam;
import com.yxf.license.service.AGxServerInfos;
import com.yxf.license.service.LinuxServerInfos;
import com.yxf.license.service.WindowsServerInfos;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>用于生成证书文件 == !!!不能放在给客户部署的代码里</p>
 *
 * @author yixiangfeng
 * @blob http://www.wxsstudy.top
 * @date 2:21 2020-05-13
 */
@RestController
@RequestMapping("/license")
public class LicenseCreatorController {

    /**
     * 证书生成路径
     */
    @Value("${license.licensePath}")
    private String licensePath;

    /**
     * <p>获取服务器硬件信息</p>
     * @param osName 操作系统类型，如果为空则自动判断
     */
    @RequestMapping(value = "/getServerInfos",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public LicenseCheck getServerInfos(@RequestParam(value = "osName",required = false) String osName) {

        //操作系统类型
        if(StringUtils.isBlank(osName)){
            osName = System.getProperty("os.name");
        }
        osName = osName.toLowerCase();
        AGxServerInfos abstractServerInfos;
        //根据不同操作系统类型选择不同的数据获取方法
        if (osName.startsWith("windows")) {
            abstractServerInfos = new WindowsServerInfos();
        } else if (osName.startsWith("linux")) {
            abstractServerInfos = new LinuxServerInfos();
        }else{//其他服务器类型
            abstractServerInfos = new LinuxServerInfos();
        }
        return abstractServerInfos.getServerInfos();

    }


    /**
     * 生成证书
      * @param param
     * @return
     */
    @PostMapping(value = "/generateLicense",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Map<String,Object> generateLicense(@RequestBody LicenseCreatorParam param) {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String,Object> resultMap = new HashMap<>(3);
        if(StringUtils.isBlank(param.getLicensePath())){
            param.setLicensePath(licensePath);
        }

        LicenseCreator licenseCreator = new LicenseCreator(param);
        boolean result = licenseCreator.generateLicense();

        if(result){
            resultMap.put("result","ok");
            resultMap.put("msg",param);
            resultMap.put("date",MessageFormat.format("证书安装成功，证书有效期：{0} - {1}",
                    format.format(param.getIssuedTime()),format.format(param.getExpiryTime())));
        }else{
            resultMap.put("result","error");
            resultMap.put("msg","证书文件生成失败！");
        }
        return resultMap;
    }

}