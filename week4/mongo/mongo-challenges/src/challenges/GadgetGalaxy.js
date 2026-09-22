//create
use('GadgetGalaxy');

//create products collection with validation
db.createCollection("products", {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["name", "price", "inStock"],
            properties: {
                name: {
                    bsonType: "string"
                },
                price: {
                    bsonType: "double"
                },
                inStock: {
                    bsonType: "bool"
                }
            }
        }
    },
    validationAction: "error"
});

//inserting documents into products collection
db.products.insertMany([
    { name: "Wireless Mouse", price: 129.99, inStock: true, specs: { brand: "Logitech"} },
    { name: "Mechanical Keyboard", price: 79.99, inStock: true, specs: { brand: "Wooting"} },
    { name: "Gaming Monitor", price: 349.99, inStock: true, specs: { brand: "ASUS"} }
]);

//Confirm validation works.. Throws Error
db.products.insertOne({ name: "BadProduct", inStock: false});

//Add category field to one record
db.products.updateOne({name: "Wireless Mouse"}, {$set: {category: "Accessories"}});

//Increase cost of one record by 15
db.products.updateOne({name: "Wireless Mouse"}, {$inc: {price: 15}});

//Add an array field called tags to that product using $push to add "wireless". Then, use $push again to add "bestseller".
db.products.updateOne({name: "Wireless Mouse"}, {$push: {tags: "Wireless"}});
db.products.updateOne({name: "Wireless Mouse"}, {$push: {tags: "Bestseller"}});

//Decide you don't want "wireless" after all, and use $pull to remove it from the tags array.;
db.products.updateOne({name: "Wireless Mouse"}, {$pull: {tags: "Wireless"}});

//Find all products priced greater than or equal to a certain amount using $gte.
db.products.find({price: {$gte: 130}});

//Find all products made by a specific brand using dotnotation (e.g., "specs.brand").
db.products.find({"specs.brand":"ASUS"});

//Find products whose category matches one in a list using $in.
db.products.find({category: {$in: ["Accessories","Others","IDK"]}});

//Create a second collection named orders.
db.createCollection("orders");

//Insert a document into orders that links a product's _id to an order (e.g., {
//productId: <ObjectId_from_product>, quantity: 2 }).
db.orders.insertOne({product_id: ObjectId("6ab1971f904cf07ec2fb4c73"), quantity: 4});

//Write an aggregation pipeline on the orders collection using $lookup and
//$unwind to join orders with products.
//Use $project to output a clean customer receipt showing:
//The product name ($product.name)
//The ordered quantity (quantity)
//Hiding the _id field.
db.orders.aggregate([
    { $lookup: { from: "products", localField: "product_id", foreignField: "_id", as: "product" }},
    { $unwind: "$product"},
    { $project: { _id: 0, product_name: "$product.name", quantity: 1} }
]);
