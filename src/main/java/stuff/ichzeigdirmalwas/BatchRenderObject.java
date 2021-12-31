package stuff.ichzeigdirmalwas;

import stuff.models.TexturedModel;
import stuff.qwertzthegame.Renderer;
import rendering.StaticShader;
import transform.SimpleTransform;

import java.util.LinkedList;
import java.util.List;

public class BatchRenderObject extends AbstactRenderObject {

    private TexturedModel model;
    private StaticShader shader;
    private List<SimpleTransform> transforms;

    public BatchRenderObject(TexturedModel model, StaticShader shader) {
        this.model = model;
        this.shader = shader;
        this.transforms = new LinkedList<>();
    }

    public void addTransform(SimpleTransform t) {
        transforms.add(t);
    }

    public void removeTransform(SimpleTransform t) {
        transforms.remove(t);
    }

    public void render(Renderer renderer) {
        for (SimpleTransform t : transforms) {
            renderer.render(model, t, shader);
        }
    }


}
