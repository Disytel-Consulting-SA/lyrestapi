package org.libertya.api.repository;

import org.libertya.api.stub.model.GLCategory;
import org.openXpertya.model.X_GL_Category;
import org.springframework.stereotype.Repository;

@Repository
public class GLCategoryRepository extends AbstractRepository {

    public GLCategoryRepository() {
        tableName = X_GL_Category.Table_Name;
        iface = GLCategory::new;
    }
}
