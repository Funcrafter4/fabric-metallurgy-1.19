package net.metallurgy.metallurgymod.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class CrusherBlockRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    private static int maxProgress = 73;

    public CrusherBlockRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;

    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(recipeItems.get(0).test(inventory.getStack(1))){
            return true;
        }

        return false;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    public static int getMaxProgress() {
        return maxProgress;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<CrusherBlockRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "crusher_block";
    }

    public static class Serializer implements RecipeSerializer<CrusherBlockRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "crusher_block";
        // this is the name given in the json file

        @Override
        public CrusherBlockRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
            JsonObject outputJ = (JsonObject) json.get("output");
            int count = Integer.parseInt(String.valueOf(outputJ.get("count")));
            maxProgress = Integer.parseInt(String.valueOf(outputJ.get("amount")));

            output.setCount(count);


            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CrusherBlockRecipe(id, output, inputs);
        }

        @Override
        public CrusherBlockRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);



            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new CrusherBlockRecipe(id, output, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, CrusherBlockRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
        }
    }
}
