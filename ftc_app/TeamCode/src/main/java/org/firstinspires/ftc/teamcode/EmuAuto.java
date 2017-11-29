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
    boolean direction = false;
    double colourMin = 1;
    double stage1time = 5;
    double stage2time = 1 + stage1time;
    double stage3time = 3 + stage2time;
    double stage4time = 5 + stage3time



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
            motors.drive( 1, 0, 0);
        } else if (timer.time() < stage2time) {
            if (colourSensor.getValue() < colourMin) {
                direction = true;
            } else {

            }
        } else if (timer.time() < stage3time) {
            if (direction) {
                motors.drive(0,0,1);
            } else {
                motors.drive(0,0,-1);
            }
        }  else if (timer.time() < stage4time) {
            motors.drive(0,1,0);
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
