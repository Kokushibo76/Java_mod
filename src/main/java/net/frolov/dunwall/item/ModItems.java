package net.frolov.dunwall.item;

import net.frolov.dunwall.dunwall;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.Random;

import static net.minecraft.world.item.Tiers.STONE;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, dunwall.MOD_ID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> DISHONORED = ITEMS.register("coin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DISHONORED_TAB)));

    public static final RegistryObject<Item> ELIXIR = ITEMS.register("elixir",
            () -> new Item(new Item.Properties()
                    .food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.5f)
                            .effect(() -> {
                                return new MobEffectInstance(MobEffects.HEAL, 60, 0);
                            }, 1.0f)
                            .build())
                    .tab(ModCreativeModeTab.DISHONORED_TAB)));

    public static final RegistryObject<SwordItem> SWORD = ITEMS.register("sword",
            () -> new SwordItem(STONE, 5, 3f, (new Item.Properties()).tab(ModCreativeModeTab.DISHONORED_TAB)));

    public static final RegistryObject<Item> VORVAN = ITEMS.register("vorvan",
            () -> new CoalCokeItem(new Item.Properties()
                    .tab(ModCreativeModeTab.DISHONORED_TAB)));

}

