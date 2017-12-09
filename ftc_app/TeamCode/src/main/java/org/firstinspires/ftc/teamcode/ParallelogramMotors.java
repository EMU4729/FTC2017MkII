package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ParallelogramMotors {
    DcMotor parallelogramMotor;
    DigitalChannel limitSwitch;

    public ParallelogramMotors(HardwareMap hardwareMap) {
        parallelogramMotor = hardwareMap.dcMotor.get("parallelogram_motor");
        limitSwitch = hardwareMap.digitalChannel.get("limit_switch");
        limitSwitch.setMode(DigitalChannel.Mode.INPUT);
    }

    public void moveParallelogram(boolean up) {
        double downSpeed = 0.15;
        double upSpeed = 0.3;
        if (up) {
            parallelogramMotor.setPower(upSpeed);
        } else {
            parallelogramMotor.setPower(-downSpeed);
        }
    }

    public void stopParallelogram() {
        parallelogramMotor.setPower(0);
    }

    public boolean getLimitSwitch() {
        return limitSwitch.getState();
    }
}
