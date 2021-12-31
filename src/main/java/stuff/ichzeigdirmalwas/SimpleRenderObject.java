package stuff.ichzeigdirmalwas;

import stuff.models.TexturedModel;
import stuff.qwertzthegame.Renderer;
import rendering.StaticShader;
import transform.SimpleTransform;

public class SimpleRenderObject extends AbstactRenderObject {
    private TexturedModel model;
    private StaticShader shader;
    private SimpleTransform transform;

    public SimpleRenderObject(TexturedModel model, StaticShader shader, SimpleTransform transform) {
        this.model = model;
        this.shader = shader;
        this.transform = transform;
    }

    public void render(Renderer renderer) {
        renderer.render(model, transform, shader);
    }
}
