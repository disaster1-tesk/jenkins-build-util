package com.disaster.resource;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.common.IntegerResponse;
import com.disaster.domain.aggregate.User;
import com.disaster.domain.share.Result;
import com.disaster.infrastructure.client.JenkinsFactory;
import com.disaster.infrastructure.utils.JobUtils;
import com.disaster.infrastructure.utils.UserContext;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.*;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/operation/platform/job/build")
public class JobBuildResource {

    private static  String jobXml = "<project>\n" +
            "<keepDependencies>false</keepDependencies>\n" +
            "<properties/>\n" +
            "<scm class=\"hudson.scm.NullSCM\"/>\n" +
            "<canRoam>true</canRoam>\n" +
            "<disabled>false</disabled>\n" +
            "<blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>\n" +
            "<blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>\n" +
            "<triggers/>\n" +
            "<concurrentBuild>false</concurrentBuild>\n" +
            "<builders/>\n" +
            "<publishers/>\n" +
            "<buildWrappers/>\n" +
            "</project>";


    /**
     * 获取 Job 最后的 Build
     *
     * @param address
     * @return
     */
    @GetMapping("/getJobLastBuild")
    public Result getJobLastBuild(@RequestParam("address") @NonNull String address) {
        try {
            User currentUser = UserContext.getCurrentUser();
            String userName = currentUser.getUserName();
            String passWord = currentUser.getPassWord();
            JenkinsServer jenkinsServer = JenkinsFactory.connection(address.substring(0, address.lastIndexOf(':') + 5), userName, passWord);
            String jobName = address.substring(address.lastIndexOf('/') + 1);
            // 获取 Job 信息
            JobWithDetails job = jenkinsServer.getJob(jobName);
            if (job.isInQueue()) {
                return Result.success(202, jobName + " prepare build");
            }
            // 获得最后编译信息
            Build lastBuild = job.getLastBuild();
            // 获取最后成功的编译信息
            Build lastSuccessfulBuild = job.getLastSuccessfulBuild();
            int number = lastBuild.getNumber();
            int number1 = lastSuccessfulBuild.getNumber();
            return number == number1 ? Result.success(true) : Result.fail("fail");
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 获取最后一次构建的信息
     *
     * @param address
     * @return
     */
    @GetMapping("/getBuildActiveLog")
    public Result getBuildActiveLog(@RequestParam("address") @NonNull String address) {
        try {
            User currentUser = UserContext.getCurrentUser();
            String userName = currentUser.getUserName();
            String passWord = currentUser.getPassWord();
            // 这里用最后一次编译来示例
            JenkinsServer jenkinsServer = JenkinsFactory.connection(address.substring(0, address.lastIndexOf(':') + 5), userName, passWord);
            BuildWithDetails build = jenkinsServer
                    .getJob(address.substring(address.lastIndexOf('/') + 1))
                    .getLastBuild()
                    .details();
            // 当前日志
            ConsoleLog currentLog = build.getConsoleOutputText(0);
            return Result.success(currentLog);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 获取当前所有的任务
     *
     * @param address
     * @return
     */
    @GetMapping("/getJobList")
    public Result getJobList(@RequestParam("address") @NonNull String address) {
        User currentUser = UserContext.getCurrentUser();
        String userName = currentUser.getUserName();
        String passWord = currentUser.getPassWord();
        JenkinsServer jenkinsServer = JenkinsFactory.connection(address.substring(0, address.lastIndexOf(':') + 5), userName, passWord);
        try {
            Map<String, Job> jobs = jenkinsServer.getJobs();
            return Result.success(jobs);
        } catch (IOException e) {
            return Result.fail(e.getMessage());
        }
    }

    /**
     * 创建job
     *
     * @param address
     * @return
     */
    @GetMapping("/createJob")
    public Result createJob(@RequestParam("address") @NonNull String address) {
        User currentUser = UserContext.getCurrentUser();
        String userName = currentUser.getUserName();
        String passWord = currentUser.getPassWord();
        String prefix = address.substring(0, address.lastIndexOf(':') + 5);
        JenkinsClient client = JenkinsFactory.getClient(prefix, userName, passWord, JobUtils.getApiToken(prefix));
        String jobName = address.substring(address.lastIndexOf('/') + 1);
        IntegerResponse response = client.api().jobsApi().build(null, jobName);
        com.cdancy.jenkins.rest.domain.user.User user = client.api().userApi().get();
        if(response.value()!=null){
            return Result.success(response.value());
        }
        return Result.fail(response.errors().toString());
    }

}
