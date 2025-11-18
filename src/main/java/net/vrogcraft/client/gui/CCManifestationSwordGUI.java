package net.vrogcraft.client.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.vrogcraft.entity.projectile.Entanglement;

public class CCManifestationSwordGUI extends Screen {

    private int closeAttempts = 0;
    private final int maxAttempts = 5;
    private Component dynamicTitle;

    public CCManifestationSwordGUI() {
        super(Component.literal("Warning!"));
        this.dynamicTitle = Component.literal("Warning!");
    }

    @Override
    protected void init() {
        this.addRenderableWidget(
                Button.builder(Component.literal("Close"), button -> onCloseClicked())
                        .bounds(this.width / 2 - 40, this.height / 2 + 20, 80, 20)
                        .build()
        );
    }

    private void onCloseClicked() {
        closeAttempts++;
        if (closeAttempts >= maxAttempts) this.onClose();
        else this.dynamicTitle = Component.literal("Try again... (" + (maxAttempts - closeAttempts) + " left)");
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        guiGraphics.fill(0, 0, this.width, this.height, 0x88000000);
        guiGraphics.drawCenteredString(this.font, this.dynamicTitle, this.width / 2, this.height / 2 - 20, 0xFF0000);
        guiGraphics.drawCenteredString(this.font, Component.literal("You are controlled... >:D"), this.width / 2, this.height / 2 - 40, 0xFFFFFF);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void onClose() {
        if (this.minecraft != null && this.minecraft.player != null) {
            this.minecraft.player.displayClientMessage(Component.literal("You broke free!"), true);
        }
        super.onClose();
    }
}
