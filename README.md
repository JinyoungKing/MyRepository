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

## Max User Processes in Linux
프로젝트 중 개발서버에서 OutOfMemoryError가 발생하여 정리   
테스트는 도커로 CentOS 컨테이너를 생성하여 진행하였고 생성한 명령어는 다음과 같다.   
* 터미널은 Windows Terminal의 PowerShell을 사용하였고 Docker-Desktop이 설치된 상태이다.
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
ulimit -a, ulimit -aH 명령어로 max user processes 확인   
* -a 옵션은 soft 타입의 limit, -aH 옵션은 hard 타입의 limit 출력




