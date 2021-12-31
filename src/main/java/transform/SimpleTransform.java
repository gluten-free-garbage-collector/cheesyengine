package transform;

import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import toolbox.Maths;

public class SimpleTransform implements NestedTransform {

    private Vector3f position;
    private Quaternionf rotation;
    private Vector3f scale;
    private Transform parent;

    //construcotrs with parent

    public SimpleTransform(Vector3f position, Quaternionf rotation, Vector3f scale, Transform parent) {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
        this.parent = parent;
    }

    public SimpleTransform(Vector3f position, Vector3f rotation, Vector3f scale, Transform parent) {
        this(position, Maths.eulerToQuaternion(rotation), scale, parent);
    }

    public SimpleTransform(Vector3f position, Quaternionf rotation, float scale, Transform parent) {
        this(position, rotation, new Vector3f(scale), parent);
    }

    public SimpleTransform(Vector3f position, Vector3f rotation, float scale, Transform parent) {
        this(position, Maths.eulerToQuaternion(rotation), new Vector3f(scale), parent);
    }

    //constructors without parent

    public SimpleTransform(Vector3f position, Quaternionf rotation, Vector3f scale) {
        this(position, rotation, scale, null);
    }

    public SimpleTransform(Vector3f position, Vector3f rotation, Vector3f scale) {
        this(position, Maths.eulerToQuaternion(rotation), scale, null);
    }

    public SimpleTransform(Vector3f position, Quaternionf rotation, float scale) {
        this(position, rotation, new Vector3f(scale), null);
    }

    public SimpleTransform(Vector3f position, Vector3f rotation, float scale) {
        this(position, Maths.eulerToQuaternion(rotation), new Vector3f(scale), null);
    }

    public SimpleTransform() {
        this(new Vector3f(), new Quaternionf(), new Vector3f(), null);
    }

    //custom methods

    public void increasePosition(float dx, float dy, float dz) {
        this.position.x += dx;
        this.position.y += dy;
        this.position.z += dz;
    }

    public void increaseRotation(float dx, float dy, float dz) {
        this.rotation.x += dx;
        this.rotation.y += dy;
        this.rotation.z += dz;
    }

    //transformation matrix getters

    @Override
    public Matrix4f getTransformationMatrix() {
        return Maths.createTransformationMatrix(getPosition(), getRotation(), getScale());
    }

    @Override
    public Matrix4f getLocalTransformationMatrix() {
        return Maths.createTransformationMatrix(getLocalPosition(), getLocalRotation(), getLocalScale());
    }

    //global getters

    @Override
    public Vector3f getPosition() {
        return parent == null ? position : new Vector3f(position).add(parent.getPosition());
    }

    @Override
    public Quaternionf getRotation() {
        return parent == null ? rotation : new Quaternionf(rotation).mul(parent.getRotation());
    }

    @Override
    public Vector3f getRotationVector() {
        return Maths.quaternionToEuler(getRotation());
    }

    @Override
    public Vector3f getScale() {
        return parent == null ? scale : new Vector3f(scale).mul(parent.getScale());
    }

    //local getters

    @Override
    public Vector3f getLocalPosition() {
        return position;
    }

    @Override
    public Quaternionf getLocalRotation() {
        return rotation;
    }

    @Override
    public Vector3f getLocalRotationVector() {
        return Maths.quaternionToEuler(rotation);
    }

    @Override
    public Vector3f getLocalScale() {
        return scale;
    }

    @Override
    public Transform getParent() {
        return parent;
    }

    //setters

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public void setRotation(Quaternionf rotation) {
        this.rotation = rotation;
    }

    public void setRotation(Vector3f rotation) {
        this.rotation = Maths.eulerToQuaternion(rotation);
    }

    public void setScale(Vector3f scale) {
        this.scale = scale;
    }

    public void setParent(Transform parent) {
        this.parent = parent;
    }
}
