package org.firstinspires.ftc.teamcode;

public class ParallelogramMotors {
    DcMotor parallelogramMotor;

    public ParallelogramMotors(HardwareMap hardwareMap) {
        parallelogramMotor = hardwareMap.dcMotor.get("parallelogram_motor");
    }

    public void moveParallelogram(boolean up) {

        double speed = 1.0;
        if (up) {
            parallelogramMotor.setPower(speed);
        } else {
            parallelogramMotor.setPower(-speed);
        }
    }

    public void stopParallelogram() {
        parallelogramMotor.setPower(0);
    }
}
