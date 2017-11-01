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


@TeleOp(name="Base Drive Code", group ="Base Code")

public class BaseDrive extends OpMode {
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor sidewaysDrive;

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

    @Override
    public void init() {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");
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
        leftDrive.setPower(1);
        rightDrive.setPower(1);
        sidewaysDrive.setPower(1);
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
            leftDrive.setPower(1);
            rightDrive.setPower(1);
        } else {
            leftDrive.setPower(1);
            rightDrive.setPower(1);
        }
        sidewaysDrive.setPower(1);
    }
}

