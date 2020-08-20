package com.mika.tutorial.items;

import com.mika.tutorial.Tutorial;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MaxHealthIceCream extends Item {
    public MaxHealthIceCream() {
        super(new Item.Properties()
                .group(ItemGroup.FOOD)
                .food(new Food.Builder()
                        .hunger(20)
                        .saturation(9.0f)
                        .effect(new EffectInstance(Effects.HEALTH_BOOST, 2*60*20, 10), 1.0f)
                        .effect(new EffectInstance(Effects.INVISIBILITY, 2*60*20, 10), 1.0f)
                        .effect(new EffectInstance(Effects.GLOWING, 2*60*20, 10), 1.0f)
                        .setAlwaysEdible()
                        .meat()
                        .build())
        );
    }
}
