# jenkins-build-util

> a jenkins build util projection

Build jenkins projects for multiple environments with one click

## Installing / Getting started

Starting this project is very simple, you just need to follow the steps

Run in jar:
```shell
git clone https://github.com/disaster1-tesk/jenkins-build-util.git
mvn clean install
cd chat-gpt-wechat-springboot-starter
java -jar chat-gpt-wechat-springboot-starter-1.1.0.jar
```
Run in ide:
```shell
git clone https://github.com/disaster1-tesk/jenkins-build-util.git
run in ide
```

### Prepare
The startup of the project depends on jdk11, so you may need to install jdk11,You also need to modify the configuration a little

### Configuration

```yaml
jenkins:
  build:
    util:
      config:
        #jenkins Username
        username: yourName
        #jenkins Password
        password: yourPassword
        #your Test Environment information
        test-address:
          weaver-operation-platform-sqlserver: http://yourIp:8080/job/weaver-operation-platform
          weaver-customer-service-oracle: http://yourIp:8080/job/weaver-customer-service
          weaver-operation-platform-oracle: http://yourIp:8080/job/weaver-operation-platform
          weaver-customer-service-PG: http://yourIp:8080/job/weaver-customer-service
          weaver-operation-platform-PG: http://yourIp:8080/job/weaver-operation-platform
          weaver-customer-service-达梦: http://yourIp:8080/job/weaver-customer-service
          weaver-operation-platform-达梦: http://yourIp:8080/job/weaver-operation-platform
          weaver-customer-service-神通: http://yourIp:8080/job/weaver-customer-service
          weaver-operation-platform-神通: http://yourIp:8080/job/weaver-operation-platform
        #your release environment information
        release-address:
          weaver-customer-service-mysql: http://yourIp:8080/job/weaver-customer-service
          weaver-operation-platform-mysql: http://yourIp:8080/job/weaver-operation-platform
          weaver-customer-service-sqlserver: http://yourIp:8080/job/weaver-customer-service
          weaver-operation-platform-sqlserver: http://yourIp:8080/job/weaver-operation-platform
          weaver-customer-service-oracle: http://yourIp:8080/job/weaver-customer-service
          weaver-operation-platform-oracle: http://yourIp:8080/job/weaver-operation-platform
          weaver-customer-service-PG: http://yourIp:8080/job/weaver-customer-service
          weaver-operation-platform-PG: http://yourIp:8080/job/weaver-operation-platform
          weaver-customer-service-DM: http://yourIp:8080/job/weaver-customer-service
          weaver-operation-platform-DM: http://yourIp:8080/job/weaver-operation-platform
          weaver-customer-service-ST: http://yourIp:8080/job/weaver-customer-service
          weaver-operation-platform-ST: http://yourIp:8080/job/weaver-operation-platform
        # jenkins apitoken for different environments
        tokens:
          http://yourIp:8080: 11ec8c8e3e021ffcfc48f91f758fe6d40d
          http://yourIp:8080: 118894759ed2e2815e795d8cdee2fe09ab
          http://yourIp:8080: 1117b5544962eafd0187a82d6e784d5f26
          http://yourIp:8080: 11351527f2f4bb99109e36971a769b3e21
          http://yourIp:8080: 114c4de9eac19d7c914dcd0763856c3466
          http://yourIp:8080: 1180ad38c514aec9ed945765fa051c1d58
          http://yourIp:8080: 117c50c13d50a9492817eb0009191a5c4f
          http://yourIp:8080: 11e995f294993610f6dc04c02dbc968433
          http://yourIp:8080: 116f1a33cdf6e951127dcebb254db50971
          http://yourIp:8080: 11f691ae7e621024015f69126a5f89ee93
```


## Features

* Supports dynamic query service
* Supports different ways of building
* The configuration center dynamically updates the configuration

## Links

The implementation of this project depends on the following projects：

sa-Token: https://gitee.com/dromara/sa-token

jenkins-rest: https://github.com/cdancy/jenkins-rest


## Licensing

"The code in this project is licensed under Apache License."
