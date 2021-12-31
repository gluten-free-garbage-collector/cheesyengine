package toolbox;

import org.joml.Quaternionf;
import rendering.SimpleCameraController;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import transform.Transform;

public class Maths {

    @Deprecated
    public static Matrix4f createTransformationMatrix(
            Vector3f translation, float rotX, float rotY, float rotZ, float scale) {
        Matrix4f matrix = new Matrix4f();
        matrix.translate(translation);
        matrix.rotate((float) Math.toRadians(rotX), new Vector3f(1, 0, 0));
        matrix.rotate((float) Math.toRadians(rotY), new Vector3f(0, 1, 0));
        matrix.rotate((float) Math.toRadians(rotZ), new Vector3f(0, 0, 1));
        matrix.scale(scale);
        return matrix;
    }

    public static Matrix4f createTransformationMatrix(
            Vector3f translation, Quaternionf rotation, Vector3f scale) {
        Matrix4f matrix = new Matrix4f();
        matrix.translate(translation);
        matrix.rotate(rotation);
        matrix.scale(scale);
        return matrix;
    }

    public static Matrix4f createViewMatrix(Transform t) {
        Matrix4f matrix = new Matrix4f();
        matrix.rotate(t.getRotation());
        matrix.translate(new Vector3f(t.getPosition()).negate());
        return matrix;
    }

    public static Quaternionf eulerToQuaternion(Vector3f vector) {
        //some black magic fuckery from wikipedia
        float cy = (float) Math.cos(vector.z * 0.5);
        float sy = (float) Math.sin(vector.z * 0.5);
        float cp = (float) Math.cos(vector.y * 0.5);
        float sp = (float) Math.sin(vector.y * 0.5);
        float cr = (float) Math.cos(vector.x * 0.5);
        float sr = (float) Math.sin(vector.x * 0.5);

        return new Quaternionf(
                sr * cp * cy - cr * sp * sy,
                cr * sp * cy + sr * cp * sy,
                cr * cp * sy - sr * sp * cy,
                cr * cp * cy + sr * sp * sy);
    }

    public static Vector3f quaternionToEuler(Quaternionf q) {
        //some black magic fuckery from wikipedia
        //TODO: optimize
        double sinr_cosp = 2 * (q.w * q.x + q.y * q.z);
        double cosr_cosp = 1 - 2 * (q.x * q.x + q.y * q.y);
        float roll = (float) Math.atan2(sinr_cosp, cosr_cosp);

        float pitch;
        double sinp = 2 * (q.w * q.y - q.z * q.x);
        if (Math.abs(sinp) >= 1) {
            pitch = (float) Math.copySign(Math.PI, sinp);
        } else {
            pitch = (float) Math.asin(sinp);
        }

        double siny_cosp = 2 * (q.w * q.z + q.x * q.y);
        double cosy_cosp = 1 - 2 * (q.y * q.y + q.z * q.z);
        float yaw = (float) Math.atan2(siny_cosp, cosy_cosp);

        return new Vector3f(roll, pitch, yaw);

    }


}
