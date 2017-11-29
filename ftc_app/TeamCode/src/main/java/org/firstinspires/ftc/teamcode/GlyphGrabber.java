package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


import android.content.Context;
import android.hardware.SensorManager;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;


//@TeleOp(name="GlyphGrabber Code", group ="GlyphGrabber Code")

public class GlyphGrabber {

    Servo Servo1;
    Servo Servo2;

    double openPos = 0.65;
    double closePos = 0;

    //@Override
    public GlyphGrabber(HardwareMap hardwareMap) {
        Servo1 = hardwareMap.servo.get("servo_1");
        Servo2 = hardwareMap.servo.get("servo_2");
    }

//    @Override
    public void moveServo(Gamepad gamepad1) {
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

//    @Override
    public void stop() {

    }


}

