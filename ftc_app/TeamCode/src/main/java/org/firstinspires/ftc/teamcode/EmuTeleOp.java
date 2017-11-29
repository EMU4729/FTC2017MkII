package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


import android.content.Context;
import android.hardware.SensorManager;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="TeleOp Code", group ="Base Code")

public class EmuTeleOp extends OpMode {

    String motorType;
    double WEIGHT;

    SensorManager sensorManager;
    float joystick_1_x;
    float joystick_1_y;
    float joystick_2_x;
    float joystick_2_y;
    boolean buttonX;
    boolean buttonB;
    boolean buttonY;
    boolean buttonA;
    float leftTrigger;
    float rightTrigger;
    boolean leftBumper;
    boolean rightBumper;
    GlyphGrabber glyphGrabber;

    @Override
    public void init() {

        motors = new Motors(hardwareMap);
        parallelogramMotors = new ParallelogramMotors(hardwareMap);

        sensorManager = (SensorManager)hardwareMap.appContext.getSystemService(Context.SENSOR_SERVICE);

        //Looper.prepare();
        //gyro =  new MyGyro();

        //sensorManager.registerListener(gyro, sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR), SensorManager.SENSOR_DELAY_GAME);
        motorType = "hdrive";
        WEIGHT = 1;

        glyphGrabber = new GlyphGrabber(hardwareMap);
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
        motors.drive(-joystick_1_y, joystick_1_x, joystick_2_x);

        glyphGrabber.moveServo(gamepad1);

        if (buttonY) {
            parallelogramMotors.moveParallelogram(true);
        } else if (buttonB) {
            parallelogramMotors.moveParallelogram(false);
        } else {
            parallelogramMotors.stopParallelogram();
        }
    }


    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sidewaysDrive.setPower(0);
        stopParallelogram();
    }






}

