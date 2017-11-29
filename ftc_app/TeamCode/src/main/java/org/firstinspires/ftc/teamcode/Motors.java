package org.firstinspires.ftc.teamcode;

public class Motors {
    public Motors(HardwareMap hardwareMap) {
        DcMotor leftDrive;
        DcMotor rightDrive;
        DcMotor sidewaysDrive;
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
            leftDrive.setPower(lb);
            rightDrive.setPower(rb);
        } else {
            leftDrive.setPower(lb / WEIGHT);
            rightDrive.setPower(rb / WEIGHT);
        }
        sidewaysDrive.setPower(sideways);
    }
}
