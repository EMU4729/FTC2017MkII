package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;

public class ColourSensor {
    AnalogInput colourSensor;

    public ColourSensor() {
        colourSensor = hardwareMap.analogInput.get("colour_sensor");
    }

    public double getValue() {
        return colourSensor.getVoltage();
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */

}

