package org.trahim.spring.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.trahim.spring.commands.CategoryCommand;
import org.trahim.spring.domain.Category;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand categoryCommand) {
        if (categoryCommand == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(category.getId());
        category.setDescription(categoryCommand.getDescription());
        return category;

    }
}
