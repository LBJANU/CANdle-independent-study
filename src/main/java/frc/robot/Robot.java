// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller;

import java.util.zip.Deflater;

import javax.lang.model.util.ElementScanner14;

import com.ctre.phoenix.led.CANdle;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class Robot extends TimedRobot {
  private static final String kDefault = "Default";
  private static final String kRed = "Red";
  private static final String kBlue = "Blue";
  private static final String kGreen = "Green";
  private static final Double numRed = 255.0;
  private static final Double numGreen = 255.0;
  private static final Double numBlue = 255.0;

  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  CANdle led = new CANdle(2);
  PS4Controller m_controller = new PS4Controller(0);
  Double joystickval = m_controller.getLeftY();
  double joystickvalred = m_controller.getLeftY() * numRed;
  double joystickvalgreen = m_controller.getLeftY() * numGreen;
  double joystickvalblue = m_controller.getLeftY() * numBlue;

  int wrapred = (int) Math.abs(joystickvalred);
  int wrapgreen = (int) Math.abs(joystickvalgreen);
  int wrapblue = (int) Math.abs(joystickvalblue);


  

  @Override
  public void autonomousPeriodic() {
    teleopPeriodic();
  }

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default", kDefault);
    m_chooser.addOption("Red", kRed);
    m_chooser.addOption("Blue", kBlue);
    m_chooser.addOption("Green", kGreen);
   
    SmartDashboard.putData("colorboi", m_chooser);
  }

  @Override
  public void teleopPeriodic() {

    //led.setLEDs(wrapred, wrapgreen, wrapblue);   <- Changing the value based on the joystick code 

    String m_colorselected = m_chooser.getSelected();

    SmartDashboard.putString("colorselected", m_colorselected);

    
        
    

    if (m_colorselected == "Default")
    {
      led.setLEDs(0, 0, 0);
    }
    else if (m_colorselected == "Red")
    {
      led.setLEDs(100, 0, 0);
    }
    else if (m_colorselected == "Blue")
    {
      led.setLEDs(0, 0, 100);
    }
    else if (m_colorselected == "Green")
    {
      led.setLEDs(0, 100, 0);
    }
    else {
      led.setLEDs(100, 100, 100);
    }

    // switch (m_colorselected) {
    //   case kRed:
    //     led.setLEDs(100, 0, 0);
    //     break;

    //   case kBlue:
    //     led.setLEDs(0, 0, 100);
    //     break;

    //   case kDefault:
    //     led.setLEDs(0, 0, 0);
    //     break;

    //   default:
    //     led.setLEDs(100, 100, 100);
    //     break;

    // }

    // if (rgbchooser.getSelected() == "red")
    // {
    // led.setLEDs(100, 0, 0);
    // }

    // if (rgbchooser.getSelected() == "blue")
    // {
    // led.setLEDs(0, 0, 100);
    // }

    // led.setLEDs(100, 126, 80);

  }
}
