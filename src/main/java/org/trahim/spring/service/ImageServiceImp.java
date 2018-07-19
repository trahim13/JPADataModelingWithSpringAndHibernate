package org.trahim.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.trahim.spring.domain.Recipe;
import org.trahim.spring.repositories.RecipeRepository;

import java.io.IOException;

@Service
@Slf4j
public class ImageServiceImp implements ImageService {
    private final RecipeRepository recipeRepository;

    public ImageServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] bytes = new Byte[file.getBytes().length];
            int i = 0;

            for (byte b :
                    file.getBytes()) {
                bytes[i++] = b;

            }

            recipe.setImage(bytes);

            recipeRepository.save(recipe);

        } catch (IOException e) {

            //todo handle better then this
            log.error("Error: " + e);
            e.printStackTrace();
        }

    }
}
