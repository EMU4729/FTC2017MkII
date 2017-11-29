package org.firstinspires.ftc.teamcode;

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
