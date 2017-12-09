package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Motors {
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor sidewaysDrive;

    public Motors(HardwareMap hardwareMap) {
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");
        sidewaysDrive = hardwareMap.dcMotor.get("sideways_drive");
    }

    public void drive(double forwards, double sideways, double turn) {
        double lf = forwards-turn;
        double rf = forwards+turn;
        double lb = forwards-turn;
        double rb = forwards+turn;
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
        leftDrive.setPower(lb);
        rightDrive.setPower(rb);

        sidewaysDrive.setPower(-sideways);
    }

    public void stop() {
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sidewaysDrive.setPower(0);
    }
}
