package kr.co.direa.kjy.test.robot;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;

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
