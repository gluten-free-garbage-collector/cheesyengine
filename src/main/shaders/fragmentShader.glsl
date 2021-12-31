#version 400 core

in vec2 pass_textureCoordinates;

out vec4 out_colour;

uniform sampler2D textureSampler;

void main (void){
    out_colour = texture(textureSampler, pass_textureCoordinates);
}