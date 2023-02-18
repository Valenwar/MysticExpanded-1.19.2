package com.Valenwar.testmod.item;

import com.Valenwar.testmod.item.custom.EightBallItem;
import com.Valenwar.testmod.item.custom.SoulResidueItem;
import com.Valenwar.testmod.testmod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, testmod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));
    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));
    public static final RegistryObject<Item> SOULRESIDUEPOTION = ITEMS.register("soulresiduepotion",
            () -> new SoulResidueItem(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1).food(Foods.SOULRESIDUEPOTION)));

    public static final RegistryObject<Item> CARBUNCLE = ITEMS.register("carbuncle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> BERYL = ITEMS.register("beryl",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> CARNELION = ITEMS.register("carnelion",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> CHALCEDONY = ITEMS.register("chalcedony",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> CHRYSOLITE = ITEMS.register("chrysolite",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> JACINTH = ITEMS.register("jacinth",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> LIGURUS = ITEMS.register("ligirus",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> ONYX = ITEMS.register("onyx",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> TESTBLOCK = ITEMS.register("testblock",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> TESTSWORD = ITEMS.register("testsword",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static class Foods{
        public static final FoodProperties SOULRESIDUEPOTION = new FoodProperties.Builder().alwaysEat().build();
    }

}


