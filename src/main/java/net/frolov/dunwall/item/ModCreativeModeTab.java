package net.frolov.dunwall.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab DISHONORED_TAB = new CreativeModeTab("Dishonored") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DISHONORED.get());
        }
    };
}
