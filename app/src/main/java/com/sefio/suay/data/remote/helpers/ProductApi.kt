package com.sefio.suay.data.remote.helpers

import com.sefio.suay.data.remote.back.BackApi
import com.sefio.suay.data.remote.back.services.ProductService
import com.sefio.suay.domain.model.AuthToken
import com.sefio.suay.domain.model.Product
import javax.inject.Inject

class ProductApi @Inject constructor(
    private val backApi: BackApi,
    private val productMapper: ProductMapper,
){
    private val productService: ProductService = backApi.create(ProductService::class.java)

    suspend fun fetchRecommendedProducts(authToken: AuthToken): List<Product> {
        return listOf(
            Product(
                id = "1a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "2a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "3a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "4a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "5a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "6a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "7a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "8a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "9a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "10a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "11a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "12a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "13a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "14a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "15a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            ),
            Product(
                id = "16a",
                name = "teclado",
                description = "descripcion producto",
                price = 15.0,
                stars = 3.7,
                category = listOf("Informatica", "Tecnologia", "PC", "KeyBoard", "Teclado")
            )
        )
    }

}