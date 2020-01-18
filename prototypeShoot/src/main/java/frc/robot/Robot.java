/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private Spark myTalon = new Spark(1);
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();
  private double power = 0.0;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
  }

  /**
   * This function is called periodically during teleoperated mode.
   */
  @Override
  public void teleopPeriodic() {
    boolean lowerPower = m_stick.getRawButton(4); // Triangle
    boolean lowPower = m_stick.getRawButton(5); // Left bumper
    boolean middlePower = m_stick.getRawButton(6); // Right Bumper
    boolean highPower = m_stick.getRawButton(7); // Left Trigger
    boolean higherPower = m_stick.getRawButton(8); // Right Trigger
    boolean veryHighPower = m_stick.getRawButton(9); // Share button
    boolean veryvHighPower = m_stick.getRawButton(10); // Options button
    if (lowerPower) {
      power = -0.7;
    } else if (lowPower) {
      power = -0.72;
    } else if (middlePower) {
      power = -0.74;
    } else if (highPower) {
      power = -0.76;
    } else if (higherPower) {
      power = -0.78;
    } else if (veryHighPower) {
      power = -0.8;
    } else if (veryvHighPower) {
      power = -1;
    } else {
      power = 0;
    }
    myTalon.set(power);
  }

  /**     70 degress -0.74 speed, 2 balls 1.66, 4 balls 2.66, 5 balls 3.26, 5 balls 3.9, 5 balls
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
