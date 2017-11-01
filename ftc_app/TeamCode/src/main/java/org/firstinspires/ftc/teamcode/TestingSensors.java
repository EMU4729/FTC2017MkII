package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;


@TeleOp(name="Testing sensors :O \\o/ XD", group="Base Code")

public class TestingSensors extends OpMode {
    AnalogInput colourSensor;

    @Override
    public void init() {
        colourSensor = hardwareMap.analogInput.get("colour_sensor");
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
        telemetry.addData("\"Colour sensor\" (ie a light sensor with a filter on it)", colourSensor.getVoltage());
    }


    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {

    }
}

