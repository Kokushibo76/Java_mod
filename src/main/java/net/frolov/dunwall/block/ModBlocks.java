package net.frolov.dunwall.block;

import net.frolov.dunwall.dunwall;
import net.frolov.dunwall.item.ModCreativeModeTab;
import net.frolov.dunwall.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, dunwall.MOD_ID);

    public static final RegistryObject<Block> OUTSIDER_BLOCK = registryBlock("outsider_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.GLASS)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.DISHONORED_TAB);

    public static final RegistryObject<Block> MONEY_BLOCK = registryBlock("money_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(3f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.DISHONORED_TAB);

    public static final RegistryObject<Block> VORVAN_BLOCK = registryBlock("vorvan_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(3f)
                    .sound(SoundType.SLIME_BLOCK)
                    .requiresCorrectToolForDrops()
                    .isRedstoneConductor((state, getter, pos, entity) -> true)
                    .isSignalSource()), ModCreativeModeTab.DISHONORED_TAB);


    public static final RegistryObject<Block> SOUND_BLOCK = registryBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL)));
    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturns = BLOCKS.register(name,block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
    }

    public static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        ModBlocks.register(eventBus);
    }
}