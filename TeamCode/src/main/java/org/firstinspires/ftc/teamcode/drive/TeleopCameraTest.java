package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.drive.subsystems.Camera.cameraConstants;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import java.util.List;

@TeleOp(name = "AprilTag Test", group = "Vision")
public class TeleopCameraTest extends LinearOpMode {

    private cameraConstants camera;

    @Override
    public void runOpMode() {
        // Inicializa o subsistema de AprilTag
        camera = new cameraConstants(hardwareMap);

        telemetry.addLine("Aguardando start...");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            // Obtém as detecções do subsistema
            List<AprilTagDetection> detections = camera.getDetections();

            // Exibir informações sobre os AprilTags detectados
            for (AprilTagDetection tag : detections) {
                telemetry.addData("Tag ID", tag.id);
                telemetry.addData("Posição X", tag.ftcPose.x);
                telemetry.addData("Posição Y", tag.ftcPose.y);
                telemetry.addData("Posição Z", tag.ftcPose.z);
                telemetry.addData("Rotação Yaw", tag.ftcPose.yaw);
                telemetry.addData("Rotação Pitch", tag.ftcPose.pitch);
                telemetry.addData("Rotação Roll", tag.ftcPose.roll);
                telemetry.addLine("-------------------------");
            }

            telemetry.update();
        }

        camera.close();
    }
}
