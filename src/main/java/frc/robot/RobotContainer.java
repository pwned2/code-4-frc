/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;

/*
 * used for pathplanning, no longer maintained
 */
// import java.io.IOException;
// import java.nio.file.Path;
// import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj.Filesystem;
// import edu.wpi.first.math.trajectory.*;
// import edu.wpi.first.math.controller.RamseteController;
// import edu.wpi.first.math.controller.PIDController;
// import edu.wpi.first.math.controller.SimpleMotorFeedforward;
// import edu.wpi.first.wpilibj2.command.RamseteCommand;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private XboxController xbox = new XboxController(0);

  public final DriveTrain m_DriveTrain = new DriveTrain();
  public final armmovey m_armmovey = new armmovey();

  private final DriveWithJoystick m_DriveWithJoystick = new DriveWithJoystick(m_DriveTrain, xbox);
  private final armmoveything m_armmoveything = new armmoveything(m_armmovey, xbox);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // Configure the button bindings

    m_DriveTrain.setDefaultCommand(m_DriveWithJoystick);
    m_armmovey.setDefaultCommand(m_armmoveything);

  }
}
