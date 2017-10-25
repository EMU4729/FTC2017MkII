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


@TeleOp(name="Gyph Code", group ="Gyph Code")

public class BaseDrive extends OpMode {
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor sidewaysDrive;

    Servo Servo1;
    Servo Servo2;

    Double openPos = 0.65;
    Double closePos = 0;

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        if(gamepad.rb) {
            Servo1.setPosition(openPos);
        } else {
            Servo1.setPosition(closePos);
        }
        if (gamepad.lb){
            Servo2.setPosition(openPos);
        } else {
            Servo2.setPosition(closePos);
        }
    }

    @Override
    public void stop() {

    }


}

