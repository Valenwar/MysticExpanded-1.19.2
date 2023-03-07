package com.Valenwar.testmod.block;

import com.Valenwar.testmod.block.custom.*;
import com.Valenwar.testmod.item.ModCreativeModeTab;
import com.Valenwar.testmod.item.ModItems;
import com.Valenwar.testmod.item.custom.RuneBook;
import com.Valenwar.testmod.testmod;
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
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, testmod.MOD_ID);

    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> TRASH_BLOCK = registerBlock("trash_block",
            () -> new Trash(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TEST_TAB);


    public static final RegistryObject<Block> TEST_BLOCK = registerBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> SAPPHIRE_GEM_CLUSTER = registerBlock("sapphire_gem_cluster",
            () -> new SapphireGemCluster(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> JACINTH_GEM_CLUSTER = registerBlock("jacinth_gem_cluster",
            () -> new JacinthGemCluster(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> LIGURUS_GEM_CLUSTER = registerBlock("ligurus_gem_cluster",
            () -> new LigurusGemCluster(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> CARNELION_GEM_CLUSTER = registerBlock("carnelion_gem_cluster",
            () -> new CarnelionGemCluster(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> CARBUNCLE_GEM_CLUSTER = registerBlock("carbuncle_gem_cluster",
            () -> new CarbuncleGemCluster(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> CHALCEDONY_GEM_CLUSTER = registerBlock("chalcedony_gem_cluster",
            () -> new ChalcedonyGemCluster(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);
    public static final RegistryObject<Block> BERYL_GEM_CLUSTER = registerBlock("beryl_gem_cluster",
            () -> new BerylGemCluster(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);
    public static final RegistryObject<Block> TOPAZ_GEM_CLUSTER = registerBlock("topaz_gem_cluster",
            () -> new TopazGemCluster(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> CHRYSOLITE_GEM_CLUSTER = registerBlock("chrysolite_gem_cluster",
            () -> new ChrysoliteGemCluster(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> ONYX_GEM_CLUSTER = registerBlock("onyx_gem_cluster",
            () -> new OnyxGemCluster(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock("deepslate_zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.TEST_TAB);

    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TEST_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }



    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
