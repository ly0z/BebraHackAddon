package com.example.addon.modules.BebraHackRender;

import com.example.addon.Addon;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.settings.ColorSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;
import net.minecraft.util.math.Vec3d;


public class Confetti extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<SettingColor> colorOne = sgGeneral.add(new ColorSetting.Builder()
        .name("color-one")
        .description("The first confetti color to change.")
        .defaultValue(new SettingColor(102, 0, 0, 255))
        .build()
    );

    private final Setting<SettingColor> colorTwo = sgGeneral.add(new ColorSetting.Builder()
        .name("color-two")
        .description("The second confetti color to change.")
        .defaultValue(new SettingColor(102, 0, 0, 255))
        .build()
    );

    public Confetti() {
        super(Addon.render, "confetti", "Changes the color of the totem pop particles.");
    }

    public Vec3d getColorOne() {
        return getDoubleVectorColor(colorOne);
    }

    public Vec3d getColorTwo() {
        return getDoubleVectorColor(colorTwo);
    }

    public Vec3d getDoubleVectorColor(Setting<SettingColor> colorSetting) {
        return new Vec3d((double) colorSetting.get().r / 255, (double) colorSetting.get().g / 255, (double) colorSetting.get().b / 255);
    }
}