package transform;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public interface NestedTransform extends Transform {

    public Matrix4f getLocalTransformationMatrix();

    public Vector3f getLocalPosition();

    public Quaternionf getLocalRotation();

    public Vector3f getLocalRotationVector();

    public Vector3f getLocalScale();

    public Transform getParent();
}
