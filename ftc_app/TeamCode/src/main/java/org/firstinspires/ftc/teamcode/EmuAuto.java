package org.firstinspires.ftc.teamcode;

import android.hardware.SensorManager;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Autonomous Code", group ="Base Code")

public class EmuAuto extends OpMode {

    SensorManager sensorManager;
    GlyphGrabber glyphGrabber;
    Motors motors;
    ParallelogramMotors parallelogramMotors;
    ColourSensor colourSensor;
    ElapsedTime timer;
    double colourMin = 1;
    double stage1time = 5;
    double stage2time = 5 + stage1time;


    @Override
    public void init() {
        motors = new Motors(hardwareMap);
        parallelogramMotors = new ParallelogramMotors(hardwareMap);
        timer = new ElapsedTime();
        colourSensor = new ColourSensor(hardwareMap);
    }

    @Override
    public void loop() {
        if (timer.time() < stage1time) {
            motors.drive(10, 0, 0);
        } else if (timer.time() < stage2time) {
            if (colourSensor.getValue() < colourMin) {

            }
        }
        //Move left
        //Scan Pictograph
        //Point toward glyphs
        //Move forward
        //Pick up glyph
        //Point toward Cryptobox
        //Move to correct box
        //Put glyph into correct box
        //Repeat Step 6 onwards

    }
}
