package net.vrogcraft.init;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ModTiers {
    public static final Tier MANIFESTATION_SWORD = new Tier() {
        @Override
        public int getUses() {
            return 1561;
        }

        @Override
        public float getSpeed() {
            return 7f;
        }

        @Override
        public float getAttackDamageBonus() {
            return 3f;
        }

        @Override
        public int getLevel() {
            return 0;
        }

        @Override
        public int getEnchantmentValue() {
            return 8;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(ModItems.NETHERITE_VROG.get());
        }
        public static final Tier SECOND_MANIFESTATION_SWORD = new Tier() {
            @Override
            public int getUses() {
                return 1561;
            }

            @Override
            public float getSpeed() {
                return 7f;
            }

            @Override
            public float getAttackDamageBonus() {
                return 3f;
            }

            @Override
            public int getLevel() {
                return 0;
            }

            @Override
            public int getEnchantmentValue() {
                return 8;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(ModItems.NETHERITE_VROG.get());
            }
        };
    };
}
