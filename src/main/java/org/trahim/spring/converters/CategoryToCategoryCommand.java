package org.trahim.spring.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.trahim.spring.commands.CategoryCommand;
import org.trahim.spring.domain.Category;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Override
    @Synchronized
    @Nullable
    public CategoryCommand convert(Category category) {
        if (category == null) {
            return null;
        }

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(category.getId());
        categoryCommand.setDescription(category.getDescription());
        return categoryCommand;
    }
}
