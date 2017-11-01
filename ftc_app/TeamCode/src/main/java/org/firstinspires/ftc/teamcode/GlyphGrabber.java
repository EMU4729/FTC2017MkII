package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


import android.content.Context;
import android.hardware.SensorManager;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="GlyphGrabber Code", group ="GlyphGrabber Code")

public class GlyphGrabber extends OpMode {
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor sidewaysDrive;

    Servo Servo1;
    Servo Servo2;

    double openPos = 0.65;
    double closePos = 0;

    @Override
    public void init() {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");
        sidewaysDrive = hardwareMap.dcMotor.get("sideways_drive");

        Servo1 = hardwareMap.servo.get("servo_1");
        Servo2 = hardwareMap.servo.get("servo_2");
    }

    @Override
    public void loop() {
        if(gamepad1.right_bumper) {
            Servo1.setPosition(openPos);
        } else {
            Servo1.setPosition(closePos);
        }
        if (gamepad1.left_bumper){
            Servo2.setPosition(openPos);
        } else {
            Servo2.setPosition(closePos);
        }
    }

    @Override
    public void stop() {

    }


}

