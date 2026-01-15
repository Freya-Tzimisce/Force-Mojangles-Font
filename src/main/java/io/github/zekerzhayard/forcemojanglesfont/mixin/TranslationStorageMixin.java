package io.github.zekerzhayard.forcemojanglesfont.mixin;

import net.minecraft.client.resource.language.TranslationStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TranslationStorage.class)
public abstract class TranslationStorageMixin {
	@Shadow
	private boolean rightToLeft;

	@Inject(method = "setRightToLeft", at = @At("HEAD"), cancellable = true)
	private void onSetRightToLeft(CallbackInfo ci) {
		this.rightToLeft = false;
		ci.cancel();
	}
}
