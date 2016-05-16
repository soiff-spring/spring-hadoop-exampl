# Spring Hadoop Example

----

## Features

1. `FsShell` is ready, and `-ls /` will automatically executed;
1. `SimpleWordCount` job is ready;

## Usage

### `SimpleWordCount`

> HDFS daemon is listening on `127.0.0.1:9000` by default, so extra address, which is in same network, should be opened for remote requests if this job is tried on remote host. Otherwise, `SimpleWordCount#getJob()` will return an empty `Job`, which would absolutely an exception.

> `inputPath` and `outputPath` of `Job` should definitely a `HDFS` URI. Relative path or absolute path could not work properly. The correct way is specify qualified paths, such as:

```
java -jar spring-hadoop-example-1.0.0-SNAPSHOT.jar --swc.input=hdfs://localhost:9000/user/soiff/input --swc.output=hdfs://localhost:9000/user/soiff/output
```

> Attention: `outputPath` should not be exist, otherwise job will abort.