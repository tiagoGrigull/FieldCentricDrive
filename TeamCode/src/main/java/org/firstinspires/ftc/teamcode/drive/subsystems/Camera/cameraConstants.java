package org.firstinspires.ftc.teamcode.drive.subsystems.Camera;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

import java.util.List;

public class cameraConstants {

    public String cameraName = "Webcam1";

    private static final boolean USE_WEBCAM = true;

    private Position cameraPosition = new Position(DistanceUnit.CM,
            0,0,0,0);

    private AprilTagProcessor aprilTagProcessor;

    private VisionPortal visionPortal;

    public cameraConstants(HardwareMap hardwareMap){
        aprilTagProcessor = new AprilTagProcessor.Builder()
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .build();

        visionPortal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, cameraName))
                .addProcessor(aprilTagProcessor)
                .build();
    }

    public List<AprilTagDetection> getDetections() {
        return aprilTagProcessor.getDetections();
    }

    public void close() {
        visionPortal.close();
    }


}
