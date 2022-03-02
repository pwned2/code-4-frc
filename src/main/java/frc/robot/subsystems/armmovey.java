
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Commands.armmoveything;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class armmovey extends SubsystemBase {
  public WPI_TalonSRX trig = talonSRXConstructor(7);
  public WPI_TalonSRX trig2 = talonSRXConstructor(6);

  public armmovey() {

  }

  @Override
  public void periodic() {
  }

  private WPI_TalonSRX talonSRXConstructor(int x){
    WPI_TalonSRX temp = new WPI_TalonSRX(x);

    //temp.configContinuousCurrentLimit(40);//used standard play
    //temp.configPeakCurrentLimit(44, 1000);//used for pushing, limit for stopping wheel spin
    //temp.enableCurrentLimit(true);
    //temp.configOpenloopRamp(.25);//fine tune for best responsiveness
    //temp.configClosedloopRamp(0);//used for driving by encoders
    //temp.setNeutralMode(NeutralMode.Brake);

    return temp;
  }
}
