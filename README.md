My First Repository
===============

> 아쉽게도 진영킹은 기억력은 킹이 아니다. 그래서 기록한다. 끄적끄적 o(*￣▽￣*)ブ

* 진영킹의 작은 연습장

## HelloWorld
```java
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("HELLO WORLD!");
	}
}
```
개발자라면 누구나 처음에 작성하는 코드
- - -

## File Write Performance
```java
public class FilesTest {
	private static final String MYNAME = FilesTest.class.getSimpleName();

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String str = FileReadTest.getFileContent();
		byte[] bytes = str.getBytes();
		Path path = Paths.get("output/" + MYNAME);
		try {
			Files.write(path, bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long finish = System.currentTimeMillis();
		System.out.println("Running time: " + (finish - start)); // 105
	}

}
```
Java에서 지원하는 파일 쓰기의 성능 테스트 중 Files 라이브러리를 사용한 코드
- - -

## MouseMoveTest
```java
/**
 * Test to prevent the screen protector.
 * @author KJY
 *
 */
public class MouseMoveTest {

	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		PointerInfo info = null;
		long sleepTime = 60 * 1000L; // 1 Minute

		while (!Thread.interrupted()) {
			info = MouseInfo.getPointerInfo();
			robot.mouseMove(info.getLocation().x + 1, info.getLocation().y + 1);
			Thread.sleep(sleepTime);
		}
	}

}
```
화면 보호기를 막고자 Robot 라이브러리를 통한 커서를 이동시키는 코드   
이런 것도 된다..! ヾ(•ω•`)o
- - -

## Max User Processes in Linux
2021-11-01   
프로젝트 중 개발서버에서 OutOfMemoryError가 발생하여 정리한다.   
테스트는 도커로 CentOS 컨테이너를 생성하여 진행하였고 생성한 명령어는 다음과 같다.   
> 터미널은 Windows Terminal의 PowerShell을 사용하였고 Docker-Desktop이 설치된 상태이다.
```
PS C:\Users\KJY> docker run -it --rm centos:latest bash
Unable to find image 'centos:latest' locally
latest: Pulling from library/centos
a1d0c7532777: Pull complete
Digest: sha256:a27fd8080b517143cbbbab9dfb7c8571c40d67d534bbdee55bd6c473f432b177
Status: Downloaded newer image for centos:latest
[root@d25ed7467411 /]# ls
bin  dev  etc  home  lib  lib64  lost+found  media  mnt  opt  proc  root  run  sbin  srv  sys  tmp  usr  var
[root@d25ed7467411 /]# cat /etc/redhat-release
CentOS Linux release 8.4.2105
```
도커로 centos:latest 이미지를 사용하여 컨테이너를 생성하였고 로컬에 이미지가 존재하지 않아 이미지를 pull   
컨테이너 생성 후 터미널 접속이 되어 CentOS 8.4 버전을 확인


```
[root@d25ed7467411 /]# ulimit -a
core file size          (blocks, -c) 0
data seg size           (kbytes, -d) unlimited
scheduling priority             (-e) 0
file size               (blocks, -f) unlimited
pending signals                 (-i) 50169
max locked memory       (kbytes, -l) 82000
max memory size         (kbytes, -m) unlimited
open files                      (-n) 1048576
pipe size            (512 bytes, -p) 8
POSIX message queues     (bytes, -q) 819200
real-time priority              (-r) 0
stack size              (kbytes, -s) 8192
cpu time               (seconds, -t) unlimited
max user processes              (-u) unlimited
virtual memory          (kbytes, -v) unlimited
file locks                      (-x) unlimited

[root@d25ed7467411 /]# ulimit -aH
core file size          (blocks, -c) unlimited
data seg size           (kbytes, -d) unlimited
scheduling priority             (-e) 0
file size               (blocks, -f) unlimited
pending signals                 (-i) 50169
max locked memory       (kbytes, -l) 82000
max memory size         (kbytes, -m) unlimited
open files                      (-n) 1048576
pipe size            (512 bytes, -p) 8
POSIX message queues     (bytes, -q) 819200
real-time priority              (-r) 0
stack size              (kbytes, -s) unlimited
cpu time               (seconds, -t) unlimited
max user processes              (-u) unlimited
virtual memory          (kbytes, -v) unlimited
file locks                      (-x) unlimited
```
```ulimit -a```, ```ulimit -aH``` 명령어로 max user processes 확인   
> -a 옵션은 soft 타입의 limit, -aH 옵션은 hard 타입의 limit 출력

```
[root@d25ed7467411 security]# ulimit -u 1024
[root@d25ed7467411 security]# ulimit -a
core file size          (blocks, -c) 0
data seg size           (kbytes, -d) unlimited
scheduling priority             (-e) 0
file size               (blocks, -f) unlimited
pending signals                 (-i) 50169
max locked memory       (kbytes, -l) 82000
max memory size         (kbytes, -m) unlimited
open files                      (-n) 1048576
pipe size            (512 bytes, -p) 8
POSIX message queues     (bytes, -q) 819200
real-time priority              (-r) 0
stack size              (kbytes, -s) 8192
cpu time               (seconds, -t) unlimited
max user processes              (-u) 1024
virtual memory          (kbytes, -v) unlimited
file locks                      (-x) unlimited
```
테스트를 위하여 max user processes 값을 1024로 변경
> hard 타입의 제한값은 여전히 unlimited

```
[root@d25ed7467411 security]# java
bash: java: command not found
[root@d25ed7467411 jre]# yum -y install java-devel
... install prcoess skip ...
[root@d25ed7467411 security]# java -version
openjdk version "1.8.0_312"
OpenJDK Runtime Environment (build 1.8.0_312-b07)
OpenJDK 64-Bit Server VM (build 25.312-b07, mixed mode)
```
java 명령어가 없으므로 yum으로 java 설치하였고 버전은 1.8   

```
[root@d25ed7467411 home]# adduser kjy
[root@d25ed7467411 kjy]# su - kjy
```
나의 정체성을 위해 이니셜 계정도 생성해주고 홈 디렉터리로 이동

```
[kjy@d25ed7467411 ~]$ vi ThreadMakerTest.java
[kjy@d25ed7467411 ~]$ ls
ThreadMakerTest.java
[kjy@d25ed7467411 ~]$ javac ThreadMakerTest.java
[kjy@d25ed7467411 ~]$ ls
ThreadMakerTest.class  ThreadMakerTest.java
```
```vi``` 편집기로 미리 작성한 코드를 복붙하여 java 파일 생성하고 컴파일

```java
public class ThreadMakerTest {
        public static void main(String[] args) {
                int threadCount = 0;
                while (!Thread.interrupted()) {
                        threadCount++;
                        System.out.println("Count: " + threadCount);
                        String name = String.valueOf(threadCount);
                        new Thread(()->{
                              System.out.println(Thread.currentThread());
                              try {
                                        Thread.sleep(Long.MAX_VALUE);
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                        // Restore interrupted state...
                                        Thread.currentThread().interrupt();
                                }
                        }, "Test-Thread-" +name).start();
                }
        }
}
```
테스트에 사용할 쓰레드 생성 코드   

```
[kjy@d25ed7467411 ~]$ java ThreadMakerTest
Count: 1
Count: 2
Thread[Test-Thread-1,5,main]
Count: 3
Count: 4
Thread[Test-Thread-2,5,main]
Thread[Test-Thread-3,5,main]
...중략...
Count: 1000
Thread[Test-Thread-999,5,main]
Count: 1001
Thread[Test-Thread-1000,5,main]
Count: 1002
Thread[Test-Thread-1001,5,main]
Count: 1003
Thread[Test-Thread-1002,5,main]
Count: 1004
Thread[Test-Thread-1003,5,main]
Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
        at java.lang.Thread.start0(Native Method)
        at java.lang.Thread.start(Thread.java:717)
        at ThreadMakerTest.main(ThreadMakerTest.java:17)
```
테스트를 시작하고 1004번째 쓰레드 생성에서 ```java.lang.OutOfMemoryError: unable to create new native thread``` 발생   
기존 쓰레드가 20개 정도 서버에 있었음을 가정하면 테스트는 성공!

```
^COpenJDK 64-Bit Server VM warning: Exception java.lang.OutOfMemoryError occurred dispatching signal SIGINT to handler- the VM may need to be forcibly terminated
```

> 터미널 인터럽트(Ctrl + C)를 해도 프로세스가 취소되지 않음... 안녕, 컨테이너.. （；´д｀）ゞ   
> 다른 터미널로 컨테이너에 접속하여 ```kill -9 PID``` 명령어를 사용하면 프로세스 종료는 가능   
> PID는 ```ps -ef | grep ThreadMakerTest``` 명령어 출력값의 2번째 값으로 검색 가능   

+ 결론
> ```ulimit -u``` 값은 사용자 계정에서 실행되는 쓰레드의 최대 갯수이다.   
> ```Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread```가 발생했다면 ulimit -u 값을 확인   
> ```ulimit -u 설정값``` 명령어로 서버의 설정을 변경   
> 쓰레드 생성 코드의 문제면 코드를 수정하도록 한다. ~~(테스트 코드처럼 작성할 개발자는 없겠지만..)~~   

+ 추가
> __위 테스트에서 사용한 ```ulimit -u``` 명령어는 영구적인 설정은 아니다.__   
> 실제로 계정 로그아웃 후 다시 로그인하여 ```ulimit -a```를 치면 서버의 기본값이 출력되는데 이를 영구적으로 설정하기 위해서 다음과 같이 수행한다.   
> ```
> 1. vi /etc/security/limits.conf
> 2. 파일의 하단에 다음 내용을 입력
> *	soft	nproc	1024
> 의미: 모든 계정( * )에 soft 타입으로 max user processes 제한을 1024로 설정한다.
> 3. 저장 후 닫기
> ```
> 
- - -


