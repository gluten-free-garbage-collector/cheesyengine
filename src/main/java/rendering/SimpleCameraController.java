package rendering;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWKeyCallbackI;
import transform.SimpleTransform;

public class SimpleCameraController implements GLFWKeyCallbackI {

    SimpleTransform transform;

    public SimpleCameraController(SimpleTransform transform) {
        this.transform = transform;
    }

    public SimpleCameraController() {
        this(new SimpleTransform());
    }

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        if (key == GLFW_KEY_W && action == GLFW_PRESS) {
            transform.getPosition().z -= 0.02f;
        } else if (key == GLFW_KEY_D && action == GLFW_PRESS) {
            transform.getPosition().x += 0.02f;
        } else if (key == GLFW_KEY_A && action == GLFW_PRESS) {
            transform.getPosition().x -= 0.02f;
        }
    }

    public SimpleTransform getTransform() {
        return transform;
    }
}