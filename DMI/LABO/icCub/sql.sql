CREATE VIEW product_view AS
SELECT ProductKey,ProductAlternateKey,EnglishProductName,FrenchProductName,StandardCost
Color,EnglishProductCategoryName,FrenchProductCategoryName,EnglishProductSubcategoryName,FrenchProductSubcategoryName
FROM dimproduct prod
JOIN dimproductsubcategory sub on (prod.ProductSubcategoryKey = sub.ProductSubcategoryKey)
JOIN dimproductcategory cat on (cat.ProductCategoryKey = sub.ProductCategoryKey) 
