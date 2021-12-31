package transform;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public interface Transform {

    public Matrix4f getTransformationMatrix();

    public Vector3f getPosition();

    public Quaternionf getRotation();

    public Vector3f getRotationVector();

    public Vector3f getScale();

}
