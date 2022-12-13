package net.devven.devvengems.block;

import net.devven.devvengems.DevvEnGems;
import net.devven.devvengems.item.ModCreativeModeTab;
import net.devven.devvengems.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DevvEnGems.MOD_ID);

    //Add blocks here
    public static final RegistryObject<Block> GEM_BLOCK = registerBlock("gem_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(6f)
                    .requiresCorrectToolForDrops())
            , ModCreativeModeTab.DEVVENSGEM_TAB);
    public static final RegistryObject<Block> GEM_ORE = registerBlock("gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    , UniformInt.of(2, 12))
            , ModCreativeModeTab.DEVVENSGEM_TAB);
    public static final RegistryObject<Block> DEEPSLATE_GEM_ORE = registerBlock("deepslate_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    , UniformInt.of(6, 16))
            , ModCreativeModeTab.DEVVENSGEM_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);

        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
