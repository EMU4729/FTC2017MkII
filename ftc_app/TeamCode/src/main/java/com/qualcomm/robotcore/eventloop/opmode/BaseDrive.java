package com.qualcomm.robotcore.eventloop.opmode;

package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import android.content.Context;
import android.hardware.SensorManager;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Base Drive Code", group ="Base Code")
@Disabled
public class BaseDrive extends LinearOpMode {
    DcMotor leftBackDrive;
    DcMotor rightBackDrive;
    DcMotor leftForwardDrive;
    DcMotor rightForwardDrive;
    DcMotor sidewaysDrive;

    @Override
    public void init() {
        leftBackDrive = hardwareMap.dcMotor.get("left_back_drive");
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive = hardwareMap.dcMotor.get("right_back_drive");
        leftForwardDrive = hardwareMap.dcMotor.get("left_forward_drive");
        leftForwardDrive.setDirection(DcMotor.Direction.REVERSE);
        rightForwardDrive = hardwareMap.dcMotor.get("right_forward_drive");
        sidewaysDrive = hardwareMap.dcMotor.get("sideways_drive");
        sensorManager = (SensorManager)hardwareMap.appContext.getSystemService(Context.SENSOR_SERVICE);
        //Looper.prepare();
        //gyro =  new MyGyro();

        //sensorManager.registerListener(gyro, sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR), SensorManager.SENSOR_DELAY_GAME);
        motorType = "hdrive";
        WEIGHT = 1;
    }

    //Runs repeatedly until play is hit
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */

    @Override
    public void loop() {
        //update input variables
        joystick_1_x = -gamepad1.left_stick_x;
        joystick_1_y = -gamepad1.left_stick_y;
        joystick_2_x = -gamepad1.right_stick_x;
        joystick_2_y = -gamepad1.right_stick_y;
        buttonX = gamepad2.x;
        buttonB = gamepad2.b;
        buttonY = gamepad2.y;
        buttonA = gamepad2.a;
        leftTrigger = gamepad2.left_trigger;
        rightTrigger = gamepad2.right_trigger;
        leftBumper = gamepad2.left_bumper;
        rightBumper = gamepad2.right_bumper;

        //update motors
        drive(-joystick_1_y, joystick_1_x, joystick_2_x);
    }


    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        leftBackDrive.setPower(0);
        rightBackDrive.setPower(0);
        leftForwardDrive.setPower(0);
        rightForwardDrive.setPower(0);
        sidewaysDrive.setPower(0);
    }


    public void drive(double forwards, double sideways, double turn) {
        double lf = forwards+turn;
        double rf = forwards-turn;
        double lb = forwards+turn;
        double rb = forwards-turn;
        if (Math.abs(lf) > 1) {
            lf = lf/Math.abs(lf);
        }
        if (Math.abs(lb) > 1) {
            lb = lb/Math.abs(lb);
        }
        if (Math.abs(rf) > 1) {
            rf = rf/Math.abs(rf);
        }
        if (Math.abs(rb) > 1) {
            rb = rb/Math.abs(rb);
        }
        if (WEIGHT < 1) {
            WEIGHT = 1 / WEIGHT;
            leftBackDrive.setPower(lb);
            rightBackDrive.setPower(rb);
            leftForwardDrive.setPower(lf / WEIGHT);
            rightForwardDrive.setPower(lf / WEIGHT);
        } else {
            leftBackDrive.setPower(lb / WEIGHT);
            rightBackDrive.setPower(rb / WEIGHT);
            leftForwardDrive.setPower(lf);
            rightForwardDrive.setPower(rf);
        }
        sidewaysDrive.setPower(sideways);
    }
}

