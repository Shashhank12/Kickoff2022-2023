// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Drivetrain extends SubsystemBase {
  TalonFX drivetrainFrontLeftMotor = new TalonFX(Constants.DRIVETRAIN_FRONT_LEFT_MOTOR);
  TalonFX drivetrainBackLeftMotor = new TalonFX(Constants.DRIVETRAIN_BACK_LEFT_MOTOR);

  TalonFX drivetrainFrontRightMotor = new TalonFX(Constants.DRIVETRAIN_FRONT_RIGHT_MOTOR);
  TalonFX drivetrainBackRightMotor = new TalonFX(Constants.DRIVETRAIN_BACK_RIGHT_MOTOR);

  public static final double TalonFX_F = 0;
  public static final double TalonFX_P = 0.025;
  public static final double TalonFX_I = 0.0000;
  public static final double TalonFX_D = 0.0075;

  public static final double Position_TalonFX_P = 0.025;
  public static final double Position_TalonFX_I = 0.0000;
  public static final double Position_TalonFX_D = 0;

  public static int loopcounter = 0;


































































  /*There are three commands(each used only once) below that 
  *need to be filled in three different places where it says "FILL OUT A COMMAND UNDER"
  *Using the descriptions, figure out where to fill each command.
  */
  
  /** DESCRIPTION FOR COMMAND 1
  * COMMAND(Use only once)
  * MUST INITIALIZE MOTORS FIRST. THIS ALLOWS THE MOTORS TO WORK
  *HOW TO FILL COMMAND: "configureMotors();"
  */
  public void configureMotors() {
    TalonFX[] drivetrainMotors = {drivetrainFrontLeftMotor, drivetrainBackLeftMotor,drivetrainFrontRightMotor, drivetrainBackRightMotor};for (TalonFX talon: drivetrainMotors) {talon.configFactoryDefault();talon.configNominalOutputForward(0);talon.configNominalOutputReverse(0);talon.configPeakOutputForward(1);talon.configPeakOutputReverse(-1);talon.configNeutralDeadband(0.001, 50);talon.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 50);talon.setSensorPhase(true);talon.setNeutralMode(NeutralMode.Coast);talon.config_kP(0, TalonFX_P, 1);talon.config_kI(0, TalonFX_I, 1);talon.config_kD(0, TalonFX_D, 1);talon.config_kP(1, TalonFX_P, 1);talon.config_kI(1, TalonFX_I, 1);talon.config_kD(1, TalonFX_D, 1);}drivetrainBackRightMotor.follow(drivetrainFrontRightMotor);drivetrainFrontLeftMotor.setInverted(InvertType.InvertMotorOutput);drivetrainBackLeftMotor.follow(drivetrainFrontLeftMotor);drivetrainBackLeftMotor.setInverted(InvertType.FollowMaster);
  }

  /*DESCRIPTION FOR COMMAND 2
  Must be moved by the left joystick
  HOW TO FILL COMMAND: "moveLeftMotors();"
  */
  public void moveLeftMotors() {
    drivetrainFrontLeftMotor.set(ControlMode.PercentOutput, RobotContainer.driveStick.getRawAxis(Constants.LEFT_JOYSTICK)/5);
  }

  /*DESCRIPTION FOR COMMAND 3 
    Must be moved by the right joystick
    HOW TO FILL COMMAND: "moveRightMotors();"
  */
  public void moveRightMotors() {
    drivetrainFrontRightMotor.set(ControlMode.PercentOutput, RobotContainer.driveStick.getRawAxis(Constants.RIGHT_JOYSTICK)/5);
  }

  //INITIALIZE MOTORS inside the braces
  public Drivetrain() {
    //FILL OUT A COMMAND UNDER
    
  }

  //Assign the LEFT MOTORS to the left joystick and assign the RIGHT MOTORS to the right joystick
  @Override
  public void periodic() {
    //Move the LEFT MOTORS inside the braces
    if(Math.abs(RobotContainer.driveStick.getRawAxis(Constants.LEFT_JOYSTICK)) < Constants.JOYSITCK_DEADBAND) {
      //FILL OUT A COMMAND UNDER

    }
    //Move the RIGHT MOTORS inside the braces
    if (Math.abs(RobotContainer.driveStick.getRawAxis(Constants.RIGHT_JOYSTICK)) < Constants.JOYSITCK_DEADBAND) {
      //FILL OUT A COMMAND UNDER

    }
  }
}