package com.mod.stuffymod.registry;

import com.mod.stuffymod.StuffyMod;
import com.mod.stuffymod.registry.Items.SomePickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(StuffyMod.MODID);

    public static final DeferredItem<Item> EXAMPLE_ITEM =
            ITEMS.registerSimpleItem("example_item",
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(1)
                                    .saturationModifier(2f)
                                    .alwaysEdible()
                                    .build()
                    )
            );

    public static final DeferredItem<Item> SomePickaxeItem =
            ITEMS.register("some_pickaxe", SomePickaxeItem::new);

    public static void register() {

    }
}
