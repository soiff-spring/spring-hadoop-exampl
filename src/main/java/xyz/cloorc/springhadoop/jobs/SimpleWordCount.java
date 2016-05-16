package xyz.cloorc.springhadoop.jobs;

import org.apache.hadoop.examples.WordCount;
import org.apache.hadoop.mapreduce.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.mapreduce.JobFactoryBean;
import org.springframework.data.hadoop.mapreduce.JobRunner;

/**
 * Created by Soiff on 2016/05/16.
 *
 * @author : Soiff
 */
@Configuration
public class SimpleWordCount {

    @Bean
    public static Job getJob() throws Exception {
        final JobFactoryBean job = new JobFactoryBean();
        job.setInputPath("input/");
        job.setOutputPath("output/");
        job.setName("hadoop-word-counter");
        job.setReducer(WordCount.IntSumReducer.class.getCanonicalName());
        job.setMapper(WordCount.TokenizerMapper.class.getCanonicalName());
        return job.getObject();
    }

    @Autowired
    @Bean
    public static JobRunner getJobRunner(Job job) {
        final JobRunner runner = new JobRunner();
        runner.setRunAtStartup(true);
        runner.setJob(job);
        return runner;
    }
}
