/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  public WPI_TalonSRX rightfront = talonSRXConstructor(10);
  public WPI_TalonSRX leftfront = talonSRXConstructor(5);
  public WPI_TalonSRX rightback = talonSRXConstructor(4);
  public WPI_TalonSRX leftback = talonSRXConstructor(1);
private MotorControllerGroup left =new MotorControllerGroup(leftfront, leftback);
private MotorControllerGroup right = new MotorControllerGroup(rightfront, rightback);
public DifferentialDrive driveBase = new DifferentialDrive(right, left);

  public DriveTrain() {
    right.setInverted(true);
    left.setInverted(false);
  }

  @Override
  public void periodic() {
  }

  private WPI_TalonSRX talonSRXConstructor(int x){
    WPI_TalonSRX temp = new WPI_TalonSRX(x);

    temp.configContinuousCurrentLimit(40);//used standard play
    temp.configPeakCurrentLimit(44, 1000);//used for pushing, limit for stopping wheel spin
    temp.enableCurrentLimit(true);
    temp.configOpenloopRamp(.25);//fine tune for best responsiveness
    temp.configClosedloopRamp(0);//used for driving by encoders
    temp.setNeutralMode(NeutralMode.Brake);

    return temp;
  }
}
