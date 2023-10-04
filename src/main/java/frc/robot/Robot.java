// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.led.CANdle;
 

public class Robot extends TimedRobot {
  CANdle led = new CANdle(2);
  @Override
  public void autonomousPeriodic() {
    teleopPeriodic();
  }

  @Override
  public void teleopPeriodic() {
    led.setLEDs(100, 126, 80);
    
  }
}
