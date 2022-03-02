
package frc.robot.Commands;

import frc.robot.subsystems.armmovey;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class armmoveything extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final armmovey m_armovey;
    XboxController xbox;
  
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public armmoveything(armmovey armmovey, XboxController x) {
      m_armovey = armmovey;
      xbox = x;
      // Use requires() here to declare subsystem dependencies.
      addRequirements(m_armovey);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(xbox.getXButton()){
            m_armovey.trig.set(1);
         } else if(xbox.getBButton()){
           m_armovey.trig.set(-1);
         
        }else{
             m_armovey.trig.set(0);
         } 
        if(xbox.getYButton()){
            m_armovey.trig2.set(1);
        } else if(xbox.getAButton()){
            m_armovey.trig2.set(-1);
        }
        else{
            m_armovey.trig2.set(0);
        }
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
  }
  