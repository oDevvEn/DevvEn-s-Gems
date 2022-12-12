package net.devven.devvengems.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab DEVVENSGEM_TAB = new CreativeModeTab("devvengemstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GEM.get());
        }
    };
}
