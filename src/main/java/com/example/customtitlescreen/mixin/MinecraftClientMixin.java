package com.example.customtitlescreen.mixin;

import com.example.customtitlescreen.client.gui.SeasonTimeTitleScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

    @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
    private void customtitlescreen$replaceTitleScreen(Screen screen, CallbackInfo ci) {
        if (screen instanceof TitleScreen && !(screen instanceof SeasonTimeTitleScreen)) {
            ci.cancel();
            ((MinecraftClient) (Object) this).setScreen(new SeasonTimeTitleScreen());
        }
    }
}
