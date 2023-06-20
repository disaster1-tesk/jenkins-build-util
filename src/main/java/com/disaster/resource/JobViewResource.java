package com.disaster.resource;

import cn.dev33.satoken.annotation.SaIgnore;
import com.disaster.domain.share.Result;
import com.disaster.infrastructure.utils.JobUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/operation/platform/job/view")
public class JobViewResource {


    /**
     * 查询所有的构建信息
     *
     * @return
     */
    @GetMapping("/findAll")
    public Result findAll() {
        return Result.success(JobUtils.getAllJobInfo());
    }

    /**
     * 查询develop环境的信息
     *
     * @param jobName
     * @return
     */
    @SaIgnore
    @GetMapping("/findTest")
    public Result findTest(@RequestParam("jobName") String jobName) {
        Map<String, String> testAddress = JobUtils.getTestAddress();
        return Result.success(filter(jobName, testAddress));
    }

    /**
     * 查询release环境的信息
     *
     * @param jobName
     * @return
     */
    @GetMapping("/findRelease")
    @SaIgnore
    public Result findRelease(@RequestParam("jobName") String jobName) {
        Map<String, String> releaseAddress = JobUtils.getReleaseAddress();
        return Result.success(filter(jobName, releaseAddress));
    }

    private static Map<String, String> filter(String jobName, Map<String, String> releaseAddress) {
        Set<Map.Entry<String, String>> entries = releaseAddress.entrySet();
        HashMap<String, String > resultMap = new HashMap<>();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getKey().contains(jobName)) {
                resultMap.put(entry.getKey(), entry.getValue());
            }
        }
        return resultMap;
    }
}
