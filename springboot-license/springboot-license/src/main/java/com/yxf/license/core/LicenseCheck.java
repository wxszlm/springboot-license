package com.yxf.license.core;

import java.io.Serializable;
import java.util.List;

/**
 * <p>自定义需要校验的License参数</p>
 *
 * @author yixiangfeng
 * @blob http://www.wxsstudy.top
 * @date 2:21 2020-05-13
 */
public class LicenseCheck implements Serializable {

    private static final long serialVersionUID = 8600137500316662317L;

    /**
     * 是否认证ip
     */
    private boolean isIpCheck ;

    /**
     * 可被允许的IP地址
     */
    private List<String> ipAddress;

    /**
     * 是否认证mac
     */
    private boolean isMacCheck ;

    /**
     * 可被允许的mac地址
     */
    private List<String> macAddress;

    /**
     * 是否认证cpu序列号
     */
    private boolean isCpuCheck ;

    /**
     * 可被允许的CPU序列号
     */
    private String cpuSerial;

    /**
     * 是否认证主板号
     */
    private boolean isBoardCheck ;

    /**
     * 可被允许的主板序列号
     */
    private String mainBoardSerial;

    public LicenseCheck(){

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<String> getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(List<String> ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<String> getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(List<String> macAddress) {
        this.macAddress = macAddress;
    }

    public String getCpuSerial() {
        return cpuSerial;
    }

    public void setCpuSerial(String cpuSerial) {
        this.cpuSerial = cpuSerial;
    }

    public String getMainBoardSerial() {
        return mainBoardSerial;
    }

    public void setMainBoardSerial(String mainBoardSerial) {
        this.mainBoardSerial = mainBoardSerial;
    }

    public boolean isIpCheck() {
        return isIpCheck;
    }

    public void setIpCheck(boolean ipCheck) {
        isIpCheck = ipCheck;
    }

    public boolean isMacCheck() {
        return isMacCheck;
    }

    public void setMacCheck(boolean macCheck) {
        isMacCheck = macCheck;
    }

    public boolean isCpuCheck() {
        return isCpuCheck;
    }

    public void setCpuCheck(boolean cpuCheck) {
        isCpuCheck = cpuCheck;
    }

    public boolean isBoardCheck() {
        return isBoardCheck;
    }

    public void setBoardCheck(boolean boardCheck) {
        isBoardCheck = boardCheck;
    }

    @Override
    public String toString() {
        return "LicenseCheckModel{" +
                "ipAddress=" + ipAddress +
                ", macAddress=" + macAddress +
                ", cpuSerial='" + cpuSerial + '\'' +
                ", mainBoardSerial='" + mainBoardSerial + '\'' +
                '}';
    }
}
