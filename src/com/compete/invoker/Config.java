package com.compete.invoker;

public class Config {
    private boolean setProxy;
    private String proxyHost;
    private String proxyPort;
    //-------below code is modified to accept proxy username and password.
    private boolean setPassword;
    private String proxyUser;
    private String proxyPassword;
    //-------End of Modification. Further modification - addition of respective getter/setter
    private String apiKey;
    private String apiKeyStr;

    public String getApiKeyStr() {
            return apiKeyStr;
    }

    public Config() {
            apiKeyStr = "";
    }

    public Config(String apiKey) {
            this.apiKey = apiKey;
            apiKeyStr = "key=" + apiKey;
    }

    public String getApiKey() {
            return apiKey;
    }

    public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
            apiKeyStr = "key=" + apiKey;
    }

    public boolean isSetProxy() {
            return setProxy;
    }

    public void setSetProxy(boolean setProxy) {
            this.setProxy = setProxy;
    }

    public String getProxyHost() {
            return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
            this.proxyHost = proxyHost;
    }

    public String getProxyPort() {
            return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
            this.proxyPort = proxyPort;
    }
    //-------below code is modified to accept proxy username and password.
    public boolean isSetPassword() {
            return setPassword;
    }

    public void setSetPassword(boolean setPassword) {
            this.setPassword = setPassword;
    }

    public String getProxyUser() {
            return proxyUser;
    }

    public void setProxyUser(String proxyUser) {
            this.proxyUser = proxyUser;
    }

    public String getProxyPassword() {
            return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
            this.proxyPassword = proxyPassword;
    }
    //-------End of Modification. 
}