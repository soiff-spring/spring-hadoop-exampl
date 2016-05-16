package xyz.cloorc.springhadoop.utils;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Soiff on 2016/05/16.
 *
 * @author : Soiff
 */
public class SimpleResolver extends PathMatchingResourcePatternResolver {

    final static String splitter = ",;:";

    @Override
    public Resource[] getResources(String locationPattern) throws IOException {
        final String[] patterns = locationPattern.split(splitter);
        final List<Resource> resources = new ArrayList<>(1024);
        for (String pattern : patterns) {
            if (pattern.startsWith("classpath"))
                resources.addAll(Arrays.asList(super.getResources(pattern)));
            else
                resources.add(new FileSystemResource(pattern));
        }
        return resources.toArray(new Resource[resources.size()]);
    }
}
